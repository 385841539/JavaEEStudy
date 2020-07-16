package com.itheima.service.impl;

import com.itheima.service.IAccountService;

import java.util.*;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImp3 implements IAccountService {


    private String[] myStrs;
    private List<String> myLists;

    private Set<String> mySet;

    private Map<String,String> myMap;
    private Properties myProps;

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyLists(List<String> myLists) {
        this.myLists = myLists;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    public void saveAccount() {


        System.out.println("---acoount----"+ Arrays.toString(myStrs));
        System.out.println("---acoount----"+ mySet);
        System.out.println("---acoount----"+ myMap);
        System.out.println("---acoount----"+ myProps);
        System.out.println("---acoount----"+ myLists);


    }
}
