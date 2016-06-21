package ru.home.utils;

import javax.persistence.AttributeConverter;

import static java.lang.Boolean.*;

/**
 * Created by Vlad on 20.06.16.
 */
public class BooleanConverter implements AttributeConverter<Boolean, Integer> {

    public Integer convertToDatabaseColumn(Boolean bool) {
        if (bool.equals(FALSE)) {
            return 0;
        } else if (bool.equals(TRUE)) {
            return 1;
        }else {
            return null;
        }
    }


    public Boolean convertToEntityAttribute(Integer dbData) {
        switch (dbData) {
            case 0:
                return Boolean.FALSE;
            case 1:
                return Boolean.TRUE;
            default:
                return Boolean.FALSE;
        }
    }
}