package net

package object emaze {

    implicit def consumers[T](ts: Traversable[T]) = new emaze.collections.ConsumableCollection(ts)
}