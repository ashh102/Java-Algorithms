// Author: Ashley Maynez  
// Code for Bubble Sort with counting swaps
import java.lang.Math;
import java.util.Random;

public class MAYA2C {

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
		System.out.println("BUBBLE SORT WITH COUNTING SWAPS");
		System.out.println("**Random Integer Arrays**");
		
		// Random 100 int array.
		Watch a = new Watch();
		a.start_timer();
		sort(arrRan);
		a.stop_timer();
		System.out.println("100 Integers: " + a.getElapsed());
		
		// Random 1000 int array.
		Watch b = new Watch();
		b.start_timer();
		sort(arrRan2);
		b.stop_timer();
		System.out.println("1000 Integers: " + b.getElapsed());
		
		// Random 10000 int array.
		Watch c = new Watch();
		c.start_timer();
		sort(arrRan3);
		c.stop_timer();
		System.out.println("10000 Integers: " + c.getElapsed());
		
		System.out.println(" ");
		
		System.out.println("**Sorted Integer Arrays**");
		
		// Sorted 100 int array.
		Watch d = new Watch();
		d.start_timer();
		sort(arrSort);
		d.stop_timer();
		System.out.println("100 Integers: " + d.getElapsed());
		
		// Sorted 1000 int array.
		Watch e = new Watch();
		e.start_timer();
		sort(arrSort2);
		e.stop_timer();
		System.out.println("1000 Integers: " + e.getElapsed());
		
		// Sorted 10000 int array.
		Watch f = new Watch();
		f.start_timer();
		sort(arrSort3);
		f.stop_timer();
		System.out.println("10000 Integers: " + f.getElapsed());
		
		System.out.println(" ");
		
		System.out.println("**Almost Sorted Integer Arrays**");
		
		// Almost sorted 100 array.
		Watch g = new Watch();
		g.start_timer();
		sort(arrAlmSort);
		g.stop_timer();
		System.out.println("100 Integers: " + g.getElapsed());
		
		// Almost sorted 1000 array.
		Watch h = new Watch();
		h.start_timer();
		sort(arrAlmSort2);
		h.stop_timer();
		System.out.println("1000 Integers: " + h.getElapsed());
		
		// Almost sorted 10000 array.
		Watch m = new Watch();
		m.start_timer();
		sort(arrAlmSort3);
		m.stop_timer();
		System.out.println("10000 Integers: " + m.getElapsed());
	}
	
	// Bubble Sort. Taken from: http://www.cs.toronto.edu/~hojjat/108w07/lectures/mar26/Sort.java
	static void sort(int[] array) {
        int lastPos;
        int index;
        int temp;
        int count = 0;

        for (lastPos = array.length - 1; lastPos >= 0; lastPos--) {
            for (index = 0; index <= lastPos - 1; index++) {

                if (array[index] > array[index + 1]) {
                    count++;
                    temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
        }
        System.out.println("Swaps: " + count);
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

