package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "voice_acting", schema = "db_films", catalog = "")
public class VoiceActing {
    private int id;
    private Integer idDubbing;
    private Integer idFilm;
    private Dubbing dubbingByIdDubbing;
    private Films filmsByIdFilm;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_dubbing")
    public Integer getIdDubbing() {
        return idDubbing;
    }

    public void setIdDubbing(Integer idDubbing) {
        this.idDubbing = idDubbing;
    }

    @Basic
    @Column(name = "id_film")
    public Integer getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Integer idFilm) {
        this.idFilm = idFilm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoiceActing that = (VoiceActing) o;
        return id == that.id && Objects.equals(idDubbing, that.idDubbing) && Objects.equals(idFilm, that.idFilm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idDubbing, idFilm);
    }

    @ManyToOne
    @JoinColumn(name = "id_dubbing", referencedColumnName = "id")
    public Dubbing getDubbingByIdDubbing() {
        return dubbingByIdDubbing;
    }

    public void setDubbingByIdDubbing(Dubbing dubbingByIdDubbing) {
        this.dubbingByIdDubbing = dubbingByIdDubbing;
    }

    @ManyToOne
    @JoinColumn(name = "id_film", referencedColumnName = "id")
    public Films getFilmsByIdFilm() {
        return filmsByIdFilm;
    }

    public void setFilmsByIdFilm(Films filmsByIdFilm) {
        this.filmsByIdFilm = filmsByIdFilm;
    }
}
