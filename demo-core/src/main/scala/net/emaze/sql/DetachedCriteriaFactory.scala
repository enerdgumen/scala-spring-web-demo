package net.emaze.sql

import org.hibernate.criterion.DetachedCriteria
import net.emaze.ddd.Repository

object DetachedCriteriaFactory {

    implicit def apply(domain: Domain): DetachedCriteria = {
        DetachedCriteria.forEntityName(domain.table)
    }

    implicit def apply(restrictedDomain: RestrictedDomain): DetachedCriteria = {
        apply(restrictedDomain.domain).add(CriterionFactory(restrictedDomain.restriction))
    }

    implicit def perform[E <: AnyRef](domain: Domain)(implicit repository: Repository): List[E] = {
        repository.searchAll[E](apply(domain))
    }

    implicit def perform[E <: AnyRef](restrictedDomain: RestrictedDomain)(implicit repository: Repository): List[E] = {
        repository.searchAll[E](apply(restrictedDomain))
    }
}