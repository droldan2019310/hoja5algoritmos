package models;

import java.util.HashMap;

import Interfaces.IMap;

public class HashMapClass implements IMap {
    int position=0;
    HashMap<Integer, Product> products = new HashMap<Integer,Product>();

    @Override
    public void add(Product product) throws Exception{
        try{
            products.put(position,product);
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
