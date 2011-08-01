package net.emaze.scalademo.core

import java.io.Serializable

trait Repository {

    def merge[E <: AnyRef](entity: E): E

    def search[E <: AnyRef](query: String, args: String*): List[E]

    def searchById[E <: AnyRef](clazz: Class[E], id: Serializable): Option[E]

    def findById[E <: AnyRef](clazz: Class[E], id: Serializable): E
}