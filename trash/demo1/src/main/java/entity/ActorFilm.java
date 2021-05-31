package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "actor_film", schema = "db_films", catalog = "")
public class ActorFilm {
    private int id;
    private Integer idFilm;
    private Integer idActor;
    private String nameOfPerson;
    private Films filmsByIdFilm;
    private Actors actorsByIdActor;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "id_actor")
    public Integer getIdActor() {
        return idActor;
    }

    public void setIdActor(Integer idActor) {
        this.idActor = idActor;
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
        ActorFilm actorFilm = (ActorFilm) o;
        return id == actorFilm.id && Objects.equals(idFilm, actorFilm.idFilm) && Objects.equals(idActor, actorFilm.idActor) && Objects.equals(nameOfPerson, actorFilm.nameOfPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idFilm, idActor, nameOfPerson);
    }

    @ManyToOne
    @JoinColumn(name = "id_film", referencedColumnName = "id")
    public Films getFilmsByIdFilm() {
        return filmsByIdFilm;
    }

    public void setFilmsByIdFilm(Films filmsByIdFilm) {
        this.filmsByIdFilm = filmsByIdFilm;
    }

    @ManyToOne
    @JoinColumn(name = "id_actor", referencedColumnName = "id")
    public Actors getActorsByIdActor() {
        return actorsByIdActor;
    }

    public void setActorsByIdActor(Actors actorsByIdActor) {
        this.actorsByIdActor = actorsByIdActor;
    }
}
