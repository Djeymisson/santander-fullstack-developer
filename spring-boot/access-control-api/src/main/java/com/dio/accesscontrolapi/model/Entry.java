package com.dio.accesscontrolapi.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.math.BigDecimal;
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
public class Entry { // Movimentação

    @Id
    @GeneratedValue
    private long id;

    private LocalDateTime inDate;
    private LocalDateTime outDate;
    private BigDecimal period;

    @ManyToOne
    private User user;

    @ManyToOne
    private Occurrence occurrence;

    @ManyToOne
    private Calendar calendar;

}
