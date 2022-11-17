package com.jgji.sokdak.domain.place.presentation.dto;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.jgji.sokdak.domain.place.presentation.dto.PlaceCreateRequest.AddressForm;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaceCreateRequestTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void test() {
        //given
        String zipCode = "01006";
        BigDecimal latitude = new BigDecimal(128.6521583);
        BigDecimal longitude = new BigDecimal(34.90709824);

        AddressForm form = AddressForm.builder()
            .jibun("성루시")
            .road("서울시")
            .zip("")
            .latitude(null)
            .longitude(longitude)
            .build();

        Set<ConstraintViolation<AddressForm>> violations = validator.validate(form);
        assertFalse(violations.isEmpty());
    }

}