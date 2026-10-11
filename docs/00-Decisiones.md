# Decisiones del proyecto

## Decisión 1 - Nombre del proyecto

**Fecha:** 04/08/2026

### Decisión

El repositorio se llamará `personal-expense-manager`.

### Motivo

Este nombre describe de forma clara el objetivo de la aplicación: gestionar gastos personales.

Se ha preferido el término **manager** frente a **tracker**, ya que refleja mejor que la aplicación permitirá gestionar la información y no únicamente realizar un seguimiento de ella.


## Decisión 2 - Clase para representar los gastos

**Fecha:** 08/08/2026

### Decisión

La clase para representar los gastos en Java se llamará `Expense`.

### Motivo

Este nombre permite identificar claramente que la clase `Expense` representa como objeto cada registro de la tabla `expenses` de la base de datos.


## Decisión 3 - Sistema de gestión de base de datos

**Fecha:** 15/08/2026

### Decisión

Se utilizará PostgreSQL como sistema de gestión de bases de datos relacionales del proyecto.

### Motivo

Su uso permitirá aplicar al proyecto conocimientos de bases de datos y SQL ya adquiridos, y permitirá guardar los gastos de forma permanente en la base de datos.


## Decisión 4 - Uso de JDBC y del driver de PostgreSQL

**Fecha:** 20/08/2026

### Decisión

Se empleará el driver JDBC de PostgreSQL para permitir la comunicación entre la aplicación Java y la base de datos PostgreSQL.

### Motivo

Se ha elegido JDBC para poder ejecutar consultas SQL para guardar, consultar, modificar y eliminar los gastos almacenados en la base de datos.

El driver proporciona los componentes necesarios para que JDBC pueda conectarse específicamente con PostgreSQL.


## Decisión 5 - Separación de la configuración de la base de datos

**Fecha:** 22/08/2026

### Decisión

Los datos necesarios para establecer la conexión con PostgreSQL se almacenarán en el archivo `config.properties`, separado del código Java.

### Motivo

La configuración de la conexión se mantendrá separada del código de la aplicación para facilitar su modificación.

Además, el archivo `config.properties` no se incluirá en el repositorio público porque contiene información sensible.


## Decisión 6 - Orden de los gastos

**Fecha:** 28/08/2026

### Decisión

Los gastos se mostrarán ordenados por fecha, de la más reciente a la más antigua.

### Motivo

Este orden permite mostrar primero los gastos registrados más recientemente y facilita la consulta del listado.


## Decisión 7 - Método para seleccionar categorías

**Fecha:** 29/08/2026

### Decisión

Se ha creado un método independiente llamado `elegirCategoria()` para realizar la selección de categorías.

### Motivo

El método permite agrupar en un único lugar la lógica relacionada con la selección de categorías.

El método se puede llamar tanto al crear un gasto como al modificarlo, evitando repetir la misma lógica en diferentes partes del programa.


## Estado del documento

**Versión:** 1.0

**Estado:** Completado

