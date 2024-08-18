package cz.sda.java.advcoding.ex17;

class MeasurementConverter {
    public static double convert(int value, ConversionType
            conversionType) {
        return switch (conversionType) {
            case METERS_TO_YARDS -> value * 1.09361d;
            case YARDS_TO_METERS -> value / 1.09361d;
            case CENTIMETERS_TO_ICHES -> value / 2.54d;
            case INCHES_TO_CENTIMETERS -> value * 2.54d;
            case KILOMETERS_TO_MILES -> value / 1.60934d;
            case MILES_TO_KILOMETERS -> value * 1.60934d;
        };
    }
}
