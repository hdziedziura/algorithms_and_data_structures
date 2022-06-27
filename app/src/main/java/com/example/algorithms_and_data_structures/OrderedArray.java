package com.example.algorithms_and_data_structures;

public class OrderedArray {
    private final long[] a;
    private int nElems;

    public OrderedArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey) return curIn;
            else if (lowerBound > upperBound) return nElems;
            else {
                if (a[curIn] < searchKey) lowerBound = curIn + 1; // it’s in upper half
                else upperBound = curIn - 1; // it’s in lower half
            }
        }
    }

    public void insertBinary(long value) { // task 2.4
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int index;
        while (true) {
            index = (lowerBound + upperBound) / 2;

            if (index == 0) break; // case when inserted value is the smallest
            if (a[index - 1] <= value && a[index] >= value) break;
            else if (lowerBound > upperBound) { // case when inserted value is the largest
                index = index + 1;
                break;
            } else {
                if (a[index] < value) lowerBound = index + 1; // it's in upper half
                else upperBound = index - 1; // it's in lower half
            }
        }

        for (int k = nElems; k > index; k--) {
            a[k] = a[k - 1];
        }

        a[index] = value;
        nElems++;
    }

    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] > value) break;
        }

        for (int k = nElems; k > j; k--) { // move bigger ones up
            a[k] = a[k - 1];
        }

        a[j] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems) return false;
        else {
            for (int k = j; k < nElems; k++) { // move bigger ones down
                a[k] = a[k + 1];
            }

            nElems--;
            return true;
        }
    }

    public void merge(OrderedArray arr, OrderedArray arr1) {
        int i = 0; // first array iterator
        int j = 0; // second array iterator
        int k = 0; // merged array iterator
        nElems = arr.size() + arr1.size();

        long[] list = arr.toArray();
        long[] list1 = arr1.toArray();

        while (i < list.length && j < list1.length) {
            if (list[i] < list1[j]) {
                a[k] = list[i];
                i++;
            } else {
                a[k] = list1[j];
                j++;
            }
            k++;
        }

        while (i < list.length) {
            a[k] = list[i];
            i++;
            k++;
        }

        while (j < list1.length) {
            a[k] = list1[j];
            j++;
            k++;
        }
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println(" ");
    }

    public long[] toArray() {
        long[] list = new long[nElems];
        for (int i = 0; i < nElems; i++) {
            list[i] = a[i];
        }
        return list;
    }
}
