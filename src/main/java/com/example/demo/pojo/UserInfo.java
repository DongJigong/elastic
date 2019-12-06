package com.example.demo.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;

@Document(indexName = "user_info")
@Setter
@Getter
public class UserInfo {

    @Id
    private long id;

    private String username;

    private String nick;

    private String address;

    private long phone;
    @Field(type = FieldType.Half_Float)
    private BigDecimal price;
}
