package net.emaze.sql

object SELECT {

    def apply(domain: WithDomain) = domain
}

trait WithDomain {

    def FROM(table: String) = new Domain(table)
}
object * extends WithDomain

class Domain(val table: String) {

    def WHERE(restriction: Restriction) = new RestrictedDomain(this, restriction)
}

class RestrictedDomain(val domain: Domain, val restriction: Restriction)

sealed abstract class Restriction
case class IdEq(value: Any) extends Restriction
case class Eq(field: String, value: Any) extends Restriction

class Field(field: String) {

    def ===(value: Any) = Eq(field, value)
}

object ID {

    def ===(value: Any) = IdEq(value)
}

object Conversion {
    
    implicit def toField(field: String) = new Field(field)
}