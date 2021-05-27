package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "actor_film", schema = "db_films")
public class ActorFilmEntity {
    private int id;
    private String nameOfPerson;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name_of_person")
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
        ActorFilmEntity that = (ActorFilmEntity) o;
        return id == that.id && Objects.equals(nameOfPerson, that.nameOfPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfPerson);
    }
}
