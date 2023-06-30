package Mostrar;

import Pojo.Empleado;
import Pojo.Persona;
import Registro.Usuario;
import Ventanas.VentanaUsuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Mostrar extends JFrame {
        private JPanel panel1;
        private JList<Empleado> list1;
        private JList<Persona> list2;
        private JButton postularseButton;
        private JButton regresarButton;
        private JButton mostrarButton;
        private DefaultListModel<Empleado> elementosModel1;
        private DefaultListModel<Persona> elementosModel2;

        public Mostrar() {
            initPanel();
            setupFrame();
            showList();
        }

        private void initPanel() {
            panel1 = new JPanel();
            list1 = new JList<>();
            list2 = new JList<>();
            postularseButton = new JButton("Postularse");
            regresarButton = new JButton("Regresar");
            mostrarButton = new JButton("Mostrar");
            elementosModel1 = new DefaultListModel<>();
            elementosModel2 = new DefaultListModel<>();
            regresarButton.addActionListener(e -> {
                this.setVisible(false);
                new VentanaUsuario().setVisible(true);
            });
        }

        private void setupFrame() {
            setTitle("Mostrar.Mostrar usuarios");
            setLayout(new FlowLayout());
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setResizable(false);
            setSize(800, 600);

            panel1.setLayout(new BorderLayout());

            JPanel listPanel = new JPanel();
            listPanel.setLayout(new GridLayout(2, 1));
            listPanel.setPreferredSize(new Dimension(600,400));
            listPanel.add(new JScrollPane(list1));
            listPanel.add(new JScrollPane(list2));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout());
            buttonPanel.add(mostrarButton);
            buttonPanel.add(postularseButton);
            buttonPanel.add(regresarButton);

            panel1.add(listPanel, BorderLayout.CENTER);
            panel1.add(buttonPanel, BorderLayout.SOUTH);

            add(panel1);
        }

    private void showList() {
        mostrarButton.addActionListener(e -> {
            elementosModel1.clear();
            elementosModel2.clear();

            ArrayList<Empleado> empleados = Usuario.getEmpleados();
            ArrayList<Persona> personas = Usuario.getPersonas();

            if (!empleados.isEmpty()) {
                for (Empleado empleado : empleados) {
                    elementosModel1.addElement(empleado);
                }
            }

            if (!personas.isEmpty()) {
                for (Persona persona : personas) {
                    elementosModel2.addElement(persona);
                }
            }

            list1.setModel(elementosModel1);
            list2.setModel(elementosModel2);
        });
    }

}



