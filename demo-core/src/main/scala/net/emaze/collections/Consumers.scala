package net.emaze.collections

import net.emaze.contracts.dbc

object Consumers {
    
    def one[T](traversable: Traversable[T]): T = {
        val iterator = traversable.toIterator
        dbc.precondition(iterator.hasNext, "no elements to consume")
        val item = iterator.next
        dbc.precondition(!iterator.hasNext, "found too many elements")
        item
    }
    
    def first[T](traversable: Traversable[T]): T = {
        val item = traversable.headOption
        dbc.precondition(item.isDefined, "no elements to consume")
        item.get
    }

    def last[T](traversable: Traversable[T]): T = {
        val item = traversable.lastOption
        dbc.precondition(item.isDefined, "no elements to consume")
        item.get
    }
    
    def all[T](traversable: Traversable[T]): List[T] = {
        dbc.precondition(!traversable.isEmpty, "no elements to consume")
        traversable.toList
    }
}