# Diseño de la base de datos

## Objetivo

Establecer la estructura de la base de datos de la aplicación, definiendo qué información se almacenará de cada gasto y cómo se organizará.

La información se organizará en una única tabla, donde cada fila representará un gasto registrado y cada columna un campo de información.

## Tabla de gastos

La tabla `expenses` contendrá la información de todos los gastos registrados por el usuario.

## Descripción de los campos

### id

- Identifica de forma única cada gasto registrado.
- Es un campo obligatorio.
- Su valor será generado automáticamente por la base de datos.
- Su tipo de dato será `INTEGER`.

### date

- Indica la fecha en la que se realizó el gasto.
- Es un campo obligatorio.
- Su valor será introducido por el usuario.
- Su tipo de dato será `DATE`.

### amount

- Representa el importe del gasto registrado.
- Es un campo obligatorio.
- Su valor será introducido por el usuario.
- Su tipo de dato será `NUMERIC`.

### category

- Permite clasificar el gasto según su categoría.
- Es un campo obligatorio.
- Su valor será seleccionado por el usuario de una lista de categorías predefinidas.
- Su tipo de dato será `VARCHAR`.

### description

- Permite añadir una descripción al gasto registrado.
- Es un campo opcional.
- Su valor será introducido por el usuario.
- Su tipo de dato será `VARCHAR`.

## Estado del documento

**Versión:** 1.0

**Estado:** Completado