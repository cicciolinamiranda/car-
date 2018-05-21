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

    public String truncateNumber(double doubleNumber, boolean isOneLetterOnly) {
        float million = 1000000L;
        float billion = 1000000000L;
        float trillion = 1000000000000L;
        float number = Math.round(doubleNumber);
        if ((number >= million) && (number < billion) && isOneLetterOnly) {
            float fraction = calculateFraction(number, million);
            return Float.toString(fraction) + "M";
        }
        else if ((number >= million) && (number < billion) && !isOneLetterOnly) {
            float fraction = calculateFraction(number, million);
            return Float.toString(fraction) + "mil";
        }
        else if ((number >= billion) && (number < trillion) && isOneLetterOnly) {
            float fraction = calculateFraction(number, billion);
            return Float.toString(fraction) + "B";
        }
        else if ((number >= billion) && (number < trillion) && !isOneLetterOnly) {
            float fraction = calculateFraction(number, billion);
            return Float.toString(fraction) + "bil";
        }

        return Float.toString(number);
    }

    public float calculateFraction(double number, double divisor) {
        double truncate = (number * 10L + (divisor / 2L)) / divisor;
        float fraction = (float) truncate * 0.10F;
        return fraction;
    }
}
