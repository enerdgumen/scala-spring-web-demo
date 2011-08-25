package net.emaze.sql.dsl

object SELECT {

    def FROM(table: String) = new Domain(table)
}

class Domain(val table: String) {

    def WHERE(restriction: Restriction) = new RestrictedDomain(this, restriction)
}

class RestrictedDomain(val domain: Domain, val restriction: Restriction)

sealed abstract class Restriction {

    def &&(rhs: Restriction) = And(this, rhs)
    // TODO: ...
}

case class IdEq(value: Any) extends Restriction
case class Eq(field: String, value: Any) extends Restriction
case class NotEq(field: String, value: Any) extends Restriction
case class Like(field: String, value: String) extends Restriction
case class ILike(field: String, value: String) extends Restriction
case class GreaterThen(field: String, value: Any) extends Restriction
case class And(lhs: Restriction, rhs: Restriction) extends Restriction
// TODO: ...

object ID {

    def ===(value: Any) = IdEq(value)
}

class Field(name: String) {

    def ===(value: Any) = Eq(name, value)
    def !==(value: Any) = NotEq(name, value)
    def LIKE(value: String) = Like(name, value)
    def ILIKE(value: String) = ILike(name, value)
    def >(value: Any) = GreaterThen(name, value)
    // TODO: ...
}

object Conversion {
    
    implicit def field(name: String) = new Field(name)
}