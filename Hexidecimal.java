// Maddie Ostergaard
// APCS pd9
// HW44 -- This or That or Fourteen Other Things
// 2015-12-08


public class Hexidecimal implements Comparable {

    private final static String HEXDIGITS = "0123456789ABCDEF";

    private int _decNum;
    private String _hexNum;


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _hexNum to "0"
      =====================================*/
    public Hexidecimal() { 
	_decNum = 0;
	_hexNum = "0";
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _hexNum to equiv string of bits
      =====================================*/
    public Hexidecimal( int n ) {
	_decNum = n;
	_hexNum = decToHex(n);
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative hexidecimal number
      post: sets _hexNum to input, _decNum to decimal equiv
      =====================================*/
    public Hexidecimal( String s ) {
	_decNum = hexToDec(s);
	_hexNum = s;
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	return _hexNum; 
    }


    /*=====================================
      String decToHex(int) -- converts base-10 input to hexidecimal
      pre:  n >= 0
      post: returns String of bits
      eg  decToHex(0) -> "0"
      decToHex(1) -> "1"
      decToHex(21) -> "15"
      decToHex(32) -> "20"
      decToHex(14) -> "D"
      =====================================*/
    public static String decToHex( int n ) {
	String retStr = "";
	if ( n == 0 ){
	    retStr = "0";
	}
	else 
	    while( n > 0 ) {
		retStr = HEXDIGITS.substring(n % 16, (n % 16) + 1) + retStr;
		n /= 16;
	    }
	return retStr;
    }


    /*=====================================
      String decToHexR(int) -- converts base-10 input to hexidecimal, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToHexR(0) -> "0"
      decToHexR(1) -> "1"
      decToHexR(21) -> "15"
      decToHexR(32) -> "20"
      decToHexR(14) -> "D"
      =====================================*/
    public static String decToHexR( int n ) 
    { 
	String retStr; 	
	if ( n < 16){
	    retStr =  HEXDIGITS.substring(n, n+1);
	}
	else {
	    retStr = decToHexR( n/16 ) + HEXDIGITS.substring(n % 16, (n % 16) + 1);
	}
	return retStr;
    }


    /*=====================================
      String hexToDec(String) -- converts base-10 input to hexidecimal
      pre:  s represents non-negative hexidecimal number
      post: returns decimal equivalent as int
      eg  
      hexToDec("1") -> 1
      hexToDec("14") -> D
      hexToDec("21") -> 15
      hexToDec("31") -> 1E
      hexToDec("32") -> 20
      =====================================*/
    public static int hexToDec( String hexStr ) {
	int decNum = 0;
	int placeVal = 0;

	//iterate L->R, adding each digit*place value
	for( int i=0; i < hexStr.length(); i++ ) {
	    placeVal = hexStr.length() - 1 - i;
	    decNum += HEXDIGITS.indexOf(hexStr.substring(i,i+1)) * Math.pow(16,placeVal);
	}
	return decNum;
    }


    /*=====================================
      String hexToDecR(String) -- converts base-10 input to hexidecimal, recursively
      pre:  s represents non-negative hexidecimal number
      post: returns decimal equivalent as int
      eg  
      hexToDec("1") -> 1
      hexToDec("D") -> 14
      hexToDec("15") -> 21
      hexToDec("1F") -> 31
      hexToDec("20") -> 32
      =====================================*/
    public static int hexToDecR( String s ) { 
	int n = HEXDIGITS.indexOf(s.substring(s.length() - 1));
	if (s.length() == 1 ) 
	    return n;
	return 16 * hexToDecR( s.substring(0,s.length() -1)) + n ;
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Hexidecimal
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal hexidecimal values
      =============================================*/
    public boolean equals( Object other ) { 
	return this == other 
	    ||
	    (other instanceof Hexidecimal
	     && this._decNum == ((Hexidecimal)other)._decNum);
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Hexidecimal objects is greater
      pre:  other is instance of class Hexidecimal
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
	if ( ! (other instanceof Hexidecimal) ){
	    throw new ClassCastException("\ncompareTo() input not Hexidecimal");
	}

	return this._decNum - ((Hexidecimal)other)._decNum;
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	  System.out.println();
	  System.out.println( "Testing ..." );

	  Hexidecimal h1 = new Hexidecimal(5);
	  Hexidecimal h2 = new Hexidecimal(5);
	  Hexidecimal h3 = h1;
	  Hexidecimal h4 = new Hexidecimal(7);

	  System.out.println( h1 );
	  System.out.println( h2 );
	  System.out.println( h3 );       
	  System.out.println( h4 );       

	  System.out.println( "\n ==? " );
	  System.out.println( h1 == h2 ); 
	  System.out.println( h1 == h3 ); 
	  
	  System.out.println( "\nhexToDecR" );
	  System.out.println( hexToDecR("1") + " --> 1" ); 
	  System.out.println( hexToDecR("D") + " --> 13");
	  System.out.println( hexToDecR("15") + " --> 21");
	  System.out.println( hexToDecR("1F") + " --> 31"); 
	  System.out.println( hexToDecR("20") + " --> 32"); 
	  
	  System.out.println( "\nhexToDec" );
	  System.out.println( hexToDec("1") + " --> 1" ); 
	  System.out.println( hexToDec("D") + " --> 13");
	  System.out.println( hexToDec("15") + " --> 21");
	  System.out.println( hexToDec("1F") + " --> 31"); 
	  System.out.println( hexToDec("20") + " --> 32");

	  System.out.println( "\ndecToHexR" );
	  System.out.println( decToHexR(1) + " --> 1" ); 
	  System.out.println( decToHexR(13) + " --> D");
	  System.out.println( decToHexR(21) + " --> 15");
	  System.out.println( decToHexR(31) + " --> 1F"); 
	  System.out.println( decToHexR(32) + " --> 20"); 

	  System.out.println( "\ndecToHex" );
	  System.out.println( decToHex(1) + " --> 1" ); 
	  System.out.println( decToHex(13) + " --> D");
	  System.out.println( decToHex(21) + " --> 15");
	  System.out.println( decToHex(31) + " --> 1F"); 
	  System.out.println( decToHex(32) + " --> 20"); 

	  System.out.println( "\n.equals()" );
	  System.out.println( h1.equals(h2) ); 
	  System.out.println( h1.equals(h3) ); 
	  System.out.println( h3.equals(h1) ); 
	  System.out.println( h4.equals(h2) ); 
	  System.out.println( h1.equals(h4) ); 

	  System.out.println( "\n.compareTo()" );
	  System.out.println( h1.compareTo(h2) ); 
	  System.out.println( h1.compareTo(h3) );
	  System.out.println( h1.compareTo(h4) );
	  System.out.println( h4.compareTo(h1) ); 

	/*=========================================
	  =========================================*/

    }//end main()

} //end class

    

