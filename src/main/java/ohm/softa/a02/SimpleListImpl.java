package ohm.softa.a02;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable {


    public SimpleListImpl() {

    }

    @Override
    public Iterator iterator() {
        return new SimpleIteratorImpl(this);
    }

    @Override
    public boolean include(Object item) {
        return false;
    }


    // TODO: Implement the required methods.
    private static class Element {
        private Object item;
        private Element next;

        public Object getItem() {
            return item;
        }

        public Element(Object item) {
            this.item = item;
        }

        public Element getNext() {
            return next;
        }
    }


    private class SimpleIteratorImpl implements Iterator {

        SimpleListImpl.Element cursor;

        public SimpleIteratorImpl(SimpleListImpl simpleList) {
            this.cursor = simpleList.head;
        }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Object next() {
            if (cursor != null) {
                Object data =  cursor.getItem();
                cursor = cursor.next;
                return data;
            } else return null;
        }
    }

    private Element head;


    public void add(Object item) {
        Element newItem = new Element(item);
        Element cursor = head;
        if (cursor == null) {
            head = newItem;
        }

        while (cursor != null) {
            if (cursor.next == null) {
                cursor.next = newItem;
                break;
            } else
                cursor = cursor.next;
        }


    }

    public int size() {
        int count = 0;
        Element temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    @Override
    public SimpleList filter(SimpleFilter filter) {
        SimpleListImpl simpleList = new SimpleListImpl();
        for (Object item : this) {
            if (filter.include(item)) {
                simpleList.add(item);
            }
        }
        return simpleList;
    }

}
