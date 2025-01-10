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

## Instalación

Sigue estos pasos para instalar y ejecutar Literalura en tu entorno local:

### 1. Clona el Repositorio
Descarga el proyecto desde el repositorio utilizando Git:
```bash
  git clone <URL_DEL_REPOSITORIO>
```
Reemplaza `<URL_DEL_REPOSITORIO>` con la URL del repositorio donde se encuentra alojado el proyecto.

### 2. Configura la Base de Datos
-  a. Asegúrate de que PostgreSQL esté instalado y en ejecución.
-  b. Crea una nueva base de datos para la aplicación, utilizando el cliente de PostgreSQL:
```bash
  CREATE DATABASE literalura;
```
-  c. Actualiza las credenciales de acceso en el archivo de configuración application.properties o application.yml del proyecto:
```bash
  spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
  spring.datasource.username=<TU_USUARIO>
  spring.datasource.password=<TU_CONTRASEÑA>
```
Reemplaza `<TU_USUARIO>` y `<TU_CONTRASEÑA>` con las credenciales de tu base de datos.

### 3. Instala las Dependencias
-  a. Abre el proyecto en tu IDE favorito (IntelliJ IDEA, Eclipse, etc.).
-  b. Asegúrate de que Maven o Gradle esté configurado correctamente.
-  c. Ejecuta el comando para instalar las dependencias del proyecto:
```bash
  ./mvnw install
```
o, si usas Gradle:
```bash
  ./gradlew build
```

### 4. Ejecuta la Aplicación
-  a. Inicia la aplicación utilizando el comando:

```bash
  ./mvnw spring-boot:run
```
o, si usas Gradle:
```bash
  ./gradlew bootRun
```
-  b. La aplicación estará disponible en la consola para interacción textual.

### 5. Opcional: Configura el Cliente SQL
   Si deseas consultar directamente la base de datos:

-  a. Conéctate a la base de datos `literalura` utilizando una herramienta como DBeaver o pgAdmin.
-  b. Explora las tablas generadas automáticamente por la aplicación para verificar el almacenamiento de datos.

¡Con estos pasos, Literalura estará lista para su uso!

## Uso

Una vez instalada y ejecutada la aplicación, puedes interactuar con **Literalura** a través de la consola. A continuación, se describen las opciones disponibles y cómo utilizarlas:
```bash
=======================================
 📚 Bienvenido al sistema de consulta: 
=======================================
Seleccione una opción del menú:
---------------------------------------
1️⃣ Buscar libros por título o autor
2️⃣ Listar todos los autores buscados
3️⃣ Listar todos los libros buscados
4️⃣ Filtrar libros buscados por idioma
5️⃣ Listar autores vivos en un año deternimado
6️⃣ Salir
---------------------------------------
```
### Opciones de Interacción
1. **Buscar libros por título o nombre del autor:**
    - Ingresa un título para buscar libros relacionados en la API de Gutendex. Si el libro no existe en la base de datos local, será agregado automáticamente.
- Ejemplo:
```bash
Seleccione una opción: 1
Ingrese el título del libro o el autor: hamlet
      
Resultado: 
📖 Título: Hamlet, Prince of Denmark
👨‍💼 Autor:
👤 Nombre: Shakespeare, William
🗓️ Año de Nacimiento: 1564
🕊️ Año de Fallecimiento: 1616
🌍 Idioma:en -
🔢 Número de Descargas: 11383
```
2. **Listar todos los autores buscados:**
    - Obtén una lista de todos los autores cuyos libros han sido registrados en la base de datos.
- Ejemplo:
```bash
Seleccione una opción: 2

👨‍💼 Lista de autores buscados:
👤 Nombre: Stoker, Bram
🗓️ Año de Nacimiento: 1847
🕊️ Año de Fallecimiento: 1912

👤 Nombre: Melville, Herman
🗓️ Año de Nacimiento: 1819
🕊️ Año de Fallecimiento: 1891

👤 Nombre: Cervantes Saavedra, Miguel de
🗓️ Año de Nacimiento: 1547
🕊️ Año de Fallecimiento: 1616
 ```
3. **Listar todos los libros buscados:**
    - Consulta todos los libros que han sido buscados previamente y almacenados en la base de datos.
- Ejemplo:
```bash
Seleccione una opción: 3

Listado de todos los libros buscados: 
📖 Título: Moby Dick; Or, The Whale
👨‍💼 Autor: 
👤 Nombre: Melville, Herman
   🗓️ Año de Nacimiento: 1819
   🕊️ Año de Fallecimiento: 1891
🌍 Idioma:en - 
🔢 Número de Descargas: 72786

📖 Título: Dracula
👨‍💼 Autor: 
👤 Nombre: Stoker, Bram
   🗓️ Año de Nacimiento: 1847
   🕊️ Año de Fallecimiento: 1912
🌍 Idioma:en - 
🔢 Número de Descargas: 30413

📖 Título: Don Quijote
👨‍💼 Autor: 
👤 Nombre: Cervantes Saavedra, Miguel de
   🗓️ Año de Nacimiento: 1547
   🕊️ Año de Fallecimiento: 1616
🌍 Idioma:es - 
🔢 Número de Descargas: 16017
```

4. **Filtrar libros buscados por idioma:**
    - Filtra los libros guardados según el idioma en el que se encuentran.
- Ejemplo:
```bash
Seleccione una opción: 4

Ingrese el idioma deseado: es

Libros disponibles en es:
📖 Título: Don Quijote
👨‍💼 Autor:
👤 Nombre: Cervantes Saavedra, Miguel de
🗓️ Año de Nacimiento: 1547
🕊️ Año de Fallecimiento: 1616
🌍 Idioma:es -
🔢 Número de Descargas: 16017

📖 Título: La Celestina
👨‍💼 Autor:
👤 Nombre: Rojas, Fernando de
🗓️ Año de Nacimiento: 0
🕊️ Año de Fallecimiento: 1541
🌍 Idioma:es -
🔢 Número de Descargas: 578
```

5. **Listar autores vivos en un año deternimado:**
    - Ingresa un año para obtener los autores que estaban vivos en esa fecha.
- Ejemplo:
```bash
Seleccione una opción: 5

Ingrese el año deseado: 1925

📜 Autores vivos en el año 1925:

👤 Nombre: Kipling, Rudyard
   🗓️ Año de Nacimiento: 1865
   🕊️ Año de Fallecimiento: 1936
---------------------------------------
Seleccione una opción: 5

Ingrese el año deseado: 2025
⚠️ No se encontraron autores vivos en el año 2025
```

6. **Salir:**
    - Cierra la aplicación.
- Ejemplo:
```bash
  Seleccione una opción: 6
🛑 Recurso de entrada cerrado.

=======================================
     ¡Gracias por usar el sistema!     
=======================================
```

### Navegación y Entrada
- Sigue las instrucciones que aparecen en pantalla para seleccionar una opción.
- En caso de ingresar una entrada no válida, se te pedirá que intentes nuevamente.
```bash
Seleccione una opción: 7
⚠️ Opción fuera de rango. Por favor, ingrese un número entre 1 y 6.
---------------------------------------
Seleccione una opción: a
⚠️ Entrada inválida. Por favor, ingrese un número.
```
### Notas Adicionales
- Los resultados de las búsquedas se guardan automáticamente en la base de datos para futuras consultas.
- Si un libro o autor ya existe en la base de datos, la aplicación evita duplicados y muestra la información desde el almacenamiento local.

¡Explora las opciones y disfruta de tu catálogo literario personalizado con **Literalura**!
