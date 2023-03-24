package org.polynomialcalculator.controllers;
import org.polynomialcalculator.models.Polynomial;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Validators {
    public static boolean validate(String poli) {
        Pattern pattern = Pattern.compile("([-+]?((?:\\sx\\^\\d+)|(?:\\d+\\sx\\^\\d+)|(?:\\d+\\sx)|(?:\\d+)|(?:x)))");
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
