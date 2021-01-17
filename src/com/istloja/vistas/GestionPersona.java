/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.vistas;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author johnp
 */
public class GestionPersona extends JFrame {

    private JPanel panelTitulo = new JPanel();
    private JPanel panelCuerpo = new JPanel();
    private JPanel panelBotones = new JPanel();

    public GestionPersona() {
        this.setLayout(new BorderLayout());
        //Mostrar Pantalla
        this.show();
        //Titulo de la venta
        this.setTitle("Ventana");
        //Tamanio Inicial de la venta
        this.setSize(400, 600);
        //Se agregar un layout distribuir los componentes.
        panelTitulo.setLayout(new FlowLayout());
        JLabel label = new JLabel("REGISTRO DE PERSONAS");
        panelTitulo.add(label);
        //Agrege el panel al Jframe
        panelCuerpo.setLayout(new GridLayout(6, 2));
        panelCuerpo.add(new JLabel("Cedula"));
        panelCuerpo.add(new JTextField("3745773645"));
        panelCuerpo.add(new JLabel("Nombre"));
        panelCuerpo.add(new JTextField("Eric"));
        panelCuerpo.add(new JLabel("Apellido"));
        panelCuerpo.add(new JTextField("Jimenez"));
        panelCuerpo.add(new JLabel("Direccion"));
        panelCuerpo.add(new JTextField("Loja"));
        panelCuerpo.add(new JLabel("Correo"));
        panelCuerpo.add(new JTextField("eric@sdkjfs.com"));
        panelCuerpo.add(new JLabel("Telefono"));
        panelCuerpo.add(new JTextField("0984756637"));

        panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(new JButton("Agregar"));
        panelBotones.add(new JButton("Editar"));
        panelBotones.add(new JButton("Eliminar"));
        panelBotones.add(new JButton("Traer ultimo registro"));

        this.add(panelTitulo, BorderLayout.NORTH);
        this.add(panelCuerpo, BorderLayout.CENTER);
        this.add(panelBotones, BorderLayout.SOUTH);
        //Centrar la pantalla
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(500,300));
        //Fin al programa.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
