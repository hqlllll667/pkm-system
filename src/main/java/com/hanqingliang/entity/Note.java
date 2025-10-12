package com.hanqingliang.entity;

import java.util.*;

/**
 * 笔记基类：封装公共字段，提供抽象方法给子类实现
 *  —— 已降级至 JDK 1.7 兼容
 */
public abstract class Note {
    private final UUID  id;          // 只读
    private final Date createTime;   // 1.7 可用
    private String title;
    private final Set<Tag> tags;     // 外部只能读，不能改集合本身

    protected Note(String title) {
        this.id         = UUID.randomUUID();
        this.createTime = new Date();            // 当前时间
        this.title      = title;
        this.tags       = new HashSet<Tag>();
    }

    /* ---------- 只读访问 ---------- */
    public UUID getId()        { return id; }
    public Date getCreateTime() { return createTime; }   // 返回类型变成 Date
    public String getTitle()   { return title; }
    public Set<Tag> getTags()  { return Collections.unmodifiableSet(tags); }

    /* ---------- 可控修改 ---------- */
    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {   // 1.7 兼容的空串判断
            this.title = title;
        }
    }
    public boolean addTag(Tag tag)     { return tags.add(tag); }
    public boolean removeTag(Tag tag)  { return tags.remove(tag); }

    /* ---------- 多态行为：子类必须实现 ---------- */
    public abstract String getContent();
    public abstract void setContent(String content);

    @Override
    public String toString() {
        return String.format("[%s] %s %s%n%s",
                id.toString().substring(0, 8), title, tags, getContent());
    }
}