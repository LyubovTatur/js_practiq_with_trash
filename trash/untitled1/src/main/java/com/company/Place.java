package com.company;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Place {
    private int id;
    private String namee;
    private Collection<EntityEmplPl> entityEmplPlsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "namee", nullable = true, length = 30)
    public String getNamee() {
        return namee;
    }

    public void setNamee(String namee) {
        this.namee = namee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return id == place.id && Objects.equals(namee, place.namee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, namee);
    }

    @OneToMany(mappedBy = "placeByIdPlace")
    public Collection<EntityEmplPl> getEntityEmplPlsById() {
        return entityEmplPlsById;
    }

    public void setEntityEmplPlsById(Collection<EntityEmplPl> entityEmplPlsById) {
        this.entityEmplPlsById = entityEmplPlsById;
    }
}
