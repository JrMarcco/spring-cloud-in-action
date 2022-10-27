package org.example.coupon.template.api.beans;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.coupon.template.api.beans.rule.TemplateRule;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponTemplateInfo {

    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String desc;

    @NotNull
    private String type;

    private Long shopId;

    @NotNull
    private TemplateRule rule;

    private Boolean available;
}
