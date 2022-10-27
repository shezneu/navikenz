package com.navikenz.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class Comments {
    @NotBlank(message = "{id.required}")
    private int id;
    private String text;
    private String user;
    private String timeStamp;
}
