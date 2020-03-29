package com.tech.kamboj.common;

import org.dozer.DozerBeanMapper;

public class DozerMapper {

    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    public static <T> T map(Object source, Class<T> destination) {

        return new DozerBeanMapper().map(source, destination);
    }
}
