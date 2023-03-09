package models;

import java.util.LinkedHashMap;

import Interfaces.IMap;

public class LinkedHashMapClass implements IMap{
    int position=0;
    LinkedHashMap<Integer, Product> products = new LinkedHashMap<Integer, Product>();

    @Override
    public void add(Product product) throws Exception{
        try{
            products.put(position, product);
            position++;
        }catch(Exception e){
            throw new Exception("NO SE LOGRÓ GUARDAD");
        }
    }

    @Override
    public void remove(int position){
        products.remove(position);
    }

    @Override
    public Product find(int position){
        return products.get(position);
    }
}
