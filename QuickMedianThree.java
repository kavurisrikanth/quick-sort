/*
  Implementation of QuickSort using the Median of Three method
*/

import java.util.Collections;
import java.util.Arrays;
import java.util.Random;

class QuickMedianThree {

    public static void sort(Comparable[] stuff) {
        Collections.shuffle(Arrays.asList(stuff));

        System.out.println("\n");
        Generic.printArray(stuff);
        sort(stuff, 0, stuff.length - 1);
    }

    private static void sort(Comparable[] stuff, int from, int to) {

        // Base case
        if(to <= from)
            return;

        int pivot = partition(stuff, from, to);
//        System.out.println("pivot: " + pivot);
        Generic.printArray(stuff);
        sort(stuff, from, pivot - 1);
        sort(stuff, pivot + 1, to);
    }

    private static int partition(Comparable[] stuff, int from, int to) {

        int lt = from - 1, gt = to + 1, test = getTest(stuff, from, to);
        //swap(stuff, from, test);
//        System.out.println("\nfrom: " + from + " to: " + to);
//        System.out.println("test " + test + ", stuff: " + stuff[test]);

        while(true) {

            while(stuff[++lt].compareTo(stuff[test]) <= 0) {
                if(lt == to)
                    break;
            }

            while(stuff[--gt].compareTo(stuff[test]) > 0) {
//                System.out.println("compared " + stuff[gt] + " to " + stuff[test]);
                if(gt == from)
                    break;
            }

            if(lt >= gt)
                break;

//            System.out.println("swapping " + lt + " and " + gt);
            swap(stuff, lt, gt);
//            Generic.printArray(stuff);
        }

//        System.out.println("outside forever");
//        System.out.println("swapping " + test + " and " + gt);
        swap(stuff, test, gt);
//        Generic.printArray(stuff);
        return gt;
    }

    private static int getTest(Comparable[] stuff, int from, int to) {

        if(to - from <= 2)
            return from;

        //System.out.println("from: " + from + ", to: " + to);

        Random rnd = new Random();
        int ind_one = 0, ind_two = 0, ind_three = 0;

        ind_one = rnd.nextInt(to - from) + from;

        do {
            ind_two = rnd.nextInt(to - from) + from;
        } while(ind_two == ind_one);

        do {
            ind_three = rnd.nextInt(to - from) + from;
        }while(ind_three == ind_one || ind_three == ind_two);

        //System.out.println("generated one: " + ind_one + ", two: " + ind_two + ", three: " + ind_three);

        Comparable one = stuff[ind_one],
                    two = stuff[ind_two],
                    three = stuff[ind_three];

        //System.out.println("one: " + one + ", two: " + two + ", three: " + three);

        int oneTwo = one.compareTo(two),
            twoThree = two.compareTo(three),
            oneThree = one.compareTo(three);

        System.out.println();

        if((oneTwo >= 0 && oneThree <= 0) || (oneTwo <= 0 && oneThree >= 0)) {
            //System.out.println("returning " + ind_one);
            if(oneTwo >= 0 && oneThree <= 0) {
                swap(stuff, ind_two, from);
                swap(stuff, ind_three, to);
            } else {
                swap(stuff, ind_three, from);
                swap(stuff, ind_two, to);
            }
            return ind_one;
        }

        if((oneTwo <= 0 && twoThree <= 0) || (oneTwo >= 0 && twoThree >= 0)) {
            //System.out.println("returning " + ind_two);
            if(oneTwo <= 0 && twoThree <= 0) {
                swap(stuff, from, ind_one);
                swap(stuff, to, ind_three);
            } else {
                swap(stuff, from, ind_three);
                swap(stuff, to, ind_one);
            }
            return ind_two;
        }

        //System.out.println("returning " + ind_three);
        if(oneThree <= 0 && twoThree >= 0) {
            swap(stuff, from, ind_one);
            swap(stuff, to, ind_two);
        } else {
            swap(stuff, from, ind_two);
            swap(stuff, to, ind_one);
        }
        return ind_three;
    }

    private static void swap(Comparable[] stuff, int one, int two) {

        Comparable temp = stuff[one];
        stuff[one] = stuff[two];
        stuff[two] = temp;
    }
}
