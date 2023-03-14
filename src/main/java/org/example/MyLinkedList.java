package org.example;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyLinkedList<T> implements List<T> {

    private Item<T> firstInList = null;

    private Item<T> lastInList = null;

    private int size;

    @Override
    public final int size() {
        return this.size;
    }

    @Override
    public final boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public final boolean contains(final Object o) {
        if (firstInList == null) {
            return false;
        }
        for (T elementInItem : this) {
            if (Objects.equals(o, elementInItem)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final Iterator<T> iterator() {
        return new ElementsIterator(0);
    }

    @Override
    public final Object[] toArray() {
        final T[] newM = (T[]) new Object[this.size()];
        int i = 0;

        for (T element : this) {
            newM[i++] = element;
        }
        return newM;
    }

    @Override
    public final <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            a = (T1[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        }
        int i = 0;

        Object[] result = a;
        for (Item<T> e = firstInList; e != null; e = e.nextItem) {
            result[i++] = e.element;
        }
        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    @Override
    public final boolean add(final T newElement) {
        // BEGIN (write your solution here)
        Item<T> newItem = new Item(newElement, lastInList, null);
        if (firstInList == null) {
            firstInList = newItem;
        } else {
            lastInList.nextItem = newItem;
        }
        lastInList = newItem;
        size++;
        return true;
        // END
    }

    @Override
    public final void add(final int index, final T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean remove(final Object o) {
        // BEGIN (write your solution here)
        for (Item<T> current = firstInList; current != null; current = current.nextItem) {
            if (o.equals(current.element)) {
                this.remove(current);
                if (this.size() == 1) {
                    this.firstInList = null;
                    this.lastInList = null;
                } else {
                    if (current == firstInList) {
                        firstInList = current.nextItem;
                        firstInList.prevItem = null;
                    }
                    if (current == lastInList) {
                        lastInList = current.prevItem;
                        lastInList.nextItem = null;
                    }
                    if (current.nextItem != null && current.prevItem != null) {
                        current.prevItem.nextItem = current.nextItem;
                        current.nextItem.prevItem = current.prevItem;
                    }
                }
                size--;
                return true;
            }
        }
        return false;
        // END
    }

    @Override
    public final T remove(final int index) throws IndexOutOfBoundsException {
        // BEGIN (write your solution here)
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        int i = 0;
        Item<T> current = firstInList;
        while (i != index) {
            current = current.nextItem;
            i++;
        }

        T oldElement = this.get(index);

        if (this.size() == 1) {
            this.firstInList = null;
            this.lastInList = null;
        } else {
            if (current == firstInList) {
                firstInList = current.nextItem;
                firstInList.prevItem = null;
            }
            if (current == lastInList) {
                lastInList = current.prevItem;
                lastInList.nextItem = null;
            }
            if (current.nextItem != null && current.prevItem != null) {
                current.prevItem.nextItem = current.nextItem;
                current.nextItem.prevItem = current.prevItem;
            }
        }
        size--;
        return oldElement;
        // END
    }

    private void remove(final Item<T> current) {
        if (current != null) {
            if (this.size() == 1) {
                this.firstInList = null;
                this.lastInList = null;
            } else {
                if (current == firstInList) {
                    firstInList = current.nextItem;
                    firstInList.prevItem = null;
                }
                if (current == lastInList) {
                    lastInList = current.prevItem;
                    lastInList.nextItem = null;
                }
                if (current.nextItem != null && current.prevItem != null) {
                    current.prevItem.nextItem = current.nextItem;
                    current.nextItem.prevItem = current.prevItem;
                }
            }
            size--;
        }
    }

    @Override
    public final boolean containsAll(final Collection<?> c) {
        for (final Object item : c) {
            if (!this.contains(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final boolean addAll(final Collection<? extends T> c) {
        for (final T item : c) {
            add(item);
        }
        return true;
    }

    @Override
    public final boolean addAll(final int index, final Collection elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean removeAll(final Collection<?> c) {
        for (final Object item : c) {
            remove(item);
        }
        return true;
    }

    @Override
    public final boolean retainAll(final Collection<?> c) {
        this.removeIf(item -> !c.contains(item));
        return true;
    }

    @Override
    public final void clear() {
        this.firstInList = null;
        this.lastInList = null;
        size = 0;
    }

    @Override
    public final List<T> subList(final int start, final int end) {
        return null;
    }

    @Override
    public final ListIterator<T> listIterator() {
        return new ElementsIterator(0);
    }

    @Override
    public final ListIterator<T> listIterator(final int index) {
        return new ElementsIterator(index);
    }

    @Override
    public final int lastIndexOf(final Object target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final int indexOf(final Object o) {
        int i = 0;
        if (o == null) {
            for (Item<T> current = firstInList; current != null; current = current.nextItem) {
                if (current.element == null) {
                    return i;
                }
                i++;
            }
        } else {
            for (Item<T> current = firstInList; current != null; current = current.nextItem) {
                if (o.equals(current.element)) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    @Override
    public final T set(final int index, final T element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        final Item<T> item = getItemByIndex(index);
        T tempElement = item.element;
        item.element = element;
        return tempElement;
    }

    @Override
    public final T get(final int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        return getItemByIndex(index).element;
    }

    private Item<T> getItemByIndex(final int index) {
        int i = 0;
        Item<T> current = firstInList;
        while (i != index) {
            current = current.nextItem;
            i++;
        }
        return current;
    }

    private class ElementsIterator implements ListIterator<T> {

        private Item<T> currentItemInIterator;

        private Item<T> lastReturnedItemFromIterator;

        private int index;

        ElementsIterator(final int index) {
            this.currentItemInIterator = (index == size) ? null : getItemByIndex(index);
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return this.index < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            lastReturnedItemFromIterator = currentItemInIterator;
            currentItemInIterator = currentItemInIterator.getNextItem();
            index++;
            return lastReturnedItemFromIterator.element;
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        //CHECKSTYLE: stop InnerAssignment check
        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }

            if (currentItemInIterator == null) {
                lastReturnedItemFromIterator = currentItemInIterator = lastInList;
            } else {
                lastReturnedItemFromIterator
                        = currentItemInIterator
                        = currentItemInIterator.getPrevItem();
            }
            /*lastReturnedItemFromIterator
            = currentItemInIterator
            = (currentItemInIterator == null) ? lastInList : currentItemInIterator.prevItem;*/
            index--;
            return lastReturnedItemFromIterator.element;
        }
        //CHECKSTYLE: resume InnerAssignment check

        @Override
        public void add(final T element) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(final T element) {
            if (lastReturnedItemFromIterator == null) {
                throw new IllegalStateException();
            }
            lastReturnedItemFromIterator.element = element;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public void remove() {
            if (lastReturnedItemFromIterator == null) {
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(lastReturnedItemFromIterator);
            lastReturnedItemFromIterator = null;
            index--;
        }
    }

    private static class Item<T> {

        private T element;

        private Item<T> nextItem;

        private Item<T> prevItem;

        Item(final T element, final Item<T> prevItem, final Item<T> nextItem) {
            this.element = element;
            this.nextItem = nextItem;
            this.prevItem = prevItem;
        }

        public Item<T> getNextItem() {
            return nextItem;
        }

        public Item<T> getPrevItem() {
            return prevItem;
        }
    }

    public String toString() {
        var result = new StringBuilder();
        for (Item<T> current = firstInList; current != null; current = current.nextItem) {
            result.append(current.element);
        }
        return result.toString();
    }
}

