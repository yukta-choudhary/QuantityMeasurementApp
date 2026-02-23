package com;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality() {
        Length f1 = new Length(1.0, Length.LengthUnit.FEET);
        Length f2 = new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(f1.equals(f2));
    }

    @Test
    public void testInchesEquality() {
        Length i1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length i2 = new Length(1.0, Length.LengthUnit.INCHES);

        assertTrue(i1.equals(i2));
    }

    @Test
    public void testFeetInchesComparison() {
        Length f = new Length(1.0, Length.LengthUnit.FEET);
        Length i = new Length(12.0, Length.LengthUnit.INCHES);

        assertTrue(f.equals(i));
    }

    @Test
    public void testFeetInequality() {
        Length f1 = new Length(1.0, Length.LengthUnit.FEET);
        Length f2 = new Length(2.0, Length.LengthUnit.FEET);

        assertFalse(f1.equals(f2));
    }

    @Test
    public void testInchesInequality() {
        Length i1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length i2 = new Length(2.0, Length.LengthUnit.INCHES);

        assertFalse(i1.equals(i2));
    }

    @Test
    public void testNullComparison() {
        Length f1 = new Length(1.0, Length.LengthUnit.FEET);

        assertFalse(f1.equals(null));
    }

    @Test
    public void testSameReference() {
        Length f1 = new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(f1.equals(f1));
    }
 // UC4: Yard to Yard
    @Test
    public void yardEquality() {
        Length y1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length y2 = new Length(1.0, Length.LengthUnit.YARDS);
        assertTrue(y1.equals(y2));
    }

    // UC4: Yard to Feet
    @Test
    public void yardEqualsFeet() {
        Length y = new Length(1.0, Length.LengthUnit.YARDS);
        Length f = new Length(3.0, Length.LengthUnit.FEET);
        assertTrue(y.equals(f));
    }

    // UC4: Yard to Inches
    @Test
    public void yardEqualsInches() {
        Length y = new Length(1.0, Length.LengthUnit.YARDS);
        Length i = new Length(36.0, Length.LengthUnit.INCHES);
        assertTrue(y.equals(i));
    }

    // UC4: Centimeter to Inches
    @Test
    public void centimeterEqualsInches() {
        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length in = new Length(0.393701, Length.LengthUnit.INCHES);
        assertTrue(cm.equals(in));
    }

    // UC4: Inequality
    @Test
    public void centimeterNotEqualFeet() {
        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length f = new Length(1.0, Length.LengthUnit.FEET);
        assertFalse(cm.equals(f));
    }
    
    @Test
    public void testNullUnitConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new Length(1.0, null));
    }
    @Test
    public void testConversion_FeetToInches() {
        double result = Length.convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        assertEquals(12.0, result);
    }

    @Test
    public void testConversion_YardsToFeet() {
        double result = Length.convert(2.0, Length.LengthUnit.YARDS, Length.LengthUnit.FEET);
        assertEquals(6.0, result, 1e-6);
    }

    @Test
    public void testConversion_CentimeterToFeet() {
        double result = Length.convert(100.0, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.FEET);
        assertEquals(3.28, result, 0.01);
    }
    @Test
    public void testConversion_NullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> Length.convert(1.0, null, Length.LengthUnit.FEET));
    }

    @Test
    public void testConversion_NaN() {
        assertThrows(IllegalArgumentException.class,
                () -> Length.convert(Double.NaN, Length.LengthUnit.FEET, Length.LengthUnit.INCHES));
    }
    @Test
    public void testConvertTo_FeetToInches() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = feet.convertTo(Length.LengthUnit.INCHES);

        assertTrue(inches.equals(new Length(12.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testConvertTo_NullTarget() {
        Length length = new Length(1.0, Length.LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> length.convertTo(null));
    }
    @Test
    public void testConvertTo_Immutability() {
        Length original = new Length(5.0, Length.LengthUnit.FEET);
        Length converted = original.convertTo(Length.LengthUnit.INCHES);

        assertNotSame(original, converted);
        assertTrue(original.equals(new Length(5.0, Length.LengthUnit.FEET)));
    }
    @Test
    public void testRoundTripConversion() {
        double original = 5.0;

        double inches = Length.convert(original,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        double feet = Length.convert(inches,
                Length.LengthUnit.INCHES,
                Length.LengthUnit.FEET);

        assertEquals(original, feet, 1e-6);
    }
}