package com.example.architect_day11.day13.simple2;

public class RenzhongFinance implements IFinance{
    @Override
    public float finance(int month, int money) {
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
}
