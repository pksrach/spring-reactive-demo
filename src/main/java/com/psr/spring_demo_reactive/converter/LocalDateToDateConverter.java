package com.psr.spring_demo_reactive.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class LocalDateToDateConverter implements Converter<LocalDate, Date> {
    @Override
    public Date convert(LocalDate source) {
        return java.sql.Date.valueOf(source);
    }
}
