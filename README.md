<div style="text-align: center;">

# Covercion de Moneda

## Descripción

**Covercion de Moneda** es una aplicación de escritorio desarrollada en Java que permite a los usuarios convertir cantidades entre diferentes monedas utilizando la API de ExchangeRate. La aplicación ofrece una interfaz gráfica de usuario intuitiva y fácil de usar, facilitando el acceso a información de cambio de divisas en tiempo real.

</div>

## Funcionalidades

- Conversión de moneda entre múltiples divisas.
- Interfaz gráfica de usuario (GUI) amigable.
- Actualización automática de tasas de cambio a través de la API de ExchangeRate.
- Soporte para diversas monedas globales.

## Requisitos

- Java 11 o superior
- Conexión a Internet para acceder a la API de ExchangeRate

## Bibliotecas Utilizadas

Este proyecto utiliza las siguientes bibliotecas:

- **Gson**: Para manejar y parsear datos JSON. [Gson en GitHub](https://github.com/google/gson)
- **SLF4J**: Una fachada para varios frameworks de logging. [SLF4J en GitHub](http://www.slf4j.org/)
- **slf4j-simple**: Implementación simple de SLF4J para logging. [slf4j-simple en GitHub](http://www.slf4j.org/)
- **slf4j-log4j12**: Implementación de SLF4J para Log4j 1.2. [slf4j-log4j12 en GitHub](http://www.slf4j.org/)

## Instalación

Sigue estos pasos para instalar y ejecutar la aplicación:

1. Clona este repositorio:
   ```bash
   git clone https://github.com/richard27-s/covermoneda.git
   ```

2. Navega a la carpeta del proyecto:
   ```bash
   cd covermoneda
   ```

3. Abre el proyecto en tu IDE favorito (por ejemplo, IntelliJ IDEA).

4. Asegúrate de que todas las dependencias estén configuradas correctamente (como Gson).

5. Ejecuta la aplicación desde tu IDE.

## Uso

1. Inicia la aplicación.
2. Selecciona la moneda que deseas convertir desde el menú desplegable.
3. Ingresa la cantidad a convertir.
4. Selecciona la moneda a la que deseas convertir.
5. Haz clic en el botón "Convertir" y visualiza el resultado.

## Contribución

Las contribuciones son bienvenidas. Si deseas contribuir a este proyecto, por favor sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama:
   ```bash
   git checkout -b feature-nueva
   ```
3. Realiza tus cambios y haz un commit:
   ```bash
   git commit -m 'Agregar nueva característica'
   ```
4. Sube tus cambios:
   ```bash
   git push origin feature-nueva
   ```
5. Abre un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENCIA para más detalles.

