@startuml
interface SimpleFilter {
	+boolean include(Object item)
}

interface "Iterable<T>" {
	+Iterator<T> iterator()
}

interface "Iterator<T>" {
	+boolean hasNext()
    +T next()
}

class SimpleList {
	-head : ListElement
	+void add(Object item)
    +int getSize()
    +SimpleList filter(SimpleFilter filter)   
}

-class SimpleIterator {
}

-class ListElement {
	-item: Object
    -next: ListElement
    -void add(Object item)
    +Object getItem()
    +ListElement getNext()
}

"Iterable<T>" <|-- SimpleList
"Iterator<T>" <|-- SimpleIterator
ListElement *-- SimpleList : head
ListElement *-- ListElement : next
@enduml