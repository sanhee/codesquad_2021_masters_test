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

    private String CreateMiddleStr(int len, int j, String MiddleStr,String newMiddleStr){
        StringBuilder MiddleStrBuilder = new StringBuilder(MiddleStr);

        if(len>3 && j==0) { //m 중앙 두번째 큐브부터 공백을 만들기 위한 조건
            MiddleStrBuilder.append("\t\t").append(newMiddleStr).append(" ");
        }
        else{ //m 중앙 좌측 공백없는 첫번째 큐브를 만들기 위한 조건
            MiddleStrBuilder.append(newMiddleStr).append(" ");
        }

        MiddleStr = MiddleStrBuilder.toString();

        return MiddleStr;
    }

    private void CreateMiddleCube(){
        for(int i=0;i<this.CubeArray.length;i++) {
            for(int j=0;j<this.CubeArray[i].length;j++) {
                MiddleCubeStr[i] = CreateMiddleStr(MiddleCubeStr[i].length(), j, MiddleCubeStr[i], this.CubeArray[i][j]);
            }
        }
        if(MiddleCubeStr[0].length()>23){ //m 중앙 큐브의 컨텐츠가 모두 채워진 경우
            PrintMiddleCube(); //m 중앙부분 큐브 출력
        }
    }
    private void PrintMiddleCube() {
        for(int i=0;i<MiddleCubeStr.length;i++) {
            System.out.printf("%s",MiddleCubeStr[i]);
            System.out.println();
        }

    }


}
