package net.emaze.sql

import org.hibernate.criterion.{Restrictions, Criterion}

object CriterionFactory {

    def apply(restriction: Restriction): Criterion = restriction match {
        case IdEq(value) => Restrictions.idEq(value)
        case Eq(field, value) => Restrictions.eq(field, value)
    }
}