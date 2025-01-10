# Introducción
**Literalura** es una aplicación backend desarrollada con **Java** y **Spring**, diseñada para interactuar con la API de **Gutendex** y una base de datos relacional basada en **PostgreSQL**.

El objetivo principal de Literalura es ofrecer la posibilidad de explorar y gestionar un catálogo de libros. La aplicación permite a los usuarios buscar libros por título o por el nombre del autor, asegurándose de que los datos obtenidos se guarden en la base de datos si no existen previamente. Si los libros o autores ya están registrados, la aplicación devuelve los datos directamente desde la base de datos, optimizando el rendimiento y minimizando solicitudes innecesarias a la API.

Además de las búsquedas individuales, Literalura ofrece una serie de funcionalidades adicionales para interactuar con el catálogo:

- Listar todos los libros previamente buscados y almacenados en la base de datos.
- Listar todos los autores de los libros registrados.
- Filtrar libros por el idioma en que se encuentran disponibles.
- Listar autores que estaban vivos en un año específico.

¡Explora el catálogo de Literalura!

## Características

Literalura ofrece diversas funcionalidades que permiten a los usuarios interactuar con un catálogo de libros de manera eficiente. A continuación, se detallan las principales características de la aplicación:

### Búsquedas Interactivas
- **Buscar libros por título:** Permite buscar libros ingresando un título específico. La búsqueda se realiza a través de la API de Gutendex, y los resultados se almacenan en la base de datos si no existen previamente.
- **Buscar libros por autor:** Ofrece la posibilidad de encontrar libros ingresando el nombre de un autor. La aplicación consulta la API, verifica si los datos ya están en la base de datos y, de ser así, devuelve los resultados desde allí.

### Gestión de Datos Persistentes
- **Almacenamiento automático:** Los resultados de las búsquedas se almacenan automáticamente en una base de datos relacional (PostgreSQL) para evitar consultas redundantes a la API.
- **Consulta de datos existentes:** Si un libro o autor ya existe en la base de datos, la aplicación utiliza esa información en lugar de realizar una nueva búsqueda.

### Listados y Filtrados
- **Listar todos los libros buscados:** Muestra un listado completo de los libros almacenados en la base de datos.
- **Listar autores registrados:** Permite ver todos los autores asociados a los libros buscados.
- **Filtrar libros por idioma:** Ofrece un listado de libros basados en el idioma en que se encuentran disponibles.
- **Listar autores vivos en un año específico:** Identifica y muestra los autores que estaban vivos en un año determinado.

### Interacción y Usabilidad
- **Interfaz por consola:** Literalura utiliza una interfaz basada en texto que permite a los usuarios interactuar fácilmente mediante un menú de opciones.
- **Optimización de recursos:** Reduce las solicitudes a la API al almacenar y reutilizar los datos relevantes.

## Requisitos Previos

Antes de utilizar Literalura, asegúrate de cumplir con los siguientes requisitos:

### Entorno de Desarrollo
- **Java Development Kit (JDK):** Versión 11 o superior instalada en tu sistema.
- **Spring Framework:** Configuración del entorno para ejecutar aplicaciones con Spring Boot.
- **PostgreSQL:** Base de datos relacional configurada y en ejecución. Se requiere acceso a una base de datos para almacenar los datos de libros y autores.

### Herramientas Recomendadas
- **IDE:** Un entorno de desarrollo integrado como IntelliJ IDEA, Eclipse o Visual Studio Code configurado para trabajar con proyectos Java y Spring.
- **Postman o similar:** Herramienta para probar y depurar las interacciones con la API de Gutendex.
- **Cliente SQL:** Una herramienta como DBeaver o pgAdmin para gestionar la base de datos PostgreSQL.

### Configuración de la Base de Datos
- Crear una base de datos en PostgreSQL para almacenar la información. Asegúrate de configurar:
    - **Nombre de la base de datos.**
    - **Usuario y contraseña.**
    - **URL de conexión.**

### API de Gutendex
- Acceso a la [API de Gutendex](https://gutendex.com/) para realizar las búsquedas de libros y autores. No se requiere una clave de API, ya que es de acceso público.

Asegúrate de cumplir con estos requisitos antes de iniciar la aplicación para garantizar su correcto funcionamiento.

