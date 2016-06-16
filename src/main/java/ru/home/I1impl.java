package ru.home;

import javax.inject.Named;

/**
 * Created by ivan on 17.06.16.
 */
@Named
public class I1impl implements I {
    public String getItem() {
        return this.getClass().getName();
    }
}
