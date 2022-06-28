package com.sapient.dao;

import com.sapient.facades.CovidFacade;

import java.io.*;
import java.util.ResourceBundle;

public class CovidImpl implements CovidFacade {




    @Override
    public void getAllData(String fileName) throws IOException {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("db");
        String path=resourceBundle.getString("path");
        File file=new File(path,fileName);
        BufferedReader bufferedReader=null;
        String[] fields=null;
        String line=null;
        if(file.exists()){
            System.out.println("File Exists");
            try {
                bufferedReader=new BufferedReader(new FileReader(file));
                while((line=bufferedReader.readLine())!=null){
                    // System.out.println(line);
                    fields=line.split(",");
                    for(String field :fields)
                        System.out.print(field+" ");
                    System.out.println("\n");
                }

            } catch (FileNotFoundException e) {
                //rethrow concept
                throw  e;
            } catch (IOException e) {
                //rethrow concept
                throw e;
            }
            finally{
                bufferedReader.close();

            }

        }
        else
            System.out.println("File Not found...");
    }
}
