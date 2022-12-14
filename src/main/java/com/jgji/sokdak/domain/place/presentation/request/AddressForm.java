package com.jgji.sokdak.domain.place.presentation.request;

import com.jgji.sokdak.domain.place.domain.Address;
import com.jgji.sokdak.global.exception.BusinessException;
import com.jgji.sokdak.global.exception.ErrorCode;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddressForm {

    private String road;
    private String jibun;

    @NotEmpty(message = "우편번호를 입력해주세요.")
    @Pattern(regexp = "\\d{5}", message = "올바르지 않은 우편번호 형식 입니다.")
    private String zip;

    @NotEmpty
    @Pattern(regexp = "^-?[0-9]{1,3}(?:\\.[0-9]{1,7})?", message = "올바르지 않은 좌표 형식 입니다.")
    private String latitude;

    @NotEmpty
    @Pattern(regexp = "^-?[0-9]{1,3}(?:\\.[0-9]{1,7})?", message = "올바르지 않은 좌표 형식 입니다.")
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
        String pointWKT = String.format("POINT(%s %s)", latitude, longitude);
        Point point = null;
        try {
            point = (Point) new WKTReader().read(pointWKT);
        } catch (ParseException e) {
            throw new BusinessException(ErrorCode.ABNORMAL_COORDINATES);
        }

        return Address.builder()
            .road(this.road)
            .jibun(this.jibun)
            .zip(this.zip)
            .location(point)
            .build();
    }
}
