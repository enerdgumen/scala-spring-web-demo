package net.emaze.sql

import org.hibernate.criterion.DetachedCriteria

trait Criteriable {

    def toCriteria: DetachedCriteria
}

object SELECT {

    def apply(what: WhatSelect) = what
}

trait WhatSelect {
    
    def FROM(table: String) = new Where(table)
}

object * extends WhatSelect

class Where(table: String) extends Criteriable {

    override def toCriteria: DetachedCriteria = DetachedCriteria.forEntityName(table)
}

object Conversion {

    implicit def toCriteria(criteriable: Criteriable): DetachedCriteria = criteriable.toCriteria
}