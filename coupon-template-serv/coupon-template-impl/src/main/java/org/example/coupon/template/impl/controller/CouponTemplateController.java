package org.example.coupon.template.impl.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.coupon.template.api.beans.CouponTemplateInfo;
import org.example.coupon.template.impl.service.inf.ICouponTemplateService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/template")
public class CouponTemplateController {

    private final ICouponTemplateService couponTemplateService;

    @PostMapping("/add")
    public CouponTemplateInfo add(@Valid @RequestBody CouponTemplateInfo req) {
        log.info("Create coupon template: data = {}" , req);
        return couponTemplateService.create(req);
    }
}
