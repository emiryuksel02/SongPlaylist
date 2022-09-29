package util.list;

/**
 * Provides methods for iterator of the list.
 * 
 * @author Emir Yuksel
 * @version 1.0
 *
 * @param <T>
 */

public interface Iterator<T> {

    /**
     * Checks if there is an element after the element.
     * 
     * @return
     */
    boolean hasNext();

    /**
     * Returns the next element.
     * 
     * @return
     */
    T next();

}
