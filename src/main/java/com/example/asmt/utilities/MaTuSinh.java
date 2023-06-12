package com.example.asmt.utilities;

public class MaTuSinh {
    public static String gen(String ma) {
        int last = (int) Math.floor((Math.random()) * 999999);
        if (last < 100000 && last >= 10000) {
            return ma + "0" + last;
        }
        if (last < 10000 && last >= 1000) {
            return ma + "00" + last;
        }
        if (last < 1000 && last >= 100) {
            return ma + "000" + last;
        }
        if (last < 100 && last >= 10) {
            return ma + "0000" + last;
        }
        if (last < 10) {
            return ma + "00000" + last;
        }

        return ma + last;

    }

}
