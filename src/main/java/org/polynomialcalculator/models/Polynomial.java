package org.polynomialcalculator.models;

import java.util.HashMap;
import java.util.Map;

public class Polynomial {
    private Map<Integer, Double> polinom = new HashMap<Integer, Double>();

    public Polynomial(Map<Integer, Double> polinom) {
        this.polinom = polinom;
    }

    public Polynomial() {

    }

    public Map<Integer, Double> getPolinom() {
        return polinom;
    }

    public void setPolinom(Map<Integer, Double> polinom) {
        this.polinom = polinom;
    }

    @Override
    public String toString() {
        return "Polynomial{" +
                "polinom=" + polinom +
                '}';
    }
}
