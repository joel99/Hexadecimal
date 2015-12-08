// Team Ye Ali
//APCS1 pd10
//HW44 - This or That or Fourteen Other Things
//2015 - 12 - 08

public class Hexadecimal {

    private final static String HEXDIGITS = "0123456789ABCDEF";
    private int _decNum;
    private String _hexNum;


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _hexNum to "0"
      =====================================*/
    public Hexadecimal() { 
	_hexNum = "0";
	_decNum = 0;
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _hexNum to equiv string of bits
      =====================================*/
    public Hexadecimal( int n ) {
	_decNum = n;
	_hexNum = decToHex(n);   
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative hexary number
      post: sets _hexNum to input, _decNum to decimal equiv
      =====================================*/
    public Hexadecimal( String s ) {
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
      String decToHex(int) -- converts base-10 input to hexary
      pre:  n >= 0
      post: returns String of bits
      eg  decToHex(0) -> "0"
      decToHex(1) -> "1"
      decToHex(2) -> "10"
      decToHex(3) -> "11"
      decToHex(14) -> "1110"
      =====================================*/
    public static String decToHex( int n ) {
	String s = "";
	while (n > 0){
	    s = HEXDIGITS.substring(n % 16, n % 16 + 1) + s;
		n /= 16;
	}
	return s;
    }


    /*=====================================
      String decToHexR(int) -- converts base-10 input to hexary, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToHexR(0) -> "0"
      decToHexR(1) -> "1"
      decToHexR(2) -> "10"
      decToHexR(3) -> "11"
      decToHexR(14) -> "1110"
      =====================================*/
    public static String decToHexR( int n ) {
	if (n == 0)
		return "0";
	return HEXDIGITS.substring(n % 16, n % 16 + 1) + decToHexR( n / 16 );
    }


    /*=====================================
      String hexToDec(String) -- converts base-10 input to hexary
      pre:  s represents non-negative hexary number
      post: returns decimal equivalent as int
      eg  
      hexToDec("0") -> 0
      hexToDec("1") -> 1
      hexToDec("10") -> 2
      hexToDec("11") -> 3
      hexToDec("1110") -> 14
      =====================================*/
    public static int hexToDec( String s ) {
	int n = 0;
	while (s.length() > 0){
	    n += HEXDIGITS.indexOf(s.substring(0,1));
		n *= 16;
		s = s.substring(1);
	}
	return n;
    }


    /*=====================================
      String hexToDecR(String) -- converts base-10 input to hexary, recursively
      pre:  s represents non-negative hexary number
      post: returns decimal equivalent as int
      eg  
      hexToDecR("0") -> 0
      hexToDecR("1") -> 1
      hexToDecR("10") -> 2
      hexToDecR("11") -> 3
      hexToDecR("1110") -> 14
      =====================================*/
    public static int hexToDecR( String s ) {
	if (s.length() <= 1)
	    return HEXDIGITS.indexOf(s);
	return HEXDIGITS.indexOf(s.substring(s.length()-1)) + 16 * hexToDecR(s.substring(0,s.length()-1));
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Hexadecimal
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal hexary values
      =============================================*/
    public boolean equals( Object other ) { 
	return this == other || (other instanceof Hexadecimal && _decNum == ((Hexadecimal)other)._decNum);   
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Hexadecimal objects is greater
      pre:  other is instance of class Hexadecimal
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
	if (other instanceof Hexadecimal)
	    return _decNum - ((Hexadecimal)other)._decNum;
	else 
	    throw new ClassCastException("Not a Hexadecimal input");
    }


    //main method for testing
    public static void main( String[] args ) {
	System.out.println();
	System.out.println( "Testing ..." );

	Hexadecimal b1 = new Hexadecimal(5);
	Hexadecimal b2 = new Hexadecimal(5);
	Hexadecimal b3 = b1;
	Hexadecimal b4 = new Hexadecimal(7);

	System.out.println( b1 );
	System.out.println( b2 );
	System.out.println( b3 );       
	System.out.println( b4 );       

	System.out.println( "\n==..." );
	System.out.println( b1 == b2 ); //should be false
	System.out.println( b1 == b3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( b1.equals(b2) ); //should be true
	System.out.println( b1.equals(b3) ); //should be true
	System.out.println( b3.equals(b1) ); //should be true
	System.out.println( b4.equals(b2) ); //should be false
	System.out.println( b1.equals(b4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( b1.compareTo(b2) ); //should be 0
	System.out.println( b1.compareTo(b3) ); //should be 0
	System.out.println( b1.compareTo(b4) ); //should be neg
	System.out.println( b4.compareTo(b1) ); //should be pos

    }//end main()

} //end class
