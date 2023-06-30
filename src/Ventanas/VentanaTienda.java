package Ventanas;

import Principal.Principal;

import javax.swing.*;
import java.awt.*;

public class VentanaTienda extends JFrame{
    private JPanel panel1;
    private JButton administradorButton;
    private JButton repartidorButton;
    private JButton regresarButton;
    public VentanaTienda(){
        setupFrame();
        init();
    }
    private void setupFrame() {
        setTitle("Ingresar usuarios");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(300, 230);
        add(panel1);
    }
    public void init(){
        regresarButton.addActionListener(e -> {
            this.setVisible(false);
            new Principal().setVisible(true);
        });
        administradorButton.addActionListener(e -> {
            this.setVisible(false);
            new Login().setVisible(true);
        });
        repartidorButton.addActionListener(e -> {
            this.setVisible(false);
            new LoginRepartidor().setVisible(true);
        });
    }
}
