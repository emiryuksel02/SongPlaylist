package util.list;

/**
 * A singly linked list implementation.
 * 
 * @author Emir Yuksel
 * @version 1.0
 *
 * @param <T>
 */

public class LinkedList<T> implements List<T> {

    private ListCell first;
    private ListCell last;
    private int size;

    /**
     * Creates a empty list.
     */

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public List<T> add(T element) {

        ListCell newCell = new ListCell(element, null);

        if (this.first == null) {
            this.first = newCell;
        } else {
            this.last.next = newCell;
        }

        this.last = newCell;
        this.size++;

        return this;
    }

    @Override
    public boolean contains(Object o) {
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            if (it.next().equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (this.size() == 0);
    }

    @Override
    public T first() {
        if (isEmpty()) {
            return null;
        }
        return this.first.getElement();
    }

    @Override
    public T remove(T t) {
        ListCell currentCell = this.first;
        ListCell previousCell = this.first;
        int position = 0;

        while (currentCell != null && currentCell.getElement() != t) {
            previousCell = currentCell;
            currentCell = currentCell.getNext();
            position++;
        }
        if (currentCell == null) {
            return null;
        } else {
            if (this.first == currentCell) {
                this.first = currentCell.getNext();
            } else if (this.last == currentCell) {
                this.last = previousCell;
                this.last.setNext(null);
            } else {
                previousCell.setNext(currentCell.getNext());
            }
        }

        size--;
        return currentCell.getElement();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this.first);
    }

    private final class ListCell {

        private T element;
        private ListCell next;

        private ListCell(T element, ListCell next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public ListCell getNext() {
            return next;
        }

        public void setNext(ListCell listCell) {
            next = listCell;
        }

    }

    private final class ListIterator implements Iterator<T> {

        private ListCell cursor;

        private ListIterator(ListCell firstCell) {
            this.cursor = firstCell;
        }

        @Override
        public boolean hasNext() {
            return (this.cursor != null);
        }

        @Override
        public T next() {
            T currentElement = this.cursor.element;
            this.cursor = this.cursor.next;
            return currentElement;
        }
    }

}
