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
        String[] InputStr;  //m 입력 문자열
        int ShiftNum = 0;   //m 입력된 문자 이동 횟수
        String ShiftDirection = "";   //m 입력된 문자 이동 방향
        Boolean[] CheckDirection = {false,false}; //m 음수의 경우, 문자 이동 방향을 반대로 하기 위한 상태 불린
        final int LEFT = 0; //m 매직넘버를 없애기 위한, 상수로 CheckDirection 불린 배열의 방향을 표시함.
        final int RIGHT = 1;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            InputStr = br.readLine().split(" ");
            br.close(); //m Close BufferReader

            ShiftStr.insert(0,InputStr[0]);
            ShiftNum = Integer.parseInt(InputStr[1]);
            ShiftDirection = InputStr[2];

            CheckDirection[LEFT] = ShiftDirection.equalsIgnoreCase("L");  //m 대소문자 상관없이 비교하는 equalsIgnoreCase() 메소드 사용
            CheckDirection[RIGHT] = ShiftDirection.equalsIgnoreCase("R");

            //m 쉬프트 횟수가 음수 일 경우, 방향 정보를 반대로 바꾸기 위한 조건문
            if(( (CheckDirection[LEFT] || CheckDirection[RIGHT]) && ShiftNum < 0)) {
                CheckDirection[RIGHT] = !CheckDirection[RIGHT]; //m 불린값 반전
                CheckDirection[LEFT] = !CheckDirection[LEFT]; //m 불린값 반전
                ShiftNum = Math.abs(ShiftNum);
            }

            //m 방향에 따른 조건문 형식
            if(CheckDirection[LEFT]) { //m 왼쪽 쉬프트인 경우
                for(int i=0; i<ShiftNum; i++){
                   ShiftStr.append(ShiftStr.charAt(0));
                   ShiftStr.deleteCharAt(0);
                }
            }
            else if(CheckDirection[RIGHT]) { //m 오른쪽 쉬프트인 경우
                for(int i=0; i<ShiftNum; i++){
                   ShiftStr.insert(0, ShiftStr.charAt(ShiftStr.length() - 1));
                   ShiftStr.deleteCharAt(ShiftStr.length()-1);
                }
            }
            System.out.println(ShiftStr);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
