package com.sapient.dao;

import com.sapient.facades.ClaimFacade;
import com.sapient.models.Claim;
import com.sapient.models.Vehicle;

import java.io.*;
import java.util.ResourceBundle;

public class ClaimImpl implements ClaimFacade {
    private String fileName;
    public ClaimImpl(String fileName) {
        this.fileName=fileName;
    }

    @Override
    public boolean addClaim(Claim claim, Vehicle vehicle) throws IOException {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("db");
        String path=resourceBundle.getString("path");
        File file=new File(path,fileName);
        BufferedWriter bufferedWriter=null;
        if(file.exists()){
            writeData(claim, file, bufferedWriter);
        }
        else
        {
            file.createNewFile();
            writeData(claim, file, bufferedWriter);
        }




        return false;
    }

    private void writeData(Claim claim, File file, BufferedWriter bufferedWriter) throws IOException {
        try {
            bufferedWriter =new BufferedWriter(new FileWriter(file,true));
            bufferedWriter.write(claim.getClaimId()+",");
            bufferedWriter.write(claim.getPolicyNo()+",");
            bufferedWriter.write(claim.getClaimAmount()+",");
            bufferedWriter.write(claim.getClaimDate()+"\n");
        } catch (IOException e) {
            throw e;
        }
        finally {
            bufferedWriter.close();
        }
    }
}
