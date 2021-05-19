package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class casaDeCambios {
    public JPanel pnlMain;
    private JButton btnCompra;
    private JButton btnVenta;
    private JComboBox cmbCambios;
    private JLabel lblValorDeCambio;
    private JLabel lblTotal;
    private JTextField txtValorCambio;
    private JLabel lblValorIngresado;
    private JButton btnEnviar;
    private JLabel lblTotalCapital;
    private JTextField txtCapitalDolar;
    private JTextField txtCapitalEuro;
    private JTextField txtCapitalLibra;
    private JTextField txtCapitalPesoColombiano;
    private JButton btnAceptar;
    private JLabel lblTotalDolar;
    private JLabel lblTotalEuro;
    private JLabel lblTotaLibra;
    private JLabel lblTotalPeso;

    private String opcion;
    private double operacion;
    public boolean x = false;

    private double capitalDolares;
    private double capitalEuros;
    private double capitalLibraEsterlina;
    private double capitalPesoColombiano;
    private double validar;

    public casaDeCambios() {

        lblValorDeCambio.setText("El valor para comprar 1 Dólar es de: $3.625");

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                capitalDolares = Integer.parseInt(txtCapitalDolar.getText());
                capitalEuros = Integer.parseInt(txtCapitalEuro.getText());
                capitalLibraEsterlina = Integer.parseInt(txtCapitalLibra.getText());
                capitalPesoColombiano = Integer.parseInt(txtCapitalPesoColombiano.getText());
            }
        });
        btnCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = true;
                opcion = (String) cmbCambios.getSelectedItem();
                switch (opcion) {
                    case "Dolar":
                        txtValorCambio.setText(txtValorCambio.getText());
                        lblValorIngresado.setText("¿Cuántos dólares desea comprar?");
                        break;
                    case "Euro":
                        txtValorCambio.setText(txtValorCambio.getText());
                        lblValorIngresado.setText("¿Cuántos euros desea comprar?");
                        break;
                    case "Libra Esterlina":
                        txtValorCambio.setText(txtValorCambio.getText());
                        lblValorIngresado.setText("¿Cuántas libras esterlinas desea comprar?");
                        break;
                }
            }
        });
        btnVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = false;
                opcion = (String) cmbCambios.getSelectedItem();
                switch (opcion) {
                    case "Dolar":
                        txtValorCambio.setText(txtValorCambio.getText());
                        lblValorIngresado.setText("¿Cuántos dólares desea vender?");
                        break;
                    case "Euro":
                        txtValorCambio.setText(txtValorCambio.getText());
                        lblValorIngresado.setText("¿Cuántos euros desea vender?");
                        break;
                    case "Libra Esterlina":
                        txtValorCambio.setText(txtValorCambio.getText());
                        lblValorIngresado.setText("¿Cuántas libras esterlinas desea vender?");
                        break;

                }
            }
        });
        cmbCambios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcion = (String) cmbCambios.getSelectedItem();
                switch (opcion) {
                    case "Dolar":
                        lblValorDeCambio.setText("El valor para comprar 1 Dólar es de: $3.625");
                        break;
                    case "Euro":
                        lblValorDeCambio.setText("El valor para comprar Euro es de: $4.061");
                        break;
                    case "Libra Esterlina":
                        lblValorDeCambio.setText("El valor para comprar 1na Libra Esterlina es de: 5.201");
                        break;
                }
            }
        });
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcion = (String) cmbCambios.getSelectedItem();
                switch (opcion) {
                    case "Dolar":
                        operacion = 0;
                        //COMPRAR
                        if (x) {
                            validar = capitalPesoColombiano - Double.parseDouble(txtValorCambio.getText()) * 3625;
                            if (validar >= 0) {
                                capitalDolares += Integer.parseInt(txtValorCambio.getText());
                                operacion = Integer.parseInt(txtValorCambio.getText()) * 3625;
                                capitalPesoColombiano -= operacion;
                                lblTotal.setText("Has comprado: " + txtValorCambio.getText()
                                        + " dólares, lo que equivale a: $" + operacion + " pesos");
                                lblTotalCapital.setText("Dolares: $" + capitalDolares);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "No hay suficientes pesos");
                            }
                            //VENDER
                        } else {
                            validar = capitalDolares - Double.parseDouble(txtValorCambio.getText());
                            if (validar >= 0) {
                                capitalDolares -= Double.parseDouble(txtValorCambio.getText());
                                operacion = Double.parseDouble(txtValorCambio.getText()) * 3736;
                                capitalPesoColombiano += operacion;
                                lblTotal.setText("Has vendido: " + txtValorCambio.getText()
                                        + " dólares, lo que equivale a: $" + operacion + " pesos");
                                lblTotalCapital.setText("Dolares: $" + capitalDolares);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "No hay suficientes dolares");
                            }
                        }
                        break;
                    case "Euro":
                        operacion = 0;
                        if (x) {
                            validar = capitalPesoColombiano - Double.parseDouble(txtValorCambio.getText()) * 4061;
                            if (validar >= 0) {
                                capitalEuros += Integer.parseInt(txtValorCambio.getText());
                                operacion += Integer.parseInt(txtValorCambio.getText()) * 4061;
                                capitalPesoColombiano -= operacion;

                                lblTotal.setText("Has comprado: " + txtValorCambio.getText()
                                        + " euros, lo que equivale a: $" + operacion + " pesos");
                                lblTotalCapital.setText("Euros: $" + capitalEuros);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "No hay suficientes pesos");
                            }
                        } else {
                            validar = capitalEuros - Double.parseDouble(txtValorCambio.getText());
                            if (validar >= 0) {
                                capitalEuros -= Integer.parseInt(txtValorCambio.getText());
                                operacion += Integer.parseInt(txtValorCambio.getText()) * 4177;
                                capitalPesoColombiano += operacion;
                                lblTotal.setText("Has vendido: " + txtValorCambio.getText()
                                        + " euros, lo que equivale a: $" + operacion + " pesos");
                                lblTotalCapital.setText("Euros: $" + capitalEuros);
                                validar = capitalDolares - Double.parseDouble(txtValorCambio.getText());

                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "No hay suficientes Euros");
                            }
                        }
                        break;
                    case "Libra Esterlina":
                        operacion = 0;
                        if (x) {
                            validar = capitalPesoColombiano - Double.parseDouble(txtValorCambio.getText()) * 5201;
                            if (validar >= 0) {
                                capitalLibraEsterlina += Integer.parseInt(txtValorCambio.getText());
                                operacion += Integer.parseInt(txtValorCambio.getText()) * 5201;
                                capitalPesoColombiano -= operacion;
                                lblTotal.setText("Has comprado: " + txtValorCambio.getText() + " libras esterinas, "
                                        + "lo que equivale a: $" + operacion + " pesos");
                                lblTotalCapital.setText("Libra Esterlina: $" + capitalLibraEsterlina);
                            }else {
                                JOptionPane.showMessageDialog(null,
                                        "No hay suficientes pesos");
                            }
                        } else {
                            validar = capitalLibraEsterlina - Double.parseDouble(txtValorCambio.getText());
                            if (validar >= 0) {
                                capitalLibraEsterlina -= Integer.parseInt(txtValorCambio.getText());
                                operacion += Integer.parseInt(txtValorCambio.getText()) * 5209;
                                capitalPesoColombiano += operacion;
                                lblTotal.setText("Has vendido: " + txtValorCambio.getText() + " libras esterinas," +
                                        " lo que equivale a: $" + operacion + " pesos");
                                lblTotalCapital.setText("Libra Esterlina: $" + capitalLibraEsterlina);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "No hay suficientes pesos");
                            }
                        }
                        break;

                }
                lblTotalDolar.setText(capitalDolares + "");
                lblTotalEuro.setText(capitalEuros + "");
                lblTotaLibra.setText(capitalLibraEsterlina + "");
                lblTotalPeso.setText(capitalPesoColombiano + "");
            }
        });

    }
}
