package Principal;


import Mostrar.MostrarProductos;
import Registro.Usuario;
import Ventanas.VentanaTienda;
import Ventanas.VentanaUsuario;

import javax.swing.*;
import java.awt.*;

public class Principal extends JFrame{
    private JButton usuario,tienda,pedido;
    private JLabel vacio,vacio1,vacio2;
    private JPanel panelButton, panelContainer, panelContent;

    public Principal() {
        initButton();
        initPanels();
        setupFrame();
    }

    public void initButton() {
        usuario = new JButton("Usuario");
        tienda = new JButton("Tienda");
        pedido=new JButton("Realizar pedido");
        usuario.addActionListener(e -> {
            this.setVisible(false);
           new VentanaUsuario().setVisible(true);
        });
        tienda.addActionListener(e -> {
            this.setVisible(false);
           new VentanaTienda().setVisible(true);
        });
        pedido.addActionListener(e -> {
            this.setVisible(false);
            new MostrarProductos().setVisible(true);
        });
    }
    public void initPanels() {
        panelButton = new JPanel();
        panelContainer = new JPanel();
        panelContent = new JPanel();
        vacio =new JLabel(" ");
        vacio1 =new JLabel(" ");
        vacio2=new JLabel(" ");
    }

    private void setupFrame() {
        setTitle("Tienda");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(400, 430);

        panelButton.setLayout(new GridLayout(6,0));
        panelButton.setPreferredSize(new Dimension(15, 130));
        panelButton.add(vacio1);
        panelButton.add(usuario);
        panelButton.add(vacio);
        panelButton.add(tienda);
        panelButton.add(vacio2);
        panelButton.add(pedido);


        panelContainer.setLayout(new BorderLayout());

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("C:\\Users\\livia\\Documents\\Paradigmas\\Tienda.jpg");
        JLabel imageLabel = new JLabel(new ImageIcon(image));

        panelContent.setLayout(new BorderLayout());
        panelContent.add(imageLabel, BorderLayout.CENTER);
        panelContent.add(panelButton, BorderLayout.SOUTH);

        panelContainer.add(panelContent, BorderLayout.CENTER);

        getContentPane().add(panelContainer);

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

}
