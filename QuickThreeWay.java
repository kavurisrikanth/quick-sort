/*
  Implementation of QuickSort using the three-way partitioning method
*/

import java.util.Collections;
import java.util.Arrays;

class QuickThreeWay {

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

        int lt = from, gt = to + 1, test = from, p = from, q = to;

        while(true) {

            // handle equality in the case of lower than
            while(stuff[++lt].compareTo(stuff[test]) == 0) {
                if(lt == to) break;

                swap(stuff, lt, p++);
            }

            while(stuff[++lt].compareTo(stuff[test]) < 0) {
                if(lt == to)
                    break;
            }

            // handle equality for greater than iteration
            while(stuff[--gt].compareTo(stuff[test]) == 0) {
                if(gt == from) break;

                swap(stuff, gt, q--);
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

        int temp_one = gt - 1,
            temp_two = p;
        while(temp_one != p) {
            swap(stuff, temp_one--, temp_two--);
        }

        return gt;
    }

    private static void swap(Comparable[] stuff, int one, int two) {

        Comparable temp = stuff[one];
        stuff[one] = stuff[two];
        stuff[two] = temp;
    }
}
