package net.emaze

package object addons {

    implicit def consumers[T](ts: Traversable[T]) = new ConsumableCollection(ts)

    implicit def strings(string: String) = new StringAddons(string)
}