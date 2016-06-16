package ru.home;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by ivan on 17.06.16.
 */
@Named
public class IServise {
    @Inject
    private I i;
    public IServise(){
    }
    public void setI(I i){
        this.i=i;

    }
    public String getItem(){
        return i.getItem();
    }
}
