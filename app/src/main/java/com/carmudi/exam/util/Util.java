package com.carmudi.exam.util;

/**
 * Created by cicciolina on 5/18/18.
 */

public class Util {

    private static Util instance;

    private Util() {}

    public static Util getInstance() {

        if (instance == null) {
            instance = new Util();
        }


        return instance;
    }

    public  String withSuffix(double count) {
        if (count < 1000) return "" + count;
        int exp = (int) (Math.log(count) / Math.log(1000));
        return String.format("%.1f %c",
                count / Math.pow(1000, exp),
                "kMGTPE".charAt(exp-1));
    }
}
