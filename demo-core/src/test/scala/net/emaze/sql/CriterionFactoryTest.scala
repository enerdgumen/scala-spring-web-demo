package net.emaze.sql

import org.junit.{Test, Assert}
import org.hibernate.criterion.Restrictions

class CriterionFactoryTest {

    @Test
    def canBuildAnIdEqCriterion {
        val expected = Restrictions.idEq(1)
        val got = CriterionFactory(ID === 1)
        Assert.assertEquals(expected.toString, got.toString)
    }
}