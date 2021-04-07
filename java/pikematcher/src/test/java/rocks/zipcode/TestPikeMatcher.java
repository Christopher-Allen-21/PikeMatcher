package test.java.rocks.zipcode;
import static org.junit.jupiter.api.Assertions.*;
import main.java.rocks.zipcode.Guts;
import main.java.rocks.zipcode.PikeMatcher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


class PikeMatcherTest {

    @org.junit.jupiter.api.Test
    void t1_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "bar";
        String text = "foobarbaz";

        boolean actual = pm.match(pattern, text);
        assertTrue(actual);
    }

    @org.junit.jupiter.api.Test
    void t2_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "kris";
        String text = "foobarbaz";

        boolean actual = pm.match(pattern, text);
        assertFalse(actual);
    }

    @org.junit.jupiter.api.Test
    void t3_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "bat";
        String text = "foobarbaz";

        boolean actual = pm.match(pattern, text);
        assertFalse(actual);
    }

    @org.junit.jupiter.api.Test
    void t4_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "^foo";
        String text = "foobarbaz";

        boolean actual = pm.match(pattern, text);
        assertTrue(actual);
    }
    @org.junit.jupiter.api.Test
    void t5_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "baz$";
        String text = "foobarbaz";

        boolean actual = pm.match(pattern, text);
        assertTrue(actual);
    }
    @org.junit.jupiter.api.Test
    void t6_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "o*";
        String text = "foobarbaz";

        boolean actual = pm.match(pattern, text);
        assertTrue(actual);
        pattern="r*";
        actual = pm.match(pattern, text);
        assertTrue(actual);
        pattern="fo*";
        actual = pm.match(pattern, text);
        assertTrue(actual);

    }

    @org.junit.jupiter.api.Test
    void t7_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "jkl";
        String text = "foobarbazabcabdcabcdexyz";

        boolean actual = pm.match(pattern, text);
        assertFalse(actual);
    }

    @org.junit.jupiter.api.Test
    void t8_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "^cab";
        String text = "foobarbazabcabdcabcdexyz";

        boolean actual = pm.match(pattern, text);
        assertFalse(actual);
    }

    private PikeMatcher foo;

    @Before
    public void setUp() throws Exception {
        foo = new PikeMatcher();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testmatch1() {
        assertEquals(true, foo.match("abc", "abc"));
    }

    @Test
    public void testmatch2() {
        assertEquals(true, foo.match("^a", "abc"));
    }

    @Test
    public void testmatch3() {
        assertEquals(false, foo.match("^b", "abc"));
    }

    @Test
    public void testmatch4() {
        assertEquals(true, foo.match("abc", "aaabcbbcc"));
    }

    @Test
    public void testmatch5() {
        assertEquals(true, foo.match("c$", "aaabcbbcc"));
    }

    @Test
    public void testmatch6() {
        assertEquals(true, foo.match(".*cc", "aaabcbbcc"));
    }

    @Test
    public void testmatch7() {
        assertEquals(false, foo.match("jkl", "aaabcbbcc"));
    }
    @Test
    public void testmatch8() {
        assertEquals(true, foo.match("cb.", "aaabcbbcc"));
    }

    @Test
    public void testmatch9() {
        assertEquals(false, foo.match("cb.", "aaabcabcc"));
    }

}
