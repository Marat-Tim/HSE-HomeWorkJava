public class Main {
    public static void printlnArray(int[] array) {
        for (int element: array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void bubbleSort2(int[] array) {
        boolean is_sorted = false;
        int i = array.length - 1;
        while (!is_sorted) {
            is_sorted = true;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] ^= array[j + 1];
                    array[j + 1] ^= array[j];
                    array[j] ^= array[j + 1];
                    is_sorted = false;
                }
            }
            i--;
        }
    }

    public static void main(String[] args) {
        int[] array = { 5, 4, 2, 3, 1 };
        bubbleSort2(array);
        printlnArray(array);
    }
}