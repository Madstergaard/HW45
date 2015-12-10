//  Maddie Ostergaard
// APCS1 pd9
// HW45 -- .
// 2015-12-09

public class SuperArray{
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor initializes 10-item array
    public SuperArray() 
    { 
	_data = new Comparable[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;	
    }

    
    public int linSearch(Comparable target){
	for (int i = 0; i < _data.length; i++){
	    if (_data[i] == target){
		return i;
	    }
	}
	return -1;
    }

    public boolean isSorted(){
	for (int i = 0; i < _data.length; i++){
	    if ((Double)_data[i] > (Double) _data[i+1]){
		return false;
	    }
	}
	return true;
    }

		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() 
    { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }

		
    //double capacity of this SuperArray
    private void expand() 
    { 
	int[] temp = new int[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public int get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public int set( int index, Comparable newVal ) 
    { 
 	int temp = _data[index];
	_data[index] = newVal;
	return temp;
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable o) {
	int newVal = o;
	_data.expand();
	_data[_lastPos +1] = o;
	if (o > 0){
	    _lastPos++;
	    _size++;
	}
    }


    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ) {
	if (index < _size){
	for (int i = _data.lastPos; i > index; i--){
	    _data[i] = _data[i + 1];
	}
	_data[index] = newVal;
	if (newVal > 0){
	    _lastPos++;
	    _size++;
	}
       
	}
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) {
	if (index < _size){
	
	if (newVal > 0){
	    _lastPos++;
	    _size++;
	}
	foo[index] = newVal;
	for (int i = _data.lastPos; i >= index; i--){
	    _data[i] = _data[i - 1];
	}
	_data = foo;
	}
    }


    //return number of meaningful items in _data
    public int size() {
	_size = 0;
	for (int i = 0; i < _data.length; i ++){
	    if (_data[i] > 0){
		_size++;
	    }
	}
	return _size;
		
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	SuperArray curtis = new SuperArray();
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set(i,i*2);
	    curtis._size++; //necessary bc no add() method yet
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	System.out.println("testing get()...");
	for( int i = 0; i < curtis._size; i++ ) {
	    System.out.print( "item at index" + i + ":\t" );
	    System.out.println( curtis.get(i) );
	}

	System.out.println("Expanded SuperArray curtis:");
	curtis.expand();
	System.out.println(curtis);
	System.out.println("Size = " + curtis.size());

	
	SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	  mayfield.add(5);
	  mayfield.add(4);
	  mayfield.add(3);
	  mayfield.add(2);
	  mayfield.add(1);
	 
	  System.out.println("Printing populated SuperArray mayfield...");
	  System.out.println(mayfield);

	  mayfield.remove(3);
	  System.out.println("Printing SuperArray mayfield post-remove...");
	  System.out.println(mayfield);
	  System.out.println("Size = " + mayfield.size());
	  mayfield.remove(3);
	  System.out.println("Printing SuperArray mayfield post-remove...");
	  System.out.println(mayfield);
	  System.out.println("Size = " + mayfield.size());

	  mayfield.add(3,99);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  mayfield.add(2,88);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  mayfield.add(1,77);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	
	//*****INSERT ANY ADDITIONAL TEST CALLS HERE*****
//	  System.out.println("Size = " + mayfield.size());

	
	}	
	
 }//end main
