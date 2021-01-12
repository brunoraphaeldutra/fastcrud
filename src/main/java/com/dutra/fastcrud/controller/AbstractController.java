package com.dutra.fastcrud.controller;

import com.dutra.fastcrud.specifications.AbstractSpecification;
import com.dutra.fastcrud.specifications.SpecificationsBuilder;
import org.springframework.data.jpa.domain.Specification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AbstractController<T, Y extends AbstractSpecification> {

    private T type;

    public Specification<T> buildSpecification(String search){
        SpecificationsBuilder<T, Y> builder = new SpecificationsBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
        return builder.build();
    }
}
