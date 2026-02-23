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

    public static void main(String[] args) {
    	demonstrateFeetEquality();
    	demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
        
        demonstrateYardEquality();
        demonstrateYardFeetComparison();
        demonstrateCentimeterInchComparison();
    }

}


    