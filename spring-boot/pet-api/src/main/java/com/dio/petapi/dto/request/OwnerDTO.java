package com.dio.petapi.dto.request;

import com.dio.petapi.entity.Pet;
import com.dio.petapi.entity.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDTO {

    private long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String name;

    @CPF
    @NotEmpty
    private String cpf;

    @NotEmpty
    private String email;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;

    @Valid
    private List<PetDTO> pets;

}
