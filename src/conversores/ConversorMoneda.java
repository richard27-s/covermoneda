package conversores;

import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class ConversorMoneda {
    private final JsonObject tasasDeCambio;

    // Constructor que recibe las tasas de cambio desde el objeto Json
    public ConversorMoneda(JsonObject tasasDeCambio) {
        this.tasasDeCambio = tasasDeCambio;
    }

    // Método para convertir de una moneda a otra
    public double convertir(String monedaOrigen, String monedaDestino, double cantidad) {
        JsonObject conversionRates = tasasDeCambio.getAsJsonObject("conversion_rates");
        if (conversionRates == null) {
            throw new RuntimeException("Las tasas de cambio no están disponibles.");
        }

        double tasaOrigen = conversionRates.get(monedaOrigen).getAsDouble();
        double tasaDestino = conversionRates.get(monedaDestino).getAsDouble();

        return (cantidad / tasaOrigen) * tasaDestino;
    }

    // Método para obtener un mapa filtrado de las monedas que deseas mostrar
    public Map<String, String> obtenerMonedasFiltradas() {
        Map<String, String> monedasFiltradas = new HashMap<>();

        monedasFiltradas.put("ARS", "ARS - Peso argentino");
        monedasFiltradas.put("BOB", "BOB - Boliviano boliviano");
        monedasFiltradas.put("BRL", "BRL - Real brasileño");
        monedasFiltradas.put("CLP", "CLP - Peso chileno");
        monedasFiltradas.put("COP", "COP - Peso colombiano");
        monedasFiltradas.put("USD", "USD - Dólar estadounidense");

        return monedasFiltradas;
    }
}
