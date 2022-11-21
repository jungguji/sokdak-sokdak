package com.jgji.sokdak.domain.place.presentation.dto;

import com.jgji.sokdak.domain.place.domain.Address;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddressForm {

    private String road;
    private String jibun;

    @NotEmpty(message = "우편번호를 입력해주세요.")
    @Pattern(regexp = "[0-6][0-3]\\d{3}")
    private String zip;

    @NotEmpty
    @Pattern(regexp = "^-?[0-9]{1,3}(?:\\.[0-9]{1,7})?")
    private String latitude;

    @NotEmpty
    @Pattern(regexp = "^-?[0-9]{1,3}(?:\\.[0-9]{1,7})?")
    private String longitude;

    @Builder
    public AddressForm(String road, String jibun, String zip, String latitude, String longitude) {

        this.road = road;
        this.jibun = jibun;
        this.zip = zip;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    protected Address toEntity() {
        return Address.builder()
            .road(this.road)
            .jibun(this.jibun)
            .zip(this.zip)
            .latitude(new BigDecimal(this.latitude))
            .longitude(new BigDecimal(this.longitude))
            .build();
    }
}
