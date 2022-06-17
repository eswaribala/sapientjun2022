package com.ps.models;

import lombok.Data;

@Data
public abstract class Product {

    protected long itemCode;
    protected String itemName;
    protected int qty;
    protected long price;

}
