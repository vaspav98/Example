package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements List<T> {

    private T[] array = (T[]) new Object[1];
    private int size = 0;


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < this.size(); i++) {
            if (array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator();
    }

    @Override
    public Object[] toArray() {
        T[] newArray = (T[]) new Object[this.size()];
        System.arraycopy(array, 0, newArray, 0, this.size());
        return newArray;
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        if (t1s.length < this.size()) {
            return (T1[]) Arrays.copyOf(array, this.size(), array.getClass());
        } else {
            System.arraycopy(array, 0, t1s, 0, this.size());
            return t1s;
        }
    }

    @Override
    public boolean add(T t) {
        if (this.size() == array.length) {
            T[] oldArray = array;
            array = (T[]) new Object[this.size() * 2];
            for (int i = 0; i < oldArray.length; i++) {
                array[i] = oldArray[i];
            }
        }
        array[this.size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < this.size(); i++) {
            if (array[i].equals(o) && i != this.size() - 1) {
                System.arraycopy(array, i + 1, array, i, this.size() - i - 1);
                size--;
                return true;
            }
            if (array[i].equals(o) && i == this.size() - 1) {
                array[i] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object item : collection) {
            if (!this.contains(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        for (T item : collection) {
            this.add(item);
        }
        return true;
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        for (int i = 0; i < collection.size(); i++) {
            for (Object item : collection) {
                this.remove(item);
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        for (int i = 0; i < this.size(); i++) {
            if (!collection.contains(array[i])) {
                this.remove(array[i]);
                i -= 1;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        this.array = (T[]) new Object[1];
        this.size = 0;
    }

    @Override
    public T get(int i) {
        return array[i];
    }

    @Override
    public T set(int i, T t) {
        array[i] = t;
        return null;
    }

    @Override
    public void add(int i, T t) {
        if (i < 0 || i > this.size()) {
            throw new IndexOutOfBoundsException();
        }
        if (this.size() == array.length) {
            T[] oldArray = array;
            array = (T[]) new Object[this.size() * 2];
            System.arraycopy(oldArray, 0, array, 0, i);
            this.set(i, t);
            System.arraycopy(oldArray, i, array, i + 1, this.size() - i);
        } else {
            System.arraycopy(array, i, array, i + 1, this.size() - i);
            this.set(i, t);
        }
        size++;
    }

    @Override
    public T remove(int i) {
        T removedElement = array[i];
        if (i == this.size() - 1) {
            array[i] = null;
            size--;
            return removedElement;
        }
        System.arraycopy(array, i + 1, array, i, this.size() - i - 1);
        size--;
        return removedElement;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < this.size(); i ++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int result = -1;
        for (int i = 0; i < this.size(); i ++) {
            if (array[i].equals(o)) {
                result = i;
            }
        }
        return result;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ElementsIterator();
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        return new ElementsIterator(i);
    }

    @Override
    public List<T> subList(int i, int i1) {
        return null;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i <this.size(); i++) {
            result += array[i] + "\n";
        }
        return result;
    }

    private class ElementsIterator implements ListIterator<T> {

        private static final int LAST_IS_NOT_SET = -1;
        private int index;
        private int lastIndex = LAST_IS_NOT_SET;

        ElementsIterator() {
            this(0);
        }

        ElementsIterator(final int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return MyArrayList.this.size() > index;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastIndex = nextIndex();
            index++;
            return MyArrayList.this.array[lastIndex];
        }

        @Override
        public int nextIndex() {
            if (!hasNext()) {
                return MyArrayList.this.size();
            }
            return index;
        }

        @Override
        public boolean hasPrevious() {
            return 0 < index;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            lastIndex = previousIndex();
            index--;
            return MyArrayList.this.array[lastIndex];
        }

        @Override
        public int previousIndex() {
            if (!hasPrevious()) {
                return -1;
            }
            return index - 1;
        }

        @Override
        public void add(final T element) {
            MyArrayList.this.add(index, element);
            lastIndex = LAST_IS_NOT_SET;
            index += 1;
        }

        @Override
        public void set(final T element) {
            if (lastIndex == LAST_IS_NOT_SET) {
                throw new IllegalStateException();
            }
            MyArrayList.this.set(lastIndex, element);
        }

        @Override
        public void remove() {
            secretRemove();
        }

        private void secretRemove() {
            if (lastIndex == LAST_IS_NOT_SET) {
                throw new IllegalStateException();
            }
            MyArrayList.this.remove(lastIndex);
            index--;
            lastIndex = LAST_IS_NOT_SET;
        }
    }
}
