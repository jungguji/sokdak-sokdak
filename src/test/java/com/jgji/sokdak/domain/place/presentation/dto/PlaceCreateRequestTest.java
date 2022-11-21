package com.jgji.sokdak.domain.place.presentation.dto;

import static org.junit.jupiter.api.Assertions.assertFalse;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlaceCreateRequestTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @DisplayName(value = "좌표 형식 불일치")
    @Test
    public void test() {
        //given
        String zipCode = "01006";
        String latitude = "1284.6521583";
        String longitude = "34.90709821";

        AddressForm form = AddressForm.builder()
            .jibun("성루시")
            .road("서울시")
            .zip(zipCode)
            .latitude(latitude)
            .longitude(longitude)
            .build();

        Set<ConstraintViolation<AddressForm>> violations = validator.validate(form);
        assertFalse(violations.isEmpty());
    }

    @DisplayName(value = "우편번호 미 입력")
    @Test
    public void test1() {
        //given
        String zipCode = "01006";
        String latitude = "128.6521583";
        String longitude = "34.9070982";

        AddressForm form = AddressForm.builder()
            .jibun("성루시")
            .road("서울시")
            .zip("")
            .latitude(latitude)
            .longitude(longitude)
            .build();

        Set<ConstraintViolation<AddressForm>> violations = validator.validate(form);
        assertFalse(violations.isEmpty());
    }

    @DisplayName(value = "우편번호 형식 불일치")
    @Test
    public void test2() {
        //given
        String zipCode = "0100635";
        String latitude = "128.6521583";
        String longitude = "34.9070982";

        AddressForm form = AddressForm.builder()
            .jibun("성루시")
            .road("서울시")
            .zip(zipCode)
            .latitude(latitude)
            .longitude(longitude)
            .build();

        Set<ConstraintViolation<AddressForm>> violations = validator.validate(form);
        assertFalse(violations.isEmpty());
    }

}