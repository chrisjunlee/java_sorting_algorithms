package sorts;
import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortAlgorithmsTest {
    private static int[] list1 = {2, 3, 9, 0, 7, 6, 1};
    private static int[] list2 = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    private static int[] list3 = {6, 1, 9, 2, 3, 8, 10, 3, 7, 5, 4};
    private static Integer[] list4 = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    @Test
    public void bubbleSortSimpleArrayTest() throws Exception {
        SortAlgorithms.bubbleSort(list1);
        Assert.assertArrayEquals(new int[] {0, 1, 2, 3, 6, 7, 9}, list1);
    }

    @Test
    public void mergeSortSimpleArrayTest() throws Exception {
        SortAlgorithms.mergeSort(list2);
        Assert.assertArrayEquals(new int[] {-2, 1, 2, 2, 3, 3, 5, 6, 12, 14}, list2);
    }

    @Test
    public void quickSortSimpleArrayTest() throws Exception {
        SortAlgorithms.quickSort(list3);
        Assert.assertArrayEquals(new int[] {1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10}, list3);
    }

    @Test
    public void heapSortSimpleArrayTest() throws Exception {
        SortAlgorithms.heapSort(list4);
        Assert.assertArrayEquals(new Integer[] {-2, 1, 2, 2, 3, 3, 5, 6, 12, 14}, list4);

    }
}