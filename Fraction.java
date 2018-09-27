
import java.util.Scanner;

public class Fraction {
    private int numerator ;
    private int denominator;

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public  Fraction()
    {

    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public  void input()
    {
        Scanner source = new Scanner(System.in);

        System.out.println("Enter Numerator:");
        numerator= source.nextInt();
        do {
            System.out.println("Enter Denominator");
            denominator  = source.nextInt();
            if( denominator == 0)
            {
                System.out.println("Wrong! Denominator must be <> 0");
            }
        }
        while( denominator == 0);
    }

    public  int greatestCommonDivisor(int a, int b)
    {
        a = Math.abs(a);
        b = Math.abs(b);
        if(a > b)
        {
            return greatestCommonDivisor(a - b, b);
        }
        else if(b>a)
        {
            return greatestCommonDivisor(a, b -a);
        }
        return  a;
    }

    public void standardized()
    {
        int GreatestCD = greatestCommonDivisor(numerator, denominator);
        numerator = numerator/GreatestCD;
        denominator = denominator/GreatestCD;
    }

    public  void output()
    {
        standardized();
        System.out.println(numerator +"/"+denominator);
    }

    public  Fraction addFractions(Fraction fraction_a)
    {
        Fraction fraction_temp = new Fraction();
        fraction_temp.numerator = numerator*fraction_a.denominator + denominator*fraction_a.numerator;
        fraction_temp.denominator = denominator*fraction_a.denominator;
        fraction_temp.standardized();
        return fraction_temp;
    }

    public Fraction subtractFractions(Fraction fraction_a)
    {
        Fraction fraction_temp = new Fraction();
        fraction_temp.numerator = numerator*fraction_a.denominator - denominator*fraction_a.numerator;
        fraction_temp.denominator = denominator*fraction_a.denominator;
        fraction_temp.standardized();
        return fraction_temp;
    }

    public Fraction multiplyFractions(Fraction fraction_a)
    {
        fraction_a.numerator = fraction_a.numerator * numerator;
        fraction_a.denominator = fraction_a.denominator * denominator;
        fraction_a.standardized();
        return  fraction_a;
    }

    public Fraction divideFractions(Fraction fraction_a)
    {
        Fraction fraction_temp = new Fraction();
        fraction_temp.numerator = fraction_a.denominator;
        fraction_temp.denominator = fraction_a.numerator;
        return this.multiplyFractions(fraction_temp);
    }
}
