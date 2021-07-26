package com.dio.petapi.utils;

import com.dio.petapi.dto.PhoneDTO;
import com.dio.petapi.entity.Phone;
import com.dio.petapi.enums.PhoneType;

public class PhoneUtils {

    private static final long PHONE_ID = 1L;
    private static final PhoneType PHONE_TYPE = PhoneType.HOME;
    private static final String PHONE_NUMBER = "8799999-9999";

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static PhoneDTO createFakeSavedDTO() {
        return PhoneDTO.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
