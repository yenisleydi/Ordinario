package Mostrar;

import Pojo.Producto;
import Registro.IngresarProducto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MostrarProducto extends JFrame {
    private JList<Producto> jLista;
    private JButton btnMostrar, btnEliminar, btnActualizar, btnRegresar;
    private DefaultListModel<Producto> elementosModel;

    // CONTENEDORES
    private JPanel panelList, panelButton, panelContainer;

    public MostrarProducto() {
        initControl();
        configFrame();
        setControl();
        configPanel();
        add(panelContainer);

        showList();
        eliminar();
        actualizar();
        regresar();
    }

    private void showList() {
        btnMostrar.addActionListener(e -> {
            elementosModel = new DefaultListModel<>();
            ArrayList<Producto> productos = IngresarProducto.getElemento();
            if (!productos.isEmpty()) {
                for (Producto producto : productos) {
                    elementosModel.addElement(producto);
                }
            }
            jLista.setModel(elementosModel);
        });
    }

    private void eliminar() {
        btnEliminar.addActionListener(e -> {
            int selectedIndex = jLista.getSelectedIndex();
            if (selectedIndex != -1) {
                Producto productoSeleccionado = elementosModel.getElementAt(selectedIndex);
                int confirmResult = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este producto?",
                        "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                if (confirmResult == JOptionPane.YES_OPTION) {
                    elementosModel.removeElementAt(selectedIndex);
                    ArrayList<Producto> productosOriginales = IngresarProducto.getElemento();
                    productosOriginales.remove(selectedIndex);
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
                Producto productoSeleccionado = elementosModel.getElementAt(selectedIndex);

                // Mostrar un formulario para que el usuario ingrese los nuevos datos
                JTextField nombreProducto = new JTextField(productoSeleccionado.getProducto());
                JTextField marca = new JTextField(productoSeleccionado.getMarca());
                JTextField cantidadExistencia = new JTextField(String.valueOf(productoSeleccionado.getCantidadExistencia()));
                JTextField descripcion = new JTextField(productoSeleccionado.getDescripcion());
                JTextField precio = new JTextField(String.valueOf(productoSeleccionado.getPrecio()));
                JTextField departamento = new JTextField(productoSeleccionado.getDepartamento());

                JPanel panel = new JPanel(new GridLayout(0, 2));
                panel.add(new JLabel("Nombre producto:"));
                panel.add(nombreProducto);
                panel.add(new JLabel("Marca:"));
                panel.add(marca);
                panel.add(new JLabel("Cantidad en existencia:"));
                panel.add(cantidadExistencia);
                panel.add(new JLabel("Descripcion:"));
                panel.add(descripcion);
                panel.add(new JLabel("Precio:"));
                panel.add(precio);
                panel.add(new JLabel("Departamento:"));
                panel.add(departamento);

                int result = JOptionPane.showConfirmDialog(null, panel, "Modificar producto",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    String nuevoNombreProducto = nombreProducto.getText();
                    String nuevoMarca = marca.getText();
                    int nuevaCantidadExistencia = Integer.parseInt(cantidadExistencia.getText());
                    String nuevoDescripcion = descripcion.getText();
                    double nuevoPrecio = Double.parseDouble(precio.getText());
                    String nuevoDepartamento = departamento.getText();

                    // Crear un nuevo objeto Producto con los nuevos datos ingresados
                    Producto productoModificado = new Producto(nuevoNombreProducto, nuevoMarca, nuevaCantidadExistencia, nuevoDescripcion, nuevoPrecio, nuevoDepartamento);

                    // Reemplazar el objeto antiguo con el objeto modificado en el modelo
                    elementosModel.set(selectedIndex, productoModificado);

                    // Actualizar también la lista original en la clase IngresarProducto
                    ArrayList<Producto> productosOriginales = IngresarProducto.getElemento();
                    productosOriginales.set(selectedIndex, productoModificado);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un producto para modificar.");
            }
        });
    }

    private void regresar() {
        btnRegresar.addActionListener(e -> {
            this.setVisible(false);
            new IngresarProducto().setVisible(true);
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
    }

    private void configPanel() {
        panelList.setLayout(new GridLayout(1, 0));
        panelList.add(jLista);
        panelList.setPreferredSize(new Dimension(800, 300));

        panelButton.setLayout(new FlowLayout());
        panelButton.setPreferredSize(new Dimension(500, 50));
        panelButton.add(btnMostrar);
        panelButton.add(btnEliminar);
        panelButton.add(btnActualizar);
        panelButton.add(btnRegresar);

        panelContainer.setLayout(new GridLayout(2, 0));
        panelContainer.add(panelList);
        panelContainer.add(panelButton);
    }
}
