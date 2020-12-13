package com.sanhee.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CubeMain {

    private int ControlNum = 0;
    public void CheckExit(String exit){
        if ( exit.equals("Q") ){
            System.out.println("Bye~");
            System.exit(0);
        }
    }

    public void KeyboardInput(){

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
                CheckExit(KeyInputCommand[0]); //m 종료(Q) 검사
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

    private void CheckGraveAccentOrNumber(RubiksCube[] CubeBoard, String[] KeyInputCommand){

        for (int i = 0; i < KeyInputCommand.length; i++) {

            if (i != KeyInputCommand.length - 1 && KeyInputCommand[i + 1].equals("`")) {  //m 다음 배열 순번의 데이터값이 `일 경우, 이어 붙여서 출력함.
                ControlNum++;
                System.out.println(KeyInputCommand[i]);
                DisplayCubeAll(CubeBoard);
                i++; //m  `이후부터 출력하기 위해 사용한 증감식
            }
            else if (i != KeyInputCommand.length - 1 && KeyInputCommand[i + 1].equals("2")) {  //m 테스트, 다음 배열 순번의 데이터값이 숫자 경우
                KeyInputCommand[i+1] = KeyInputCommand[i];
                CheckGraveAccentOrNumber(CubeBoard,KeyInputCommand);
                i++; //m  `이후부터 출력하기 위해 사용한 증감식
            }
            else {
                ControlNum++;
                System.out.println(KeyInputCommand[i]);
                DisplayCubeAll(CubeBoard);
            }
            System.out.println("조작개수: "+ControlNum);
        }
    }

    public static void main(String[] args) {

        CubeMain cubeMain = new CubeMain();
        cubeMain.KeyboardInput();

    }

}
