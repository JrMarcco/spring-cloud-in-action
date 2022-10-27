package org.example.coupon.template.dao.converter;

import org.example.common.utils.JacksonUtils;
import org.example.coupon.template.api.beans.rule.TemplateRule;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RuleConverter implements AttributeConverter<TemplateRule, String> {

    @Override
    public String convertToDatabaseColumn(TemplateRule rule) {
        return JacksonUtils.toJsonString(rule);
    }

    @Override
    public TemplateRule convertToEntityAttribute(String rule) {
        return JacksonUtils.parseObject(rule, TemplateRule.class);
    }
}
