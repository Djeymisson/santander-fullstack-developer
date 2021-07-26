package com.dio.petapi.utils;

import com.dio.petapi.dto.OwnerDTO;
import com.dio.petapi.entity.Owner;

import java.util.Collections;

public class OwnerUtils {

    private static final String NAME = "Robert Cecil Martin";
    private static final String CPF = "02022025008";
    private static final String EMAIL = "cleancode@book.com";
    private static final long OWNER_ID = 1L;

    public static OwnerDTO createFakeDTO() {
        return OwnerDTO.builder()
                .name(NAME)
                .cpf(CPF)
                .email(EMAIL)
                .phones(Collections.singleton(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static OwnerDTO createFakeSavedDTO() {
        return OwnerDTO.builder()
                .id(OWNER_ID)
                .name(NAME)
                .cpf(CPF)
                .email(EMAIL)
                .phones(Collections.singleton(PhoneUtils.createFakeSavedDTO()))
                .build();
    }

    public static Owner createFakeEntity() {
        return Owner.builder()
                .id(OWNER_ID)
                .name(NAME)
                .cpf(CPF)
                .email(EMAIL)
                .phones(Collections.singleton(PhoneUtils.createFakeEntity()))
                .build();
    }

}
