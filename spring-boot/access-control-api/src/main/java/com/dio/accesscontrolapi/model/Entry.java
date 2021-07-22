package com.dio.accesscontrolapi.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(schema= "DIO")
public class Entry { // Movimentação

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class EntryId implements Serializable {
        private long idEntry;
        private long idUser;
    }

    @EmbeddedId
    private EntryId id;

    private LocalDateTime inDate;
    private LocalDateTime outDate;
    private BigDecimal period;

    @ManyToOne
    private Occurrence occurrence;

    @ManyToOne
    private Calendar calendar;

}
