

import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/** 
 * re-implementation of an ArrayList  
 * @author walker
 */
public class MyArrayList <E>  implements Iterable<E>{
	
   private E myArray [];
    private int numStored;  // the number of items actually stored in myArray
 
    public MyArrayList ()
	{
        // initially, the internal array has room for 10 items,
        // but no items have actually been inserted
        myArray = (E[]) new Object [10];
        numStored = 0;	
	}
    
    public void add (E e)
    {
       // check if myArray must be expanded
       if (numStored == myArray.length)
          {
              /* the following code follows approach A in the lab */
             E newArray [] = (E[]) new Object [myArray.length + 1];
             for (int i = 0; i < numStored; i++)
                 newArray[i] = myArray[i];
             myArray = newArray; 
          }

    // insert the given element into myArray
    myArray[numStored] = e;
    numStored++;
    }
    
    E get (int index)
    {
    	return myArray[index];
    }
    
    public void print ()
    {
    	System.out.println ("Listing of array elements");
    	int i;
    	/*
    	 * only cycle through array elements with stored data 
    	 */
    	for (i = 0; i < numStored; i++)
    	{
    		System.out.println ("\t" + myArray[i]);
    	}
    	System.out.println ("End of listing");
   	
    }
    
	// Iterator material starts here
	public Iterator<E> iterator() {
	    return new MyArrayListIterator ();
	}
	 
	private class MyArrayListIterator implements Iterator<E> {
		
		private int iteratorCount;

		@Override
		public boolean hasNext(){
			if (numStored < 0 || numStored > myArray.length)
				throw new NoSuchElementException();
			else return true;
		}

		@Override
		public E next() {
			if (!hasNext()) // no next element
			{
				throw new NoSuchElementException();
			}
			else 
				return myArray[numStored-1];
		}

		@Override
		public void remove() {
			/* remove last value */
			myArray[numStored-1] = null;
			
		}
            /* fill in details here */
	}

    public static void main (String args [])
    {
      	MyArrayList <Integer> intArr = new MyArrayList <Integer>();
      	MyArrayList <String> strArr = new MyArrayList <String>();
          	
      	/*
      	 * test of constructor
      	 */
      	System.out.println ("Initialized array lists");
      	System.out.print("Integer:  ");
      	intArr.print();
      	System.out.print("String:  ");
      	strArr.print();
      	
      	/*
      	 * add some items to array list
      	 */
     	for (int i = 1; i <= 22; i++)
      		intArr.add(i);

      	/*
      	 * check contents of array list
      	 */
      	strArr.add("a");
      	strArr.add("bc");
      	strArr.add("def");
      	strArr.add("ghij");
      	strArr.add("klmno");
      	
      	System.out.println ("Array lists with 22 and 5 items, respectively");
      	System.out.print("Integer:  ");
      	intArr.print();
      	System.out.print("String:  ");
      	strArr.print();
      	
      	/*
      	 * check iterator construction and use
      	 */
   
      	System.out.println ("print integer data via iterator");
      	for (Integer intItem: intArr)
      	{
      		System.out.println ("\t" + intItem);
      	}
      	
      	System.out.println ("print String data via iterator");
      	for (String strItem: strArr)
      	{
      		System.out.println ("\t" + strItem);
      	}
    }	
}	
