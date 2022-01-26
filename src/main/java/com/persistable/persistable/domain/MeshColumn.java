package com.persistable.persistable.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mesh_column")
public class MeshColumn extends AbstractEntity<Long> {

    private int number;

    private Mesh mesh;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mesh_id")
    public Mesh getMesh() {
        return mesh;
    }

    public void setMesh(Mesh mesh) {
        this.mesh = mesh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MeshColumn that = (MeshColumn) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), number);
    }

    @Override
    public String toString() {
        return "GridColumn{" +
                "number=" + number +
                ", gridId=" + mesh.getId() +
                '}';
    }
}