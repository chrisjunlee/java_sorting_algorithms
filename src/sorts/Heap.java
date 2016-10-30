package sorts;

import java.util.ArrayList;

public class Heap<E extends Comparable<E>> {
    private ArrayList<E> list = new ArrayList<>();

    public Heap(){
    }

    public Heap(E[] objects) {
        for (E object : objects) {
            add(object);
        }
    }

    protected ArrayList<E> getHeapList () {
        return list;
    }

    public void add(E newObject) {
        list.add(newObject);
        int currentIndex = list.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (list.get(parentIndex).compareTo(list.get(currentIndex)) < 0) {
                E temp = list.get(parentIndex);
                list.set(parentIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    public E remove() {
        E retObject = list.get(0);

        // move last leaf to root
        int lastIndex = list.size() - 1;
        list.set(0, list.get(lastIndex));
        list.remove(lastIndex);
        heapify();
        return retObject;
    }

    private void heapify() {
        int parentIndex = 0;
        int leftIndex = 2 * parentIndex + 1;
        int rightIndex = 2 * parentIndex + 2;
        while (leftIndex <= list.size() - 1) {
            // find largest child
            int largerIndex = leftIndex;
            if (rightIndex <= list.size() - 1) {
                if (list.get(rightIndex).compareTo(list.get(leftIndex)) > 0) {
                    largerIndex = rightIndex;
                }
            }

            // swap with larger child
            if (list.get(parentIndex).compareTo(list.get(largerIndex)) < 0) {
                E temp = list.get(parentIndex);
                list.set(parentIndex, list.get(largerIndex));
                list.set(largerIndex, temp);

                parentIndex = largerIndex;
            } else {
                // heap conditions met
                break;
            }

            leftIndex = 2 * parentIndex + 1;
            rightIndex = 2 * parentIndex + 2;
        }
    }

    public int getSize() {
        return list.size();
    }
}
