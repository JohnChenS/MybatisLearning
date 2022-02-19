package com.kuang.utils;

import java.util.UUID;
import org.junit.Test;
/**
 * @author John Chen
 * @Date 202202
 */

//抑制警告
//@SuppressWarnings("all")
public class IDUtils {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test(){
        System.out.println(IDUtils.getId());
        System.out.println(IDUtils.getId());
        System.out.println(IDUtils.getId());
    }
}

