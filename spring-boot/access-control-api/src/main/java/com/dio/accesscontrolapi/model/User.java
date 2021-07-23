package com.dio.accesscontrolapi.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(schema = "access_control_api")
public class User {
    @Id
    private long id;

    private String name;
    private BigDecimal delayTolerance;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;

    @ManyToOne
    private UserCategory userCategory;

    @ManyToOne
    private Company company;

    @ManyToOne
    private AccessLevel accessLevel;

    @ManyToOne
    private Workload workload;

}
