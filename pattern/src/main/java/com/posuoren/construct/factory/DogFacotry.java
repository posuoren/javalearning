package com.posuoren.construct.factory;

/**
 * @Description
 * @Author leiyutian
 * @Date 2020/2/9 19:54
 */
public class DogFacotry {
    public Dog getDog(String name){
        if(name == null){
            return null;
        }
        if(name.equalsIgnoreCase("Husky")){
            return new Husky();
        }else if(name.equalsIgnoreCase("Corgi")){
            return new Corgi();
        }else if(name.equalsIgnoreCase("Shepherd")){
            return new Shepherd();
        }
        return null;
    }
}
