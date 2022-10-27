package com.navikenz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;


@Table(name="comments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comments {
    @Id
    private Long id;
    @Column(name = "text")
    private String text;

    @Column(name = "user")
    private String user;

    @Column(name = "timestamp")
    private String timestamp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "comments_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Contact contact;
}
