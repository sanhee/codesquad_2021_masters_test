package com.sanhee.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 입력: 사용자로부터 단어 하나, 정수 숫자 하나( -100 <= N < 100) , L 또는 R을 입력받는다. L 또는 R은 대소문자 모두 입력 가능하다.
 * 주어진 단어를 L이면 주어진 숫자 갯수만큼 왼쪽으로, R이면 오른쪽으로 밀어낸다.
 * 밀려나간 단어는 반대쪽으로 채워진다.
 */
public class PushWord {

    public static void main(String[] args) {

        StringBuffer ShiftStr = new StringBuffer();
        int ShiftNum = 0;
        String ShiftDirection = "";

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] InputStr = br.readLine().split(" ");

            ShiftStr.insert(0,InputStr[0]);
            ShiftNum = Integer.parseInt(InputStr[1]);
            ShiftDirection = InputStr[2];


            System.out.println(ShiftStr);
            System.out.println(ShiftNum);
            System.out.println(ShiftDirection);

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
