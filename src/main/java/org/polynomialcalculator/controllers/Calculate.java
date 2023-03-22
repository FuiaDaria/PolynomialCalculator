package org.polynomialcalculator.controllers;

import org.polynomialcalculator.models.Polynomial;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Calculate {

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

    public static Polynomial subtraction(Polynomial x, Polynomial y) {
        Polynomial res = new Polynomial();
        Map<Integer, Double> aux = new HashMap<>();
        aux = x.getPolinom();
        for (Map.Entry<Integer, Double> a : y.getPolinom().entrySet()) {
            aux.put(a.getKey(), x.getPolinom().getOrDefault(a.getKey(), 0.0) - a.getValue());
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

    public static Polynomial division(Polynomial x, Polynomial y) {
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

    public static boolean validate(String poli) {
        Pattern pattern = Pattern.compile("([+-]?((?:\\sx\\^\\d+)|(?:\\d+\\sx\\^\\d+)|(?:\\d+\\sx)|(?:\\d+)|(?:x)))");
        Matcher match = pattern.matcher(poli);
        return match.matches();
    }

    public static HashMap<Integer, Double> parse_a_string(String input) {
        HashMap<Integer, Double> map = new HashMap<>();
        input = input.replaceAll("-", "+-");
        String[] terms = input.split("\\+");
        for (String term : terms) {
            term = term.trim();
            if (term.isEmpty()) {
                continue;
            }

            double coeff = 1.0;
            int degree = 0;

            String[] parts = term.split("x\\^");
            if (parts.length == 2) {
                if (!parts[0].isEmpty()) {
                    coeff = Double.parseDouble(parts[0].trim());
                }
                degree = Integer.parseInt(parts[1].trim());
            } else if (parts.length == 1) {
                if (term.endsWith("x")) {
                    String[] aux = term.split("x");
                    coeff = Double.parseDouble(aux[0].trim());
                    degree = 1;
                }
                if (!parts[0].isEmpty()) {
                    coeff = Double.parseDouble(parts[0].trim());
                }
            } else {
                throw new IllegalArgumentException("Invalid term: " + term);
            }

            double prevCoeff = map.getOrDefault(degree, 0.0);

            map.put(degree, coeff + prevCoeff);
        }

        return map;
    }

    public static String parse_a_polinom(HashMap<Integer, Double> polinom) {
        StringBuilder s = new StringBuilder();
        boolean first = true;

        for (Map.Entry<Integer, Double> a : polinom.entrySet()) {
            double coeff = a.getValue();
            int degree = a.getKey();

            if (coeff == 0) {
                continue;
                //skip if coeff equals 0 because it doesn't count for us
            }
            if (!first) {
                if (coeff < 0) {
                    s.append("-");
                    coeff = (-1) * coeff;
                } else {
                    s.append("+");
                }
            } else {
                first = false;
                if (coeff < 0) {
                    s.append("-");
                    coeff = (-1) * coeff;
                }
            }
            if (coeff == 1 && degree != 0) {
                s.append("x");
            } else {
                s.append(coeff);
                if (degree != 0) {
                    s.append("x");
                }
            }
            if (degree > 1) {
                s.append("^").append(degree);
            }
        }
        return s.toString();
    }

}
