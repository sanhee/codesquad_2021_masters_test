package com.sanhee.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlatCube {

    public void CheckExit(String exit){
        if ( exit.equals("Q") ){
            System.out.println("Bye~");
            System.exit(0);
        }
    }
    public void CheckGraveAccent(PrintCube PrintCube, String[] KeyInputCommand){

        for (int i = 0; i < KeyInputCommand.length; i++) {
            if (i != KeyInputCommand.length - 1 && KeyInputCommand[i + 1].equals("`")) {  //m 다음 배열 순번의 데이터값이 `일 경우, 이어 붙여서 출력함.
                PrintCube.SetShiftType(KeyInputCommand[i] + KeyInputCommand[i + 1]);
                i++; //m  `이후부터 출력하기 위해 사용한 증감식
            } else {
                PrintCube.SetShiftType(KeyInputCommand[i]);
            }
            PrintCube.DisplayAll();
        }

    }
    public void KeyboardInput(){

        PrintCube PrintCube = new PrintCube();

        while(true) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("CUBE> "); //m CLI 입력 표시
                String[] KeyInputCommand = br.readLine().split(""); //m 입력값을 한글자씩 잘라서 배열에 삽입함.

                CheckExit(KeyInputCommand[0]); //m 종료(Q) 검사
                CheckGraveAccent(PrintCube, KeyInputCommand); //m 커맨드 문자열 중 `를 검사하여 존재할 경우 전 문자와 이어붙임

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        FlatCube flatCube = new FlatCube();
        flatCube.KeyboardInput(); //m 키보드의 입력을 받는 메서드

    }

}
