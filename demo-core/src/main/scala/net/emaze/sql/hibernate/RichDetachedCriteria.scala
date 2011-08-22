package net.emaze.sql.hibernate

import org.hibernate.criterion.DetachedCriteria
import net.emaze.ddd.Repository
import net.emaze.sql.dsl.{RestrictedDomain, Domain}

class RichDetachedCriteria(detachedCriteria: DetachedCriteria) {
    
    def asList[E <: AnyRef](implicit repository: Repository) = {
        repository.searchAll[E](detachedCriteria)
    }
}

object RichDetachedCriteria {

    implicit def richDetachedCriteria(domain: Domain) = {
        new RichDetachedCriteria(DetachedCriteriaFactory(domain))
    }

    implicit def richDetachedCriteria(restrictedDomain: RestrictedDomain) = {
        new RichDetachedCriteria(DetachedCriteriaFactory(restrictedDomain))
    }
}