package com.hanqingliang.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TagTest {

    @Test
    void testNormalCreation() {
        Tag tag = new Tag("  Java  ");
        assertEquals("java", tag.getName());
    }

    @Test
    void testEqualsIgnoreCase() {
        Tag t1 = new Tag("Java");
        Tag t2 = new Tag("JAVA");
        assertEquals(t1, t2);
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    void testNotEquals() {
        Tag t1 = new Tag("java");
        Tag t2 = new Tag("python");
        assertNotEquals(t1, t2);
    }

    @Test
    void testToString() {
        assertEquals("#spring", new Tag("Spring").toString());
    }
}