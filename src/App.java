import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Interfaces.IMap;
import factory.Factory;
import models.Product;

public class App {


    Scanner in  = new Scanner(System.in);
    
    Factory factory = new Factory();
    IMap productsMayor;
    IMap productsMinor;
    public static void main(String[] args) throws Exception {
        App app = new App();
        app.start();
    }


    public void start(){
        menuMap();
        menuNormal();
    }


    public void readFile(){
        File file = new File("src/ListadoProducto.txt");
        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)
 
        // Creating an object of BufferedReader class
        BufferedReader reader;
        try {
            
            
            
            reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
            Product product;
			while (line != null) {
				// read next line
				line = reader.readLine();

                if(line!=null){
                    String[] values = line.split("\\|");
    
                    String name = values[1];
                    String category = values[0];
                    product = new Product();
                    product.setName(name);
                    product.setCategory(category);
                    try {
                        productsMayor.add(product);
                        productsMinor.add(product);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
			}
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e);
            System.out.println("ARCHIVO NO ENCONTRADO");
        }
    }

    public void menuMap(){
        System.out.println("BIENVENIDO");
        System.out.println("QUÉ MAP DESEAS USAR?");
        System.out.println("1. HASHMAP");
        System.out.println("2. LINKEDHASHMAP ");
        System.out.println("3. TREEMAP");
        int resp = in.nextInt();

        productsMayor = factory.getMap(resp);
        productsMinor = factory.getMap(resp);


        readFile();

    }


    public void menuNormal(){
        int resp = 0;
        while(resp!=7){
            System.out.println("GESTIÓN DE PRODUCTOS");
            System.out.println("1. AGREGAR UN PRODUCTO");
            System.out.println("2. MOSTRAR LA CATEGORÍA DEL PRODUCTO INGRESANDO NOMBRE");
            System.out.println("3. MOSTRAR PRODUCTOS");
            System.out.println("4. MOSTRAR PRODUCTOS ORDENADOS POR TIPO.");
            System.out.println("5. MOSTRAR EL PRODUCTO Y LA CATEGORÍA TODO EL INVENTARIO");
            System.out.println("6. MOSTRAR EL PRODUCTO Y LA CATEGORÍA ORDENADAS POR TIPO TODO EL INVENTARIO.");
            System.out.println("7. SALIR");
            resp = in.nextInt();

            switch (resp) {
                case 1:
                    addProduct();
                    break;
                
                case 2:
                    getProductCategory();
                    break;
                case 3:
                    getProductMayor();
                    break;
                case 4:
                    getProductsortCategory();
                    break;
                case 5:
                    getProductAll();
                    break;
                case 6:
                    getProductsortCategoryAll();
                    break;
                default:
                    break;
            }
        }
        

    }

    public void getProductsortCategory(){
        ArrayList<Product> productTemporal = productsMayor.sortByCategory();

        for (Product product : productTemporal) {
            System.out.println("NOMBRE:"+product.getName());
            System.out.println("CATEGORÍA: "+product.getCategory());
        }
    }



    
    public void getProductsortCategoryAll(){
        ArrayList<Product> productTemporal = productsMayor.sortByCategory();
        System.out.println("MERCADO MAYOR======================================");
        for (Product product : productTemporal) {
            System.out.println("NOMBRE:"+product.getName());
            System.out.println("CATEGORÍA: "+product.getCategory());
        }


        ArrayList<Product> productTemporal2 = productsMinor.sortByCategory();
        System.out.println("MERCADO MENOR======================================");
        for (Product product : productTemporal2) {
            System.out.println("NOMBRE:"+product.getName());
            System.out.println("CATEGORÍA: "+product.getCategory());
        }
    }




    public void getProductsAllsortCategory(){
        ArrayList<Product> productTemporal = productsMayor.sortByCategory();
        System.out.println("MERCADO MAYOR================================");
        for (Product product : productTemporal) {
            System.out.println("NOMBRE:"+product.getName());
            System.out.println("CATEGORÍA: "+product.getCategory());
        }

        System.out.println("MERCADO MENOR");
        ArrayList<Product> productTemporal1 = productsMinor.sortByCategory();

        for (Product product : productTemporal1) {
            System.out.println("NOMBRE:"+product.getName());
            System.out.println("CATEGORÍA: "+product.getCategory());
        }

    }

    public void getCategoryProduct(){
        System.out.println("INGRESA LA CATEGORÍA: ");
        String category = in.next();
        System.out.println("CATEGORIA: "+category);
        for(int x =0; x<productsMayor.size();x++){
            if(productsMayor.find(x).getCategory().equals(category)){
                System.out.println("NOMBRE: "+productsMayor.find(x).getName());
            }
        }
    }


    public void getProductCategory(){
        System.out.println("INGRESA EL NOMBRE DEL PRODUCTO: ");
        String name = in.next();
        System.out.println("NOMBRE: "+name);
        for(int x =0; x<productsMayor.size();x++){
            if(productsMayor.find(x).getName().equals(name)){
                System.out.println("CATEGORÍA: "+productsMayor.find(x).getCategory());
                break;
            }
        }
    }


    public void getProductMayor(){
        System.out.println("MERCADO MAYOR");
        
        for(int x =0; x<productsMayor.size();x++){
            System.out.println("NOMBRE: "+productsMayor.find(x).getName());
        }
    }

    public void getProductAll(){
        System.out.println("MERCADO MAYOR");
        
        for(int x =0; x<productsMayor.size();x++){
            System.out.println("NOMBRE: "+productsMayor.find(x).getName());
        }


        System.out.println("MERCADO MENOR");
        
        for(int x =0; x<productsMinor.size();x++){
            System.out.println("NOMBRE: "+productsMayor.find(x).getName());
        }
    }

    public void addProduct(){
        Product product = new Product();
        System.out.println("INGRESA EL NOMBRE: ");
        String name = in.next();
        System.out.println("INGRESA LA CATEGORÍA: ");
        String category = in.next();
        System.out.println("EN QUE MERCADO DESEAS INGRESARLO?");
        System.out.println("1. MAYOR");
        System.out.println("2. MENOR");
        int market = in.nextInt();


        product.setName(name);
        product.setCategory(category);


        switch (market) {
            case 1:
                try {
                    productsMayor.add(product);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    productsMinor.add(product);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("OPCIÓN INVALIDA");
                break;
        }
        
    }
}
