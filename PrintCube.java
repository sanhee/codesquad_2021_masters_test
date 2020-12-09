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
