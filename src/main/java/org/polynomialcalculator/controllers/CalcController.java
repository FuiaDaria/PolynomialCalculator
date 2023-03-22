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
            if (!(Calculate.validate(one)) || !(Calculate.validate(two))) {
                view.setRx("Invalid input");
            }
            HashMap<Integer, Double> p = Calculate.parse_a_string(one);
            HashMap<Integer, Double> q = Calculate.parse_a_string(two);
            HashMap<Integer, Double> list = new HashMap<>();
            Polynomial x = new Polynomial();
            Polynomial y = new Polynomial();
            x.setPolinom(p);
            y.setPolinom(q);
            Polynomial r = Calculate.addition(x, y);
            for (Map.Entry<Integer, Double> a : r.getPolinom().entrySet())
                list.put(a.getKey(), a.getValue());
            String res = Calculate.parse_a_polinom(list);
            view.setRx(res);
        }
    }

    private class SubButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String one = view.getPx();
            String two = view.getQx();
            if (!(Calculate.validate(one)) || !(Calculate.validate(two))) {
                view.setRx("Invalid input");
            }
            HashMap<Integer, Double> p = Calculate.parse_a_string(one);
            HashMap<Integer, Double> q = Calculate.parse_a_string(two);
            HashMap<Integer, Double> list = new HashMap<>();
            Polynomial x = new Polynomial();
            Polynomial y = new Polynomial();
            x.setPolinom(p);
            y.setPolinom(q);
            if (x.equals(y)) {
                view.setRx("nothing");
            }
            Polynomial r = Calculate.subtraction(x, y);
            for (Map.Entry<Integer, Double> a : r.getPolinom().entrySet())
                list.put(a.getKey(), a.getValue());
            String res = Calculate.parse_a_polinom(list);
            view.setRx(res);
        }
    }

    private class MulButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String one = view.getPx();
            String two = view.getQx();
            if (!(Calculate.validate(one)) || !(Calculate.validate(two))) {
                view.setRx("Invalid input");
            }
            HashMap<Integer, Double> p = Calculate.parse_a_string(one);
            HashMap<Integer, Double> q = Calculate.parse_a_string(two);
            HashMap<Integer, Double> list = new HashMap<>();
            Polynomial x = new Polynomial();
            Polynomial y = new Polynomial();
            x.setPolinom(p);
            y.setPolinom(q);
            Polynomial r = Calculate.multiplication(x, y);
            for (Map.Entry<Integer, Double> a : r.getPolinom().entrySet())
                list.put(a.getKey(), a.getValue());
            String res = Calculate.parse_a_polinom(list);
            view.setRx(res);
        }
    }

    private class DivButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String one = view.getPx();
            String two = view.getQx();
            if (!(Calculate.validate(one)) || !(Calculate.validate(two))) {
                view.setRx("Invalid input");
            }
            HashMap<Integer, Double> p = Calculate.parse_a_string(one);
            HashMap<Integer, Double> q = Calculate.parse_a_string(two);
            HashMap<Integer, Double> list = new HashMap<>();
            HashMap<Integer, Double> val = new HashMap<>();
            Polynomial x = new Polynomial();
            Polynomial y = new Polynomial();
            x.setPolinom(p);
            y.setPolinom(q);
            if (Calculate.max_degree(x) < Calculate.max_degree(y)) {
                view.setRx("Division cannot be performed");
            }
            Polynomial d = Calculate.division(x, y);
            for (Map.Entry<Integer, Double> a : d.getPolinom().entrySet())
                list.put(a.getKey(), a.getValue());
            String res = Calculate.parse_a_polinom(list);
            view.setRx(res);
            Polynomial c = Calculate.multiplication(d, y);
            Polynomial r = Calculate.subtraction(x, c);
            for (Map.Entry<Integer, Double> b : r.getPolinom().entrySet())
                val.put(b.getKey(), b.getValue());
            String rem = Calculate.parse_a_polinom(val);
            view.setRemainder(rem);
            view.reveal(true);

        }
    }

    private class DerButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String one = view.getPx();
            if (!(Calculate.validate(one))) {
                view.setRx("Invalid input");
            }
            HashMap<Integer, Double> p = Calculate.parse_a_string(one);
            HashMap<Integer, Double> list = new HashMap<>();
            Polynomial x = new Polynomial();
            x.setPolinom(p);
            Polynomial r = Calculate.derivative(x);
            for (Map.Entry<Integer, Double> a : r.getPolinom().entrySet())
                list.put(a.getKey(), a.getValue());
            String res = Calculate.parse_a_polinom(list);
            view.setRx(res);
        }
    }

    private class IngButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String one = view.getPx();
            if (!(Calculate.validate(one))) {
                view.setRx("Invalid input");
            }
            HashMap<Integer, Double> p = Calculate.parse_a_string(one);
            HashMap<Integer, Double> list = new HashMap<>();
            Polynomial x = new Polynomial();
            x.setPolinom(p);
            Polynomial r = Calculate.integration(x);
            for (Map.Entry<Integer, Double> a : r.getPolinom().entrySet())
                list.put(a.getKey(), a.getValue());
            String res = Calculate.parse_a_polinom(list);
            view.setRx(res);
        }
    }

}