package com.dio.accesscontrolapi.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(schema= "access_control_api")
@Audited
public class Calendar {

    @Id
    @GeneratedValue
    private Long id;

    private String description;
    private LocalDateTime specialDate;

    @ManyToOne
    private DateType dateType;
}
