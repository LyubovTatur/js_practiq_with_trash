package com.company;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Languages {
    private int id;
    private String title;
    private String shortTitle;
    private Collection<Dubbing> dubbingsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 20)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "short_title", nullable = true, length = 3)
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
        Languages languages = (Languages) o;
        return id == languages.id && Objects.equals(title, languages.title) && Objects.equals(shortTitle, languages.shortTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, shortTitle);
    }

    @OneToMany(mappedBy = "languagesByIdLanguage")
    public Collection<Dubbing> getDubbingsById() {
        return dubbingsById;
    }

    public void setDubbingsById(Collection<Dubbing> dubbingsById) {
        this.dubbingsById = dubbingsById;
    }
}
