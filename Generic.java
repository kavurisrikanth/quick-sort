/*
    Generic functions
*/

class Generic {

    public static void printArray(Comparable[] stuff) {
        System.out.print("[");
        for(int i = 0; i < stuff.length; i++) {
            System.out.print(stuff[i]);
            if(i != stuff.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}
