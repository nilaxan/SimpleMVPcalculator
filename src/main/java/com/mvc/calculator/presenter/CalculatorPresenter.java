package com.mvc.calculator.presenter;

import com.mvc.calculator.view.CalculatorView;
import com.mvc.calculator.model.CalculatorModel;

/**
 * Created with IntelliJ IDEA.
 * User: tharanga
 * Date: 6/6/13
 * Time: 4:55 PM
 * To change this template use File | Settings | File Templates.
 */
class CalculatorPresenter
        implements CalculatorView.CalculatorViewListener {

    CalculatorModel model;
    CalculatorView  view;

    private double current = 0.0;
    private char   lastOperationRequested = 'C';

    public CalculatorPresenter(CalculatorModel model,
                               CalculatorView  view) {
        this.model = model;
        this.view  = view;

        view.setDisplay(current);
        view.addListener(this);
    }

    @Override
    public void buttonClick(char operation) {
        // Handle digit input
        if ('0' <= operation && operation <= '9') {
            current = current * 10
                    + Double.parseDouble("" + operation);
            view.setDisplay(current);
            return;
        }

        // Execute the previously input operation
        switch (lastOperationRequested) {
            case '+':
                model.add(current);
                break;
            case '-':
                model.add(-current);
                break;
            case '/':
                model.divide(current);
                break;
            case '*':
                model.multiply(current);
                break;
            case 'C':
                model.setValue(current);
                break;
        } // '=' is implicit

        lastOperationRequested = operation;

        current = 0.0;
        if (operation == 'C')
            model.clear();
        view.setDisplay(model.getValue());
    }
}