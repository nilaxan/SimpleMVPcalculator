package com.mvc.calculator.view;

/**
 * Created with IntelliJ IDEA.
 * User: tharanga
 * Date: 6/6/13
 * Time: 4:40 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CalculatorView {
    public void setDisplay(double value);

    interface CalculatorViewListener {
        void buttonClick(char operation);
    }
    public void addListener(CalculatorViewListener listener);
}