package com.temelt.common;

public interface ScenarioProcessor <M, S extends Scenario>{

    M process(S item);
}
