package com.dio.accesscontrolapi.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(schema= "access_control_api")
public class Company {

    @Id
    private long id;

    private String description;
    private String cnpj;
    private String address;
    private String district;
    private String city;
    private String state;
    private String phone;

}
