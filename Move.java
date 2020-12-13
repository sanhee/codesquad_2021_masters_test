package com.sanhee.step3;

public class Move {

    public void CubeElements(RubiksCube[] CubeBoard, String KeyInputCommand){

        switch (KeyInputCommand){
            case "F":
                ReadyFrontClockWise(CubeBoard);
                break;
        }
    }


    private void ReadyFrontClockWise(RubiksCube[] CubeBoard){
      CubeBoard[0].SetCubeFrontCW(0,false,CubeBoard);
      CubeBoard[1].SetCubeFrontCW(1,true,CubeBoard);
      CubeBoard[3].SetCubeFrontCW(3,true,CubeBoard);
      CubeBoard[5].SetCubeFrontCW(5,true,CubeBoard);
    }

}
