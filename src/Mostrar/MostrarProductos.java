package Mostrar;

import Pojo.CarritoCompras;
import Pojo.Producto;
import Principal.Principal;
import Registro.IngresarProducto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MostrarProductos extends JFrame {
    private static ArrayList<CarritoCompras> carritoCompras=new ArrayList<>();
    private JList<Producto> jLista;
    private JButton btnMostrar, btnMostrarMas, btnAgregarCarrito, btnRegresar,btnMostrarCarrito;
    private DefaultListModel<Producto> elementosModel;

    // CONTENEDORES
    private JPanel panelList, panelButton, panelContainer;

    public MostrarProductos() {
        initControl();
        configFrame();
        setControl();
        configPanel();
        add(panelContainer);

        showList();
        regresar();
        agregarAlCarrito();
        mostrarCarro();
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
    private void mostrarCarro(){
        btnMostrarCarrito.addActionListener(e -> {
            this.setVisible(false);
            new MostrarCarrito().setVisible(true);
        });
    }
    private void regresar() {
        btnRegresar.addActionListener(e -> {
            this.setVisible(false);
            new Principal().setVisible(true);
        });
    }

    private void initControl() {
        jLista = new JList<>();
        panelButton = new JPanel();
        panelList = new JPanel();
        panelContainer = new JPanel();
        btnMostrar = new JButton();
        btnMostrarMas = new JButton();
        btnAgregarCarrito = new JButton();
        btnRegresar = new JButton();
        btnMostrarCarrito=new JButton();
    }
    private void agregarAlCarrito() {
        btnAgregarCarrito.addActionListener(e -> {
            int selectedIndex = jLista.getSelectedIndex();
            if (selectedIndex != -1) {
                Producto productoSeleccionado = elementosModel.getElementAt(selectedIndex);
                // Obtener la cantidad de productos a agregar
                String cantidadString = JOptionPane.showInputDialog(null, "Ingrese la cantidad de productos:");
                if (cantidadString != null) {
                    int cantidad = Integer.parseInt(cantidadString);

                    // Crear una instancia de CarritoCompras con la información del producto, la cantidad y el precio
                    CarritoCompras itemCarrito = new CarritoCompras(productoSeleccionado.getProducto(), cantidad, productoSeleccionado.getPrecio());
                    carritoCompras.add(itemCarrito); // Agregar el itemCarrito al ArrayList de carritoCompras
                    itemCarrito.agregarItemCarrito(); // Llamar al método agregarItemCarrito en la clase CarritoCompras

                    JOptionPane.showMessageDialog(null, "Producto agregado al carrito correctamente.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un producto para agregar al carrito.");
            }
        });
    }
    public static ArrayList<CarritoCompras> getCarritoCompras() {
        return carritoCompras;
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
        btnMostrarMas.setText("Mostrar mas");
        btnAgregarCarrito.setText("Agregar al carrito");
        btnRegresar.setText("Regresar");
        btnMostrarCarrito.setText("Mostrar carrito");
    }

    private void configPanel() {
        panelList.setLayout(new GridLayout(1, 0));
        panelList.add(jLista);
        panelList.setPreferredSize(new Dimension(800, 300));

        panelButton.setLayout(new FlowLayout());
        panelButton.setPreferredSize(new Dimension(500, 50));
        panelButton.add(btnMostrar);
        panelButton.add(btnMostrarMas);
        panelButton.add(btnAgregarCarrito);
        panelButton.add(btnRegresar);
        panelButton.add(btnMostrarCarrito);

        panelContainer.setLayout(new GridLayout(2, 0));
        panelContainer.add(panelList);
        panelContainer.add(panelButton);
    }
}
