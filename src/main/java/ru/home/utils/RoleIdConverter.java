package ru.home.utils;

import ru.home.dao.RoleId;

import javax.persistence.AttributeConverter;

/**
 * Created by ivan on 21.06.16.
 */
public class RoleIdConverter implements AttributeConverter<RoleId,String> {

    public String convertToDatabaseColumn(RoleId roleId) {
        switch (roleId){
            case ADM:
                return "ADM";
            case RES:
                return "RES";
            case HOA:
                return "HOA";
            case PROV:
                return "ADM";
            default:return null;
        }
    }

    public RoleId convertToEntityAttribute(String s) {
        if (s.equals("RES")) {
            return RoleId.RES;
        } else if (s.equals("HOA")) {
            return RoleId.HOA;
        } else if (s.equals("PROV")) {
            return RoleId.PROV;
        } else if (s.equals("ADM")) {
            return RoleId.ADM;
        } else {
            return null;
        }
    }
}
