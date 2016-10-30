package sorts;

public class SortAlgorithms {
    public static void bubbleSort(int[] list) {
        boolean needNextPass = true;

        for (int i = 1; i < list.length && needNextPass; i++) {
            needNextPass = false;
            for (int k = 0; k < list.length - i; k++) {
                if (list[k] > list[k+1]) {
                    int temp = list[k];
                    list[k] = list[k+1];
                    list[k+1] = temp;
                    needNextPass = true;
                }
            }
        }
    }

    public static void mergeSort(int[] list) {
        if(list.length > 1) {
            int leftLength = list.length/2;
            int[] leftHalf = new int[leftLength];
            System.arraycopy(list, 0, leftHalf, 0, leftLength);
            mergeSort(leftHalf);

            int rightLength = list.length - leftLength;
            int[] rightHalf = new int[rightLength];
            System.arraycopy(list, leftLength, rightHalf, 0, rightLength);
            mergeSort(rightHalf);

            merge(leftHalf, rightHalf, list);
        }
    }

    private static void merge(int[] left, int[] right, int[] temp) {
        int leftIndex = 0;
        int rightIndex = 0;
        int tempIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                temp[tempIndex++] = left[leftIndex++];
            }
            else {
                temp[tempIndex++] = right[rightIndex++];
            }
        }

        // add the rest
        while (leftIndex < left.length) {
            temp[tempIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            temp[tempIndex++] = right[rightIndex++];
        }
    }

    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    public static void quickSort (int[] list, int start, int end) {
        if ( end > start ) {
            int pivotIndex = partition(list, start, end);
            quickSort(list, start, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, end);
        }
    }

    private static int partition (int[] list, int start, int end ) {
        if (start >= end)
            return start;

        int pivot = list[start];
        int low = start + 1;
        int high = end;

        while (low < high) {
            // careful: the low <= high check comes first, else index out of bound!
            while (low <= high && list[low] <= pivot)
                low++;

            while (low <= high && list[high] > pivot)
                high--;

            if (high > low) {
                int temp = list[low];
                list[low] = list[high];
                list[high] = temp;
            }
        }

        while (list[high] > pivot)
            high--;

        int temp = list[high];
        list[high] = list[start];
        list[start] = temp;

        return high;
    }

    public static <E extends Comparable<E>> void heapSort (E[] list) {
        Heap<E> heap = new Heap<>(list);
        int size = heap.getSize();      // important: do not use "getSize()" inside loop conditional

        for(int i = 0; i < size; i++) {
            list[size - 1 - i] = heap.remove();
        }
    }
}
