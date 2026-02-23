package com;

public class QuantityMeasurementApp {

    
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static void demonstrateFeetEquality() {
        Length f1 = new Length(1.0, Length.LengthUnit.FEET);
        Length f2 = new Length(1.0, Length.LengthUnit.FEET);

        System.out.println("Feet equal? " + f1.equals(f2));
    }

    public static void demonstrateInchesEquality() {
        Length i1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length i2 = new Length(1.0, Length.LengthUnit.INCHES);

        System.out.println("Inches equal? " + i1.equals(i2));
    }

    public static void demonstrateFeetInchesComparison() {
        Length f = new Length(1.0, Length.LengthUnit.FEET);
        Length i = new Length(12.0, Length.LengthUnit.INCHES);

        System.out.println("Feet and Inches equal? " + f.equals(i));
    }

    public static void demonstrateYardEquality() {
        Length y1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length y2 = new Length(1.0, Length.LengthUnit.YARDS);

        System.out.println("Yards equal? " + y1.equals(y2));
    }

    public static void demonstrateYardFeetComparison() {
        Length y = new Length(1.0, Length.LengthUnit.YARDS);
        Length f = new Length(3.0, Length.LengthUnit.FEET);

        System.out.println("Yard and Feet equal? " + y.equals(f));
    }

    public static void demonstrateCentimeterInchComparison() {
        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length in = new Length(0.393701, Length.LengthUnit.INCHES);

        System.out.println("Centimeter and Inches equal? " + cm.equals(in));
    }
    
    public static Length demonstrateLengthConversion(double value, Length.LengthUnit source, Length.LengthUnit target) {

		// Create source length
		Length length = new Length(value, source);
		
		// Use instance convertTo()
		return length.convertTo(target);
	}

    public static Length demonstrateLengthConversion(Length length, Length.LengthUnit target) {

    	return length.convertTo(target);
	}
    public static void main(String[] args) {
    	demonstrateFeetEquality();
    	demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
        
        demonstrateYardEquality();
        demonstrateYardFeetComparison();
        demonstrateCentimeterInchComparison();
        
        // Example 1: 3 Feet to Inches
        Length lengthInInches = demonstrateLengthConversion(
                3.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        System.out.println("3 Feet in Inches = " + lengthInInches);

        // Example 2: Using overloaded method
        Length yard = new Length(2.0, Length.LengthUnit.YARDS);
        Length yardToInches = demonstrateLengthConversion(
                yard, Length.LengthUnit.INCHES);
        System.out.println("2 Yards in Inches = " + yardToInches);
    }

}


    