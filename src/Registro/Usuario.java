package Registro;

import Pojo.Empleado;
import Pojo.Persona;
import Principal.Principal;
import Ventanas.VentanaUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Usuario extends JFrame {
    private static ArrayList<Empleado> empleados = new ArrayList<>();
    private static ArrayList<Persona> personas = new ArrayList<>();
    private JPanel panel1;
    private JRadioButton administradorRepartidorRadioButton;
    private JRadioButton clienteRadioButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JButton regresarButton;
    private JButton guardarButton;
    private ButtonGroup tipoUsuarioGroup;

    public Usuario() {
        init();
        setupFrame();
    }

    private void setupFrame() {
        setTitle("Ingresar usuarios");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(390, 450);
        add(panel1);
    }

    public void init() {
        tipoUsuarioGroup=new ButtonGroup();
        tipoUsuarioGroup.add(administradorRepartidorRadioButton);
        tipoUsuarioGroup.add(clienteRadioButton);
        regresarButton.addActionListener(e -> {
            this.setVisible(false);
            new VentanaUsuario().setVisible(true);
        });
        guardarButton.addActionListener(new EventClick());
        clienteRadioButton.addActionListener(e -> {
            textField8.setEnabled(false);
            textField9.setEnabled(false);
            textField10.setEnabled(false);
        });
        administradorRepartidorRadioButton.addActionListener(e -> {
            textField8.setEnabled(true);
            textField9.setEnabled(true);
            textField10.setEnabled(true);
        });
    }

    public class EventClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            String opcion = boton.getText();

            if (opcion.equals("Guardar")) {
                String nombre = textField1.getText();
                String apellidoP = textField2.getText();
                String apellidoM = textField3.getText();
                String edadString = textField4.getText();
                String direccion = textField5.getText();
                String telefonoString = textField6.getText();
                String ine = textField7.getText();
                String numEmpleadoString = textField8.getText();
                String cargo = textField9.getText();
                String diaDescanso = textField10.getText();

                // Validar que nombre no contenga números
                if (!validarTextoSinNumeros(nombre)) {
                    JOptionPane.showMessageDialog(null, "El nombre no debe contener números.");
                    return;
                }

                // Validar que apellidoP no contenga números
                if (!validarTextoSinNumeros(apellidoP)) {
                    JOptionPane.showMessageDialog(null, "El apellido paterno no debe contener números.");
                    return;
                }

                // Validar que apellidoM no contenga números
                if (!validarTextoSinNumeros(apellidoM)) {
                    JOptionPane.showMessageDialog(null, "El apellido materno no debe contener números.");
                    return;
                }

                // Validar que direccion no contenga números
                if (!validarTextoSinNumeros(diaDescanso)) {
                    JOptionPane.showMessageDialog(null, "El dia de descanso no debe contener números.");
                    return;
                }
                if (!validarTextoSinNumeros(cargo)) {
                    JOptionPane.showMessageDialog(null, "El cargo  no debe contener números.");
                    return;
                }

                // Validar que edadString sea un número entero
                if (!validarNumeroEntero(edadString)) {
                    JOptionPane.showMessageDialog(null, "La edad debe ser un número entero.");
                    return;
                }
                int edad = Integer.parseInt(edadString);

                // Validar que telefonoString sea un número entero
                if (!validarNumeroEntero(telefonoString)) {
                    JOptionPane.showMessageDialog(null, "El teléfono debe ser un número entero.");
                    return;
                }
                int telefono = Integer.parseInt(telefonoString);

                if (administradorRepartidorRadioButton.isSelected()) {
                    // Validar que numEmpleadoString sea un número entero
                    if (!validarNumeroEntero(numEmpleadoString)) {
                        JOptionPane.showMessageDialog(null, "El número de empleado debe ser un número entero.");
                        return;
                    }
                    int numEmpleado = Integer.parseInt(numEmpleadoString);

                    Empleado empleado = new Empleado(nombre, apellidoP, apellidoM, edad, direccion, telefono, ine, numEmpleado, cargo, diaDescanso);
                    empleados.add(empleado);
                } else if (clienteRadioButton.isSelected()) {
                    Persona persona = new Persona(nombre, apellidoP, apellidoM, edad, direccion, telefono, ine);
                    personas.add(persona);
                }

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");
                textField7.setText("");
                textField8.setText("");
                textField9.setText("");
                textField10.setText("");
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


    public static ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public static ArrayList<Persona> getPersonas() {
        return personas;
    }
}
