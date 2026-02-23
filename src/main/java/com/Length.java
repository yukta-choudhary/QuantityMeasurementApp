package com;

// Generic Length class for UC3
public class Length {

    // Instance variables
    private double value;
    private LengthUnit unit;

    // Enum for unit types and conversion factors
    public enum LengthUnit {
        FEET(12.0),   // 1 foot = 12 inches
        INCHES(1.0);  // base unit

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

    // Convert to base unit (inches)
    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
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