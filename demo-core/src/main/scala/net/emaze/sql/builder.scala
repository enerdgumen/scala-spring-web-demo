package net.emaze.sql

import org.hibernate.criterion.{Criterion, Restrictions, DetachedCriteria}

trait Criteriable {

    def toCriteria: DetachedCriteria
}

object SELECT {

    def apply(domain: WithDomain) = domain
}

trait WithDomain {

    def FROM(table: String) = new Domain(table)
}
object * extends WithDomain

class Domain(table: String) extends Criteriable {

    def WHERE(restriction: Restriction) = new RestrictedDomain(this, restriction)

    override def toCriteria = DetachedCriteria.forEntityName(table)
}

class RestrictedDomain(criteriable: Criteriable, restriction: Restriction) extends Criteriable {

    override def toCriteria = criteriable.toCriteria.add(restriction.toCriterion)
}

trait Restriction {

    def toCriterion: Criterion
}

class EqRestriction(field: String, value: Any) extends Restriction {

    override def toCriterion = Restrictions.eq(field, value)
}

class Field(field: String) {

    def ===(value: Any): Restriction = new EqRestriction(field, value)
}

object Conversion {

    implicit def toCriteria(criteriable: Criteriable): DetachedCriteria = criteriable.toCriteria

    implicit def toField(field: String) = new Field(field)
}