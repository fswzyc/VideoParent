package com.xcy.video.utils;

import org.springframework.util.DigestUtils;

/**
 * @author yanzhenwei
 *     <p>MD5 是一个加密算法，经常在项目中使用，特别是密码 MD5无法破解
 */
public class MD5Utils {

  public static String getMd5(String oldStr) {

    String str = DigestUtils.md5DigestAsHex(oldStr.getBytes());
    String childStr = str.substring(7, 18);

    String newStr = str + childStr;

    return DigestUtils.md5DigestAsHex(newStr.getBytes());
  }

  public static void main(String[] args) {

    String passMi = DigestUtils.md5DigestAsHex("123456".getBytes());
    System.out.println(passMi.length());

    System.out.println(getMd5("admin"));
  }
}
