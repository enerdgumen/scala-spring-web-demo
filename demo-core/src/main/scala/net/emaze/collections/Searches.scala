package net.emaze.collections

object Searches {

    def one[T](traversable: Traversable[T]): Option[T] = {
        val iterator = traversable.toIterator
        if (iterator.hasNext)
            Some(iterator.next ensuring (!iterator.hasNext, "found too many elements"))
        else
            None
    }

    def first[T](traversable: Traversable[T]): Option[T] = {
        traversable.headOption
    }

    def last[T](traversable: Traversable[T]): Option[T] = {
        traversable.lastOption
    }

    def all[T](traversable: Traversable[T]): List[T] = {
        traversable.toList
    }
}
