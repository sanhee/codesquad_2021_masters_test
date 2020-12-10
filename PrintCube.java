package com.sanhee.step2;

public class PrintCube {

    private String[][] CubeArray;

    public PrintCube(){
        CubeArray = new String[][]{
                {"R", "R", "W"},   //m 00 01 02
                {"G", "C", "W"},   //m 10 11 12
                {"G", "B", "B"}    //m 20 21 22
        };
        PrintCube();
    }

    public void SetShiftType(String InputCommand){

        //m 매직넘버를 없애기 위한 상수 (추후, enum으로 변경할 것)
        int ROW = 1;
        int COL = 2;
        int UP = -1;
        int DOWN = 1;
        int LEFT = -1;
        int RIGHT = 1;

        switch (InputCommand){
            case "U`":
                SetCubeArray(0, RIGHT, ROW);
                break;
            case "B":
                SetCubeArray(2, RIGHT, ROW);
                break;
            case "L":
                SetCubeArray(0, DOWN, COL);
                break;
            case "R`":
                SetCubeArray(2, DOWN, COL);
                break;
            case "U":
                SetCubeArray(0, LEFT, ROW);
                break;
            case "B`":
                SetCubeArray(2, LEFT, ROW);
                break;
            case "L`":
                SetCubeArray(0, UP, COL);
                break;
            case "R":
                SetCubeArray(2, UP, COL);
                break;
        }

    }

    public String[][] CopyCubeArray(String[][] tempArray){
        for(int i=0;i<this.CubeArray.length;i++) {
            for(int j=0;j<this.CubeArray[0].length;j++) {
                 tempArray[i][j] = this.CubeArray[i][j];
            }
        }
        return tempArray;
    }

    public void SetCubeArray(int fixNum, int ShiftDirection, int ShiftType){

        final int ROW = 1;
        final int COL = 2;

        int cnt;
        String[][] tempArray = CopyCubeArray(new String[3][3]);

        switch (ShiftType){
            case ROW:
                for(int i=0;i<this.CubeArray.length;i++){
                    cnt = i+ShiftDirection > 2 ? 0 : i+ShiftDirection < 0  ? 2 : i+ShiftDirection;
                    this.CubeArray[fixNum][cnt] = tempArray[fixNum][i];
                }
                break;
            case COL:
                for(int i=0;i<this.CubeArray[0].length;i++){
                    cnt = i+ShiftDirection > 2 ? 0 : i+ShiftDirection < 0 ? 2 : i+ShiftDirection;
                    this.CubeArray[cnt][fixNum] = tempArray[i][fixNum];
                }
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
