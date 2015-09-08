package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("============ Welcome To Longest Repeating Substring ============");
        System.out.print("Ok give me a string to evaluate: ");
        Scanner user_input = new Scanner(System.in);
        String random_string = user_input.next();
        ArrayList<String> lrs = Substring.GetLongestRepeatedSubstring(random_string);
        System.out.println("Longest Repeated Substring is: " + lrs);
    }

}
