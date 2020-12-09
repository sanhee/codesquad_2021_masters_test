package com.sanhee.step2;

public class PrintCube {

    private String[][] CubeArray;
    private int ShiftType;
    private int ShiftDirection;
    private String InputCommand;
    private final int ROW = 1;
    private final int COL = 2;
    private int fixNum = 0;
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

        int UP = -1;
        int DOWN = 1;
        int LEFT = -1;
        int RIGHT = 1;
        this.InputCommand = InputCommand;

        switch (this.InputCommand){
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

    public void SetCubeArray(){
        int cnt = 0;
        String[][] tempArray = new String[3][3];

        for(int i=0;i<this.CubeArray.length;i++)
        {
            for(int j=0;j<this.CubeArray[0].length;j++)
            {
                tempArray[i][j] = this.CubeArray[i][j];
            }
        }


        if(this.InputCommand.equals("B") || this.InputCommand.equals("B`")  || this.InputCommand.equals("R")  || this.InputCommand.equals("R`") )
        {
            fixNum = 2;
        }
        else
        {
            fixNum = 0;
        }

        switch (this.ShiftType){

            case ROW:
                for(int i=0;i<this.CubeArray.length;i++){
                    cnt = i+this.ShiftDirection > 2 ? 0 : i+this.ShiftDirection < 0  ? 2 : i+this.ShiftDirection;
                    this.CubeArray[fixNum][cnt] = tempArray[fixNum][i];
                }
                break;
            case COL:
                for(int i=0;i<this.CubeArray[0].length;i++){
                    cnt = i+this.ShiftDirection > 2 ? 0 : i+this.ShiftDirection < 0 ? 2 : i+this.ShiftDirection;
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
