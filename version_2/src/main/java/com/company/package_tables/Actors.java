package com.company.package_tables;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Actors {
    private int id;
    private String fio;
    private Integer age;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fio", nullable = true, length = 50)
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actors actors = (Actors) o;
        return id == actors.id && Objects.equals(fio, actors.fio) && Objects.equals(age, actors.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fio, age);
    }

    @Override
    public String toString() {
        return "Actors{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", age=" + age +
                '}';
    }
}
