package org.training;

public class Calculation {

    public static double toMillimeters(double original) {
        if (!notZero(original)) {
            return 0;
        }
        return original * 10;
    }

    public static double toMeters(double original) {
        if (!notZero(original)) {
            return 0;
        }
        return original / 100;
    }

    public static double toKilometers(double original) {
        if (!notZero(original)) {
            return 0;
        }
        return original / 10000;
    }

    private static boolean notZero(double original) {
        if (original <= 0.0) {
            System.out.println("Число должно быть > 0");
            return false;
        }
        return true;
    }
}
