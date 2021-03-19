package ohm.softa.a02;

import java.util.Iterator;
import java.lang.Iterable;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable<Object> {

    private static class Element {
        private Object obj;
        private Element next;

        Element(Object obj) {
            this.obj = obj;
            this.next = null;
        }

        public Element GetNext() {
            return next;
        }

        public void SetNext(Element next) {
            this.next = next;
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
            while (current.GetNext() != null) {
                current = current.GetNext();
            }
            current.SetNext(new Element(obj));
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
    public Iterator<Object> iterator() {
        return null;
    }
}