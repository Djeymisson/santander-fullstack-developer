package com.dio.accesscontrolapi.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(schema = "access_control_api")
@Audited
public class Location {

    @Id
    @GeneratedValue
    private long id;

    private String description;

    @ManyToOne
    private AccessLevel accessLevel;

}
