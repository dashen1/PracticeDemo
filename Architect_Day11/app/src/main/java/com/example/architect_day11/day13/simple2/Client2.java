package com.example.architect_day11.day13.simple2;

public class Client2 {
    public static void main(String[] args) {

        IFinance finance = new RenzhongFinance();
        float money = finance.finance(12, 10000);
        System.out.println("renzhong money:"+money);
    }
}
