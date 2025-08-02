package com.example.bean;

import java.util.Objects;

public class Example {
    private String messageExample;

    public Example(String messageExample) {
        this.messageExample = messageExample;
    }

    public String getMessageExample() {
        return messageExample;
    }

    public void setMessageExample(String messageExample) {
        this.messageExample = messageExample;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Example example)) return false;
        return Objects.equals(messageExample, example.messageExample);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(messageExample);
    }

    @Override
    public String toString() {
        return "Example [messageExample=" + messageExample + "]";
    }
}
