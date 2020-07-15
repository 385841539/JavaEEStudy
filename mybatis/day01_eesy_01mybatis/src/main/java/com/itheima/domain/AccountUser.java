package com.itheima.domain;

public class AccountUser extends Account{

     private  String username;
     private  String  address;


    @Override
    public String toString() {
        return  super.toString()+"     AccountUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
