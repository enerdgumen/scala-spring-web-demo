package net.emaze.sql

import org.junit.{Test, Assert}
import org.hibernate.criterion.Restrictions
import net.emaze.sql.Conversion.field

class CriterionFactoryTest {

    @Test
    def canBuildAnEqualCriterion {
        val expected = Restrictions.eq("field", 1)
        val got = CriterionFactory("field" === 1)
        Assert.assertEquals(expected.toString, got.toString)
    }

    @Test
    def canBuildAnIdEqualCriterion {
        val expected = Restrictions.idEq(1)
        val got = CriterionFactory(ID === 1)
        Assert.assertEquals(expected.toString, got.toString)
    }

    @Test
    def canBuildANotEqualCriterion {
        val expected = Restrictions.ne("field", 1)
        val got = CriterionFactory("field" !== 1)
        Assert.assertEquals(expected.toString, got.toString)
    }

    @Test
    def canBuildALikeCriterion {
        val expected = Restrictions.like("field", "val%")
        val got = CriterionFactory("field" LIKE "val%")
        Assert.assertEquals(expected.toString, got.toString)
    }

    @Test
    def canBuildACaseInsensitiveLikeCriterion {
        val expected = Restrictions.ilike("field", "val%")
        val got = CriterionFactory("field" ILIKE "val%")
        Assert.assertEquals(expected.toString, got.toString)
    }

    @Test
    def canBuildAGreaterThenCriterion {
        val expected = Restrictions.gt("field", 2)
        val got = CriterionFactory(field("field") > 2)
        Assert.assertEquals(expected.toString, got.toString)
    }

    @Test
    def canBuildAnAndCompositeCriterion {
        val expected = Restrictions.and(Restrictions.eq("a", 1), Restrictions.eq("b", 2))
        val got = CriterionFactory("a" === 1 && "b" === 2)
        Assert.assertEquals(expected.toString, got.toString)
    }
}