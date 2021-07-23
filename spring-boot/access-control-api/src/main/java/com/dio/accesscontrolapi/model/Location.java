package com.dio.accesscontrolapi.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(schema = "access_control_api")
public class Location {

    @Id
    private long id;

    private String description;

    @ManyToOne
    private AccessLevel accessLevel;

}
