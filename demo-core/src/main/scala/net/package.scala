package net

package object emaze {

    implicit def toConstrainedCollection[T](ts: Traversable[T]) = new emaze.collections.ConstrainedCollection(ts)
}