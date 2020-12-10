package com.sanhee.step2;

public class PrintCube {

    private String[][] CubeArray;

    public PrintCube(){            //m 생성자 함수
        CubeArray = new String[][]{
                {"R", "R", "W"},   //m 00 01 02
                {"G", "C", "W"},   //m 10 11 12
                {"G", "B", "B"}    //m 20 21 22
        };
        DisplayAll();
    }

    public void SetShiftType(String InputCommand){ //m 입력된 명령어에 따라 배열 쉬프트 방향을 결정하는 함수

        System.out.println(InputCommand);

        //m 매직넘버를 없애기 위한 상수
        final int ROW = 1;
        final int COL = 2;
        final int UP = -1;
        final int DOWN = 1;
        final int LEFT = -1;
        final int RIGHT = 1;

        switch (InputCommand){
            case "U`":
            case "B":
                SetCubeArray(InputCommand, RIGHT, ROW);
                break;
            case "L":
            case "R`":
                SetCubeArray(InputCommand, DOWN, COL);
                break;
            case "U":
            case "B`":
                SetCubeArray(InputCommand, LEFT, ROW);
                break;
            case "L`":
            case "R":
                SetCubeArray(InputCommand, UP, COL);
                break;
        }

    }

    public String[][] CopyCubeArray(String[][] tempArray){ //m 큐뷰를 임시 배열에 복사하는 함수
        for(int i=0;i<this.CubeArray.length;i++) {
            for(int j=0;j<this.CubeArray[0].length;j++) {
                 tempArray[i][j] = this.CubeArray[i][j];
            }
        }
        return tempArray;
    }

    public void SetCubeArray(String InputCommand, int ShiftDirection, int ShiftType){ //m 큐브 데이터를 수정하는 함수

        final int ROW = 1; //m ShiftType 구분자 상수
        final int COL = 2; //m ShiftType 구분자 상수

        int ShiftPosCalculate; //m 값이 쉬프트 될 배열 위치를 담는 변수
        String[][] tempArray = CopyCubeArray(new String[3][3]); //m 큐브 데이터 임시 배열에 복사
        Boolean RowColMaxCheck = (InputCommand.equals("B") || InputCommand.equals("B`") || InputCommand.equals("R") || InputCommand.equals("R`"));
        int FixPos= RowColMaxCheck ? 2 : 0;

        switch (ShiftType){
            case ROW:
                for(int i=0;i<this.CubeArray.length;i++){
                    ShiftPosCalculate = i+ShiftDirection > 2 ? 0 : i+ShiftDirection < 0  ? 2 : i+ShiftDirection;
                    this.CubeArray[FixPos][ShiftPosCalculate] = tempArray[FixPos][i];
                }
                break;
            case COL:
                for(int i=0;i<this.CubeArray[0].length;i++){
                    ShiftPosCalculate = i+ShiftDirection > 2 ? 0 : i+ShiftDirection < 0 ? 2 : i+ShiftDirection;
                    this.CubeArray[ShiftPosCalculate][FixPos] = tempArray[i][FixPos];
                }
                break;
        }

    }

    public void DisplayAll(){

        for(int i=0;i<this.CubeArray.length;i++) {
            for(int j=0;j<this.CubeArray[0].length;j++) {
                System.out.printf("%2s",this.CubeArray[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
