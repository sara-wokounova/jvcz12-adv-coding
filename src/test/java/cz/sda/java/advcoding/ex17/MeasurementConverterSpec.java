package cz.sda.java.advcoding.ex17;

import org.junit.jupiter.api.Test;

class MeasurementConverterSpec {
    @Test
    void checksConvertMetersToYards() {
        assert MeasurementConverter.convert(1, ConversionType.METERS_TO_YARDS) == 1.09361;
        assert MeasurementConverter.convert(10, ConversionType.METERS_TO_YARDS) == 10.9361;
        assert Math.round(MeasurementConverter.convert(100, ConversionType.METERS_TO_YARDS)) == Math.round(109.361);
    }

    @Test
    void checksConvertYardsToMeters() {
        assert Math.round(MeasurementConverter.convert(1000, ConversionType.YARDS_TO_METERS)) == Math.round(914.4);
    }

    @Test
    void checksConvertCentimetersToInches() {
        assert Math.round(MeasurementConverter.convert(1000, ConversionType.CENTIMETERS_TO_ICHES)) == Math.round(393.701);
    }

    @Test
    void checksConvertInchesToCentimeters() {
        assert Math.round(MeasurementConverter.convert(1000, ConversionType.INCHES_TO_CENTIMETERS)) == 2540;
    }

    @Test
    void checksConvertKilometersToMiles() {
        assert Math.round(MeasurementConverter.convert(1000, ConversionType.KILOMETERS_TO_MILES)) == 621;
    }

    @Test
    void checksConvertMilesToKilometers() {
        assert Math.round(MeasurementConverter.convert(1000, ConversionType.MILES_TO_KILOMETERS)) == 1609;
    }
}
