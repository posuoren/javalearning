package com.posuoren.construct.factory.abstractfactory.cat;

import com.posuoren.construct.factory.abstractfactory.cat.AmericanShortHair;
import com.posuoren.construct.factory.abstractfactory.cat.BritishShortHair;
import com.posuoren.construct.factory.abstractfactory.cat.Cat;
import com.posuoren.construct.factory.normal.dog.Corgi;
import com.posuoren.construct.factory.normal.dog.Dog;
import com.posuoren.construct.factory.normal.dog.Husky;
import com.posuoren.construct.factory.normal.dog.Shepherd;

/**
 * @Description
 * @Author leiyutian
 * @Date 2020/2/11 10:28
 */
public class CatFactory {

    public Cat getCat(String name){
        if(name == null){
            return null;
        }
        if(name.equalsIgnoreCase("AmericanShortHair")){
            return new AmericanShortHair();
        }else if(name.equalsIgnoreCase("BritishShortHair")){
            return new BritishShortHair();
        }
        return null;
    }
}
