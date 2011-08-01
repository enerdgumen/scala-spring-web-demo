package net.emaze.scalademo.core

import org.apache.log4j.Logger

trait Logging {

    private val logger = Logger.getLogger(getClass)

    protected def debug(message: String, args: String*) {
        logger.debug(String.format(message, args))
    }
    
    protected def info(message: String, args: String*) {
        logger.info(String.format(message, args))
    }

    protected def warning(message: String, args: String*) {
        logger.warn(String.format(message, args))
    }

    protected def error(message: String, args: String*) {
        logger.error(String.format(message, args))
    }

    protected def fatal(message: String, args: String*) {
        logger.fatal(String.format(message, args))
    }
}
