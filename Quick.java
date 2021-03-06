/*
  Implementation of QuickSort
*/

import java.util.Collections;
import java.util.Arrays;

class Quick {

    public static void sort(Comparable[] stuff) {
        Collections.shuffle(Arrays.asList(stuff));
        sort(stuff, 0, stuff.length - 1);
    }

    private static void sort(Comparable[] stuff, int from, int to) {

        // Base case
        if(to <= from)
            return;

        int pivot = partition(stuff, from, to);
        sort(stuff, from, pivot - 1);
        sort(stuff, pivot + 1, to);
    }

    private static int partition(Comparable[] stuff, int from, int to) {

        int lt = from, gt = to + 1, test = from;

        while(true) {

            while(stuff[++lt].compareTo(stuff[test]) < 0) {
                if(lt == to)
                    break;
            }

            while(stuff[--gt].compareTo(stuff[test]) > 0) {
                if(gt == from)
                    break;
            }

            if(lt >= gt)
                break;

            swap(stuff, lt, gt);
        }

        swap(stuff, test, gt);
        return gt;
    }

    private static void swap(Comparable[] stuff, int one, int two) {

        Comparable temp = stuff[one];
        stuff[one] = stuff[two];
        stuff[two] = temp;
    }
}
