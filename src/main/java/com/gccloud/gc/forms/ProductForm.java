package com.gccloud.gc.forms;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductForm {

    
    private String name;
    private String description;
    private String model;
    private String picture;

    private String category;
    
    private List<String> categoryTags;




}
