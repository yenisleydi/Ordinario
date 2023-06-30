package Registro;

import Mostrar.MostrarProducto;
import Pojo.Producto;
import Ventanas.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.*;

public class IngresarProducto extends JFrame {
    private static ArrayList<Producto> productos = new ArrayList<>();
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton regresarButton;
    private JButton guardarButton;
    private JButton mostrarButton;

    public IngresarProducto() {
        setupFrame();
        init();
    }

    private void setupFrame() {
        setTitle("Ingresar usuarios");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(390, 350);
        add(panel1);
    }

    public void init() {
        regresarButton.addActionListener(e -> {
            this.setVisible(false);
            new Login().setVisible(true);
        });
        mostrarButton.addActionListener(e -> {
            this.setVisible(false);
            new MostrarProducto().setVisible(true);
        });
        guardarButton.addActionListener(new EventClick());
    }

    public class EventClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            String opcion = boton.getText();

            if (opcion.equals("Guardar")) {
                String nombreProducto = textField1.getText();
                String marca = textField2.getText();
                String cantidadExistenciaString = textField3.getText().trim();
                String descripcion = textField4.getText();
                String precioString = textField5.getText();
                String departamento = textField6.getText();

                // Validar que nombreProducto no contenga números
                if (!validarTextoSinNumeros(nombreProducto)) {
                    JOptionPane.showMessageDialog(null, "El nombre del producto no debe contener números.");
                    return;
                }

                // Validar que marca no contenga números
                if (!validarTextoSinNumeros(marca)) {
                    JOptionPane.showMessageDialog(null, "La marca no debe contener números.");
                    return;
                }

                // Validar que cantidadExistenciaString sea un número
                if (!validarNumeroEntero(cantidadExistenciaString)) {
                    JOptionPane.showMessageDialog(null, "La cantidad de existencia debe ser un número entero.");
                    return;
                }
                int cantidadExistencia = Integer.parseInt(cantidadExistenciaString);

                // Validar que precioString sea un número decimal
                if (!validarNumeroDecimal(precioString)) {
                    JOptionPane.showMessageDialog(null, "El precio debe ser un número decimal.");
                    return;
                }
                double precio = Double.parseDouble(precioString);

                if (!validarTextoSinNumeros(departamento)) {
                    JOptionPane.showMessageDialog(null, "El departamento no debe contener números.");
                    return;
                }


                productos.add(new Producto(nombreProducto, marca, cantidadExistencia, descripcion, precio, departamento));

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");
            }
        }

        private boolean validarTextoSinNumeros(String texto) {
            // Expresión regular para validar que el texto no contenga números
            String patron = "^[^0-9]+$";
            return Pattern.matches(patron, texto);
        }

        private boolean validarNumeroEntero(String numero) {
            // Expresión regular para validar que el número sea un entero
            String patron = "^[0-9]+$";
            return Pattern.matches(patron, numero);
        }

        private boolean validarNumeroDecimal(String numero) {
            // Expresión regular para validar que el número sea decimal
            String patron = "^[0-9]+(\\.[0-9]+)?$";
            return Pattern.matches(patron, numero);
        }
    }

    public static ArrayList<Producto> getElemento() {
        return productos;
    }
}
