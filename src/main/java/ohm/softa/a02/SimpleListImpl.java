package ohm.softa.a02;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable<Object> {

    private ListElement head;
    private int size;

    public SimpleListImpl() {
        head = null;
    }

    /**
     * Add an object to the end of the list
     * @param item item to add
     */
    public void add(Object item){
        /* special case empty list */
        if(head == null){
            head = new ListElement(item);
        }else {
            /* any other list length */
            ListElement current = head;
            while (current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(new ListElement(item));
        }
        size++;
    }

    /**
     * @return size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Get a new SimpleList instance with all items of this list which match the given filter
     * @param filter SimpleFilter instance
     * @return new SimpleList instance
     */
    public SimpleList filter(SimpleFilter filter){
        SimpleList result = new SimpleListImpl();
        for(Object o : this){
            if(filter.include(o)){
                result.add(o);
            }
        }
        return result;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Iterator<Object> iterator() {
        return new SimpleIterator();
    }

    /**
     * Helper class which implements the Iterator<T> interface
     * Has to be non static because otherwise it could not access the head of the list
     */
    private class SimpleIterator implements Iterator<Object> {

        private ListElement current = head;

        /**
         * @inheritDoc
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * @inheritDoc
         */
        @Override
        public Object next() {
            Object tmp = current.getItem();
            current = current.getNext();
            return tmp;
        }
    }

    /**
     * Helper class for the linked list
     * can be static because the ListElement does not need to access the SimpleList instance
     */
    private static class ListElement {
        private Object item;
        private ListElement next;

        ListElement(Object item) {
            this.item = item;
            this.next = null;
        }

        /**
         * @return get object in the element
         */
        public Object getItem() {
            return item;
        }

        /**
         * @return successor of the ListElement - may be NULL
         */
        public ListElement getNext() {
            return next;
        }

        /**
         * Sets the successor of the ListElement
         * @param next ListElement
         */
        public void setNext(ListElement next) {
            this.next = next;
        }
    }

}
