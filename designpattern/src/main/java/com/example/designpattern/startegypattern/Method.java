package com.example.designpattern.startegypattern;

/**
 * @Description: 将策略传入构造函数中
 * @Author: Estelle
 * @Time: 2018/10/23 19:12
 * @update: wb.huhuimin 2018/10/23 19:12
 */
public class Method {
    private I_Startegy startegy;

    public Method(I_Startegy startegy) {
        this.startegy = startegy;
    }

    public void action() {
        startegy.startegy();
    }
}
