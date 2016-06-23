package ru.home.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by ivan on 20.06.16.
 */
public class PasswordEncoder {

    //хэширует пароль
    public static String md5Apache(String st) {
        String md5Hex = DigestUtils.md5Hex(st);

        return md5Hex;
    }


    //сравнивает хэшированный и не хэшированный пароль
    public static boolean stringVsMd5(String uncoded, String encoded){
        return md5Apache(uncoded).equals(encoded);
    }
}
