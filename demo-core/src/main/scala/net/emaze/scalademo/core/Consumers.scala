package net.emaze.scalademo.core

object Consumers {

    def searchOne[T](traversable: Traversable[T]): Option[T] = {
        val iterator = traversable.toIterator
        if (iterator.hasNext) {
            val item = iterator.next
            dbc.precondition(!iterator.hasNext, "found too many elements")
            Some(item)
        } else None
    }
    
    def findOne[T](traversable: Traversable[T]): T = {
        val iterator = traversable.toIterator
        dbc.precondition(iterator.hasNext, "no elements to consume")
        val item = iterator.next
        dbc.precondition(!iterator.hasNext, "found too many elements")
        item
    }
    
    def searchFirst[T](traversable: Traversable[T]): Option[T] = {
        traversable.headOption
    }
    
    def findFirst[T](traversable: Traversable[T]): T = {
        val item = traversable.headOption
        dbc.precondition(item.isDefined, "no elements to consume")
        item.get
    }
    
    def searchAll[T](traversable: Traversable[T]): List[T] = {
        traversable.toList
    }
    
    def findAll[T](traversable: Traversable[T]): List[T] = {
        dbc.precondition(!traversable.isEmpty, "no elements to consume")
        traversable.toList
    }
}
