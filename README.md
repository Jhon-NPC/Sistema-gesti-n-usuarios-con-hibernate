# 🧩 Migración de JDBC a Hibernate

## 🎯 Objetivo del proyecto

Este proyecto tiene como propósito **reemplazar la lógica de acceso a datos implementada con JDBC puro** por una solución moderna basada en **Hibernate ORM**, **manteniendo la funcionalidad actual** del sistema. La migración se realizó para:

- Mejorar el **mantenimiento** del código.
- Incrementar la **escalabilidad** del sistema.
- Optimizar el **rendimiento** en el acceso a la base de datos.

---

## 🧱 ¿Qué es Hibernate?

Hibernate es un **framework de mapeo objeto-relacional (ORM)** para Java. Permite mapear las clases Java a las tablas de una base de datos relacional, eliminando gran parte del código SQL manual y facilitando la persistencia de objetos.

---

## 🏗️ Migración desde JDBC

### Antes:
El sistema usaba conexiones manuales a MySQL con `java.sql.Connection`, `PreparedStatement`, `ResultSet`, etc.

### Ahora:
Se utiliza **Hibernate** para manejar la persistencia con clases Java (entidades), eliminando la necesidad de escribir SQL explícito para operaciones CRUD.

---
