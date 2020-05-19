package com.mine.docdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author weapon
 * @date 2020/4/23 10:05
 */
public class TestCase {

    public static void main(String[] args) {
        String words = "AAABBHHAAAAAHAAAABCAAAAAA";
        System.out.println(getLongs(words));
    }

    public static String getLongs(String words) {
        Pattern pattern = Pattern.compile("([a-zA-Z])\\1+");
        Matcher matcher = pattern.matcher(words);
        String word = "";
        while (matcher.find()) {
            String index = matcher.group();
            if (word.length() < index.length()) {
                word = index;
            }
        }

        return word + "," + word.length();
    }
}
