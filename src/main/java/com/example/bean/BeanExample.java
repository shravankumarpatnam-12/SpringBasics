package com.example.bean;

import java.util.Objects;

public class BeanExample {
    private Example example;
    private String message;

    public Example getExample() {
        return example;
    }

    public void setExample(Example example) {
        this.example = example;
    }

    public BeanExample(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BeanExample(Example example, String message) {
        this.example = example;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BeanExample that)) return false;
        return Objects.equals(example, that.example) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(example, message);
    }

    @Override
    public String toString() {
        return  "BeanExample [example=" + example + ", message=" + message + "]";
    }
}
