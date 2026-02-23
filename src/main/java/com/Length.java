package com;

// Generic Length class for UC3
public class Length {

    // Instance variables
    private double value;
    private LengthUnit unit;

    // Enum for unit types and conversion factors
    public enum LengthUnit {
        FEET(12.0),        // 1 foot = 12 inches
        INCHES(1.0),       // base unit
        YARDS(36.0),       // 1 yard = 36 inches
        CENTIMETERS(0.393701); // 1 cm = 0.393701 inches

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // Constructor
    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }
    
    //Convert
    
    public static double convert(double value, LengthUnit source, LengthUnit target) {

        // 1. Validate input
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        if (source == null || target == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        // 2. Convert to base unit (inches in your design)
        double baseValue = value * source.getConversionFactor();

        // 3. Convert to target unit
        double result = baseValue / target.getConversionFactor();

        // 4. Optional rounding
        return Math.round(result * 100.0) / 100.0;
    }
    // Convert to base unit (inches)
    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }
    
    // Convert current Length object to target unit
    public Length convertTo(LengthUnit targetUnit) {

        // 1. Validate
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        if (!Double.isFinite(this.value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        
        if (this.unit == targetUnit) {
            return this;
        }

        // 2. Convert to base (inches)
        double baseValue = this.convertToBaseUnit();

        // 3. Convert to target
        double result = baseValue / targetUnit.getConversionFactor();

        // 4. Optional rounding
        result = Math.round(result * 100.0) / 100.0;

        // 5. Return new Length object
        return new Length(result, targetUnit);
    }

    // Compare two Length objects
    public boolean compare(Length thatLength) {
        double thisValue = this.convertToBaseUnit();
        double thatValue = thatLength.convertToBaseUnit();
        return Double.compare(thisValue, thatValue) == 0;
    }

    // Override equals
    @Override
    public boolean equals(Object obj) {

        // Reference check
        if (this == obj) {
            return true;
        }

        // Null check
        if (obj == null) {
            return false;
        }

        // Type check
        if (getClass() != obj.getClass()) {
            return false;
        }

        // Cast
        Length other = (Length) obj;

        // Compare
        return this.compare(other);
    }
}