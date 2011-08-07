package net.emaze.collections


class ConstrainedCollection[T](val traversable: Traversable[T]) {

    def findOne: T = {
        val iterator = traversable.toIterator
        require(iterator.hasNext, "no elements to consume")
        iterator.next ensuring (!iterator.hasNext, "found too many elements")
    }

    def findFirst: T = {
        require(!traversable.isEmpty, "no elements to consume")
        traversable.head
    }

    def findLast: T = {
        require(!traversable.isEmpty, "no elements to consume")
        traversable.last
    }

    def findAll: List[T] = {
        require(!traversable.isEmpty, "no elements to consume")
        traversable.toList
    }

    def searchOne: Option[T] = {
        val iterator = traversable.toIterator
        if (iterator.hasNext)
            Some(iterator.next ensuring (!iterator.hasNext, "found too many elements"))
        else
            None
    }

    @inline
    def searchFirst: Option[T] = {
        traversable.headOption
    }

    @inline
    def searchLast: Option[T] = {
        traversable.lastOption
    }

    @inline
    def searchAll: List[T] = {
        traversable.toList
    }
}