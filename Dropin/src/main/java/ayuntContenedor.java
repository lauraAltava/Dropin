import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ayuntContenedor extends JFrame {
    public ayuntContenedor() {
        // Configurar la pantalla "Añadir Contenedor"
        setTitle("Añadir Contenedor");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 450);
        setLocationRelativeTo(null);

        // Crear componentes
        JLabel serialNumberLabel = new JLabel("Nº de serie:");
        JTextField serialNumberTextField = new JTextField();

        JLabel typeLabel = new JLabel("Tipo:");
        JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"Vidrio", "Cartón", "Orgánico"});

        JLabel addressLabel = new JLabel("Dirección:");
        JTextField addressTextField = new JTextField();

        JButton addButton = new JButton("Añadir");
        JButton backButton = new JButton("Atrás");

        // Establecer colores personalizados
        Color backgroundColor = new Color(85, 211, 83);
        Color buttonColor = new Color(255, 255, 255);
        Color textColor = new Color(85, 211, 83);

        // Configurar estilo de los componentes
        Font labelFont = new Font("Arial", Font.PLAIN, 12);
        Font buttonFont = new Font("Arial", Font.BOLD, 12);

        serialNumberLabel.setFont(labelFont);
        typeLabel.setFont(labelFont);
        addressLabel.setFont(labelFont);

        serialNumberLabel.setForeground(buttonColor);
        typeLabel.setForeground(buttonColor);
        addressLabel.setForeground(buttonColor);

        addButton.setBackground(buttonColor);
        backButton.setBackground(buttonColor);

        addButton.setForeground(textColor);
        backButton.setForeground(textColor);

        addButton.setFont(buttonFont);
        backButton.setFont(buttonFont);

        // Crear un panel para contener los componentes
        JPanel addContainerPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        addContainerPanel.setBackground(backgroundColor);
        addContainerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Agregar componentes al panel
        addContainerPanel.add(serialNumberLabel);
        addContainerPanel.add(serialNumberTextField);
        addContainerPanel.add(typeLabel);
        addContainerPanel.add(typeComboBox);
        addContainerPanel.add(addressLabel);
        addContainerPanel.add(addressTextField);

        addContainerPanel.add(backButton); // Agregar el botón "Atrás"
        addContainerPanel.add(addButton); // Agregar el botón "Añadir"

        // Agregar el panel al marco
        add(addContainerPanel);

        // Acción del botón "Añadir"
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para añadir el contenedor
                JOptionPane.showMessageDialog(null, "Contenedor añadido");
            }
        });

        // Acción del botón "Atrás"
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ayuntNombre ayuntNombre = new ayuntNombre();
                ayuntNombre.setVisible(true);
                dispose(); // Cerrar la pantalla actual (AñadirContenedor)
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ayuntContenedor añadirContenedor = new ayuntContenedor();
                añadirContenedor.setVisible(true);
            }
        });
    }
}
