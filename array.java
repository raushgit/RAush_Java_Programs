// Write a program to make an array and find max. and min. element of the array and also find the index of the element 

public class array {
    public static void main(String[] args) {
        int[] array = { 5, 2, 8, 12, 3 }; // Initialize array

        int max = array[0]; // Initialize max and min with first element
        int min = array[0];
        int maxIndex = 0;
        int minIndex = 0;

        // Loop through array to find max, min and their indices
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }

        // Print results
        System.out.println("Max element: " + max);
        System.out.println("Index of Max element: " + maxIndex);
        System.out.println("Min element: " + min);
        System.out.println("Index of Min element: " + minIndex);
    }
}