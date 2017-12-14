package com.comp20010;

public class LinkedEntry {

    public String key;
    public int value;
    public LinkedEntry next;

    public LinkedEntry(String key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public String getKey(){
        return key;
    }

    public LinkedEntry getNext() {
        return next;
    }

    public void setNext(LinkedEntry next) {
        this.next = next;
    }
}