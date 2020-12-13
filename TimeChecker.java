package com.sanhee.step3;

public class TimeChecker{

    private long startTime;
    private long endTime;
    private long elapsedTime;

    public void setStartTime(){
        startTime = System.currentTimeMillis();
    }

    public void setEndTime(){
        endTime = System.currentTimeMillis();
    }


    public double elapsedTime(){
        elapsedTime = endTime - startTime;
        return elapsedTime/1000.0;
    }

}
