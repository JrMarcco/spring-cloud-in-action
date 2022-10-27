package org.example.coupon.template.impl.mapper;

import org.example.coupon.template.api.beans.CouponTemplateInfo;
import org.example.coupon.template.dao.entity.CouponTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CouponTemplateMapper {

    CouponTemplateMapper INSTANCE = Mappers.getMapper(CouponTemplateMapper.class);

    CouponTemplateInfo toRecord(CouponTemplate entity);
}
