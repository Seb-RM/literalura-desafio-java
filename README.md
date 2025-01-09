# Introducción
**Literalura** es una aplicación backend desarrollada con **Java** y **Spring**, diseñada para interactuar con la API de **Gutendex** y una base de datos relacional basada en **PostgreSQL**.

El objetivo principal de Literalura es ofrecer la posibilidad de explorar y gestionar un catálogo de libros. La aplicación permite a los usuarios buscar libros por título o por el nombre del autor, asegurándose de que los datos obtenidos se guarden en la base de datos si no existen previamente. Si los libros o autores ya están registrados, la aplicación devuelve los datos directamente desde la base de datos, optimizando el rendimiento y minimizando solicitudes innecesarias a la API.

Además de las búsquedas individuales, Literalura ofrece una serie de funcionalidades adicionales para interactuar con el catálogo:

- Listar todos los libros previamente buscados y almacenados en la base de datos.
- Listar todos los autores de los libros registrados.
- Filtrar libros por el idioma en que se encuentran disponibles.
- Listar autores que estaban vivos en un año específico.

¡Explora el catálogo de Literalura!