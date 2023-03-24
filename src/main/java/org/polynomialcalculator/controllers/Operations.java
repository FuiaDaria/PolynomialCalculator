package org.polynomialcalculator.controllers;

import org.polynomialcalculator.models.Polynomial;

import java.util.HashMap;
import java.util.Map;

public class Operations {

    public static int max_degree(Polynomial x) {
        int max = -1;
        for (Map.Entry<Integer, Double> a : x.getPolinom().entrySet()) {
            if (a.getKey() > max && a.getValue() != 0)
                max = a.getKey();
        }
        return max;
    }

    public static Polynomial addition(Polynomial x, Polynomial y) {
        Polynomial res = new Polynomial();
        Map<Integer, Double> aux = new HashMap<>();
        aux = y.getPolinom();
        for (Map.Entry<Integer, Double> a : x.getPolinom().entrySet()) {
            aux.put(a.getKey(), a.getValue() + aux.getOrDefault(a.getKey(), 0.0));
        }
        res.setPolinom(aux);
        return res;
    }

    public static Polynomial subtraction(Polynomial x, Polynomial y) throws ArithmeticException{
        Polynomial res = new Polynomial();
        Map<Integer, Double> aux = new HashMap<>();
        aux = x.getPolinom();
        if(x.equals(y)){
            throw new ArithmeticException();
        }
        for (Map.Entry<Integer, Double> a : y.getPolinom().entrySet()) {
            if(x.getPolinom().getOrDefault(a.getKey(),0.0) - a.getValue() == 0.0){
                aux.remove(a.getKey());
            }else {
                aux.put(a.getKey(), x.getPolinom().getOrDefault(a.getKey(), 0.0) - a.getValue());
            }
        }
        res.setPolinom(aux);
        return res;
    }

    public static Polynomial multiplication(Polynomial x, Polynomial y) {
        Polynomial result = new Polynomial();
        Map<Integer, Double> aux = new HashMap<>();
        for (Map.Entry<Integer, Double> a : x.getPolinom().entrySet())
            for (Map.Entry<Integer, Double> b : y.getPolinom().entrySet()) {
                aux.put(a.getKey() + b.getKey(), a.getValue() * b.getValue() + aux.getOrDefault(a.getKey() + b.getKey(), 0.0));
            }
        result.setPolinom(aux);
        return result;
    }

    public static Polynomial division(Polynomial x, Polynomial y) throws ArithmeticException{
        if(max_degree(x) < max_degree(y)){
            throw new ArithmeticException();
        }
        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial();
        Polynomial divident = new Polynomial();
        divident = x;
        int coeff = max_degree(divident);
        while (coeff >= max_degree(y)) {
            double res = divident.getPolinom().getOrDefault(coeff, 0.0) / y.getPolinom().getOrDefault(max_degree(y), 0.0);
            quotient.getPolinom().put(coeff - max_degree(y), res);
            Polynomial aux1 = new Polynomial();
            aux1.getPolinom().put(coeff - max_degree(y), res);
            remainder = subtraction(divident, multiplication(aux1, y));
            divident = remainder;
            coeff = max_degree(divident);
        }

        return quotient;
    }

    public static Polynomial derivative(Polynomial x) {
        Polynomial result = new Polynomial();
        Map<Integer, Double> aux = new HashMap<>();
        double degree = max_degree(x);
        for (Map.Entry<Integer, Double> a : x.getPolinom().entrySet()) {
            if (a.getKey() == 0) {
                aux.remove(0);
            } else {
                aux.put(a.getKey() - 1, a.getValue() * a.getKey());
            }
        }
        result.setPolinom(aux);
        return result;
    }

    public static Polynomial integration(Polynomial x) {
        Polynomial result = new Polynomial();
        Map<Integer, Double> aux = new HashMap<>();
        for (Map.Entry<Integer, Double> a : x.getPolinom().entrySet()) {
            aux.put(a.getKey() + 1, a.getValue() / (a.getKey() + 1));
        }
        aux.remove(0);
        result.setPolinom(aux);
        return result;
    }


}
