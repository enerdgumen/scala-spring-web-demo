package net.emaze.sql

import org.hibernate.criterion.{Restrictions, Criterion}

object CriterionFactory {

    def apply(restriction: Restriction): Criterion = restriction match {
        case IdEq(value) => Restrictions.idEq(value)
        case Eq(field, value) => Restrictions.eq(field, value)
        case NotEq(field, value) => Restrictions.ne(field, value)
        case Like(field, value) => Restrictions.like(field, value)
        case ILike(field, value) => Restrictions.ilike(field, value)
        case GreaterThen(field, value) => Restrictions.gt(field, value)
        case And(lhs, rhs) => Restrictions.and(apply(lhs), apply(rhs))
    }
}