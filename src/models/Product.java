package models;

public class Product {
    private String name;
    private String category;
    
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }


    public void setCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return this.category;
    }
}
