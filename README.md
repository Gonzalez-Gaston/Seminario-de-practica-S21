# Sistema de Gestión de Turnos - Consultora SIJAC

Este es un sistema de gestión de turnos desarrollado en Java para la consultora SIJAC, diseñado para permitir a los clientes solicitar consultas legales y mediaciones con abogados.

## Funcionamiento

El sistema permite realizar las siguientes acciones:

1. **Solicitar Turno**: Permite al usuario ingresar los datos del cliente, abogado, tipo de turno (consulta legal o mediación), fecha y hora del turno.
   
2. **Mostrar Turnos**: Muestra todos los turnos programados, incluyendo detalles como el tipo de turno, la fecha y hora, el cliente y el abogado asociados.

3. **Eliminar Turno**: Permite eliminar un turno específico ingresando su ID.

## Estructura del Proyecto

El proyecto está organizado en varias clases Java:

- **Usuario.java**: Clase abstracta para representar a un usuario genérico.
- **Cliente.java**: Clase que extiende Usuario y representa a un cliente con un atributo adicional (`telefono`).
- **Abogado.java**: Clase que extiende Usuario y representa a un abogado con un atributo adicional (`especialidad`).
- **Turno.java**: Clase para representar un turno genérico con atributos como `id`, `fechaHora`, `Cliente` y `Abogado`.
- **Consulta.java**: Subclase de Turno para representar un turno de consulta legal.
- **Mediacion.java**: Subclase de Turno para representar un turno de mediación, que incluye una descripción del problema a tratar.
- **GestionTurnos.java**: Clase para gestionar la lista de turnos, con métodos para agregar, mostrar y eliminar turnos.

## Cómo Ejecutar el Sistema

Para ejecutar el sistema en otro PC, sigue estos pasos:

1. **Requisitos**:
   - Java Development Kit (JDK) instalado.
   - IDE compatible con Java como IntelliJ IDEA, Eclipse, o similar.

2. **Clonar el Repositorio**:
git clone <[URL del repositorio](https://github.com/Gonzalez-Gaston/Seminario-de-practica-S21/tree/main)>


3. **Importar el Proyecto**:
- Abre el proyecto en tu IDE.

4. **Compilar y Ejecutar**:
- Busca y abre el archivo `Main.java` en la carpeta `main`.
- Ejecuta la aplicación desde tu IDE.

## Ejemplo de Uso

1. **Solicitar un Turno**:
- Selecciona la opción 1 en el menú principal.
- Ingresa los datos solicitados como el ID del turno, nombre del cliente, etc.

2. **Mostrar Turnos Programados**:
- Selecciona la opción 2 en el menú principal para ver todos los turnos programados.

3. **Eliminar un Turno**:
- Selecciona la opción 3 en el menú principal.
- Ingresa el ID del turno que deseas eliminar.

## Contribución

Contribuciones y mejoras son bienvenidas. Si encuentras algún problema o tienes una sugerencia, por favor abre un issue en el repositorio.

---
