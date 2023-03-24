package org.polynomialcalculator.controllers;

import org.polynomialcalculator.models.*;
import org.polynomialcalculator.views.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CalcController {
    Frame view;

    public CalcController(Frame view) {
        this.view = view;
        this.view.addAddButtonActionListener(new AddButtonActionListener());
        this.view.addSubButtonActionListener(new SubButtonActionListener());
        this.view.addMulButtonActionListener(new MulButtonActionListener());
        this.view.addDivButtonActionListener(new DivButtonActionListener());
        this.view.addDerButtonActionListener(new DerButtonActionListener());
        this.view.addIngButtonActionListener(new IngButtonActionListener());

    }

    private class AddButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String one = view.getPx();
            String two = view.getQx();
            if (!(Validators.validate(one)) || !(Validators.validate(two))) {
                view.setRx("Invalid input");
            }
            HashMap<Integer, Double> p = Validators.parse_a_string(one);
            HashMap<Integer, Double> q = Validators.parse_a_string(two);
            Polynomial x = new Polynomial();
            Polynomial y = new Polynomial();
            x.setPolinom(p);
            y.setPolinom(q);
            Polynomial r = Operations.addition(x, y);
            String res = Validators.parse_a_polinom((HashMap<Integer, Double>) r.getPolinom());
            view.setRx(res);
        }
    }

    private class SubButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String one = view.getPx();
            String two = view.getQx();
            if (!(Validators.validate(one)) || !(Validators.validate(two))) {
                view.setRx("Invalid input");
            }
            HashMap<Integer, Double> p = Validators.parse_a_string(one);
            HashMap<Integer, Double> q = Validators.parse_a_string(two);
            Polynomial x = new Polynomial();
            Polynomial y = new Polynomial();
            x.setPolinom(p);
            y.setPolinom(q);
            Polynomial r = new Polynomial();
            r.getPolinom().put(0,0.0);
            try {
                r = Operations.subtraction(x, y);
            } catch (ArithmeticException e1) {

            }
            String res = Validators.parse_a_polinom((HashMap<Integer, Double>) r.getPolinom());
            view.setRx(res);
        }
    }

    private class MulButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String one = view.getPx();
            String two = view.getQx();
            if (!(Validators.validate(one)) || !(Validators.validate(two))) {
                view.setRx("Invalid input");
            }
            HashMap<Integer, Double> p = Validators.parse_a_string(one);
            HashMap<Integer, Double> q = Validators.parse_a_string(two);
            Polynomial x = new Polynomial();
            Polynomial y = new Polynomial();
            x.setPolinom(p);
            y.setPolinom(q);
            Polynomial r = Operations.multiplication(x, y);
            String res = Validators.parse_a_polinom((HashMap<Integer, Double>) r.getPolinom());
            view.setRx(res);
        }
    }

    private class DivButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String one = view.getPx();
            String two = view.getQx();
            if (!(Validators.validate(one)) || !(Validators.validate(two))) {
                view.setRx("Invalid input");
            }
            HashMap<Integer, Double> p = Validators.parse_a_string(one);
            HashMap<Integer, Double> q = Validators.parse_a_string(two);
            Polynomial x = new Polynomial();
            Polynomial y = new Polynomial();
            x.setPolinom(p);
            y.setPolinom(q);
            Polynomial d = null;
            try {
                d = Operations.division(x, y);
            } catch (ArithmeticException e1) {
                view.setRx("Division cannot be performed");
            }
            String res = Validators.parse_a_polinom((HashMap<Integer, Double>) d.getPolinom());
            view.setRx(res);
            String rem = Validators.parse_a_polinom((HashMap<Integer, Double>) x.getPolinom());
            view.setRemainder(rem);
            view.reveal(true);

        }
    }

    private class DerButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String one = view.getPx();
            if (!(Validators.validate(one))) {
                view.setRx("Invalid input");
            }
            HashMap<Integer, Double> p = Validators.parse_a_string(one);
            HashMap<Integer, Double> list = new HashMap<>();
            Polynomial x = new Polynomial();
            x.setPolinom(p);
            Polynomial r = Operations.derivative(x);
            for (Map.Entry<Integer, Double> a : r.getPolinom().entrySet())
                list.put(a.getKey(), a.getValue());
            String res = Validators.parse_a_polinom(list);
            view.setRx(res);
        }
    }

    private class IngButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String one = view.getPx();
            if (!(Validators.validate(one))) {
                view.setRx("Invalid input");
            }
            HashMap<Integer, Double> p = Validators.parse_a_string(one);
            HashMap<Integer, Double> list = new HashMap<>();
            Polynomial x = new Polynomial();
            x.setPolinom(p);
            Polynomial r = Operations.integration(x);
            for (Map.Entry<Integer, Double> a : r.getPolinom().entrySet())
                list.put(a.getKey(), a.getValue());
            String res = Validators.parse_a_polinom(list);
            view.setRx(res);
        }
    }

}