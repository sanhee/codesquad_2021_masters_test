package com.sanhee.step3;

public class RubiksCube {

    private String[][] CubeArray = new String[3][3];

    public RubiksCube(int tag){
        for(int i=0;i<this.CubeArray.length;i++) {
            for(int j=0;j<this.CubeArray[0].length;j++) {
                this.CubeArray[i][j] = String.format("%s",tag);
            }
        }
    }


    public void DisplayCube(int tag){

        switch (tag){
            case 0:
                PrintFirstCube();
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                PrintMiddleCube();
                break;
            case 5:
                PrintLastCube();
                break;

        }

    }



}
