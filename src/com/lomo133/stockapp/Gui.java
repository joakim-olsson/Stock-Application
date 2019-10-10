package com.lomo133.stockapp;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.io.FileNotFoundException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Gui {

    private JFrame frame;
    private JTextField txtCorporation;
    private StockPrice sym;
    /**
     * Create the application.
     */
    public Gui() throws FileNotFoundException {
        initialize();
        frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        JLabel lblHigh = new JLabel("High: ");
        lblHigh.setBounds(33, 56, 225, 15);
        frame.getContentPane().add(lblHigh);

        JLabel lblLow = new JLabel("Low:");
        lblLow.setBounds(33, 83, 225, 15);
        frame.getContentPane().add(lblLow);

        JLabel lblVolume = new JLabel("Volume:");
        lblVolume.setBounds(33, 110, 225, 15);
        frame.getContentPane().add(lblVolume);

        JLabel lblCorporationsName = new JLabel("Corporations name");
        lblCorporationsName.setFont(new Font("Dialog", Font.BOLD, 20));
        lblCorporationsName.setBounds(33, 12, 225, 38);
        frame.getContentPane().add(lblCorporationsName);

        JLabel lblDate = new JLabel("Date:");
        lblDate.setBounds(33, 137, 225, 15);
        frame.getContentPane().add(lblDate);

        JButton btnRandomize = new JButton("Randomize");
        btnRandomize.setBounds(227, 227, 112, 23);
        frame.getContentPane().add(btnRandomize);
        btnRandomize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sym = new StockPrice();
                lblCorporationsName.setText(sym.getSymbol().toUpperCase());
                lblHigh.setText("High: " + sym.getHigh() + "$");
                lblLow.setText("Low " + sym.getLow() + "$");
                lblVolume.setText("Volume: " + sym.getVolume());
                lblDate.setText("Date: " + sym.getDate());
            }
        });

        txtCorporation = new JTextField();
        txtCorporation.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    sym = new StockPrice(txtCorporation.getText());
                    lblCorporationsName.setText(sym.getSymbol().toUpperCase());
                    lblHigh.setText("High: " + sym.getHigh() + "$");
                    lblLow.setText("Low " + sym.getLow() + "$");
                    lblVolume.setText("Volume: " + sym.getVolume());
                    lblDate.setText("Date: " + sym.getDate());
                }
            }
        });
        txtCorporation.setText("Corporation symbol");
        txtCorporation.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                txtCorporation.setText("");
                txtCorporation.removeKeyListener(this);
            }
        });
        txtCorporation.setBounds(84, 228, 131, 20);
        frame.getContentPane().add(txtCorporation);
        txtCorporation.setColumns(10);
    }
}
