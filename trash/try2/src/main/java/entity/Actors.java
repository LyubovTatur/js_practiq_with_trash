package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Actors {
    private int id;
    private String fio;
    private Integer age;
    private Date startCareerDate;
    private Collection<ActorFilm> actorFilmsById;

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
        Actors actors = (Actors) o;
        return id == actors.id && Objects.equals(fio, actors.fio) && Objects.equals(age, actors.age) && Objects.equals(startCareerDate, actors.startCareerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fio, age, startCareerDate);
    }

    @OneToMany(mappedBy = "actorsByIdActor")
    public Collection<ActorFilm> getActorFilmsById() {
        return actorFilmsById;
    }

    public void setActorFilmsById(Collection<ActorFilm> actorFilmsById) {
        this.actorFilmsById = actorFilmsById;
    }
}
