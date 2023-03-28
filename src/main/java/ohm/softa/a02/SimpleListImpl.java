package ohm.softa.a02;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable {

    Element head = null;

    @Override
    public java.util.Iterator iterator() {
        Iterator iterator = new Iterator();
        return iterator;
    }

    @Override
    public void add(Object o) {
        Element e = new Element(o, null);
        if (head != null) {
            Element current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = e;
        } else
            head = e;
    }

    @Override
    public int size() {
        if (head == null) {
            return 0;
        }
        int counter = 0;
        Element e = head;
        while (e != null) {
            counter++;
            e = e.next;
        }
        return counter;
    }

    @Override
    public SimpleList filter(SimpleFilter filter) {
        SimpleListImpl filteredList = new SimpleListImpl();
        Element current = head;
        while (current != null) {
            if (filter.include(current.obj))
                filteredList.add(current.obj);
            current = current.next;
        }
        if (filteredList.size() == 0)
            System.out.println("List is empty!");
        return filteredList;
    }

    private static class Element {
        Object obj;
        Element next;

        public Element(Object obj, Element next) {
            this.obj = obj;
            this.next = next;
        }
    }

    class Iterator implements java.util.Iterator {

        private Element currentElement = head;

        @Override
        public boolean hasNext() {
            return currentElement != null;
        }

        @Override
        public Object next() {
            Element temp = currentElement;
            currentElement = currentElement.next;
            return temp.obj;
        }
    }

}
