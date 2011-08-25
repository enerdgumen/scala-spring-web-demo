package net.emaze.sql

import org.junit.{Test, Assert}
import org.hibernate.criterion.{Restrictions, DetachedCriteria}
import net.emaze.sql.dsl._
import net.emaze.sql.dsl.Conversion._
import net.emaze.sql.hibernate.DetachedCriteriaFactory._

class DetachedCriteriaFactoryTest {

    @Test
    def canDoSelectAllFromATable {
        val expectedCriteria = DetachedCriteria.forEntityName("Table")
        val gotCriteria: DetachedCriteria = SELECT FROM "Table"
        Assert.assertEquals(expectedCriteria.toString, gotCriteria.toString)
    }

    @Test
    def canApplyARestrictionToASelect {
        val expectedCriteria = DetachedCriteria.forEntityName("Table").add(Restrictions.eq("field", 1))
        val gotCriteria: DetachedCriteria = SELECT FROM "Table" WHERE ("field" === 1)
        Assert.assertEquals(expectedCriteria.toString, gotCriteria.toString)
    }
}
