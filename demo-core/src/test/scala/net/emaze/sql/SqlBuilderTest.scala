package net.emaze.sql

import org.junit.{Test, Assert}
import org.hibernate.criterion.DetachedCriteria
import net.emaze.sql.Conversion._

class SqlBuilderTest {

    @Test
    def canDoSelectAllFromATable {
        val expectedCriteria = DetachedCriteria.forEntityName("Table")
        val gotCriteria: DetachedCriteria = SELECT (*) FROM "Table"
        Assert.assertEquals(expectedCriteria.toString, gotCriteria.toString)
    }
}
