package ohm.softa.a02;

import java.util.Iterator;
import java.lang.Iterable;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable {

    private static class Element {

        private Object obj;
        private Element next;

        Element(Object obj) {
            this.obj = obj;
            this.next = null;
        }
    }

    private class SimpleIteratorImpl implements Iterator {
        Element current;

        public SimpleIteratorImpl() {
            current = SimpleListImpl.this.head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            Object obj = current.obj;
            current = current.next;

            return obj;
        }
    }

    private Element head;
    private int size;

    public SimpleListImpl() {
        head = null;
    }

    @Override
    public void add(Object obj) {
        if (head == null) {
            head = new Element(obj);
        } else {
            Element current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Element(obj);
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public SimpleList filter(SimpleFilter filter) {

        SimpleList list = new SimpleListImpl();

        for (Object obj : this) {
            if (filter.include(obj)) {
                list.add(obj);
            }
        }
        return list;
    }

    @Override
    public Iterator iterator() {
        return new SimpleIteratorImpl();
    }
}