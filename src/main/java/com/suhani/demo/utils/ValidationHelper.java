package com.suhani.demo.utils;


import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

@UtilityClass
public class ValidationHelper {




    public void isTrue(Boolean value, String errorMessage) throws Exception {
        if (!value) {
            throw new Exception(errorMessage);
        }
    }


    public void isNotZero(Integer value, String errorMessage) throws Exception {
        if (value == null || value == 0) {
            throw new Exception(errorMessage);
        }
    }
}
