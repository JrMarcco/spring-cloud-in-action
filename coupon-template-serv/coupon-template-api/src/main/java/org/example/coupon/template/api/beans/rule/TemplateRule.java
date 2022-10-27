package org.example.coupon.template.api.beans.rule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateRule {

    private Discount discount;

    private Integer limitation;

    private Long deadline;
}
