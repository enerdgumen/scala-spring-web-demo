package net.emaze.ddd

import java.io.Serializable
import scala.reflect.BeanProperty
import scala.collection.JavaConversions
import org.springframework.orm.hibernate3.HibernateOperations
import net.emaze.contracts.dbc

class HibernateRepository extends Repository {

    @BeanProperty
    var hibernateOperations: HibernateOperations = _

    override def merge[E <: AnyRef](entity: E) = {
        val merged = hibernateOperations.merge(entity).asInstanceOf[E]
        dbc.statePrecondition(merged != null, "merged entity cannot be null")
        merged
    }

    override def search[E <: AnyRef](query: String, args: String*) = {
        val results = hibernateOperations.find(query, args).asInstanceOf[java.util.List[E]]
        dbc.statePrecondition(results != null, "results cannot be null")
        JavaConversions.asBuffer(results).toList
    }

    override def searchById[E <: AnyRef](clazz: Class[E], id: Serializable) = {
        val entity = hibernateOperations.get(clazz, id).asInstanceOf[E]
        if (entity == null) None else Some(entity)
    }

    override def findById[E <: AnyRef](clazz: Class[E], id: Serializable) = {
        val entity = hibernateOperations.get(clazz, id).asInstanceOf[E]
        dbc.statePrecondition(entity != null, "no entity %s found with id %s", clazz.getSimpleName, id)
        entity
    }
}