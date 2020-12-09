package com.sanhee.step2;

public class PrintCube {

    private String[][] CubeArray;
    private int ShiftType;
    private int ShiftDirection;

    public PrintCube(){

        CubeArray = new String[][]{
                {"R", "R", "W"},   //m 00 01 02
                {"G", "C", "W"},   //m 10 11 12
                {"G", "B", "B"}    //m 20 21 22
        };
        PrintCube();

    }
    public void SetShiftType(String ShiftType){

        //m 매직넘버를 없애기 위한 상수 (추후, enum으로 변경할 것)
        int ROW = 1;
        int COL = 2;
        int UP = -1;
        int DOWN = 1;
        int LEFT = -1;
        int RIGHT = 1;

        switch (ShiftType){
            case "U`":
            case "B":
                this.ShiftDirection = RIGHT; //m 오른쪽 이동
                this.ShiftType = ROW;
                break;
            case "L":
            case "R`":
                this.ShiftDirection = DOWN; //m 아래쪽 이동
                this.ShiftType = COL;
                break;

            case "U":
            case "B`":
                this.ShiftDirection = LEFT; //m 왼쪽 이동
                this.ShiftType = ROW;
                break;
            case "L`":
            case "R":
                this.ShiftDirection = UP; //m 위쪽 이동
                this.ShiftType = COL;
                break;
            default:
                break;
        }

    }

    public void PrintCube(){

        for(int i=0;i<this.CubeArray.length;i++)
        {
            for(int j=0;j<this.CubeArray[0].length;j++)
            {
                System.out.printf("%2s",this.CubeArray[i][j]);
            }
            System.out.println();
        }
    }
}
