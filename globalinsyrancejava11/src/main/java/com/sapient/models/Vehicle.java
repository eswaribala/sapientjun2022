package com.sapient.models;

import com.sapient.vos.Bridge;
import com.sapient.vos.TollBooth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private String regNo;
    private String model;

    public void sendMessage(String regNo) throws InterruptedException {
        System.out.print(regNo+"\t");
        new Bridge().bridgeMessage();
        new TollBooth().tollMessage();
    }

}
