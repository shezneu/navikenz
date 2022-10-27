package com.navikenz.entity;

import javax.persistence.*;

import com.navikenz.model.Comments;
import com.navikenz.model.LinkedEntities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Table(name = "contact")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contact {

    @Id
    private Long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "notes")
    private String notes;
    @Column(name = "created_on")
    private String createdOn;
    @Column(name = "updated_on")
    private String updatedOn;


    @Column(name = "comments_id")
    private List<Comments> comments;

    @Column(name = "firstname")
    private List<LinkedEntities> linkedEntities;


}
