package com.psr.spring_demo_reactive.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class LocalDateToDateConverter implements Converter<LocalDate, Date> {
    @Override
    public Date convert(@NonNull LocalDate source) {
        return java.sql.Date.valueOf(source);
    }
}
