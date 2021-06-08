package package_tables;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Dubbing {
    private int id;
    private String title;
    private String dubbingActorsList;
    private Languages languagesByIdLanguage;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 30)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "dubbing_actors_list", nullable = true, length = -1)
    public String getDubbingActorsList() {
        return dubbingActorsList;
    }

    public void setDubbingActorsList(String dubbingActorsList) {
        this.dubbingActorsList = dubbingActorsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dubbing dubbing = (Dubbing) o;
        return id == dubbing.id && Objects.equals(title, dubbing.title) && Objects.equals(dubbingActorsList, dubbing.dubbingActorsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, dubbingActorsList);
    }

    @ManyToOne
    @JoinColumn(name = "id_language", referencedColumnName = "id")
    public Languages getLanguagesByIdLanguage() {
        return languagesByIdLanguage;
    }

    public void setLanguagesByIdLanguage(Languages languagesByIdLanguage) {
        this.languagesByIdLanguage = languagesByIdLanguage;
    }
}
