import java.util.Scanner;

import Interfaces.IMap;
import factory.Factory;

public class App {


    Scanner in  = new Scanner(System.in);
    
    Factory factory = new Factory();
    IMap products;
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

        products = factory.getMap(resp);
    }


    public void menuNormal(){
      
    }
}
