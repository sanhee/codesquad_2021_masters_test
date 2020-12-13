# 2021 마스터즈 코스 테스트 3단계

### 루빅스 큐브 구현하기

1. [참고 링크](https://cube3x3.com/%ED%81%90%EB%B8%8C%EB%A5%BC-%EB%A7%9E%EC%B6%94%EB%8A%94-%EB%B0%A9/#notation)를 참고해서 루빅스 큐브를 구현한다.
2. 큐브는 W, B, G, Y, O, R의 6가지 색깔을 가지고 있다.
3. 입력: 각 조작법을 한 줄로 입력받는다.
4. 출력: 큐브의 6면을 펼친 상태로 출력한다.
5. Q를 입력받으면 프로그램을 종료하고, 조작 받은 명령의 갯수를 출력시킨다.

### 요구사항
> - 가능한 한 커밋을 자주 하고 구현의 의미가 명확하게 전달되도록 커밋 메시지를 작성할 것
> - 함수나 메소드는 한 번에 한 가지 일을 하고 가능하면 20줄이 넘지 않도록 구현한다.
> - 함수나 메소드의 들여쓰기를 가능하면 적게(3단계까지만) 할 수 있도록 노력해 본다

### 해결과정

|초기상태 ( 2차원 배열 X 6개 )|
|--|
|![](https://i.imgur.com/88U8Jua.png)|

|F|F`|
|--|--|
|![](https://i.imgur.com/xGdTsz8.png)|![](https://i.imgur.com/Ri92jYA.png)|

|R|R`|
|--|--|
|![](https://i.imgur.com/O03Ex0J.png)|![](https://i.imgur.com/cG6ttAb.png)|


|U|U`|
|--|--|
|![](https://i.imgur.com/JNpgeJZ.png)|![](https://i.imgur.com/i19cbeo.png)|

|B|B`|
|--|--|
|![](https://i.imgur.com/mRFSo0V.png)|![](https://i.imgur.com/htaD81K.png)|

|L|L`|
|--|--|
|![](https://i.imgur.com/ApRhftT.png)|![](https://i.imgur.com/OaDBb1w.png)|

|D|D`|
|--|--|
|![](https://i.imgur.com/vzHjdEx.png)|![](https://i.imgur.com/UhEzMoi.png)|

### 실행결과 ( 중간과정 임시 출력 )
|FRR'U2R | * (무작위 출력)|
|--|--|
|![](https://i.imgur.com/uMp58SM.gif)|![](https://i.imgur.com/fsNBS40.gif)|

