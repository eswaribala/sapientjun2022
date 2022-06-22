package com.sapient.utility;

import com.sapient.models.Claim;

public class MultiCatchException {

    public static  void main(String[] args){

        Claim[] claim=new Claim[5];

        try{
            claim[0]=new Claim();
            System.out.println(claim[0].getClaimAmount()/0);
        }

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
        }
    }
}
