# 2021 마스터즈 코스 테스트 1단계

### 단어 밀어내기 구현하기

1. 입력: 사용자로부터 단어 하나, 정수 숫자 하나( -100 <= N < 100) , L 또는 R을 입력받는다. L 또는 R은 대소문자 모두 입력 가능하다.
2. 주어진 단어를 L이면 주어진 숫자 갯수만큼 왼쪽으로, R이면 오른쪽으로 밀어낸다.
3. 밀려나간 단어는 반대쪽으로 채워진다.

### 요구사항
> 컴파일 및 실행되지 않을 경우 불합격
> 자기만의 기준으로 최대한 간결하게 코드를 작성한다.

### 핵심코드
```java
  // mutable class로 자유롭게 인스턴스의 값을 변경하기 위해 사용
  StringBuffer ShiftStr = new StringBuffer(); 
  
  ...
  //m 쉬프트 횟수가 음수 일 경우, 방향 정보를 반대로 바꾸기 위한 조건문
        if(ShiftNum < 0) {
            CheckDirection[RIGHT] = !CheckDirection[RIGHT]; //m 불린값 반전
            CheckDirection[LEFT] = !CheckDirection[LEFT]; //m 불린값 반전
            ShiftNum = Math.abs(ShiftNum); //m 음수 절대값으로 변환
        }
  ...
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
````

### 실행결과 ( 중간과정 임시 출력 )
|carror -1 r|banana 6 R|
|--|--|
|![](https://i.imgur.com/7YrsrQX.png)|![](https://i.imgur.com/PD8jCmk.png)|

|apple 3 L|cat -4 R|
|--|--|
|![](https://i.imgur.com/TkmkuEa.png)|![](https://i.imgur.com/uN2TK69.png)|

