// Author: Ashley Maynez  
// Code for Merge Sort
import java.lang.Math;
import java.util.Random;
public class MAYA2E {

	public static void main(String[] args) {
		
		// 100 int arrays.
		int[] arrRan = new int[100];
		int[] arrSort = new int[100];
		int [] arrAlmSort = new int[100];
		
		// 1000 int arrays.
		int [] arrRan2 = new int[1000];
		int [] arrSort2 = new int[1000];
		int [] arrAlmSort2 = new int[1000];
		
		// 10000 int arrays.
		int [] arrRan3 = new int[10000];
		int [] arrSort3 = new int[10000];
		int [] arrAlmSort3 = new int[10000];
		
		
		
		// Creates random number arrays.
		for (int i = 0; i < arrRan.length; i ++) {
			arrRan[i] = (int)(Math.random() * 10000 + 1);
		}
		
		for (int i = 0; i < arrRan2.length; i ++) {
			arrRan2[i] = (int)(Math.random() * 10000 + 1);
		}
		
		for (int i = 0; i < arrRan3.length; i ++) {
			arrRan3[i] = (int)(Math.random() * 10000 + 1);
		}
		
		
		
		// Creates sorted number arrays.
		for (int i = 0; i < arrSort.length; i++) {
			arrSort[i] = i * 100 + 1;
		}
		
		for (int i = 0; i < arrSort2.length; i++) {
			arrSort2[i] = i * 10 + 1;
		}
		
		for (int i = 0; i < arrSort2.length; i++) {
			arrSort2[i] = i + 1;
		}
		
		
		
		//  Creates almost sorted number arrays with 10th digit out of place.
		Random r = new Random();
		for (int i = 0; i < arrAlmSort.length; i++) {
		    if ((i + 1) % 10 != 0) {
		        arrAlmSort[i] = (i + 1) * 10;
		    } 
		    else {
		        arrAlmSort[i] = r.nextInt(10000);
		    }
		}
		
		Random r2 = new Random();
		for (int i = 0; i < arrAlmSort2.length; i++) {
		    if ((i + 1) % 10 != 0) {
		        arrAlmSort2[i] = (i + 1) * 10;
		    } 
		    else {
		        arrAlmSort2[i] = r2.nextInt(10000);
		    }
		}
		
		Random r3 = new Random();
		for (int i = 0; i < arrAlmSort3.length; i++) {
		    if ((i + 1) % 10 != 0) {
		        arrAlmSort3[i] = (i + 1) * 10;
		    } 
		    else {
		        arrAlmSort3[i] = r3.nextInt(10000);
		    }
		}
		
		
		
		// Outputs all times.
		System.out.println("MERGE SORT");
		System.out.println("**Random Integer Arrays**");
		
		// Random 100 int array.
		int l1 = arrRan.length;
		Watch a = new Watch();
		a.start_timer();
		sort(arrRan, 0, l1 - 1);
		a.stop_timer();
		System.out.println("100 Integers: " + a.getElapsed());
		
		// Random 1000 int array.
		int l2 = arrRan2.length;
		Watch b = new Watch();
		b.start_timer();
		sort(arrRan2, 0, l2 - 1);
		b.stop_timer();
		System.out.println("1000 Integers: " + b.getElapsed());
		
		// Random 10000 int array.
		int l3 = arrRan3.length;
		Watch c = new Watch();
		c.start_timer();
		sort(arrRan3, 0, l3 - 1);
		c.stop_timer();
		System.out.println("10000 Integers: " + c.getElapsed());
		
		System.out.println(" ");
		
		System.out.println("**Sorted Integer Arrays**");
		
		// Sorted 100 int array.
		int l4 = arrSort.length;
		Watch d = new Watch();
		d.start_timer();
		sort(arrSort, 0, l4 - 1);
		d.stop_timer();
		System.out.println("100 Integers: " + d.getElapsed());
		
		// Sorted 1000 int array.
		int l5 = arrSort2.length;
		Watch e = new Watch();
		e.start_timer();
		sort(arrSort2, 0, l5 - 1);
		e.stop_timer();
		System.out.println("1000 Integers: " + e.getElapsed());
		
		// Sorted 10000 int array.
		int l6 = arrSort3.length;
		Watch f = new Watch();
		f.start_timer();
		sort(arrSort3, 0, l6 - 1);
		f.stop_timer();
		System.out.println("10000 Integers: " + f.getElapsed());
		
		System.out.println(" ");
		
		System.out.println("**Almost Sorted Integer Arrays**");
		
		// Almost sorted 100 array.
		int l7 = arrAlmSort.length;
		Watch g = new Watch();
		g.start_timer();
		sort(arrAlmSort, 0, l7 - 1);
		g.stop_timer();
		System.out.println("100 Integers: " + g.getElapsed());
		
		// Almost sorted 1000 array.
		int l8 = arrAlmSort.length;
		Watch h = new Watch();
		h.start_timer();
		sort(arrAlmSort2, 0, l8 - 1);
		h.stop_timer();
		System.out.println("1000 Integers: " + h.getElapsed());
		
		// Almost sorted 10000 array.
		int l9 = arrAlmSort.length;
		Watch m = new Watch();
		m.start_timer();
		sort(arrAlmSort3, 0 , l9 - 1);
		m.stop_timer();
		System.out.println("10000 Integers: " + m.getElapsed());
	}
	
	// Merge Sort. Taken from: https://www.geeksforgeeks.org/merge-sort/
	static void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    static void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    }  
}

//Stopwatch.
class Watch{
	private long startClock;
	private long endClock;
		
	public Watch(){
		startClock = System.currentTimeMillis();
	}
		
	public void start_timer() {
		startClock = System.currentTimeMillis();
	}
		
	public void stop_timer() {
		endClock = System.currentTimeMillis();
	}
		
	public long getElapsed() {
		return endClock - startClock;
	}
}

	

