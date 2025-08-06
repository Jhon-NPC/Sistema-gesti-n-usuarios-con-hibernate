package com.usuario;

import com.usuario.dao.UsuarioDAOImplementado;
import com.usuario.dao.UsuarioDAOInterface;
import com.usuario.modelo.Usuario;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static UsuarioDAOInterface dao = new UsuarioDAOImplementado();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- Menú del sistema ---");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: registrar(); break;
                case 2: listar(); break;
                case 3: actualizar(); break;
                case 4: eliminar(); break;
                case 5: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida"); break;
            }
        } while (opcion != 5);
        sc.close();
    }

    private static void registrar() {
        try {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Edad: ");
            int edad = sc.nextInt();
            sc.nextLine();
            dao.insertar(new Usuario(nombre, edad));
            System.out.println("Usuario registrado.");
        } catch (Exception e) {
            System.err.println("Error al registrar: " + e.getMessage());
        }
    }

    private static void listar() {
        try {
            List<Usuario> lista = dao.listar();
            lista.forEach(u -> System.out.println(u.getId() + " - " + u.getNombre() + " - " + u.getEdad()));
        } catch (Exception e) {
            System.err.println("Error al listar: " + e.getMessage());
        }
    }

    private static void actualizar() {
        try {
            System.out.print("ID del usuario: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Nueva edad: ");
            int edad = sc.nextInt();
            sc.nextLine();
            dao.actualizar(new Usuario(id, nombre, edad));
            System.out.println("Usuario actualizado.");
        } catch (Exception e) {
            System.err.println("Error al actualizar: " + e.getMessage());
        }
    }

    private static void eliminar() {
        try {
            System.out.print("ID del usuario a eliminar: ");
            int id = sc.nextInt();
            sc.nextLine();
            dao.eliminar(id);
            System.out.println("Usuario eliminado.");
        } catch (Exception e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }
}