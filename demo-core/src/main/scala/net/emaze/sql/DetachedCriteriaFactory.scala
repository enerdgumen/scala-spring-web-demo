package net.emaze.sql

import org.hibernate.criterion.{Restrictions, Criterion, DetachedCriteria}

object DetachedCriteriaFactory {

    implicit def apply(domain: Domain): DetachedCriteria = {
        DetachedCriteria.forEntityName(domain.table)
    }

    implicit def apply(restrictedDomain: RestrictedDomain): DetachedCriteria = {
        apply(restrictedDomain.domain).add(toCriterion(restrictedDomain.restriction))
    }

    private def toCriterion: Restriction => Criterion = {
        case Eq(field, value) => Restrictions.eq(field, value)
    }
}