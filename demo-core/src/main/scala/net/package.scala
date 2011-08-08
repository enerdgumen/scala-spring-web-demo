package net

package object emaze {

    implicit def consumers[T](ts: Traversable[T]) = new emaze.collections.ConsumableCollection(ts)

    private class StringAddons(self: String) {
        def %(args: Any*) = self.format(args: _*)
    }

    implicit def strings(string: String) = new StringAddons(string)
}