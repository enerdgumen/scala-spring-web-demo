package net.emaze.ddd

import java.io.Serializable
import org.hibernate.criterion.DetachedCriteria

trait Repository {

    def merge[E <: AnyRef](entity: E): E

    def searchAll[E <: AnyRef](query: String, args: String*): List[E]

    def searchAll[E <: AnyRef](detachedCriteria: DetachedCriteria): List[E]

    def searchById[E <: AnyRef](clazz: Class[E], id: Serializable): Option[E]

    def findById[E <: AnyRef](clazz: Class[E], id: Serializable): E
}