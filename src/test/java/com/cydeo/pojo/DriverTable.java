package com.cydeo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.sql.Driver;
import java.util.List;
@Data
public class DriverTable {
    public List<Driver> drivers;
}
