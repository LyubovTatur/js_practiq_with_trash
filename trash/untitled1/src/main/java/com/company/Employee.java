package com.company;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Employee {
    private int id;
    private String job;
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
    @Column(name = "job", nullable = true, length = 30)
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(job, employee.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, job);
    }

    @OneToMany(mappedBy = "employeeByIdEmp")
    public Collection<EntityEmplPl> getEntityEmplPlsById() {
        return entityEmplPlsById;
    }

    public void setEntityEmplPlsById(Collection<EntityEmplPl> entityEmplPlsById) {
        this.entityEmplPlsById = entityEmplPlsById;
    }
}
