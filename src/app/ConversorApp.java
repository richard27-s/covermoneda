package app;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConversorApp {

    private static final Logger logger = LoggerFactory.getLogger(ConversorApp.class);
    private JsonObject tasasDeCambio;

    public ConversorApp() {
        obtenerTasasDeCambio();
    }

    // Método para obtener las tasas de cambio desde la API
    private void obtenerTasasDeCambio() {
        try {
            final String apiKey = "616cbe7b590e71ca65373cc2"; // Asegúrate de usar tu clave correcta aquí
            final String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";
            final URL url = new URL(urlStr);
            final HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Parsear la respuesta JSON
            tasasDeCambio = JsonParser.parseReader(new InputStreamReader(request.getInputStream())).getAsJsonObject();

            // Imprimir la respuesta completa para ver qué está devolviendo la API
            // System.out.println("Respuesta de la API: " + tasasDeCambio);

        } catch (IOException e) {
            logger.error("Error al obtener las tasas de cambio.", e);
            System.out.println("Error al obtener las tasas de cambio.");
        }
    }

    public JsonObject getTasasDeCambio() {
        return tasasDeCambio;
    }
}

