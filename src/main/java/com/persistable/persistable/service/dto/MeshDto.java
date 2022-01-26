package com.persistable.persistable.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.persistable.persistable.domain.MeshColumn;
import com.persistable.persistable.domain.MeshLine;
import com.sun.istack.NotNull;

import javax.validation.constraints.*;
import java.util.List;
import java.util.Objects;


public class MeshDto {

    private Long id;

    @NotBlank
    @Size(min = 1, max = 200)
    private String name;

    @NotNull
    @Positive
    @Min(1)
    @Max(100_000)
    private int cellSize;

    @JsonIgnore
    private List<MeshColumn> columns;

    @JsonIgnore
    private List<MeshLine> rows;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    public List<MeshColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<MeshColumn> columns) {
        this.columns = columns;
    }

    public List<MeshLine> getRows() {
        return rows;
    }

    public void setRows(List<MeshLine> rows) {
        this.rows = rows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeshDto meshDto = (MeshDto) o;
        return cellSize == meshDto.cellSize &&
                Objects.equals(id, meshDto.id) &&
                Objects.equals(name, meshDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cellSize);
    }
}
