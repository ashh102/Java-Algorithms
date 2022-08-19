// Author: Ashley Maynez  
// Code for Quick Sort
import java.lang.Math;
import java.util.Random;

public class MAYA2D {
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
		System.out.println("QUICK SORT");
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
	
	// Quick Sort. Taken from: https://www.geeksforgeeks.org/quick-sort/
	static int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (arr[j] <= pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    static void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
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

	

