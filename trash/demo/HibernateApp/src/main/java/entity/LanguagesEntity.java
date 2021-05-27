package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "languages", schema = "db_films", catalog = "")
public class LanguagesEntity {
    private int id;
    private String title;
    private String shortTitle;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "short_title")
    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanguagesEntity that = (LanguagesEntity) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(shortTitle, that.shortTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, shortTitle);
    }
}
