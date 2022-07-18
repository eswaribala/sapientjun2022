package com.sapient.globalinsurancejee.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DbConfiguration {

    private String url;
    private String userName;
    private String password;
    private String driverClassName;
}
