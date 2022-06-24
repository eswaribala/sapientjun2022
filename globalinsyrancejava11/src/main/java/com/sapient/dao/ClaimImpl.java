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


        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(claim.getClaimId() + ",");
            bw.write(claim.getPolicyNo() + ",");
            bw.write(claim.getClaimAmount() + ",");
            bw.write(claim.getClaimDate() + "\n");
        }



    }
}
