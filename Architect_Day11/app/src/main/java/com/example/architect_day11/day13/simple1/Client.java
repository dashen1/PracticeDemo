package com.example.architect_day11.day13.simple1;

public class Client {

    public static void main(String[] args) {
        FinanceManager financeManager = new FinanceManager();
        float money = financeManager.finance(3, 10000, FinanceManager.Finance.REN_ZHONG);
        System.out.println("money:"+money);
    }
}
