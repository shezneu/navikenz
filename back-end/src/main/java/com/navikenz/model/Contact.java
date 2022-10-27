package com.navikenz.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;


@Data
@Builder
public class Contact {
    @NotBlank(message = "{id.required}")
    private String id;
    @NotBlank(message = "{firstName.required}")
    private String firstName;
    @NotBlank(message = "{lastName.required}")
    private String lastName;
    @NotBlank(message = "{fullname.required}")
    private String fullname;
    @NotBlank(message = "{email.required}")
    private String email;
    @NotBlank(message = "{phone.required}")
    private String phone;
    @NotBlank(message = "{notes.required}")
    private String notes;
    @NotBlank(message = "{createdOn.required}")
    private String createdOn;
    @NotBlank(message = "{updatedOn.required}")
    private String updatedOn;



    private List<Comments> comments;

    private List<LinkedEntities> linkedEntities;

}
