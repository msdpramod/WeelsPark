package com.example.parkinglot.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter@Setter
public class BaseModel {
    private Long Id;
    private Date CreatedAt;
    private Date UpdatedAt;

}
