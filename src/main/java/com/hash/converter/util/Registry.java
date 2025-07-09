package com.hash.converter.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Registry {
    public final static Map<Units, Unit> map = new HashMap<>();

    static {
        // LENGTH
        map.put(Units.KILOMETER, new Unit(Types.LENGTH, Units.KILOMETER, "km", x -> x * 1000, x -> x / 1000));
        map.put(Units.METER, new Unit(Types.LENGTH, Units.METER, "m", x -> x, x -> x));
        map.put(Units.DECIMETER, new Unit(Types.LENGTH, Units.DECIMETER, "dm", x -> x / 10, x -> x * 10));
        map.put(Units.CENTIMETER, new Unit(Types.LENGTH, Units.CENTIMETER, "cm", x -> x / 100, x -> x * 100));
        map.put(Units.MILLIMETER, new Unit(Types.LENGTH, Units.MILLIMETER, "mm", x -> x / 1000, x -> x * 1000));
        map.put(Units.MICROMETER, new Unit(Types.LENGTH, Units.MICROMETER, "μm", x -> x / 1_000_000, x -> x * 1_000_000));
        map.put(Units.NANOMETER, new Unit(Types.LENGTH, Units.NANOMETER, "nm", x -> x / 1_000_000_000, x -> x * 1_000_000_000));
        map.put(Units.PICOMETER, new Unit(Types.LENGTH, Units.PICOMETER, "pm", x -> x / 1e12, x -> x * 1e12));

        map.put(Units.LIGHT_YEAR, new Unit(Types.LENGTH, Units.LIGHT_YEAR, "ly", x -> x * 9.4607e15, x -> x / 9.4607e15));
        map.put(Units.PARSEC, new Unit(Types.LENGTH, Units.PARSEC, "pc", x -> x * 3.0857e16, x -> x / 3.0857e16));
        map.put(Units.LUNAR_DISTANCE, new Unit(Types.LENGTH, Units.LUNAR_DISTANCE, "LD", x -> x * 384_400_000, x -> x / 384_400_000));
        map.put(Units.ASTRONOMICAL_UNIT, new Unit(Types.LENGTH, Units.ASTRONOMICAL_UNIT, "AU", x -> x * 1.496e11, x -> x / 1.496e11));

        map.put(Units.INCH, new Unit(Types.LENGTH, Units.INCH, "in", x -> x * 0.0254, x -> x / 0.0254));
        map.put(Units.FOOT, new Unit(Types.LENGTH, Units.FOOT, "ft", x -> x * 0.3048, x -> x / 0.3048));
        map.put(Units.YARD, new Unit(Types.LENGTH, Units.YARD, "yd", x -> x * 0.9144, x -> x / 0.9144));
        map.put(Units.MILE, new Unit(Types.LENGTH, Units.MILE, "mi", x -> x * 1609.344, x -> x / 1609.344));
        map.put(Units.NAUTICAL_MILE, new Unit(Types.LENGTH, Units.NAUTICAL_MILE, "nmi", x -> x * 1852, x -> x / 1852));
        map.put(Units.FATHOM, new Unit(Types.LENGTH, Units.FATHOM, "fm", x -> x * 1.8288, x -> x / 1.8288));
        map.put(Units.FURLONG, new Unit(Types.LENGTH, Units.FURLONG, "fur", x -> x * 201.168, x -> x / 201.168));


        // AREA
        map.put(Units.SQUARE_KILOMETER,  new Unit(Types.AREA, Units.SQUARE_KILOMETER, "km²", x -> x * 1_000_000, x -> x / 1_000_000));
        map.put(Units.HECTARE,           new Unit(Types.AREA, Units.HECTARE, "ha",   x -> x * 10_000,     x -> x / 10_000));
        map.put(Units.ARE,               new Unit(Types.AREA, Units.ARE, "a",         x -> x * 100,        x -> x / 100));
        map.put(Units.SQUARE_METER,      new Unit(Types.AREA, Units.SQUARE_METER, "m²", x -> x,            x -> x));
        map.put(Units.SQUARE_DECIMETER,  new Unit(Types.AREA, Units.SQUARE_DECIMETER, "dm²", x -> x / 100, x -> x * 100));
        map.put(Units.SQUARE_CENTIMETER, new Unit(Types.AREA, Units.SQUARE_CENTIMETER, "cm²", x -> x / 10_000, x -> x * 10_000));
        map.put(Units.SQUARE_MILLIMETER, new Unit(Types.AREA, Units.SQUARE_MILLIMETER, "mm²", x -> x / 1_000_000, x -> x * 1_000_000));

        map.put(Units.ACRE,              new Unit(Types.AREA, Units.ACRE, "ac",       x -> x * 4046.8564224, x -> x / 4046.8564224));
        map.put(Units.SQUARE_MILE,       new Unit(Types.AREA, Units.SQUARE_MILE, "mi²", x -> x * 2_589_988.110336, x -> x / 2_589_988.110336));
        map.put(Units.SQUARE_YARD,       new Unit(Types.AREA, Units.SQUARE_YARD, "yd²", x -> x * 0.83612736, x -> x / 0.83612736));
        map.put(Units.SQUARE_FOOT,       new Unit(Types.AREA, Units.SQUARE_FOOT, "ft²", x -> x * 0.09290304, x -> x / 0.09290304));
        map.put(Units.SQUARE_INCH,       new Unit(Types.AREA, Units.SQUARE_INCH, "in²", x -> x * 0.00064516, x -> x / 0.00064516));
        map.put(Units.ROOD,              new Unit(Types.AREA, Units.ROOD, "rd²",       x -> x * 1_011.7141056, x -> x / 1_011.7141056));


        // VOLUME
        map.put(Units.CUBIC_METER,    new Unit(Types.VOLUME, Units.CUBIC_METER, "m³", x -> x, x -> x));
        map.put(Units.HECTOLITER,     new Unit(Types.VOLUME, Units.HECTOLITER, "hl", x -> x / 10, x -> x * 10));
        map.put(Units.DECILITER,      new Unit(Types.VOLUME, Units.DECILITER, "dl", x -> x / 10_000, x -> x * 10_000));
        map.put(Units.LITER,          new Unit(Types.VOLUME, Units.LITER, "L", x -> x / 1_000, x -> x * 1_000));
        map.put(Units.CENTILITER,     new Unit(Types.VOLUME, Units.CENTILITER, "cl", x -> x / 100_000, x -> x * 100_000));
        map.put(Units.MILLILITER,     new Unit(Types.VOLUME, Units.MILLILITER, "mL", x -> x / 1_000_000, x -> x * 1_000_000));
        map.put(Units.CUBIC_DECIMETER,new Unit(Types.VOLUME, Units.CUBIC_DECIMETER, "dm³", x -> x / 1_000, x -> x * 1_000));
        map.put(Units.CUBIC_CENTIMETER,new Unit(Types.VOLUME, Units.CUBIC_CENTIMETER, "cm³", x -> x / 1_000_000, x -> x * 1_000_000));

        map.put(Units.CUBIC_INCH,     new Unit(Types.VOLUME, Units.CUBIC_INCH, "in³", x -> x * 0.000016387064, x -> x / 0.000016387064));
        map.put(Units.CUBIC_FOOT,     new Unit(Types.VOLUME, Units.CUBIC_FOOT, "ft³", x -> x * 0.028316846592, x -> x / 0.028316846592));
        map.put(Units.CUBIC_YARD,     new Unit(Types.VOLUME, Units.CUBIC_YARD, "yd³", x -> x * 0.764554857984, x -> x / 0.764554857984));
        map.put(Units.ACRE_FOOT,      new Unit(Types.VOLUME, Units.ACRE_FOOT, "ac·ft", x -> x * 1233.48183754752, x -> x / 1233.48183754752)); // 1 ac·ft = 1233.48183754752 m³

        map.put(Units.GALLON,         new Unit(Types.VOLUME, Units.GALLON, "gal", x -> x * 0.003785411784, x -> x / 0.003785411784)); // US gallon
        map.put(Units.FLUID_OUNCE,    new Unit(Types.VOLUME, Units.FLUID_OUNCE, "fl oz", x -> x * 0.0000295735295625, x -> x / 0.0000295735295625)); // US fluid ounce


        // WEIGHT
        map.put(Units.KILOGRAM,        new Unit(Types.WEIGHT, Units.KILOGRAM, "kg", x -> x, x -> x));
        map.put(Units.GRAM,            new Unit(Types.WEIGHT, Units.GRAM, "g", x -> x / 1000, x -> x * 1000));
        map.put(Units.MILLIGRAM,       new Unit(Types.WEIGHT, Units.MILLIGRAM, "mg", x -> x / 1_000_000, x -> x * 1_000_000));
        map.put(Units.MICROGRAM,       new Unit(Types.WEIGHT, Units.MICROGRAM, "μg", x -> x / 1e9, x -> x * 1e9));
        map.put(Units.TONNE,           new Unit(Types.WEIGHT, Units.TONNE, "t", x -> x * 1000, x -> x / 1000));
        map.put(Units.QUINTAL,         new Unit(Types.WEIGHT, Units.QUINTAL, "q", x -> x * 100, x -> x / 100));
        map.put(Units.CARAT,           new Unit(Types.WEIGHT, Units.CARAT, "ct", x -> x * 0.0002, x -> x / 0.0002));

        map.put(Units.POUND,           new Unit(Types.WEIGHT, Units.POUND, "lb", x -> x * 0.45359237, x -> x / 0.45359237));
        map.put(Units.OUNCE,           new Unit(Types.WEIGHT, Units.OUNCE, "oz", x -> x * 0.028349523125, x -> x / 0.028349523125));
        map.put(Units.GRAIN,           new Unit(Types.WEIGHT, Units.GRAIN, "gr", x -> x * 0.00006479891, x -> x / 0.00006479891));
        map.put(Units.LONG_TON,        new Unit(Types.WEIGHT, Units.LONG_TON, "lt", x -> x * 1016.0469088, x -> x / 1016.0469088));
        map.put(Units.SHORT_TON,       new Unit(Types.WEIGHT, Units.SHORT_TON, "st", x -> x * 907.18474, x -> x / 907.18474));
        map.put(Units.LONG_HUNDREDWEIGHT, new Unit(Types.WEIGHT, Units.LONG_HUNDREDWEIGHT, "lg cwt", x -> x * 50.80234544, x -> x / 50.80234544));
        map.put(Units.SHORT_HUNDREDWEIGHT, new Unit(Types.WEIGHT, Units.SHORT_HUNDREDWEIGHT, "sh cwt", x -> x * 45.359237, x -> x / 45.359237));
        map.put(Units.STONE,           new Unit(Types.WEIGHT, Units.STONE, "st (stone)", x -> x * 6.35029318, x -> x / 6.35029318));
        map.put(Units.DRAM,            new Unit(Types.WEIGHT, Units.DRAM, "dr", x -> x * 0.0017718451953125, x -> x / 0.0017718451953125));


        // TEMPERATURE
        map.put(Units.CELSIUS, new Unit(Types.TEMPERATURE, Units.CELSIUS, "°C", x -> x, x -> x));
        map.put(Units.FAHRENHEIT, new Unit(Types.TEMPERATURE, Units.FAHRENHEIT, "°F", x -> (x - 32) * 5 / 9, x -> (x * 9 / 5) + 32));
        map.put(Units.KELVIN, new Unit(Types.TEMPERATURE, Units.CELSIUS, "K", x -> x - 273.15, x -> x + 273.15));


        // POWER
        map.put(Units.WATT, new Unit(Types.POWER, Units.WATT, "W", x -> x, x -> x));
        map.put(Units.KILOWATT, new Unit(Types.POWER, Units.KILOWATT, "kW", x -> x * 1000, x -> x / 1000));
        map.put(Units.MEGAWATT, new Unit(Types.POWER, Units.MEGAWATT, "MW", x -> x * 1_000_000, x -> x / 1_000_000));
        map.put(Units.GIGAWATT, new Unit(Types.POWER, Units.GIGAWATT, "GW", x -> x * 1_000_000_000, x -> x / 1_000_000_000));

        map.put(Units.MILLIWATT, new Unit(Types.POWER, Units.MILLIWATT, "mW", x -> x / 1000, x -> x * 1000));
        map.put(Units.MICROWATT, new Unit(Types.POWER, Units.MICROWATT, "μW", x -> x / 1_000_000, x -> x * 1_000_000));

        map.put(Units.HORSEPOWER_MECHANICAL, new Unit(Types.POWER, Units.HORSEPOWER_MECHANICAL, "hp", x -> x * 745.699872, x -> x / 745.699872));
        map.put(Units.HORSEPOWER_METRIC, new Unit(Types.POWER, Units.HORSEPOWER_METRIC, "hp(M)", x -> x * 735.49875, x -> x / 735.49875));
        map.put(Units.BTU_PER_HOUR, new Unit(Types.POWER, Units.BTU_PER_HOUR, "BTU/h", x -> x * 0.29307107, x -> x / 0.29307107));
        map.put(Units.FOOT_POUND_PER_SECOND, new Unit(Types.POWER, Units.FOOT_POUND_PER_SECOND, "ft·lb/s", x -> x * 1.3558179483314, x -> x / 1.3558179483314));

        // SPEED
        map.put(Units.METERS_PER_SECOND, new Unit(Types.SPEED, Units.METERS_PER_SECOND, "m/s", x -> x, x -> x));
        map.put(Units.KILOMETERS_PER_HOUR, new Unit(Types.SPEED, Units.KILOMETERS_PER_HOUR, "km/h", x -> x / 3.6, x -> x * 3.6));
        map.put(Units.MILES_PER_HOUR, new Unit(Types.SPEED, Units.MILES_PER_HOUR, "mph", x -> x * 0.44704, x -> x / 0.44704));
        map.put(Units.FEET_PER_SECOND, new Unit(Types.SPEED, Units.FEET_PER_SECOND, "ft/s", x -> x * 0.3048, x -> x / 0.3048));
        map.put(Units.KNOT, new Unit(Types.SPEED, Units.KNOT, "kn", x -> x * 0.514444, x -> x / 0.514444));
        map.put(Units.MACH, new Unit(Types.SPEED, Units.MACH, "Mach", x -> x * 340.29, x -> x / 340.29));
        map.put(Units.SPEED_OF_LIGHT, new Unit(Types.SPEED, Units.SPEED_OF_LIGHT, "c", x -> x * 299_792_458, x -> x / 299_792_458));


        // PRESSURE
        map.put(Units.PASCAL,       new Unit(Types.PRESSURE, Units.PASCAL, "Pa", x -> x, x -> x));
        map.put(Units.HECTOPASCAL,  new Unit(Types.PRESSURE, Units.HECTOPASCAL, "hPa", x -> x * 100, x -> x / 100));
        map.put(Units.KILOPASCAL,   new Unit(Types.PRESSURE, Units.KILOPASCAL, "kPa", x -> x * 1000, x -> x / 1000));
        map.put(Units.MEGAPASCAL,   new Unit(Types.PRESSURE, Units.MEGAPASCAL, "MPa", x -> x * 1_000_000, x -> x / 1_000_000));
        map.put(Units.BAR,          new Unit(Types.PRESSURE, Units.BAR, "bar", x -> x * 100000, x -> x / 100000));
        map.put(Units.MILLIBAR,     new Unit(Types.PRESSURE, Units.MILLIBAR, "mbar", x -> x * 100, x -> x / 100));
        map.put(Units.ATMOSPHERE,   new Unit(Types.PRESSURE, Units.ATMOSPHERE, "atm", x -> x * 101325, x -> x / 101325));
        map.put(Units.TORR,         new Unit(Types.PRESSURE, Units.TORR, "Torr", x -> x * 133.322, x -> x / 133.322));
        map.put(Units.PSI,          new Unit(Types.PRESSURE, Units.PSI, "psi", x -> x * 6894.76, x -> x / 6894.76));
        map.put(Units.INHG,         new Unit(Types.PRESSURE, Units.INHG, "inHg", x -> x * 3386.39, x -> x / 3386.39));
        map.put(Units.MMHG,         new Unit(Types.PRESSURE, Units.MMHG, "mmHg", x -> x * 133.322, x -> x / 133.322));


        // MEMORY
        map.put(Units.BIT, new Unit(Types.MEMORY, Units.BIT, "b", x -> x / 8, x -> x * 8));
        map.put(Units.NIBBLE, new Unit(Types.MEMORY, Units.NIBBLE, "n", x -> x / 2, x -> x * 2));
        map.put(Units.BYTE, new Unit(Types.MEMORY, Units.BYTE, "B", x -> x, x -> x));
        map.put(Units.KILOBYTE, new Unit(Types.MEMORY, Units.KILOBYTE, "KB", x -> x * 1024, x -> x / 1024));
        map.put(Units.MEGABYTE, new Unit(Types.MEMORY, Units.MEGABYTE, "MB", x -> x * 1_048_576, x -> x / 1_048_576));
        map.put(Units.GIGABYTE, new Unit(Types.MEMORY, Units.GIGABYTE, "GB", x -> x * 1_073_741_824, x -> x / 1_073_741_824));

    }

    public static List<Unit> getUnitsByType(Types type) {
        return map.values().stream().filter(unit -> unit.getType() == type).collect(Collectors.toList());
    }
}
