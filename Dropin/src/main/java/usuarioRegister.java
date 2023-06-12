import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class usuarioRegister extends JFrame {
    private JTextField nombreTextField;
    private JTextField apellidos1TextField;
    private JTextField apellidos2TextField;
    private JTextField emailTextField;
    private JTextField movilTextField;
    private JPasswordField contraseñaPasswordField;

    public usuarioRegister() {
        setTitle("Registro de Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);
        setLocationRelativeTo(null);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreTextField = new JTextField();

        JLabel apellidos1Label = new JLabel("Apellidos 1:");
        apellidos1TextField = new JTextField();

        JLabel apellidos2Label = new JLabel("Apellidos 2:");
        apellidos2TextField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        emailTextField = new JTextField();

        JLabel movilLabel = new JLabel("Móvil:");
        movilTextField = new JTextField();

        JLabel contraseñaLabel = new JLabel("Contraseña:");
        contraseñaPasswordField = new JPasswordField();

        JButton registrarButton = new JButton("Registrar");

        Color backgroundColor = new Color(85, 211, 83);
        Color buttonColor = new Color(255, 255, 255);
        Color textColor = new Color(255, 255, 255);

        getContentPane().setBackground(backgroundColor);
        nombreLabel.setForeground(textColor);
        apellidos1Label.setForeground(textColor);
        apellidos2Label.setForeground(textColor);
        emailLabel.setForeground(textColor);
        movilLabel.setForeground(textColor);
        contraseñaLabel.setForeground(textColor);
        registrarButton.setBackground(buttonColor);
        registrarButton.setForeground(backgroundColor);

        JPanel mainPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(backgroundColor);

        mainPanel.add(nombreLabel);
        mainPanel.add(nombreTextField);
        mainPanel.add(apellidos1Label);
        mainPanel.add(apellidos1TextField);
        mainPanel.add(apellidos2Label);
        mainPanel.add(apellidos2TextField);
        mainPanel.add(emailLabel);
        mainPanel.add(emailTextField);
        mainPanel.add(movilLabel);
        mainPanel.add(movilTextField);
        mainPanel.add(contraseñaLabel);
        mainPanel.add(contraseñaPasswordField);

        mainPanel.add(registrarButton);

        add(mainPanel);

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText();
                String apellido1 = apellidos1TextField.getText();
                String apellido2 = apellidos2TextField.getText();
                String email = emailTextField.getText();
                String movil = movilTextField.getText();
                String contraseña = new String(contraseñaPasswordField.getPassword());
                System.out.println(nombre);

                // Establecer conexión a la base de datos SQLite
                try (Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/baseDropin")) {
                    // Preparar la consulta SQL para insertar los valores en la tabla
                    String insertQuery = "INSERT INTO Usuarios (nombre, apellido1, apellido2, email, movil, contraseña) " +
                            "VALUES (?, ?, ?, ?, ?, ?)";

                    // Crear un objeto PreparedStatement para ejecutar la consulta
                    PreparedStatement statement = connection.prepareStatement(insertQuery);
                    statement.setString(1, nombre);
                    statement.setString(2, apellido1);
                    statement.setString(3, apellido2);
                    statement.setString(4, email);
                    statement.setString(5, movil);
                    statement.setString(6, contraseña);

                    // Ejecutar la consulta
                    int filasAfectadas = statement.executeUpdate();

                    statement.close();

                    // Mostrar mensaje de éxito
                    String mensaje = "Datos registrados:\n" +
                            "Nombre: " + nombre + "\n" +
                            "Apellidos 1: " + apellido1 + "\n" +
                            "Apellidos 2: " + apellido2 + "\n" +
                            "Email: " + email + "\n" +
                            "Móvil: " + movil;
                    JOptionPane.showMessageDialog(usuarioRegister.this, mensaje, "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

                    // Ocultar la ventana actual
                    setVisible(false);

                    // Crear una nueva instancia de la pantalla anterior y hacerla visible
                    usuarioLogin usuarioLogin = new usuarioLogin();
                    usuarioLogin.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(usuarioRegister.this, "Error al registrar los datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                usuarioRegister app = new usuarioRegister();
                app.setVisible(true);
            }
        });
    }
}
