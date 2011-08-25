package net.emaze.ddd

import java.io.Serializable
import scala.reflect.BeanProperty
import scala.collection.JavaConversions
import org.springframework.orm.hibernate3.HibernateOperations
import net.emaze.addons.strings
import org.hibernate.criterion.DetachedCriteria

class HibernateRepository extends Repository {

    @BeanProperty var hibernateOperations: HibernateOperations = _

    override def merge[E <: AnyRef](entity: E): E = {
        hibernateOperations.merge(entity).asInstanceOf[E] ensuring (_ != null, "merged entity cannot be null")
    }

    override def searchAll[E <: AnyRef](query: String, args: String*): List[E] = {
        val results = hibernateOperations.find(query, args).asInstanceOf[java.util.List[E]] ensuring (_ != null, "results cannot be null")
        JavaConversions.asBuffer(results).toList
    }

    override def searchAll[E <: AnyRef](detachedCriteria: DetachedCriteria): List[E] = {
        val results = hibernateOperations.findByCriteria(detachedCriteria).asInstanceOf[java.util.List[E]] ensuring (_ != null, "results cannot be null")
        JavaConversions.asBuffer(results).toList
    }

    override def searchById[E <: AnyRef](clazz: Class[E], id: Serializable): Option[E] = {
        val entity = hibernateOperations.get(clazz, id).asInstanceOf[E]
        if (entity == null) None else Some(entity)
    }

    override def findById[E <: AnyRef](clazz: Class[E], id: Serializable): E = {
        hibernateOperations.get(clazz, id).asInstanceOf[E] ensuring (_ != null, "no entity %s found with id %s" % (clazz.getSimpleName, id))
    }
}