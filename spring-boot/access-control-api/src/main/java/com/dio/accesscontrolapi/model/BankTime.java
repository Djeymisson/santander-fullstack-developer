package com.dio.accesscontrolapi.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
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
@Table(schema= "access_control_api")
@Audited
public class BankTime { // Movimentação

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class BankTimeId implements Serializable {
        private long idBankTime;
        private long idEntry;
        private long idUser;
    }

    @EmbeddedId
    private BankTimeId id;

    private LocalDateTime workedDate;
    private BigDecimal workedHours;
    private BigDecimal balance;

}
