package com.cvc.challenge.utils;

public class CalcUtils {

    public static Double stay(Double rate, int days, Double commission, Integer people) {
         return ((rate * days) * people) / 0.7;
    }

}
