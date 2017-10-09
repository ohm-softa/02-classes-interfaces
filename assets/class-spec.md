@startuml
interface SimpleFilter {
	+boolean include(Object item)
}

interface Iterable {
	+Iterator iterator()
}

interface Iterator {
	+boolean hasNext()
    +Object next()
}

interface SimpleList {
    +void add(Object item)
    +int size()
    +SimpleList filter(SimpleFilter filter)_
}

class SimpleListImpl implements SimpleList, Iterable {
	-head : Element
	+void add(Object item)
    +int size()
    +SimpleList filter(SimpleFilter filter)   
}

-class SimpleIteratorImpl implements Iterator {
}

-class Element {
	-item: Object
    -next: Element
}

Element --* SimpleListImpl : head
Element --* Element : next
SimpleFilter <-- SimpleList
SimpleIteratorImpl --> SimpleListImpl
@enduml