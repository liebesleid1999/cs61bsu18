/**
 * A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 *
 * This is a dummy implementation to allow IntListTest to compile. Replace this
 * file with your own IntList class.
 */
public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /** Returns an IntList consisting of the given values. */
    public static IntList of(int... values) {
        if (values.length == 0) {
            return null;
        }
        IntList p = new IntList(values[0], null);
        IntList front = p;
        for (int i = 1; i < values.length; i += 1) {
            p.rest = new IntList(values[i], null);
            p = p.rest;
        }
        return front;
    }

    /** Returns the size of the list. */
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + rest.size();
    }

    /** Returns [position]th value in this list. */
    public int get(int position) {
        if (position == 0) {
            return first;
        } else {
            return rest.get(position - 1);
        }
    }

    public void add(int value) {
    	IntList p=this;
    	while(p.rest != null) {
    		p = p.rest;
    	}
    	p.rest = new IntList(value,null);
      
    }

    public int smallest() {
        int small = first;
        int num=1;
        while(num <= this.size()) {
        	if(get(num) < small)
        		small = get (num);
        	num++;
        }
    	return small;
             
    }

    public int squaredSum() {
    	int ssum;
    	int i;
    	for(i=1; i<=this.size(); i++) {
    		ssum += i*i;
    	}
        return ssum;
    }

    public static void dSquareList(IntList L) {
        while (L != null) {
            L.first = L.first * L.first;
            L = L.rest;
        }
    }
    
    public static IntList squareListRecursive(IntList L) {
        if (L == null) {
            return null;
        }
        return new IntList(L.first * L.first, squareListRecursive(L.rest));
    }

    public static IntList catenate(IntList A, IntList B) {
    	IntList Ca;
    	if (B == null) {
    		Ca = A;
    		return Ca;
    	}
    	if (A == null) {
    		Ca = B;
    		return Ca;    	
    	}
    	if (A != null) {
    		Ca = new IntList (A.first, catenate(A.rest,B));
    	}
    	
        return Ca;
    }

    public static IntList dcatenate(IntList A, IntList B) {
    	if (B == null) return A;
    	if (A == null) return B;
    	while(A != null) {
    		A.rest = dcatenate(A.rest,B);
    	}
    	return A;
    	   	
    }
    

    
    
}
