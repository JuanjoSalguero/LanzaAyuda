/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lanzaayuda;



import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import java.io.File;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JMenu;
import java.awt.event.KeyEvent;


/**
 *
 * @author Juanjo
 */
public class LanzaAyuda extends JFrame {

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItemContenido, menuItemAbout;

    public LanzaAyuda() {

        /* Creamos el JMenuBar y lo asociamos con el JFrame */
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        /* Creamos el primer JMenu y lo pasamos como parámetro al JMenuBar mediante el método add */
        menu = new JMenu("Ayuda");
        menuBar.add(menu);

        /* Creamos el segundo y tercer objetos de la clase JMenu y los asociamos con el primer JMenu creado */
        menuItemContenido = new JMenuItem("Contenido de Ayuda");
        menuItemContenido.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        menu.add(menuItemContenido);
        menuItemAbout = new JMenuItem("About");
        menu.add(menuItemAbout);
                
        // Método para abrir la ayuda
        abrirAyuda();

        // Configurar y mostrar JFrame
        initPantalla();
    }

    private void initPantalla() {

        setLayout(null); //Layout absoluto
        setTitle("Aplicación Swing con Ayuda"); //Título del JFrame
        setSize(400, 200); //Dimensiones del JFrame
        setResizable(false); //No redimensionable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
        setVisible(true); //Mostrar JFrame
    }

    /* Método que implementa la acción del menú item Contenido de Ayuda */
    public void abrirAyuda() {
        
        try {
            
            // Asociamos el fichero helpset.hs al objeto File
            File fichero = new File("help/helpset.hs");
            URL hsURL = fichero.toURI().toURL();
            
            // Cereamos el objeto HelpSet
            HelpSet hs = new HelpSet(getClass().getClassLoader(), hsURL);
            
            // Creamos el objeto HelpBroker
            HelpBroker hb = hs.createHelpBroker();
            hb.setSize(new Dimension(1000, 850));
            
            // Habilitamos el botón de ayuda en item MenuItemContenido
            hb.enableHelpOnButton(menuItemContenido, "aplicacion", hs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new LanzaAyuda();

    }
}
