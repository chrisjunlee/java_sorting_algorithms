package sorts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class HeapTest {
    private Heap<Integer> heap;
    private static final Integer[] list1 = {3, 1, 10};
    private static final Integer[] list2 = {5, -10, 2, 4, 1, -2, 20};

    @Before
    public void setup() throws Exception {
        heap = new Heap<>();
    }

    @Test
    public void addOneTest() throws Exception {
        heap.add(1);
        Assert.assertEquals(buildExpectedList(new Integer[] {1}), heap.getHeapList());
    }

    @Test
    public void addThreeTest() throws Exception {
        addAllToHeap(list1);
        ArrayList<Integer> expected = buildExpectedList(new Integer[] {10, 1, 3});
        Assert.assertEquals(expected, heap.getHeapList());
    }

    @Test
    public void addTest() throws Exception {
        addAllToHeap(list2);
        ArrayList<Integer> expected =  buildExpectedList(new Integer[] {20, 4, 5, -10, 1, -2, 2});
        Assert.assertEquals(expected, heap.getHeapList());
    }

    @Test
    public void removeOneTest() throws Exception {
        heap.add(1);
        Assert.assertEquals((Integer)1, heap.remove());
    }

    @Test
    public void removeThreeTest() throws Exception {
        addAllToHeap(list1);
        ArrayList<Integer> expected = buildExpectedList(new Integer[] {10, 3, 1});
        Assert.assertEquals(expected, removeResult());
    }

    @Test
    public void removeTest() throws Exception{
        addAllToHeap(list2);
        ArrayList<Integer> expected = buildExpectedList(new Integer[] {20, 5, 4, 2, 1, -2, -10});
        Assert.assertEquals(expected, removeResult());
    }

    private ArrayList<Integer> buildExpectedList(Integer[] array) {
        ArrayList<Integer> expected = new ArrayList<>();
        for(Integer item : array) {
            expected.add(item);
        }
        return expected;
    }

    private void addAllToHeap(Integer[] array) {
        for(Integer item : array) {
            heap.add(item);
        }
    }

    private ArrayList<Integer> removeResult() {
        ArrayList<Integer> result = new ArrayList<>();
        int listSize = heap.getSize();
        for(int i = 0; i < listSize; i++) {
            result.add(heap.remove());
        }
        return result;
    }
}