package com.mvc.calculator.model;

/**
 * Created with IntelliJ IDEA.
 * User: tharanga
 * Date: 6/6/13
 * Time: 4:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class CalculatorModel {
    private double value = 0.0;

    public void clear() {
        value = 0.0;
    }

    public void add(double arg) {
        value += arg;
    }

    public void multiply(double arg) {
        value *= arg;
    }

    public void divide(double arg) {
        if (arg != 0.0)
            value /= arg;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}