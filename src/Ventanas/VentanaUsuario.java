package Ventanas;

import Mostrar.Mostrar;
import Principal.Principal;
import Registro.Usuario;

import javax.swing.*;
import java.awt.*;

public class VentanaUsuario extends JFrame{
    private JPanel panel1;
    private JButton registrarButton;
    private JButton mostrarButton;
    private JButton regresarButton;
    public VentanaUsuario(){
        setupFrame();
        init();
    }
    private void setupFrame() {
        setTitle("Ventana usuario");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(300, 230);
        add(panel1);
    }
    public void init(){
        registrarButton.addActionListener(e -> {
            this.setVisible(false);
            new Usuario().setVisible(true);
        });
        mostrarButton.addActionListener(e -> {
            this.setVisible(false);
            new Mostrar().setVisible(true);
        });
        regresarButton.addActionListener(e -> {
            this.setVisible(false);
            new Principal().setVisible(true);
        });

    }

}
