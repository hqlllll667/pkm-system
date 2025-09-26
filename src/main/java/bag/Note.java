package bag;

import java.time.LocalDateTime;

public class Note {

    /* ===================== 字段 ===================== */
    private Long id;
    private String title;
    private String content;
    private final LocalDateTime createTime = LocalDateTime.now();
    private LocalDateTime updateTime = LocalDateTime.now();

    /* ===================== 构造 ===================== */
    public Note() { }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    /* ===================== Getter / Setter ===================== */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        touch();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        touch();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /* ===================== 私有工具方法 ===================== */
    private void touch() {
        this.updateTime = LocalDateTime.now();
    }

    /* ===================== 可选：toString ===================== */
    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}