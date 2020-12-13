package com.sanhee.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CubeMain {

    private int ControlNum = 0; //m 조작개수

    private void CheckExit(String command, TimeChecker timeChecker){
        if ( command.equals("Q") ){
            timeChecker.setEndTime();
            System.out.println("경과시간: "+timeChecker.elapsedTime()+" 초");
            System.out.println("조작갯수: "+ControlNum);
            System.out.println("이용해주셔서 감사합니다. 뚜뚜뚜");
            System.exit(0);
        }
    }

    private String[] CheckRandomInput(String[] command){

        if (command[0].equals("*")){
            String[] RandomCommand = new String[]{"F", "R"};

            return RandomCommand;
        }

        return command;
    }


    private void KeyboardInput(){
        TimeChecker timeChecker = new TimeChecker();
        timeChecker.setStartTime();

        RubiksCube[] CubeBoard = new RubiksCube[6];

        for(int i=0;i<6;i++)
        {
            CubeBoard[i] = new RubiksCube(i);
            CubeBoard[i].DisplayCube(i);
        }

        while(true) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("CUBE> "); //m CLI 입력 표시
                String[] KeyInputCommand = br.readLine().split(""); //m 입력값을 한글자씩 잘라서 배열에 삽입함.
                CheckExit(KeyInputCommand[0],timeChecker); //m 종료(Q) 검사

                KeyInputCommand = CheckRandomInput(KeyInputCommand); //m 무작위 출력 명령어(*)가 들어왔는지 검사
                CheckGraveAccentOrNumber(CubeBoard, KeyInputCommand); //m 커맨드 문자열 중 `를 검사하여 존재할 경우 전 문자와 이어붙임


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void DisplayCubeAll(RubiksCube[] CubeBoard){
        for(int i=0;i<6;i++)
        {
            CubeBoard[i].DisplayCube(i);
        }
    }

    private boolean IsDigit(String KeyInputCommand){
        char num = KeyInputCommand.charAt(0);
        return Character.isDigit(num);
    }
    private String[] AddCommandStr(String KeyInputCommand, int period){
        StringBuilder preCommand = new StringBuilder();
        StringBuilder newCommand = new StringBuilder();
        String[] NewKeyInputCommand = new String[]{""};

        preCommand.append(KeyInputCommand);
        newCommand.append(KeyInputCommand);

        for(int i=0 ; i<period-1 ; i++){
            newCommand.append(preCommand);
        }
        NewKeyInputCommand = newCommand.toString().split("");
        return NewKeyInputCommand;
    }
    private void CheckGraveAccentOrNumber(RubiksCube[] CubeBoard, String[] KeyInputCommand){

        Move move = new Move();
        String[] NewKeyInputCommand = new String[]{""};

        for (int i = 0; i < KeyInputCommand.length; i++) {

            if (i != KeyInputCommand.length - 1 && KeyInputCommand[i + 1].equals("`")) {  //m 다음 배열 순번의 데이터값이 `일 경우, 이어 붙여서 출력함.
                ControlNum++;
                System.out.println(KeyInputCommand[i]+KeyInputCommand[i+1]);
                move.CubeElements(CubeBoard,KeyInputCommand[i]+KeyInputCommand[i+1]);
                DisplayCubeAll(CubeBoard);
                i++; //m  `이후부터 출력하기 위해 사용한 증감식
            }
            else if (i != KeyInputCommand.length - 1 && IsDigit(KeyInputCommand[i + 1])) {  //m 다음 배열 순번의 데이터값이 숫자 경우, 함수 재호출
                NewKeyInputCommand = AddCommandStr(KeyInputCommand[i],Integer.parseInt(KeyInputCommand[i + 1]));
                CheckGraveAccentOrNumber(CubeBoard,NewKeyInputCommand);
                i++; //m  숫자 이후부터 출력하기 위해 사용한 증감식
            }
            else {
                ControlNum++;
                System.out.println(KeyInputCommand[i]);
                move.CubeElements(CubeBoard,KeyInputCommand[i]);
                DisplayCubeAll(CubeBoard);
            }
        }
    }

    public static void main(String[] args) {

        CubeMain cubeMain = new CubeMain();
        cubeMain.KeyboardInput();

    }

}
