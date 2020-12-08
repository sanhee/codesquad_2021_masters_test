package com.sanhee.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlatCube {

    public static void main(String[] args) {

       String[][] CubeArray = {{"R","R","W"},   //m 00 01 02
                               {"G","C","W"},   //m 10 11 12
                               {"G","B","B"}};  //m 20 21 22

       for(int i=0;i<CubeArray.length;i++){
           for(int j=0;j<CubeArray[0].length;j++){
               System.out.printf("%2s",CubeArray[i][j]);
           }
           System.out.println();
       }

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("CUBE> "); //m CLI 입력 표시
            System.out.println(br.readLine());

            br.close(); //m Close BufferedReader
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
