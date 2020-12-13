package com.sanhee.step3;

public class RubiksCube {

    public static String[] MiddleCubeStr = new String[]{"","",""};
    public static String[][][] CopyCubeArray = new String[4][3][3];

    private String[][] CubeArray = new String[3][3];

    public void DisplayCube(int tag){

        switch (tag){
            case 0:
            case 5:
                CreateFirstOrLastStr();
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                CreateMiddleCube();
                break;

        }

    }

    public RubiksCube(int tag){
        for(int i=0;i<this.CubeArray.length;i++) {
            for(int j=0;j<this.CubeArray[0].length;j++) {
                this.CubeArray[i][j] = String.format("%s",TagToName(tag));
            }
        }
    }


    public void SetCubeFrontCW(int tag, boolean CopyUpdateCheck, RubiksCube[] CubeBoard){

        if (!CopyUpdateCheck) {
            CopyCubeArray[0] = GetCubeContents(CubeBoard[1]);
            CopyCubeArray[1] = GetCubeContents(CubeBoard[5]);
            CopyCubeArray[2] = GetCubeContents(CubeBoard[0]);
            CopyCubeArray[3] = GetCubeContents(CubeBoard[3]);
        }

        if (tag == 0 ){
            this.CubeArray[2][0] = CopyCubeArray[0][2][2];
            this.CubeArray[2][1] = CopyCubeArray[0][1][2];
            this.CubeArray[2][2] = CopyCubeArray[0][0][2];
        }
        else if (tag == 1 ){
            this.CubeArray[0][2] = CopyCubeArray[1][0][0];
            this.CubeArray[1][2] = CopyCubeArray[1][0][1];
            this.CubeArray[2][2] = CopyCubeArray[1][0][2];
        }
        else if (tag == 3 ){
            this.CubeArray[0][0] = CopyCubeArray[2][2][0];
            this.CubeArray[1][0] = CopyCubeArray[2][2][1];
            this.CubeArray[2][0] = CopyCubeArray[2][2][2];
        }
        else if (tag == 5){
            this.CubeArray[0][0] = CopyCubeArray[3][2][0];
            this.CubeArray[0][1] = CopyCubeArray[3][1][0];
            this.CubeArray[0][2] = CopyCubeArray[3][0][0];
        }


    }

    public void SetCubeFrontCCW(int tag, boolean CopyUpdateCheck, RubiksCube[] CubeBoard){

        if (!CopyUpdateCheck) {
            CopyCubeArray[0] = GetCubeContents(CubeBoard[3]);
            CopyCubeArray[1] = GetCubeContents(CubeBoard[0]);
            CopyCubeArray[2] = GetCubeContents(CubeBoard[5]);
            CopyCubeArray[3] = GetCubeContents(CubeBoard[1]);
        }

        if (tag == 0 ){
            this.CubeArray[2][0] = CopyCubeArray[0][0][0];
            this.CubeArray[2][1] = CopyCubeArray[0][1][0];
            this.CubeArray[2][2] = CopyCubeArray[0][2][0];
        }
        else if (tag == 1 ){
            this.CubeArray[0][2] = CopyCubeArray[1][2][2];
            this.CubeArray[1][2] = CopyCubeArray[1][2][1];
            this.CubeArray[2][2] = CopyCubeArray[1][2][0];
        }
        else if (tag == 3 ){
            this.CubeArray[0][0] = CopyCubeArray[2][0][2];
            this.CubeArray[1][0] = CopyCubeArray[2][0][1];
            this.CubeArray[2][0] = CopyCubeArray[2][0][0];
        }
        else if (tag == 5){
            this.CubeArray[0][0] = CopyCubeArray[3][0][2];
            this.CubeArray[0][1] = CopyCubeArray[3][1][2];
            this.CubeArray[0][2] = CopyCubeArray[3][2][2];
        }


    }


    private String[][] GetCubeContents(RubiksCube CubeBoard){

        String[][] copyCube = new String[3][3];

        for (int i = 0; i < CubeBoard.CubeArray.length; i++) {
            for (int j = 0; j < CubeBoard.CubeArray[i].length; j++) {
                copyCube[i][j] = CubeBoard.CubeArray[i][j];
            }
        }

        return copyCube;
    }

    private String TagToName(int tag){ //m 처음 큐브 객체 생성시 태그를 기준으로 엘리먼트의 이름을 지정

        StringBuilder Name = new StringBuilder();

        switch (tag){
            case 0:
                Name.append("B");
                break;
            case 1:
                Name.append("W");
                break;
            case 2:
                Name.append("O");
                break;
            case 3:
                Name.append("G");
                break;
            case 4:
                Name.append("Y");
                break;
            case 5:
                Name.append("R");
                break;
        }

        return Name.toString();
    }


    private void PrintFirstOrLastCube(StringBuilder strTemp, int j){
        if(j>0 && j % 2 == 0){
            System.out.printf("%24s",strTemp);
            strTemp.delete(0,strTemp.length());
        }
    }

    private void CreateFirstOrLastStr() {

        StringBuilder strTemp = new StringBuilder();

        for(int i=0;i<this.CubeArray.length;i++) {
            for(int j=0;j<this.CubeArray[0].length;j++) {
                strTemp.append(CubeArray[i][j]).append(" ");
                PrintFirstOrLastCube(strTemp,j);
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
        if(MiddleCubeStr[0].length()>29){ //m 중앙 큐브의 컨텐츠가 모두 채워진 경우
            PrintMiddleCube(); //m 중앙부분 큐브 출력
            MiddleCubeStr = new String[]{"","",""};
        }
    }
    public void PrintMiddleCube() {
        for(int i=0;i<MiddleCubeStr.length;i++) {
            System.out.printf("%s",MiddleCubeStr[i]);
            System.out.println();
        }

    }


}
