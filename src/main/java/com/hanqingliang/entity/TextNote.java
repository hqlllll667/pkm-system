package com.hanqingliang.entity;

/**
 * 纯文本笔记：继承 Note，扩展额外字段
 */
public class TextNote extends Note {
    private String text;

    public TextNote(String title, String text) {
        super(title);
        this.text = text;
    }

    @Override
    public String getContent() {
        return text;
    }

    @Override
    public void setContent(String content) {
        this.text = content;
    }

    /* ---------- 子类特有行为 ---------- */
    public int wordCount() {
        return text == null ? 0 : text.split("\\s+").length;
    }
}