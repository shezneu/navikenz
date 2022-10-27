package com.navikenz.model;


import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class LinkedEntities {
    @NotBlank(message = "{id.required}")
    private int id;
    private String entityType;
    private String name;
}
