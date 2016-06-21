package ru.home.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by ivan on 20.06.16.
 */
public class PasswordEncoder {
    public static String md5Apache(String st) {
        String md5Hex = DigestUtils.md5Hex(st);

        return md5Hex;
    }
}
