package com.hanqingliang.entity;

/**
 * 标签实体：完全封装，只暴露必要方法
 *  —— 已降级至 JDK 1.7 兼容
 */
public class Tag {
    private final String name;   // 一旦构造不可变

    public Tag(String name) {
        if (name == null || name.trim().isEmpty()) {   // 1.7 兼容空串判断
            throw new IllegalArgumentException("标签名不能为空");
        }
        this.name = name.trim().toLowerCase();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;
        return name.equals(((Tag) o).name);
    }

    @Override
    public int hashCode() {
        // JDK 1.7 没有 Objects.hash，直接手写
        return 31 + name.hashCode();
    }

    @Override
    public String toString() {
        return "#" + name;
    }
}