package com.example.algorithms_and_data_structures;

class HighArray {
    private final long[] a;
    private int nElems;

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == searchKey) break;
        }
        return j != nElems;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (value == a[j]) break;
        }
        if (j == nElems) return false;
        else {
            for (int k = j; k < nElems; k++) { // move higher ones down
                a[k] = a[k + 1];
            }
            nElems--;
            return true;
        }
    }

    public long getMax() { // task 2.1
        long max = 0;
        if (nElems > 0) {
            for (int i = 0; i < nElems; i++) {
                if (a[i] > max) max = a[i];
            }
            return max;
        } else return -1;
    }

    public long removeMax() { // task 2.2 and 2.3
        long max = 0;
        if (nElems > 0) {
            for (int i = 0; i < nElems; i++) {
                if (a[i] > max) max = a[i];
            }

            delete(max);

            return max;
        } else return -1;
    }

    public void noDups() {
        for (int i = 0; i < nElems; i++) {
            for (int j = 0; j < nElems; j++) {
                if (i == j);
                else if (a[i] == a[j]) a[j] = 0L;
            }
        }

        for (int j = 0; j < nElems; j++) {
            delete(0);
        }
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
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
