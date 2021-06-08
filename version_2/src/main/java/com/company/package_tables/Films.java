package com.company.package_tables;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Films {
    private int id;
    private String title;
    private Integer budget;
    private Integer dues;
    private String mark;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 30)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "budget", nullable = true)
    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    @Basic
    @Column(name = "dues", nullable = true)
    public Integer getDues() {
        return dues;
    }

    public void setDues(Integer dues) {
        this.dues = dues;
    }

    @Basic
    @Column(name = "mark", nullable = true, length = 4)
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Films films = (Films) o;
        return id == films.id && Objects.equals(title, films.title) && Objects.equals(budget, films.budget) && Objects.equals(dues, films.dues) && Objects.equals(mark, films.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, budget, dues, mark);
    }

    @Override
    public String toString() {
        return "Films{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", budget=" + budget +
                ", dues=" + dues +
                ", mark='" + mark + '\'' +
                '}';
    }
}
