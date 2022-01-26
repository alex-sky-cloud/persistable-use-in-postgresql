package com.persistable.persistable.repository;


import com.persistable.persistable.domain.Mesh;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColumnRepository extends JpaRepository<Mesh, Long> {
}