package com.ps.utilities;

import com.ps.models.*;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class GoodProductsApp {

    public static void main(String... args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Number of products");
        int size=scanner.nextInt();
        scanner.nextLine();
        Product[] products= new Product[size];
        //2 food items, 2 apparel and 1 electronics
        FoodItem foodItem=null;
        Apparel apparel=null;
        Electronics electronics=null;
        for(int i=0;i<products.length;i++){
            if(i<2){
                foodItem=new FoodItem();
                foodItem.setItemCode(i);
                foodItem.setItemName("I"+i);
                foodItem.setDom(LocalDate.now());
                foodItem.setDoe(LocalDate.now().plusMonths(3));
                foodItem.setVegetarian(true);
                foodItem.setQty(new Random().nextInt(1000));
                foodItem.setPrice(new Random().nextInt(100000));
                products[i]=foodItem;
            }
            if((i>=2)&&(i<4)){
                apparel=new Apparel();
                apparel.setItemCode(i);
                apparel.setItemName("I"+i);
                apparel.setMaterial(Material.COTTON);
                apparel.setSize(Size.MEDIUM);
                apparel.setQty(new Random().nextInt(1000));
                apparel.setPrice(new Random().nextInt(100000));
                products[i]=apparel;
            }

            if(i==4){
                electronics=new Electronics();
                electronics.setItemCode(i);
                electronics.setItemName("I"+i);
                electronics.setQty(new Random().nextInt(1000));
                electronics.setPrice(new Random().nextInt(100000));
                electronics.setMonth((byte) (1+new Random().nextInt(12)));
                products[i]=electronics;

            }
        }

        for(Product product : products){
            System.out.println(product);
        }

    }
}
