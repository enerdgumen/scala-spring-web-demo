package net.emaze.logging

import org.apache.log4j.Logger

trait Logging {

    private val logger = Logger.getLogger(getClass)

    protected def debug(message: String) {
        logger.debug(message)
    }
    
    protected def info(message: String) {
        logger.info(message)
    }

    protected def warning(message: String) {
        logger.warn(message)
    }

    protected def error(message: String) {
        logger.error(message)
    }

    protected def fatal(message: String) {
        logger.fatal(message)
    }
}
