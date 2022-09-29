package util.list;

public interface List<T> {

    /**
     * Adds the element to the list.
     * 
     * @param element
     * @return
     */

    List<T> add(T element);

    /**
     * Checks if the list contains the given object.
     * 
     * @param o
     * @return
     */

    boolean contains(Object o);

    /**
     * Returns the size of the list.
     * 
     * @return
     */

    int size();

    /**
     * Checks if the list is empty.
     * 
     * @return
     */

    boolean isEmpty();

    /**
     * Returns the first element of the list.
     */

    T first();

    /**
     * Removes the given element from the list.
     */

    T remove(T t);

    /**
     * Iterator for the list.
     * 
     * @return
     */

    Iterator<T> iterator();
}
