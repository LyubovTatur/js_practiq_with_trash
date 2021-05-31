package db_package;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Dubbing {
    private int id;
    private String title;
    private Integer idLanguage;
    private String dubbingActorsList;
    private Languages languagesByIdLanguage;
    private Collection<VoiceActing> voiceActingsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "id_language")
    public Integer getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(Integer idLanguage) {
        this.idLanguage = idLanguage;
    }

    @Basic
    @Column(name = "dubbing_actors_list")
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
        return id == dubbing.id && Objects.equals(title, dubbing.title) && Objects.equals(idLanguage, dubbing.idLanguage) && Objects.equals(dubbingActorsList, dubbing.dubbingActorsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, idLanguage, dubbingActorsList);
    }

    @ManyToOne
    @JoinColumn(name = "id_language", referencedColumnName = "id")
    public Languages getLanguagesByIdLanguage() {
        return languagesByIdLanguage;
    }

    public void setLanguagesByIdLanguage(Languages languagesByIdLanguage) {
        this.languagesByIdLanguage = languagesByIdLanguage;
    }

    @OneToMany(mappedBy = "dubbingByIdDubbing")
    public Collection<VoiceActing> getVoiceActingsById() {
        return voiceActingsById;
    }

    public void setVoiceActingsById(Collection<VoiceActing> voiceActingsById) {
        this.voiceActingsById = voiceActingsById;
    }
}
