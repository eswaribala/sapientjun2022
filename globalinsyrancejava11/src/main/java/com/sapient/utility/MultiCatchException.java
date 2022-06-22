package com.sapient.utility;

import com.sapient.exceptions.PasswordException;
import com.sapient.models.Claim;
import com.sapient.models.CustomerVO;

public class MultiCatchException {

    public static  void main(String[] args){

        Claim[] claim=new Claim[5];
      try {
          try {
              claim[0] = new Claim();
              System.out.println(claim[0].getClaimAmount() / 0);
          } catch (NullPointerException | ArithmeticException exception) {
          }
          System.out.println("outer block....");
      }
      catch(NegativeArraySizeException negativeArraySizeException){

      }

      //test password

      CustomerVO customerVO=new CustomerVO();
      customerVO.setUserName("parameswari");


        try {
            customerVO.setPassword("Test123");
        } catch (PasswordException e) {
            throw new RuntimeException(e);
        }


        System.out.println("able to continue");

/*
        catch (NullPointerException nullPointerException){

            System.out.println(nullPointerException.getMessage());
            for(StackTraceElement stackTraceElement:
                    nullPointerException.getStackTrace()){
                System.out.println(stackTraceElement.getClassName());
                System.out.println(stackTraceElement.getMethodName());
                System.out.println(stackTraceElement.getLineNumber());
                System.out.println(stackTraceElement.getClass().getName());
            }


        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
            for(StackTraceElement stackTraceElement:
                    exception.getStackTrace()){
                System.out.println(stackTraceElement.getClassName());
                System.out.println(stackTraceElement.getMethodName());
                System.out.println(stackTraceElement.getLineNumber());

           }
  */

    }
}
