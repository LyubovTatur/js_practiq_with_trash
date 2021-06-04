package com.company.package_tables;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "voice_acting", schema = "db_films", catalog = "")
public class VoiceActing {
    private int id;
    private Dubbing dubbingByIdDubbing;
    private Films filmsByIdFilm;

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
