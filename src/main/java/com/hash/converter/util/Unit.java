package com.hash.converter.util;

import java.util.function.Function;

public class Unit {
    private final Types type;
    private final Units unit;
    private final String symbol;
    private final Function<Double, Double> toBase;
    private final Function<Double, Double> fromBase;

    public Unit(Types type, Units unit, String symbol, Function<Double, Double> toBase, Function<Double, Double> fromBase) {
        this.type = type;
        this.unit = unit;
        this.symbol = symbol;
        this.toBase = toBase;
        this.fromBase = fromBase;
    }

    public Double convert(Double value, Units newUnitEnum) {
        Unit newUnit = Registry.map.get(newUnitEnum);

        if (newUnit == null) {
            throw new IllegalArgumentException("Provided unit enum as null");
        }

        if (newUnit.getType() != this.type) {
            throw new IllegalArgumentException("Types mismatch: got " + newUnit.getType() + " expected " + this.type);
        }

        double baseValue = toBase.apply(value);
        return newUnit.fromBase.apply(baseValue);
    }

    public Types getType() {
        return type;
    }

    public Units getUnit() {
        return unit;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "type=" + type +
                ", unit='" + unit + '\'' +
                ", symbol='" + symbol + '\'' +
                ", toBase=" + toBase +
                ", fromBase=" + fromBase +
                '}';
    }
}
