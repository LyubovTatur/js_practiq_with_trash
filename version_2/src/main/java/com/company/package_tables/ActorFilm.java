package com.company.package_tables;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "actor_film", schema = "db_films", catalog = "")
public class ActorFilm {
    private int id;
    private String nameOfPerson;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name_of_person", nullable = true, length = 30)
    public String getNameOfPerson() {
        return nameOfPerson;
    }

    public void setNameOfPerson(String nameOfPerson) {
        this.nameOfPerson = nameOfPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorFilm actorFilm = (ActorFilm) o;
        return id == actorFilm.id && Objects.equals(nameOfPerson, actorFilm.nameOfPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfPerson);
    }
}
