package com.orangehrmlive;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GivenTask test = new GivenTask();
        test.login();
        test.admin();
        test.newUser();
        System.out.println(test.checkUser());
        test.deleteUser();
    }
}
