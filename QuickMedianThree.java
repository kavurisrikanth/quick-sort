/*
  Implementation of QuickSort using the Median of Three method
*/

import java.util.Collections;
import java.util.Arrays;

class QuickMedianThree {

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

        int lt = from, gt = to + 1, test = getTest(stuff, from, to);

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

    private static int getTest(Comparable[] stuff, int from, int to) {

        if(to - from < 2)
            return 0;

        Comparable one = stuff[from],
                    two = stuff[to],
                    three = stuff[from + (to - from)/2];

        int oneTwo = one.compareTo(two),
            twoThree = two.compareTo(three),
            oneThree = one.compareTo(three);

        if((oneTwo >= 0 && oneThree <= 0) || (oneTwo <= 0 && oneThree >= 0))
            return from;

        if((oneTwo <= 0 && twoThree <= 0) || (oneTwo >= 0 && twoThree >= 0))
            return to;

        return from + (to - from)/2;
    }

    private static void swap(Comparable[] stuff, int one, int two) {

        Comparable temp = stuff[one];
        stuff[one] = stuff[two];
        stuff[two] = temp;
    }
}
