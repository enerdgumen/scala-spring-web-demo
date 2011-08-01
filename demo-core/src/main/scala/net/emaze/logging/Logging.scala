package net.emaze.logging

import org.apache.log4j.Logger

trait Logging {

    private val logger = Logger.getLogger(getClass)

    protected def debug(message: String, args: String*) {
        logger.debug(String.format(message, args: _*))
    }
    
    protected def info(message: String, args: String*) {
        logger.info(String.format(message, args: _*))
    }

    protected def warning(message: String, args: String*) {
        logger.warn(String.format(message, args: _*))
    }

    protected def error(message: String, args: String*) {
        logger.error(String.format(message, args: _*))
    }

    protected def fatal(message: String, args: String*) {
        logger.fatal(String.format(message, args: _*))
    }
}