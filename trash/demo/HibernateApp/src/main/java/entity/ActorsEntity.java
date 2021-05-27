package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "actors", schema = "db_films", catalog = "")
public class ActorsEntity {
    private int id;
    private String fio;
    private Integer age;
    private Date startCareerDate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fio")
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "start_career_date")
    public Date getStartCareerDate() {
        return startCareerDate;
    }

    public void setStartCareerDate(Date startCareerDate) {
        this.startCareerDate = startCareerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorsEntity that = (ActorsEntity) o;
        return id == that.id && Objects.equals(fio, that.fio) && Objects.equals(age, that.age) && Objects.equals(startCareerDate, that.startCareerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fio, age, startCareerDate);
    }
}
