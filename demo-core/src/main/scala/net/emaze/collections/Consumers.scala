package net.emaze.collections

object Consumers {

    def one[T](traversable: Traversable[T]): T = {
        val iterator = traversable.toIterator
        require(iterator.hasNext, "no elements to consume")
        iterator.next ensuring (!iterator.hasNext, "found too many elements")
    }

    def first[T](traversable: Traversable[T]): T = {
        val item = traversable.headOption
        require(item.isDefined, "no elements to consume")
        item.get
    }

    def last[T](traversable: Traversable[T]): T = {
        val item = traversable.lastOption
        require(item.isDefined, "no elements to consume")
        item.get
    }

    def all[T](traversable: Traversable[T]): List[T] = {
        require(!traversable.isEmpty, "no elements to consume")
        traversable.toList
    }
}