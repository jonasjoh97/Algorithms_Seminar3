package com.company;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Timer {

    private long startTime, stopTime;
    private final NumberFormat formatter = new DecimalFormat("#0.000000000");

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        stopTime = System.nanoTime();
    }

    @Override
    public String toString() {                                                   //Returns second as Output
        return formatter.format((stopTime - startTime) / 1000000000d);
    }

    public long getTime() {                                                      //Returns nanoseconds
        return stopTime - startTime;
    }

    //additions to given code

    public String getTimeinSec() {
        return this + " sec";
    }

}
