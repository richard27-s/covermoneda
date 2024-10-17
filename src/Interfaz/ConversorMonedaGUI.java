package Interfaz;

import app.ConversorApp;
import conversores.ConversorMoneda;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ConversorMonedaGUI {
    private final ConversorApp conversorApp;

    public ConversorMonedaGUI(ConversorApp conversorApp) {
        this.conversorApp = conversorApp;
    }

    public void crearVentana() {
        JFrame frame = new JFrame("Conversor de Monedas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2));

        // Crear los elementos de la interfaz
        JLabel labelCantidad = new JLabel("Cantidad:");
        JTextField fieldCantidad = new JTextField();

        JLabel labelMonedaOrigen = new JLabel("Moneda Origen:");
        JComboBox<String> comboMonedaOrigen = new JComboBox<>();

        JLabel labelMonedaDestino = new JLabel("Moneda Destino:");
        JComboBox<String> comboMonedaDestino = new JComboBox<>();

        JButton buttonConvertir = new JButton("Convertir");
        JLabel labelResultado = new JLabel("Resultado:");

        // Obtener las monedas filtradas
        ConversorMoneda conversorMoneda = new ConversorMoneda(conversorApp.getTasasDeCambio());
        Map<String, String> monedasFiltradas = conversorMoneda.obtenerMonedasFiltradas();

        // Llenar los JComboBox con las monedas filtradas
        for (String moneda : monedasFiltradas.values()) {
            comboMonedaOrigen.addItem(moneda);
            comboMonedaDestino.addItem(moneda);
        }

        // Acción del botón convertir
        buttonConvertir.addActionListener(e -> {
            try {
                String cantidadStr = fieldCantidad.getText();
                double cantidad = Double.parseDouble(cantidadStr);

                // Obtener el valor seleccionado de los JComboBox
                String monedaOrigen = (String) comboMonedaOrigen.getSelectedItem();
                String monedaDestino = (String) comboMonedaDestino.getSelectedItem();

                // Validar que no sean null antes de hacer split
                if (monedaOrigen != null && monedaDestino != null) {
                    // Extraer el código de la moneda del formato "ARS - Peso argentino"
                    monedaOrigen = monedaOrigen.split(" ")[0];
                    monedaDestino = monedaDestino.split(" ")[0];

                    // Realizar la conversión
                    double resultado = conversorMoneda.convertir(monedaOrigen, monedaDestino, cantidad);

                    // Mostrar el resultado con el valor convertido y la moneda de destino
                    labelResultado.setText("Resultado: " + resultado + " " + monedaDestino);
                } else {
                    JOptionPane.showMessageDialog(frame, "Seleccione una moneda de origen y destino.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Error: La cantidad ingresada no es válida.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        // Agregar los elementos a la ventana
        frame.add(labelCantidad);
        frame.add(fieldCantidad);
        frame.add(labelMonedaOrigen);
        frame.add(comboMonedaOrigen);
        frame.add(labelMonedaDestino);
        frame.add(comboMonedaDestino);
        frame.add(buttonConvertir);
        frame.add(labelResultado);

        // Mostrar la ventana
        frame.setVisible(true);
    }

    // Método main para ejecutar la aplicación
    public static void main(String[] args) {
        // Aquí puedes inicializar la clase principal que obtiene las tasas de cambio
        ConversorApp conversorApp = new ConversorApp();
        ConversorMonedaGUI gui = new ConversorMonedaGUI(conversorApp);
        gui.crearVentana();
    }
}
