package net.emaze.ddd

import java.io.Serializable
import scala.reflect.BeanProperty
import scala.collection.JavaConversions
import org.springframework.orm.hibernate3.HibernateOperations

class HibernateRepository extends Repository {

    @BeanProperty var hibernateOperations: HibernateOperations = _

    override def merge[E <: AnyRef](entity: E) = {
        requireHibernate
        hibernateOperations.merge(entity).asInstanceOf[E] ensuring (_ != null, "merged entity cannot be null")
    }

    override def searchAll[E <: AnyRef](query: String, args: String*) = {
        requireHibernate
        val results = hibernateOperations.find(query, args).asInstanceOf[java.util.List[E]] ensuring (_ != null, "results cannot be null")
        JavaConversions.asBuffer(results).toList
    }

    override def searchById[E <: AnyRef](clazz: Class[E], id: Serializable) = {
        requireHibernate
        val entity = hibernateOperations.get(clazz, id).asInstanceOf[E]
        if (entity == null) None else Some(entity)
    }

    override def findById[E <: AnyRef](clazz: Class[E], id: Serializable) = {
        requireHibernate
        hibernateOperations.get(clazz, id).asInstanceOf[E] ensuring (_ != null, "no entity %s found with id %s" format (clazz.getSimpleName, id))
    }

    private def requireHibernate {
        require(hibernateOperations != null, "hibernateOperations doesn't injected into object of type " + getClass.getName)
    }
}