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
    }


    public void menuNormal(){
        int resp = 0;
        while(resp!=7){
            System.out.println("GESTIÓN DE PRODUCTOS");
            System.out.println("1. AGREGAR UN PRODUCTO");
            System.out.println("2. MOSTRAR LA CATEGORÍA DEL PRODUCTO");
            System.out.println("3. MOSTRAR PRODUCTOs ");
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
                    
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                default:
                    break;
            }
        }
        

    }

    public void addProduct(){
        Product product = new Product();
        System.out.println("INGRESA EL NOMBRE");
        String name = in.nextLine();
        System.out.println("INGRESA LA CATEGORÍA");
        String category = in.nextLine();
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
