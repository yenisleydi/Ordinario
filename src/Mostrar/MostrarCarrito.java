package Mostrar;

import Pojo.CarritoCompras;
import Pojo.Producto;
import Registro.IngresarProducto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MostrarCarrito extends JFrame {

        private JList<CarritoCompras> jLista;
        private JButton btnMostrar, btnEliminar, btnActualizar, btnRegresar,btnPagar;
        private DefaultListModel<CarritoCompras> elementosModel;

        // CONTENEDORES
        private JPanel panelList, panelButton, panelContainer;

        public MostrarCarrito() {
            initControl();
            configFrame();
            setControl();
            configPanel();
            add(panelContainer);

            showList();
            eliminar();
            regresar();
            actualizar();
            pagar();

        }

    private void showList() {
        btnMostrar.addActionListener(e -> {
            elementosModel = new DefaultListModel<>();
            ArrayList<CarritoCompras> productosCarrito = MostrarProductos.getCarritoCompras();
            if (!productosCarrito.isEmpty()) {
                for (CarritoCompras itemCarrito : productosCarrito) {
                    elementosModel.addElement(itemCarrito);
                }
            }
            jLista.setModel(elementosModel);
        });
    }

    private void eliminar() {
        btnEliminar.addActionListener(e -> {
            int selectedIndex = jLista.getSelectedIndex();
            if (selectedIndex != -1) {
                int confirmResult = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este producto?",
                        "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                if (confirmResult == JOptionPane.YES_OPTION) {
                    CarritoCompras productoSeleccionado = elementosModel.getElementAt(selectedIndex);
                    elementosModel.removeElementAt(selectedIndex);
                    MostrarProductos.getCarritoCompras().remove(productoSeleccionado);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un producto para eliminar.");
            }
        });
    }
    private void actualizar() {
        btnActualizar.addActionListener(e -> {
            int selectedIndex = jLista.getSelectedIndex();
            if (selectedIndex != -1) {
                CarritoCompras productoSeleccionado = elementosModel.getElementAt(selectedIndex);

                // Mostrar un formulario para que el usuario ingrese la nueva cantidad
                JTextField cantidad = new JTextField(String.valueOf(productoSeleccionado.getCantidad()));

                JPanel panel = new JPanel(new GridLayout(0, 2));
                panel.add(new JLabel("Cantidad:"));
                panel.add(cantidad);

                int result = JOptionPane.showConfirmDialog(null, panel, "Modificar cantidad",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    int nuevaCantidad = Integer.parseInt(cantidad.getText());

                    // Actualizar la cantidad del producto seleccionado en el modelo
                    productoSeleccionado.setCantidad(nuevaCantidad);
                    elementosModel.set(selectedIndex, productoSeleccionado);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un producto para modificar la cantidad.");
            }
        });
    }
    private void pagar() {
        btnPagar.addActionListener(e -> {
            JTextField cuentaBanco = new JTextField();
            JPasswordField contraseña = new JPasswordField();
            JTextField cantidadPagar = new JTextField();

            JPanel panel = new JPanel(new GridLayout(0, 2));
            panel.add(new JLabel("Cuenta de banco:"));
            panel.add(cuentaBanco);
            panel.add(new JLabel("Contraseña:"));
            panel.add(contraseña);
            panel.add(new JLabel("Cantidad a pagar:"));
            panel.add(cantidadPagar);

            int result = JOptionPane.showConfirmDialog(null, panel, "Pagar",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                String cuentaBancoText = cuentaBanco.getText();
                String contraseñaText = new String(contraseña.getPassword());
                double cantidadPagarValue = Double.parseDouble(cantidadPagar.getText());

                // Validar la contraseña y la cuenta de banco
                if (validarCuentaBanco(cuentaBancoText, contraseñaText)) {
                    JOptionPane.showMessageDialog(null, "Pago realizado");
                } else {
                    JOptionPane.showMessageDialog(null, "La cuenta de banco o la contraseña son incorrectas.");
                }
            }
        });
    }

    private boolean validarCuentaBanco(String cuentaBanco, String contraseña) {
        String cuentaBancoCorrecta = "123456789";
        String contraseñaCorrecta = "cliente123";

        return cuentaBanco.equals(cuentaBancoCorrecta) && contraseña.equals(contraseñaCorrecta);
    }



    private void regresar() {
            btnRegresar.addActionListener(e -> {
                this.setVisible(false);
                new MostrarProductos().setVisible(true);
            });
        }

        private void initControl() {
            jLista = new JList<>();
            panelButton = new JPanel();
            panelList = new JPanel();
            panelContainer = new JPanel();
            btnMostrar = new JButton();
            btnEliminar = new JButton();
            btnActualizar = new JButton();
            btnRegresar = new JButton();
            btnPagar=new JButton();
        }

        private void configFrame() {
            setTitle("Productos");
            setLayout(new FlowLayout());
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            setSize(900, 500);
        }

        private void setControl() {
            btnMostrar.setText("Mostrar");
            btnEliminar.setText("Eliminar producto");
            btnActualizar.setText("Actualizar");
            btnRegresar.setText("Regresar");
            btnPagar.setText("Pagar");
        }

        private void configPanel() {
            panelList.setLayout(new GridLayout(1, 0));
            panelList.add(jLista);
            panelList.setPreferredSize(new Dimension(800, 300));

            panelButton.setLayout(new FlowLayout());
            panelButton.setPreferredSize(new Dimension(600, 70));
            panelButton.add(btnMostrar);
            panelButton.add(btnEliminar);
            panelButton.add(btnActualizar);
            panelButton.add(btnRegresar);
            panelButton.add(btnPagar);

            panelContainer.setLayout(new GridLayout(2, 0));
            panelContainer.add(panelList);
            panelContainer.add(panelButton);
        }
    }


