/*
   Team D-O-M  -- David Merlinsky, Maddie Ostergaard 
   APCS1 pd9
   HW41 -- In America, the driver sits on the left
   2015-12-3
*/

public class Rational implements Comparable
{
    //attributes
    private int p, q; //p = numerator; q = denominator (q!=0)

    //constructors
    public  Rational()
    {
        p = 0;
        q = 1;
    }

    public Rational(int numerator, int denominator)
    {
        p = numerator;
        q = denominator;
        if (q==0){
            p = 0;
            q = 1;
            System.out.println("Invalid demoninator submitted. Number set to 0/1");
        }
        reduce();
    }

    //accessors
    public int getNumerator()
    {
        return p;
    }

    public int getDenominator()
    {
        return q;
    }

    //methods
    public String toString()
    {

        String s = "";

        s += p;
        s += "/";
        s += q;

        return s;  
    }

    public double doubleValue()
    {
        return (double)(p/q);
    }

    public static int gcd(int a, int b)
    {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
    public void reduce()
    {
        int g = gcd(p, q);
        p /= g;
        q /= g;
    }
    public int compareTo(Object o)
    {
        Rational other = (Rational) o;
        if (doubleValue() == other.doubleValue()) return 0;
        if (doubleValue() < other.doubleValue()) return -1;
        return 1;
    }

    public void multiply(Rational r)
    {
        this.p *= r.getNumerator();
        this.q *= r.getDenominator();
        reduce();
    }


    public void divide(Rational r)
    {
        this.p *= r.getDenominator();
        this.q *= r.getNumerator();
        reduce();
    }

    public void add(Rational r)
    {
        this.p = this.p * r.q + this.q * r.p;
        this.q *= r.q;
        reduce();
    }

    public void subtract(Rational r)
    {
        this.p = this.p * r.q - this.q * r.p;
        this.q *= r.q;
        reduce();
    }

    public boolean equals(Object obj){
	if (obj instanceof Rational){
	    if (this.compareTo((Rational)obj) == 0){
		return true;
	    }
	}
	return false;
    }

    // main
    public static void main(String[] args)
    {
        Rational r = new Rational(2,17);
        Rational s = new Rational(1,31);
        Rational w = new Rational(1, 31);

        System.out.println(r + ", " + s + ", " + w);

        r.add(s);
	System.out.println(s);
	s.subtract(new Rational(1,4));
	System.out.println(s);
	System.out.println(w);
	System.out.println(s.equals(w));
	System.out.println(s.compareTo(w));

	
			  // System.out.println(r);
			  //  System.out.println(s);
    }
}

