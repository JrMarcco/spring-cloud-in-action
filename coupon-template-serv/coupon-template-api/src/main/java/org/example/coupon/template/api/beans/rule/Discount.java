package org.example.coupon.template.api.beans.rule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discount {

    // 满减 - quota 是减掉的钱数，单位是分
    // 折扣 - quota 是折扣(以 100 表示原价)，90 就是打 9 折
    // 随机减 - quota 是最高的随机立减额
    // 晚间优惠 - quota 是日间优惠额，晚间优惠翻倍
    private Long quota;

    // 订单最低要达到多少钱才能用优惠券，单位为分
    private Long threshold;
}
