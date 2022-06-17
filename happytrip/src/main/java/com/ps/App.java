package com.ps;

import com.ps.models.Person;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {

      for(String arg : args){
          System.out.println(arg);
      }
       for(Person person : generateData())
           System.out.println(person);
    }

    static Person[] generateData(){
      Scanner scanner=new Scanner(System.in);
      System.out.println("Enter Number of persons");
      int size=scanner.nextInt();
      scanner.nextLine();
      Person[] persons=new Person[size];
      for(int i=0;i<persons.length;i++){
          persons[i]=new Person(new Random().nextInt(100),"person"+i,
                  LocalDate.of(2000+new Random().nextInt(20),
                          new Random().nextInt(10),
                          new Random().nextInt(26)),true);
     }

        return persons;

    }

}