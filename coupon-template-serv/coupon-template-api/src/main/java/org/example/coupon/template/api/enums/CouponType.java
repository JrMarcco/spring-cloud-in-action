package org.example.coupon.template.api.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum CouponType {

    UNKNOWN("0", "unknown"),
    MONEY_OFF("1", "满减"),
    DISCOUNT("2", "折扣"),
    RANDOM_DISCOUNT("3", "随机减"),
    NIGHTLY_MONEY_OFF("4", "晚间优惠"),
    ;

    private final String code;
    private final String description;

    public static CouponType convert(String code) {
        return Stream.of(values())
                .filter(item -> item.code.equalsIgnoreCase(code))
                .findFirst()
                .orElse(UNKNOWN);
    }
}
