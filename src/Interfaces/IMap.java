package Interfaces;

import models.Product;

public interface IMap {
    
    public void add(Product product) throws Exception;

    public void remove(int position);

    public Product find(int position);


}
