# Modelo de datos

## Objetivo

Representar como objeto un gasto en Java a partir de lo definido en la tabla `expenses` de la base de datos.

## Clase Expense

La clase `Expense` en Java será el molde para crear objetos que representen gastos, cuyos atributos corresponderán con los campos definidos en la tabla `expenses`.

## Atributos de la clase

La siguiente tabla muestra la correspondencia entre los tipos de datos de los campos de la tabla `expenses` de la base de datos y los tipos de datos de los atributos de los objetos del tipo `Expense` que se crearán en Java.

| Campo        | PostgreSQL | Java        |
|--------------|-------------|------------|
| `id`         | `INTEGER`   |`int`       |
| `date`       | `DATE`      |`LocalDate` |
| `amount`     | `NUMERIC`   |`BigDecimal`|
| `category`   | `VARCHAR`   |`String`    |
| `description`| `VARCHAR`   |`String`    |

## Relación con la base de datos

Cada objeto del tipo `Expense` creado en Java se corresponderá con un registro de un gasto en la tabla `expenses` de la base de datos.

La base de datos almacenará los gastos de forma permanente, mientras que Java trabajará temporalmente con objetos del tipo `Expense` en memoria cuando necesite utilizarlos.

## Estado del documento

**Versión:** 1.0

**Estado:** Completado
