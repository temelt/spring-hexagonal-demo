package com.temelt.common;

public interface ScenarioProcessor <E, T extends Scenario>{

    E process(T item);
}
