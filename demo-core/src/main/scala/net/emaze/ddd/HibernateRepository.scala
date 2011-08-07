package net.emaze.ddd

import java.io.Serializable
import scala.reflect.BeanProperty
import scala.collection.JavaConversions
import org.springframework.orm.hibernate3.HibernateOperations

class HibernateRepository extends Repository {

    @BeanProperty var hibernateOperations: HibernateOperations = _

    override def merge[E <: AnyRef](entity: E) = {
        requireDependencies
        val merged = hibernateOperations.merge(entity).asInstanceOf[E]
        assert(merged != null, "merged entity cannot be null")
        merged
    }

    override def search[E <: AnyRef](query: String, args: String*) = {
        requireDependencies
        val results = hibernateOperations.find(query, args).asInstanceOf[java.util.List[E]]
        assert(results != null, "results cannot be null")
        JavaConversions.asBuffer(results).toList
    }

    override def searchById[E <: AnyRef](clazz: Class[E], id: Serializable) = {
        requireDependencies
        val entity = hibernateOperations.get(clazz, id).asInstanceOf[E]
        if (entity == null) None else Some(entity)
    }

    override def findById[E <: AnyRef](clazz: Class[E], id: Serializable) = {
        requireDependencies
        val entity = hibernateOperations.get(clazz, id).asInstanceOf[E]
        assert(entity != null, "no entity " + clazz.getSimpleName + " found with id " + id)
        entity
    }

    private def requireDependencies {
        require(hibernateOperations != null, "hibernateOperations doesn't injected into object of type " + getClass.getName)
    }
}