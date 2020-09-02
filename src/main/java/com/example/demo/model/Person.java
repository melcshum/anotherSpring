/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author lcshum
 */
public class Person {

    private final UUID id;
    @Valid
    @NotBlank
    private final String name;

    public Person(@JsonProperty("id") UUID id,
            @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}