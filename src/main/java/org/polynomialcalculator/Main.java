package org.polynomialcalculator;
import org.polynomialcalculator.controllers.CalcController;
import org.polynomialcalculator.views.Frame;

public class Main {
    public static void main(String[] args) {
        // replace - with +- and then split by +
        new CalcController(new Frame());
        /*String poli = "x^2 + 5x^1 + 6 ";
        String poli1 = "x^1 + 3";
        Polynomial one = new Polynomial();
        Polynomial two = new Polynomial();
        HashMap<Integer, Double> map = new HashMap<>();
        HashMap<Integer, Double> map1 = new HashMap<>();
        HashMap<Integer, Double> list = new HashMap<>();
        HashMap<Integer, Double> list1 = new HashMap<>();
        HashMap<Integer, Double> list2 = new HashMap<>();
        map = Calculate.parse_a_string(poli);
        map1 = Calculate.parse_a_string(poli1);
        one.setPolinom(map);
        two.setPolinom(map1);
        for(Map.Entry<Integer, Double> a : one.getPolinom().entrySet()) {
            System.out.println(a.getKey() + " " + a.getValue());
        }
        Polynomial res = Calculate.division(one,two);
        Polynomial rem = Calculate.multiplication(res, two);
        Polynomial w = Calculate.subtraction(one,rem);
        for(Map.Entry<Integer, Double> a : res.getPolinom().entrySet()) {
            list.put(a.getKey(),a.getValue());
        }
        for(Map.Entry<Integer, Double> b : rem.getPolinom().entrySet()) {
            list1.put(b.getKey(),b.getValue());
        }
        for(Map.Entry<Integer, Double> c : one.getPolinom().entrySet()) {
            list2.put(c.getKey(),c.getValue());
        }
        String s = Calculate.parse_a_polinom(list);
        String s1 = Calculate.parse_a_polinom(list1);
        String s2 = Calculate.parse_a_polinom(list2);
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);*/

    }
}