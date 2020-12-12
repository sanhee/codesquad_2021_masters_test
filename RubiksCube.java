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
            case 5:
                PrintFirstOrLastCube();
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                break;

        }

    }


    private void PrintFirstOrLastCube() {

        StringBuilder strTemp = new StringBuilder();

        for(int i=0;i<this.CubeArray.length;i++) {
            for(int j=0;j<this.CubeArray[0].length;j++) {
                strTemp.append(CubeArray[i][j]);

                if(j>0 && j % 2 == 0){
                    System.out.printf("%20s",strTemp);
                    strTemp.delete(0,strTemp.length());
                }
            }
            System.out.println();
        }
    }


}
