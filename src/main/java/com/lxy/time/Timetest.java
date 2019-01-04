package com.lxy.time;

import java.time.Clock;

public class Timetest {
    public static void main(String[] args) {
        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());
    }
}
