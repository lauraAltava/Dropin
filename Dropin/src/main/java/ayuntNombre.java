import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ayuntNombre extends JFrame {
    public ayuntNombre() {
        // Configuración de la ventana
        setTitle("Drop-in - Ayuntamiento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);
        setLocationRelativeTo(null);

        // Crear componentes de la interfaz
        JLabel imageLabel = new JLabel();
        ImageIcon ayuntamientoImage = new ImageIcon("IMAGES/vall.png");  // Replace "ayuntamiento.jpg" with the actual image file path

        JLabel containerLabel = new JLabel("Nº de Contenedores:");
        JTextField containerTextField = new JTextField();

        JButton addButton = new JButton("Añadir");

        // Establecer colores personalizados
        Color backgroundColor = new Color(85, 211, 83);
        Color buttonColor = new Color(255, 255, 255);
        Color textColor = new Color(85, 211, 83);

        // Configurar estilo de los componentes
        containerLabel.setForeground(buttonColor);
        addButton.setBackground(buttonColor);
        addButton.setForeground(textColor);

        Font labelFont = new Font("Arial", Font.PLAIN, 20);
        Font buttonFont = new Font("Arial", Font.BOLD, 18);
        containerLabel.setFont(labelFont);
        addButton.setFont(buttonFont);

        // Configurar la imagen del ayuntamiento
        Image image = ayuntamientoImage.getImage();
        Image scaledImage = image.getScaledInstance(350, 120, Image.SCALE_SMOOTH); // Cambiar los valores 300, 100 según tus necesidades
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        imageLabel.setIcon(scaledIcon);

        // Agregar componentes al panel principal
        JPanel panelAyuntamiento = new JPanel(new BorderLayout());
        panelAyuntamiento.setBackground(backgroundColor);
        panelAyuntamiento.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBackground(backgroundColor);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(containerLabel);
        inputPanel.add(containerTextField);

        panelAyuntamiento.add(imageLabel, BorderLayout.NORTH);
        panelAyuntamiento.add(inputPanel, BorderLayout.CENTER);
        panelAyuntamiento.add(addButton, BorderLayout.SOUTH);

        add(panelAyuntamiento);

        // Acción del botón "Añadir"
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ayuntContenedor añadirContenedor = new ayuntContenedor();
                añadirContenedor.setVisible(true);
                dispose(); // Cierra la ventana actual de PanelAyuntamiento
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ayuntNombre app = new ayuntNombre();
                app.setVisible(true);
            }
        });
    }
}
