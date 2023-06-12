import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ayuntLogin extends JFrame {
    public ayuntLogin() {
        // Configurar la pantalla
        setTitle("Map Buttons");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);
        setLocationRelativeTo(null);

        // Crear botones
        JButton castellonButton = new JButton("Castellón de la Plana");
        JButton vilaRealButton = new JButton("Vila-real");
        JButton vallDUixoButton = new JButton("Vall d'Uixó");
        JButton benicassimButton = new JButton("Benicàssim");

        // Establecer colores personalizados
        Color backgroundColor = new Color(85, 211, 83);
        Color buttonColor = new Color(255, 255, 255);
        Color textColor = new Color(85, 211, 83);

        // Configurar estilo de los botones
        castellonButton.setBackground(buttonColor);
        castellonButton.setForeground(textColor);
        vilaRealButton.setBackground(buttonColor);
        vilaRealButton.setForeground(textColor);
        vallDUixoButton.setBackground(buttonColor);
        vallDUixoButton.setForeground(textColor);
        benicassimButton.setBackground(buttonColor);
        benicassimButton.setForeground(textColor);

        Font buttonFont = new Font("Arial", Font.BOLD, 18);
        castellonButton.setFont(buttonFont);
        vilaRealButton.setFont(buttonFont);
        vallDUixoButton.setFont(buttonFont);
        benicassimButton.setFont(buttonFont);

        // Crear panel para los botones
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setBackground(backgroundColor);
        buttonPanel.add(castellonButton);
        buttonPanel.add(vilaRealButton);
        buttonPanel.add(vallDUixoButton);
        buttonPanel.add(benicassimButton);

        // Agregar panel al marco
        add(buttonPanel);

        // Acciones de los botones
        castellonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ayuntNombre panelAyuntamiento = new ayuntNombre();
                panelAyuntamiento.setVisible(true);
                dispose(); // Cierra la ventana actual de MapButtons
            }
        });

        vilaRealButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ayuntNombre panelAyuntamiento = new ayuntNombre();
                panelAyuntamiento.setVisible(true);
                dispose(); // Cierra la ventana actual de MapButtons
            }
        });

        vallDUixoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ayuntNombre panelAyuntamiento = new ayuntNombre();
                panelAyuntamiento.setVisible(true);
                dispose(); // Cierra la ventana actual de MapButtons
            }
        });

        benicassimButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ayuntNombre panelAyuntamiento = new ayuntNombre();
                panelAyuntamiento.setVisible(true);
                dispose(); // Cierra la ventana actual de MapButtons
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ayuntLogin mapButtons = new ayuntLogin();
                mapButtons.setVisible(true);
            }
        });
    }
}
