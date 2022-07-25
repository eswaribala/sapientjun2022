package com.example.sparkkafkacassandra.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vote implements Serializable {
    private String name;
    private Integer votes;

}
