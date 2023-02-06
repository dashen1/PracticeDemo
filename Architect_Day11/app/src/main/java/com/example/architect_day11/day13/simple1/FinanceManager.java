package com.example.architect_day11.day13.simple1;

public class FinanceManager {

    public enum Finance{
        ALI_PAY,
        REN_ZHONG
    }

    private float alipayFinance(int month, int money) {
        if (month == 3) {
            return money + money * 0.047f / 12 * month;
        }

        if (month == 6) {
            return money + money * 0.05f / 12 * month;
        }

        if (month == 12) {
            return money + money * 0.06f / 12 * month;
        }
        throw new IllegalArgumentException("月份不对");
    }

    private float renzhongFinance(int month, int money) {
        if (month == 3) {
            return money + money * 0.009f / 12 * month;
        }

        if (month == 6) {
            return money + money * 0.112f / 12 * month;
        }

        if (month == 12) {
            return money + money * 0.12f / 12 * month;
        }
        throw new IllegalArgumentException("月份不对");
    }

    public float finance(int month, int money, Finance finance){
        switch (finance){
            case ALI_PAY:
                return alipayFinance(month, money);
            case REN_ZHONG:
                return renzhongFinance(month, money);
            default:
                return 0f;
        }
    }
}
