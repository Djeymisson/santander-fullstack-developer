package com.dio.accesscontrolapi.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(schema= "access_control_api")
public class Calendar {

    @Id
    private Long id;

    private String description;
    private LocalDateTime specialDate;

    @ManyToOne
    private DateType dateType;
}
