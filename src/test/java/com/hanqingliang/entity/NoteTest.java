package com.hanqingliang.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NoteTest {

    /* ---------- 内存子类，仅测试用 ---------- */
    private static class TestNote extends Note {
        private String body;
        TestNote(String title, String body) {
            super(title);
            this.body = body;
        }
        @Override
        public String getContent() { return body; }
        @Override
        public void setContent(String body) { this.body = body; }
    }

    private Note note;
    private Tag  tag;

    @BeforeEach
    void setUp() {
        note = new TestNote("Test Title", "Test Content");
        tag  = new Tag("important");
    }

    @Test
    void testCreation() {
        assertNotNull(note.getId());
        assertNotNull(note.getCreateTime());
        assertEquals("Test Title", note.getTitle());
        assertTrue(note.getTags().isEmpty());
    }

    @Test
    void testAddTag() {
        assertTrue(note.addTag(tag));
        assertEquals(1, note.getTags().size());
        assertTrue(note.getTags().contains(tag));
    }

    @Test
    void testRemoveTag() {
        note.addTag(tag);
        assertTrue(note.removeTag(tag));
        assertTrue(note.getTags().isEmpty());
    }

    @Test
    void testSetTitle() {
        note.setTitle("New Title");
        assertEquals("New Title", note.getTitle());
    }

    @Test
    void testInheritance() {
        TextNote textNote = new TextNote("Inheritance", "Testing inheritance");
        assertInstanceOf(Note.class, textNote);
        assertEquals("Inheritance", textNote.getTitle());
    }
}