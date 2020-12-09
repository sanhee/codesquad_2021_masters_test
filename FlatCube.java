package com.sanhee.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlatCube {

    public static void PrintCube(){

        String[][] CubeArray = {
          {"R","R","W"},   //m 00 01 02
          {"G","C","W"},   //m 10 11 12
          {"G","B","B"}    //m 20 21 22
        };

        for(int i=0;i<CubeArray.length;i++)
        {
            for(int j=0;j<CubeArray[0].length;j++)
            {
                System.out.printf("%2s",CubeArray[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        PrintCube();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("CUBE> "); //m CLI 입력 표시
            String[] KeyInputCommand = br.readLine().split(""); //m 입력값을 한글자씩 잘라서 배열에 삽입함.


            for(int i=0 ; i<KeyInputCommand.length;i++){

                if(i != KeyInputCommand.length-1 && KeyInputCommand[i+1].equals("`") ) {  //m 다음 배열 순번의 데이터값이 `일 경우, 이어 붙여서 출력함.
                    System.out.println(KeyInputCommand[i]+KeyInputCommand[i+1]);
                    i++; //m  `이후부터 출력하기 위해 사용한 증감식
                }
                else {
                    System.out.println(KeyInputCommand[i]);
                }
                PrintCube();

            }
            br.close(); //m Close BufferedReader
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
