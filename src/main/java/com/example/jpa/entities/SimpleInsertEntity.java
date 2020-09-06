package com.example.jpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.domain.Persistable;

/**
 * This interface will <b><i>suppress</i></b> select & update function of saveAll method of JpaRepository,
 * which is useful to improve performance
  */
public interface SimpleInsertEntity<ID> extends Persistable<ID> {

    @JsonIgnore
    @Override
    default boolean isNew() {
        return true;
    }

}
