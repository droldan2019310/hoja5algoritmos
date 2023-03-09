package factory;

import Interfaces.IMap;
import models.HashMapClass;
import models.LinkedHashMapClass;
import models.TreeMapClass;

public class Factory {
    

    public IMap getMap(int type){

        switch (type) {
            case 1:
                return new HashMapClass();
                
            case 2:
                return new LinkedHashMapClass();
                
            case 3:
                return new TreeMapClass(); 
            default:
                return null;
        }
    }
}
