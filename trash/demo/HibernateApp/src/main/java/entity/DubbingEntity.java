package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dubbing", schema = "db_films", catalog = "")
public class DubbingEntity {
    private int id;
    private String title;
    private String dubbingActorsList;

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
        DubbingEntity that = (DubbingEntity) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(dubbingActorsList, that.dubbingActorsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, dubbingActorsList);
    }
}
