package com.company;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "entity_empl_pl", schema = "test1", catalog = "")
public class EntityEmplPl {
    private int id;
    private Integer idEmp;
    private Integer idPlace;
    private Employee employeeByIdEmp;
    private Place placeByIdPlace;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_emp", nullable = true)
    public Integer getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Integer idEmp) {
        this.idEmp = idEmp;
    }

    @Basic
    @Column(name = "id_place", nullable = true)
    public Integer getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(Integer idPlace) {
        this.idPlace = idPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityEmplPl that = (EntityEmplPl) o;
        return id == that.id && Objects.equals(idEmp, that.idEmp) && Objects.equals(idPlace, that.idPlace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idEmp, idPlace);
    }

    @ManyToOne
    @JoinColumn(name = "id_emp", referencedColumnName = "id")
    public Employee getEmployeeByIdEmp() {
        return employeeByIdEmp;
    }

    public void setEmployeeByIdEmp(Employee employeeByIdEmp) {
        this.employeeByIdEmp = employeeByIdEmp;
    }

    @ManyToOne
    @JoinColumn(name = "id_place", referencedColumnName = "id")
    public Place getPlaceByIdPlace() {
        return placeByIdPlace;
    }

    public void setPlaceByIdPlace(Place placeByIdPlace) {
        this.placeByIdPlace = placeByIdPlace;
    }
}
