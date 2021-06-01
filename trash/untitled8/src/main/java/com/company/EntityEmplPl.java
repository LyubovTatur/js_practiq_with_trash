package com.company;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "entity_empl_pl", schema = "test1", catalog = "")
public class EntityEmplPl {
    private int id;
    private Employee employeeByIdEmp;

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
        EntityEmplPl that = (EntityEmplPl) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "id_emp", referencedColumnName = "id")
    public Employee getEmployeeByIdEmp() {
        return employeeByIdEmp;
    }

    public void setEmployeeByIdEmp(Employee employeeByIdEmp) {
        this.employeeByIdEmp = employeeByIdEmp;
    }
}
