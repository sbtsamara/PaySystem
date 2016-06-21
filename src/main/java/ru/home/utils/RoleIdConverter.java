package ru.home.utils;

import ru.home.dao.RoleId;

import javax.persistence.AttributeConverter;

/**
 * Created by ivan on 21.06.16.
 */
public class RoleIdConverter implements AttributeConverter<RoleId,String> {

    public String convertToDatabaseColumn(RoleId roleId) {
        switch (roleId){
            case ADMIN:
                return "ADM";
            case RESIDENT:
                return "RES";
            case HOA_EMP:
                return "HOA";
            case PROVIDER_EMP:
                return "ADM";
            default:return null;
        }
    }

    public RoleId convertToEntityAttribute(String s) {
        if (s.equals("RES")) {
            return RoleId.RESIDENT;
        } else if (s.equals("HOA")) {
            return RoleId.HOA_EMP;
        } else if (s.equals("PROV")) {
            return RoleId.PROVIDER_EMP;
        } else if (s.equals("ADM")) {
            return RoleId.ADMIN;
        } else {
            return null;
        }
    }
}
