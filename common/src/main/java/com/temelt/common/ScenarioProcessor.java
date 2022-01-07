package com.temelt.common;

/**
 * Generic interface to unify all use cases
 *
 * @param <M> Model of domain object
 * @param <S> Request for specific domain object
 */
public interface ScenarioProcessor<M, S extends Scenario> {

    /**
     * Process business logic with related handler
     *
     * @param item Scenario
     * @return Model
     */
    M process(S item);
}
