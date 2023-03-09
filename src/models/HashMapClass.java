package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

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

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return products.size();
    }


    @Override
    //implementation bubble sort
    public ArrayList sortByCategory()
    {
        ArrayList<Product> temporalproduct = new ArrayList<Product>(products.values());

        
        int n = products.size();
        for(int x= 0 ; x<n-1; x++){
            for(int y= 0 ; y<n-1; y++){
                if (temporalproduct.get(y).getCategory().compareTo(temporalproduct.get(y+1).getCategory())==1) {
                    // swap arr[j+1] and arr[j]
                    Product temp = temporalproduct.get(y);
                    temporalproduct.add(y,temporalproduct.get(y+1));  
                    temporalproduct.add(y+1,temp);
                }
            }   
        }

        return temporalproduct;
    }

}
