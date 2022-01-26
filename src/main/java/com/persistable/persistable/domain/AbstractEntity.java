package com.persistable.persistable.domain;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public class AbstractEntity<ID extends Serializable> implements Persistable<ID> {

    private ID id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }


    @Override
    @Transient
    public boolean isNew() {
        return null == getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity<?> that = (AbstractEntity<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                '}';
    }
}