package com.persistable.persistable.domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mesh")
public class Mesh extends AbstractEntity<Long> {

    private String name;

    private int cellSize;

    private List<MeshColumn> columns;
    private List<MeshLine> rows;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "cell_size")
    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    @OrderBy("number")
    @OneToMany(mappedBy = "mesh")
    public List<MeshColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<MeshColumn> columns) {
        this.columns = columns;
    }

    @OrderBy("number")
    @OneToMany(mappedBy = "mesh")
    public List<MeshLine> getRows() {
        return rows;
    }

    public void setRows(List<MeshLine> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Grid{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", cellSize=" + cellSize +
                ", columns=" + columns +
                ", rows=" + rows +
                '}';
    }
}