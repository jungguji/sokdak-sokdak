package com.jgji.sokdak.domain.place.presentation.dto;

import com.jgji.sokdak.domain.place.domain.Address;
import com.jgji.sokdak.domain.place.domain.Place;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlaceCreateRequest {

    private String name;
    @Valid
    private AddressForm address;
    private Long categoryId;

    public Place toEntity() {
        return Place.builder()
            .name(this.name)
            .address(this.address.toEntity())
            .categoryId(this.categoryId)
            .build();
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class AddressForm {

        private String road;
        private String jibun;

        @NotEmpty(message = "우편번호를 입력해주세요.")
        @Pattern(regexp = "[0-6][0-3]\\d{3}")
        private String zip;

        @NotNull
        @Pattern(regexp = "^-?[0-9]{1,3}(?:\\.[0-9]{1,7})?$")
        private BigDecimal latitude;

        @NotNull
        @Pattern(regexp = "^-?[0-9]{1,3}(?:\\.[0-9]{1,7})?$")
        private BigDecimal longitude;

        @Builder
        public AddressForm(String road, String jibun,
            @NotEmpty(message = "우편번호를 입력해주세요.") @Pattern(regexp = "[0-6][0-3]\\d{3}") String zip,
            @NotNull @Pattern(regexp = "^-?[0-9]{1,3}(?:\\.[0-9]{1,7})?$") BigDecimal latitude,
            @NotNull @Pattern(regexp = "^-?[0-9]{1,3}(?:\\.[0-9]{1,7})?$") BigDecimal longitude) {

          this.road = road;
          this.jibun = jibun;
          this.zip = zip;
          this.latitude = latitude;
          this.longitude = longitude;
        }

        private Address toEntity() {
            return Address.builder()
                .road(this.road)
                .jibun(this.jibun)
                .zip(this.zip)
                .latitude(this.latitude)
                .longitude(this.longitude)
                .build();
        }
    }
}

