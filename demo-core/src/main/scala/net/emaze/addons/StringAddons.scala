package net.emaze.addons

class StringAddons(self: String) {

    def %(args: Any*) = self.format(args: _*)
}
