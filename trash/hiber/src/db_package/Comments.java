package db_package;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Comments {
    private int id;
    private String commentator;
    private Integer idFilm;
    private String commentText;
    private Integer mark;
    private Films filmsByIdFilm;

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
    @Column(name = "id_film")
    public Integer getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Integer idFilm) {
        this.idFilm = idFilm;
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
        Comments comments = (Comments) o;
        return id == comments.id && Objects.equals(commentator, comments.commentator) && Objects.equals(idFilm, comments.idFilm) && Objects.equals(commentText, comments.commentText) && Objects.equals(mark, comments.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, commentator, idFilm, commentText, mark);
    }

    @ManyToOne
    @JoinColumn(name = "id_film", referencedColumnName = "id")
    public Films getFilmsByIdFilm() {
        return filmsByIdFilm;
    }

    public void setFilmsByIdFilm(Films filmsByIdFilm) {
        this.filmsByIdFilm = filmsByIdFilm;
    }
}
