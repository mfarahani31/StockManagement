package com.hoom.stockmanagement.controller;

import lombok.Data;

@Data
public class CreateProductRequestModel {

    private String name;

    private String color;

    private String description;
}
