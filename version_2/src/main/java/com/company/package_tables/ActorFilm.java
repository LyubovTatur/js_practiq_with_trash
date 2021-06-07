package com.company.package_tables;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "actor_film", schema = "db_films", catalog = "")
public class ActorFilm {
    private int id;
    private String nameOfPerson;
    private Films filmsByIdFilm;
    private Actors actorsByIdActor;

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




//    @ManyToOne
//    @JoinColumn(name = "id_film", referencedColumnName = "id")
//    public Films getFilmsByIdFilm() {
//        return filmsByIdFilm;
//    }
//
//    public void setFilmsByIdFilm(Films filmsByIdFilm) {
//        this.filmsByIdFilm = filmsByIdFilm;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "id_actor", referencedColumnName = "id")
//    public Actors getActorsByIdActor() {
//        return actorsByIdActor;
//    }
//
//    public void setActorsByIdActor(Actors actorsByIdActor) {
//        this.actorsByIdActor = actorsByIdActor;
//    }

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

    @Override
    public String toString() {
        return
                "id=" + id +
                ", nameOfPerson=" + nameOfPerson +
                ", filmsByIdFilm=" + filmsByIdFilm +
                ", actorsByIdActor=" + actorsByIdActor +
                '\n';
    }
}
