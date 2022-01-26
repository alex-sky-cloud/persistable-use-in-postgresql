package com.persistable.persistable.service.mapper;

import com.persistable.persistable.domain.AbstractEntity;
import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class FixedCycleAvoidingMappingContext  {

    private Map<Key, Object> knownInstances = new HashMap<Key, Object>();


    @BeforeMapping
    public <T> T getMappedInstance(Object source, @TargetType Class<T> targetType) {

        T t = (T) knownInstances.get( toKey( source ) );
        return t;
    }


    @BeforeMapping
    public void storeMappedInstance(Object source, @MappingTarget Object target) {
        knownInstances.put( toKey( source ), target );
    }

    Key toKey(Object source) {
        if ( source instanceof AbstractEntity) {
            Serializable id = ( (AbstractEntity<?>) source ).getId();
            return new Key( source, id );
        }
        return new Key( source, null );
    }

    private class Key {
        private Object source;
        private Serializable id;

        public Key(Object source, Serializable id) {
            this.source = source;
            this.id = id;
        }

        @Override
        public int hashCode() {
            return Objects.hash( source, id );
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            if (id != null) {
                return Objects.equals( id, ( (Key) obj ).id )
                    && Objects.equals( source.getClass(), ( (Key) obj ).source.getClass() );
            }else {
                if ( ( (Key) obj ).id != null ) {
                    return false;
                }
                else {
                    return Objects.equals( source.getClass(), ( (Key) obj ).source.getClass() );
                }
            }
        }
    }
}