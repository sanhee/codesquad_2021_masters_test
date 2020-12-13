package com.sanhee.step3;

public class Move {

    public void CubeElements(RubiksCube[] CubeBoard, String KeyInputCommand){

        switch (KeyInputCommand){
            case "F":
                ReadyFrontClockWise(CubeBoard);
                break;
            case "F`":
                ReadyFrontInverted(CubeBoard);
                break;
            case "R":
                ReadyRightClockWise(CubeBoard);
                break;
            case "R`":
                ReadyRightInverted(CubeBoard);
                break;
        }
    }


    private void ReadyFrontClockWise(RubiksCube[] CubeBoard){
      CubeBoard[0].SetCubeFrontCW(0,false,CubeBoard);
      CubeBoard[1].SetCubeFrontCW(1,true,CubeBoard);
      CubeBoard[3].SetCubeFrontCW(3,true,CubeBoard);
      CubeBoard[5].SetCubeFrontCW(5,true,CubeBoard);
    }

    private void ReadyFrontInverted(RubiksCube[] CubeBoard){
      CubeBoard[0].SetCubeFrontCCW(0,false,CubeBoard);
      CubeBoard[1].SetCubeFrontCCW(1,true,CubeBoard);
      CubeBoard[3].SetCubeFrontCCW(3,true,CubeBoard);
      CubeBoard[5].SetCubeFrontCCW(5,true,CubeBoard);
    }

    private void ReadyRightClockWise(RubiksCube[] CubeBoard){
        CubeBoard[0].SetCubeRightCW(0,false,CubeBoard);
        CubeBoard[2].SetCubeRightCW(2,true,CubeBoard);
        CubeBoard[4].SetCubeRightCW(4,true,CubeBoard);
        CubeBoard[5].SetCubeRightCW(5,true,CubeBoard);
    }
    private void ReadyRightInverted(RubiksCube[] CubeBoard){
        CubeBoard[0].SetCubeRightCCW(0,false,CubeBoard);
        CubeBoard[2].SetCubeRightCCW(2,true,CubeBoard);
        CubeBoard[4].SetCubeRightCCW(4,true,CubeBoard);
        CubeBoard[5].SetCubeRightCCW(5,true,CubeBoard);
    }

}
