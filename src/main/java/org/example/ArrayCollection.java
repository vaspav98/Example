package org.example;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayCollection<T> implements Collection<T> {

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
    public <T> T[] toArray(T[] t1s) {
        if (t1s.length < this.size()) {
            return (T[]) Arrays.copyOf(array, this.size(), array.getClass());
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

    class ElementsIterator implements Iterator<T> {

        private int index = 0;
        private T lastElement = null;

        @Override
        public boolean hasNext() {
            return ArrayCollection.this.size() > index;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastElement = ArrayCollection.this.array[index];
            return ArrayCollection.this.array[index++];
        }

        @Override
        public void remove() {
            if (lastElement == null) {
                throw new IllegalStateException();
            }
            ArrayCollection.this.remove(lastElement);
            index--;
            lastElement = null;
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i <this.size(); i++) {
            result += array[i] + "\n";
        }
        return result;
    }
}
