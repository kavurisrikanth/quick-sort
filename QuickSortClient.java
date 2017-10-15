/*
    Tester program for Quick sort
*/

import java.util.Scanner;
import java.util.Random;
import java.util.Collections;
import java.util.Arrays;

public class QuickSortClient {
    public static void main(String[] args) {
        testQuickSort();
    }

    private static void testQuickSort() {

        int len = 0;
        Integer nums[];
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        while(sc.hasNextInt()) {
            len = sc.nextInt();
            nums = new Integer[len];
            for(int i = 0; i < len; i++)
                nums[i] = rnd.nextInt(50);

            Generic.printArray(nums);
            Quick.sort(nums);
            Generic.printArray(nums);

            Collections.shuffle(Arrays.asList(nums));
            System.out.println("\n");

            Generic.printArray(nums);
            QuickSentinel.sort(nums);
            Generic.printArray(nums);

            Collections.shuffle(Arrays.asList(nums));
            System.out.println("\n");

            Generic.printArray(nums);
            QuickMedianThree.sort(nums);
            Generic.printArray(nums);
        }
        sc.close();
    }
}
