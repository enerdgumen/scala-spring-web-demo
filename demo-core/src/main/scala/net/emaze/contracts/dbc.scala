package net.emaze.contracts

object dbc {

    def precondition(valid: Boolean, message: String, args: Any*) {
        if (!valid) {
            throw new IllegalArgumentException(String.format(message, args))
        }
    }
    
    def statePrecondition(valid: Boolean, message: String, args: Any*) {
        if (!valid) {
            throw new IllegalStateException(String.format(message, args))
        }
    }
}
