package com.javaPractrice.springWebServices.basics.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SomeBean {
    private String field1;

    private String field2;

    @JsonIgnore //set this so that when you call the Controller, this field will NOT show up
    //This is an example of STATIC filtering -> For dynamic filtering you need a Mapping Filter -> Refer to Course for Dynamic Filtering -> Toolazy to code it (niche usecase for now)
    private String field3;

    public SomeBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    @Override
    public String toString() {
        return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
    }

    

}