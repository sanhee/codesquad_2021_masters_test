package com.sanhee.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PushWord {

    public static void main(String[] args) {

        String[] KeyboardInput;  //m 입력 문자열 배열
        StringBuffer ShiftResult = new StringBuffer();
        int ShiftNum = 0;   //m 입력된 문자 이동 횟수
        String ShiftDirection = "";   //m 입력된 문자 이동 방향
        Boolean[] CheckDirection = {false,false}; //m 음수의 경우, 문자 이동 방향을 반대로 하기 위한 상태 불린

        //m 매직넘버를 없애기 위한 상수들
        final int LEFT = 0;  //m CheckDirection 불린 배열 구분자 역할
        final int RIGHT = 1;  //m CheckDirection 불린 배열 구분자 역할
        final int CONTENTS = 0; //m KeyboardInput 스트링 배열 구분자 역할
        final int SHIFT_TIME = 1; //m KeyboardInput 스트링 배열 구분자 역할
        final int SHIFT_DIRECTION = 2; //m KeyboardInput 스트링 배열 구분자 역할

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            KeyboardInput = br.readLine().split(" "); //m 공백 기준 입력값 짤라서 배열에 삽입

            ShiftResult.insert(0,KeyboardInput[CONTENTS]); //m 쉬프팅 할 문자열
            ShiftNum = Integer.parseInt(KeyboardInput[SHIFT_TIME]); //m 쉬프팅 횟수
            ShiftDirection = KeyboardInput[SHIFT_DIRECTION]; //m 쉬프팅 방향

            br.close(); //m Close BufferedReader
        } catch (IOException e) {
            e.printStackTrace();
        }

        //m 대소문자 상관없이 비교하는 equalsIgnoreCase() 메소드 사용
        CheckDirection[LEFT] = ShiftDirection.equalsIgnoreCase("L");
        CheckDirection[RIGHT] = ShiftDirection.equalsIgnoreCase("R");

        //m 쉬프트 횟수가 음수 일 경우, 방향 정보를 반대로 바꾸기 위한 조건문
        if(( (CheckDirection[LEFT] || CheckDirection[RIGHT]) && ShiftNum < 0)) {
            CheckDirection[RIGHT] = !CheckDirection[RIGHT]; //m 불린값 반전
            CheckDirection[LEFT] = !CheckDirection[LEFT]; //m 불린값 반전
            ShiftNum = Math.abs(ShiftNum); //m 음수 절대값으로 변환
        }
        //m 왼쪽 쉬프트인 경우
        if(CheckDirection[LEFT]) {
            for(int i=0; i<ShiftNum; i++){
                ShiftResult.append(ShiftResult.charAt(0));
                ShiftResult.deleteCharAt(0);
            }
        }
        //m 오른쪽 쉬프트인 경우
        else if(CheckDirection[RIGHT]) {
            for(int i=0; i<ShiftNum; i++){
                ShiftResult.insert(0, ShiftResult.charAt(ShiftResult.length() - 1));
                ShiftResult.deleteCharAt(ShiftResult.length()-1);
            }
        }
        System.out.println(ShiftResult); //m 쉬프팅 결과 출력
    }
}
