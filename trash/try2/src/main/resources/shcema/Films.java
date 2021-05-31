package shcema;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Films {
    private int id;
    private String title;
    private Date showDate;
    private Integer budget;
    private Integer dues;
    private String mark;
    private Collection<ActorFilm> actorFilmsById;
    private Collection<Comments> commentsById;
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
    @Column(name = "show_date")
    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    @Basic
    @Column(name = "budget")
    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    @Basic
    @Column(name = "dues")
    public Integer getDues() {
        return dues;
    }

    public void setDues(Integer dues) {
        this.dues = dues;
    }

    @Basic
    @Column(name = "mark")
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Films films = (Films) o;
        return id == films.id && Objects.equals(title, films.title) && Objects.equals(showDate, films.showDate) && Objects.equals(budget, films.budget) && Objects.equals(dues, films.dues) && Objects.equals(mark, films.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, showDate, budget, dues, mark);
    }

    @OneToMany(mappedBy = "filmsByIdFilm")
    public Collection<ActorFilm> getActorFilmsById() {
        return actorFilmsById;
    }

    public void setActorFilmsById(Collection<ActorFilm> actorFilmsById) {
        this.actorFilmsById = actorFilmsById;
    }

    @OneToMany(mappedBy = "filmsByIdFilm")
    public Collection<Comments> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<Comments> commentsById) {
        this.commentsById = commentsById;
    }

    @OneToMany(mappedBy = "filmsByIdFilm")
    public Collection<VoiceActing> getVoiceActingsById() {
        return voiceActingsById;
    }

    public void setVoiceActingsById(Collection<VoiceActing> voiceActingsById) {
        this.voiceActingsById = voiceActingsById;
    }
}
