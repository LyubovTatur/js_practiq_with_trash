package com.company.package_tables;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "voice_acting", schema = "db_films", catalog = "")
public class VoiceActing {
    private int id;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoiceActing that = (VoiceActing) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dubbing", referencedColumnName = "id")
    private Dubbing dubbingByIdDubbing;

    public Dubbing getDubbingByIdDubbing() {
        return dubbingByIdDubbing;
    }

    public void setDubbingByIdDubbing(Dubbing dubbingByIdDubbing) {
        this.dubbingByIdDubbing = dubbingByIdDubbing;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_film", referencedColumnName = "id")
    private Films filmsByIdFilm;

    public Films getFilmsByIdFilm() {
        return filmsByIdFilm;
    }

    public void setFilmsByIdFilm(Films filmsByIdFilm) {
        this.filmsByIdFilm = filmsByIdFilm;
    }

    @Override
    public String toString() {
        return "VoiceActing{" +
                "id=" + id +
                ", dubbingByIdDubbing=" + dubbingByIdDubbing.getTitle() +
                ", filmsByIdFilm=" + filmsByIdFilm.getTitle() +
                '}'+'\n';
    }
}
