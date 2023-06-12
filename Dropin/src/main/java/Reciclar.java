import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reciclar extends JFrame {
    public Reciclar() {
        // Configurar la pantalla "Reciclar"
        setTitle("Reciclar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);
        setLocationRelativeTo(null);

        // Crear componentes
        JLabel typesLabel = new JLabel("Tipos:");
        JComboBox<String> typesComboBox = new JComboBox<>(new String[]{"Vidrio", "Cartón", "Orgánico"});

        JLabel addressLabel = new JLabel("Dirección:");
        JTextField addressField = new JTextField();

        JLabel mapLabel = new JLabel("Mapa");
        // Añade aquí la lógica para mostrar el mapa con la ubicación de la dirección

        // Establecer colores personalizados
        Color backgroundColor = new Color(85, 211, 83);
        Color buttonColor = new Color(255, 255, 255);
        Color textColor = new Color(85, 211, 83);

        // Configurar estilo de los componentes
        typesLabel.setForeground(buttonColor);
        addressLabel.setForeground(buttonColor);
        typesComboBox.setBackground(buttonColor);
        addressField.setBackground(buttonColor);
        typesComboBox.setForeground(textColor);
        addressField.setForeground(textColor);

        // Establecer fuente personalizada
        Font labelFont = new Font("Arial", Font.PLAIN, 20);
        Font comboBoxFont = new Font("Arial", Font.PLAIN, 16);
        typesLabel.setFont(labelFont);
        addressLabel.setFont(labelFont);
        typesComboBox.setFont(comboBoxFont);
        addressField.setFont(comboBoxFont);

        // Crear un panel para contener los componentes
        JPanel recyclePanel = new JPanel(new BorderLayout());
        recyclePanel.setBackground(backgroundColor);
        recyclePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panel inferior con botones "Atrás" y "Reciclar"
        JPanel lowerPanel = new JPanel(new BorderLayout());
        lowerPanel.setOpaque(false);

        // Botón "Atrás"
        JButton backButton = new JButton("Atrás");
        backButton.setBackground(buttonColor);
        backButton.setForeground(textColor);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    usuarioOpciones usuarioOpciones = new usuarioOpciones();
                    usuarioOpciones.setVisible(true);
                    dispose(); // Cierra la ventana actual
                });
            }
        });
        lowerPanel.add(backButton, BorderLayout.WEST);

        // Botón "Reciclar"
        JButton recycleButton = new JButton("Reciclar");
        recycleButton.setBackground(buttonColor);
        recycleButton.setForeground(textColor);
        recycleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) typesComboBox.getSelectedItem();
                String address = addressField.getText();

                // TODO: Realizar la lógica de reciclaje aquí
                JOptionPane.showMessageDialog(null, "Tipo seleccionado: " + selectedType + "\nDirección: " + address);
            }
        });
        lowerPanel.add(recycleButton, BorderLayout.EAST);

        // Panel para los componentes superiores
        JPanel componentsPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        componentsPanel.setOpaque(false);
        componentsPanel.add(typesLabel);
        componentsPanel.add(typesComboBox);
        componentsPanel.add(addressLabel);
        componentsPanel.add(addressField);
        recyclePanel.add(componentsPanel, BorderLayout.NORTH);

        // Panel para el mapa
        JPanel mapPanel = new JPanel(new BorderLayout());
        mapPanel.setOpaque(false);
        mapPanel.add(mapLabel, BorderLayout.CENTER);

        // Agregar paneles al panel principal
        recyclePanel.add(mapPanel, BorderLayout.CENTER);
        recyclePanel.add(lowerPanel, BorderLayout.SOUTH);

        // Agregar el panel al marco
        add(recyclePanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Reciclar reciclar = new Reciclar();
                reciclar.setVisible(true);
            }
        });
    }
}
