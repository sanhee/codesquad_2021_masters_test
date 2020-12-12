package com.sanhee.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CubeMain {

    public void CheckExit(String exit){
        if ( exit.equals("Q") ){
            System.out.println("Bye~");
            System.exit(0);
        }
    }

    public void KeyboardInput(){

        while(true) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("CUBE> "); //m CLI 입력 표시
                String[] KeyInputCommand = br.readLine().split(""); //m 입력값을 한글자씩 잘라서 배열에 삽입함.

                CheckExit(KeyInputCommand[0]); //m 종료(Q) 검사

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {

        RubiksCube[] CubeBoard = new RubiksCube[6];

        for(int i=0;i<6;i++)
        {
            CubeBoard[i] = new RubiksCube(i);
            CubeBoard[i].DisplayCube(i);
        }

        CubeMain cubeMain = new CubeMain();
        cubeMain.KeyboardInput();

    }

}
