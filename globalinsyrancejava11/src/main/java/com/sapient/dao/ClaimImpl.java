package com.sapient.dao;

import com.sapient.facades.ClaimFacade;
import com.sapient.models.Claim;
import com.sapient.models.Vehicle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ResourceBundle;

public class ClaimImpl implements ClaimFacade {
    private String fileName;
    private String path;
    private File file;
    private boolean status;
    private  ResourceBundle resourceBundle;
    private BufferedWriter bufferedWriter;
    public ClaimImpl(String fileName) {
        this.fileName=fileName;
       resourceBundle=ResourceBundle.getBundle("db");
        path=resourceBundle.getString("path");
        file=new File(path,fileName);
    }

    @Override
    public boolean addClaim(Claim claim, Vehicle vehicle) throws IOException {


        if(file.exists()){
            writeData(claim, file, bufferedWriter);
            status=true;
        }
        else
        {
            file.createNewFile();
            writeData(claim, file, bufferedWriter);
            status=true;
        }




        return status;
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
