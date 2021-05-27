package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comments", schema = "db_films", catalog = "")
public class CommentsEntity {
    private int id;
    private String commentator;
    private String commentText;
    private Integer mark;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "commentator")
    public String getCommentator() {
        return commentator;
    }

    public void setCommentator(String commentator) {
        this.commentator = commentator;
    }

    @Basic
    @Column(name = "comment_text")
    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Basic
    @Column(name = "mark")
    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentsEntity that = (CommentsEntity) o;
        return id == that.id && Objects.equals(commentator, that.commentator) && Objects.equals(commentText, that.commentText) && Objects.equals(mark, that.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, commentator, commentText, mark);
    }
}
