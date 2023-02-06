package com.example.architect_day11.day13.simple2;

/**
 * 策略模式上下文
 * 可以获取额外的一些基本信息
 */
public class FinanceContext {
    IFinance finance;

    public FinanceContext(IFinance finance) {
        this.finance = finance;
    }
}
