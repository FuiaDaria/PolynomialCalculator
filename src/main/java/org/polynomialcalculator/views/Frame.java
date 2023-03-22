package org.polynomialcalculator.views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Frame extends JFrame {
    protected JButton add;
    protected JButton sub;
    protected JButton mul;
    protected JButton div;
    protected JButton der;
    protected JButton ing;
    protected JTextField Px;
    protected JTextField Qx;
    protected JTextField Rx;
    protected JTextField remainder;

    public Frame() {
        this.setBounds(100, 100, 643, 432);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.pink);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        JLabel titleLabel = new JLabel("POLYNOMIAL CALCULATOR");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        titleLabel.setBounds(200, 30, 400, 40);
        this.getContentPane().add(titleLabel);
        titleLabel.setVisible(true);
        JLabel firstLabel = new JLabel("Enter P(x):");
        firstLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        firstLabel.setBounds(100, 100, 100, 40);
        this.getContentPane().add(firstLabel);
        firstLabel.setVisible(true);
        JLabel secondLabel = new JLabel("Enter Q(x):");
        secondLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        secondLabel.setBounds(100, 130, 100, 40);
        this.getContentPane().add(secondLabel);
        secondLabel.setVisible(true);
        add = new JButton("ADDITION");
        add.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add.setBounds(100, 180, 160, 25);
        add.setBackground(Color.MAGENTA);
        this.getContentPane().add(add);
        add.setVisible(true);
        sub = new JButton("SUBTRACTION");
        sub.setFont(new Font("Tahoma", Font.PLAIN, 15));
        sub.setBounds(100, 215, 160, 25);
        sub.setBackground(Color.MAGENTA);
        this.getContentPane().add(sub);
        sub.setVisible(true);
        mul = new JButton("MULTIPLICATION");
        mul.setFont(new Font("Tahoma", Font.PLAIN, 15));
        mul.setBounds(100, 250, 160, 25);
        mul.setBackground(Color.MAGENTA);
        this.getContentPane().add(mul);
        mul.setVisible(true);
        div = new JButton("DIVISION");
        div.setFont(new Font("Tahoma", Font.PLAIN, 15));
        div.setBounds(380, 180, 140, 25);
        div.setBackground(Color.MAGENTA);
        this.getContentPane().add(div);
        div.setVisible(true);
        der = new JButton("DERIVATIVE");
        der.setFont(new Font("Tahoma", Font.PLAIN, 15));
        der.setBounds(380, 215, 140, 25);
        der.setBackground(Color.MAGENTA);
        this.getContentPane().add(der);
        der.setVisible(true);
        ing = new JButton("INTEGRATION");
        ing.setFont(new Font("Tahoma", Font.PLAIN, 15));
        ing.setBounds(380, 250, 140, 25);
        ing.setBackground(Color.MAGENTA);
        this.getContentPane().add(ing);
        ing.setVisible(true);
        JLabel resLabel = new JLabel("Result:");
        resLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        resLabel.setBounds(130, 300, 80, 40);
        this.getContentPane().add(resLabel);
        resLabel.setVisible(true);
        Px = new JTextField();
        Px.setBounds(200, 100, 275, 25);
        this.getContentPane().add(Px);
        Px.setColumns(20);
        Px.setVisible(true);
        Qx = new JTextField();
        Qx.setBounds(200, 130, 275, 25);
        this.getContentPane().add(Qx);
        Qx.setColumns(20);
        Rx = new JTextField();
        Rx.setBounds(200, 310, 275, 25);
        this.getContentPane().add(Rx);
        Rx.setColumns(2);
        remainder = new JTextField();
        remainder.setBounds(200, 350, 275, 25);
        this.getContentPane().add(remainder);
        remainder.setColumns(2);
        remainder.setVisible(false);

        this.setVisible(true);
    }

    public void addAddButtonActionListener(ActionListener a) {
        add.addActionListener(a);
    }

    public void addSubButtonActionListener(ActionListener a) {
        sub.addActionListener(a);
    }

    public void addMulButtonActionListener(ActionListener a) {
        mul.addActionListener(a);
    }

    public void addDivButtonActionListener(ActionListener a) {
        div.addActionListener(a);
    }

    public void addDerButtonActionListener(ActionListener a) {
        der.addActionListener(a);
    }

    public void addIngButtonActionListener(ActionListener a) {
        ing.addActionListener(a);
    }

    public String getPx() {
        return Px.getText();
    }

    public String getQx() {
        return Qx.getText();
    }

    public void setRx(String rx) {
        this.Rx.setText(rx);
    }

    public void setRemainder(String rem) {
        this.remainder.setText(rem);
    }

    public void reveal(boolean bool) {
        this.remainder.setVisible(bool);
    }

}

