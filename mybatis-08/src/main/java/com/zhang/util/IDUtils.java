package com.zhang.util;

import org.testng.annotations.Test;

import java.lang.annotation.Target;
import java.util.UUID;

public class IDUtils {
    public static String getID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
    @Test
    public void test(){
        System.out.println(IDUtils.getID());
    }

}
