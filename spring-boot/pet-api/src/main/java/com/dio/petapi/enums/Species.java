package com.dio.petapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Species {

    CAT("Cat"),
    DOG("Dog"),
    BIRD("Bird"),
    REPTILE("Reptile");

    private final String description;

}
