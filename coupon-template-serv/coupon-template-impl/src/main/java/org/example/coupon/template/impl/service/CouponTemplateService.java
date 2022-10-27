package org.example.coupon.template.impl.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.coupon.template.api.beans.CouponTemplateInfo;
import org.example.coupon.template.api.enums.CouponType;
import org.example.coupon.template.dao.CouponTemplateDao;
import org.example.coupon.template.dao.entity.CouponTemplate;
import org.example.coupon.template.impl.mapper.CouponTemplateMapper;
import org.example.coupon.template.impl.service.inf.ICouponTemplateService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CouponTemplateService implements ICouponTemplateService {

    private final CouponTemplateDao couponTemplateDao;

    @Override
    public CouponTemplateInfo create(CouponTemplateInfo req) {
        if (req.getShopId() != null) {
            Integer count = couponTemplateDao.countByShopIdAndAvailable(req.getShopId(), true);
            if (count >= 100) {
                log.error("the totals of coupon template exceeds maxim number");
                throw new UnsupportedOperationException("exceeded the maxim of coupon templates that you can create");
            }
        }

        CouponTemplate template = CouponTemplate.builder()
                .name(req.getName())
                .description(req.getName())
                .couponType(CouponType.convert(req.getType()))
                .available(true)
                .shopId(req.getShopId())
                .rule(req.getRule())
                .build();

        template = couponTemplateDao.save(template);

        return CouponTemplateMapper.INSTANCE.toRecord(template);
    }
}
