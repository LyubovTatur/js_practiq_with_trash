package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "films", schema = "db_films", catalog = "")
public class FilmsEntity {
    private int id;
    private String title;
    private Date showDate;
    private Integer budget;
    private Integer dues;
    private String mark;

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
    @Column(name = "show_date")
    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    @Basic
    @Column(name = "budget")
    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    @Basic
    @Column(name = "dues")
    public Integer getDues() {
        return dues;
    }

    public void setDues(Integer dues) {
        this.dues = dues;
    }

    @Basic
    @Column(name = "mark")
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
        FilmsEntity that = (FilmsEntity) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(showDate, that.showDate) && Objects.equals(budget, that.budget) && Objects.equals(dues, that.dues) && Objects.equals(mark, that.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, showDate, budget, dues, mark);
    }
}
