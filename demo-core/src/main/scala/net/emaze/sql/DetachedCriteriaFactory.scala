package net.emaze.sql

import org.hibernate.criterion.DetachedCriteria

object DetachedCriteriaFactory {

    implicit def apply(domain: Domain): DetachedCriteria = {
        DetachedCriteria.forEntityName(domain.table)
    }

    implicit def apply(restrictedDomain: RestrictedDomain): DetachedCriteria = {
        apply(restrictedDomain.domain).add(CriterionFactory(restrictedDomain.restriction))
    }
}