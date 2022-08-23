package com.eric.elkmsdemo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

@Data
@Document(indexName = "stockdataindex")
public class Stock {
    @Id
	private long stockId;
    @Field(type = FieldType.Long, name = "productId")
	private long productId;
    @Field(type = FieldType.Long, name = "qty")
	private long qty;
    @Field(type = FieldType.Boolean, name = "status")
	private boolean status;
    @Field(type = FieldType.Text, name = "location")
	private String location;
	
}
