package com.sanhee.step3;

public class RubiksCube {

    private String[][] CubeArray = new String[3][3];
    public static String[] MiddleCubeStr = new String[]{"","",""};

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
                CreateMiddleCube();
                break;

        }

    }


    private void PrintFirstOrLastCube() {

        StringBuilder strTemp = new StringBuilder();

        for(int i=0;i<this.CubeArray.length;i++) {
            for(int j=0;j<this.CubeArray[0].length;j++) {
                strTemp.append(CubeArray[i][j]+" ");

                if(j>0 && j % 2 == 0){
                    System.out.printf("%24s",strTemp);
                    strTemp.delete(0,strTemp.length());
                }
            }
            System.out.println();
        }
    }

    private String CreateStr(int len, int j, String str,String str2){
        StringBuilder strBuilder = new StringBuilder(str);

        if(len>3 && j==0)
        {
            strBuilder.append("\t\t").append(str2+" ");
        }
        else{
            strBuilder.append(str2+" ");
        }

        str = strBuilder.toString();


        return str;
    }

    private void CreateMiddleCube(){
        for(int i=0;i<this.CubeArray.length;i++) {
            for(int j=0;j<this.CubeArray[i].length;j++) {
                MiddleCubeStr[i] = CreateStr(MiddleCubeStr[i].length(), j, MiddleCubeStr[i], this.CubeArray[i][j]);
            }
        }
        if(MiddleCubeStr[0].length()>23){
            PrintMiddleCube();
        }
    }
    private void PrintMiddleCube() {
        for(int i=0;i<MiddleCubeStr.length;i++) {
            System.out.printf("%s",MiddleCubeStr[i]);
            System.out.println();
        }

    }


}
