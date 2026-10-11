
import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ExpenseDAO dao = new ExpenseDAO();

        int opcion;

        do {
            opcion = mostrarMenu(sc);

            switch (opcion) {
                case 1 -> {
                    System.out.println("Has elegido crear gasto");

                    System.out.print("Introduce la fecha (AAAA-MM-DD):");
                    LocalDate fecha = LocalDate.parse(sc.nextLine());

                    System.out.print("Introduce el importe:");
                    BigDecimal importe = new BigDecimal(sc.nextLine());

                    String categoria = elegirCategoria(sc);

                    System.out.print("Introduce la descripcion si quieres:");
                    String descripcion = sc.nextLine();

                    Expense expense = new Expense(fecha, importe, categoria, descripcion);

                    dao.createExpense(expense);

                }
                case 2 -> {
                    System.out.println("Has elegido ver los gastos");

                    ArrayList<Expense> expenses = dao.getExpenses();

                    for (Expense expense : expenses) {
                        System.out.println(expense);
                    }
                }
                case 3 -> {
                    System.out.println("Has elegido modificar gasto");

                    System.out.print("Introduce el id del gasto que quieres modificar:");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Introduce la fecha (AAAA-MM-DD):");
                    LocalDate fecha = LocalDate.parse(sc.nextLine());

                    System.out.print("Introduce el importe:");
                    BigDecimal importe = new BigDecimal(sc.nextLine());

                    String categoria = elegirCategoria(sc);

                    System.out.print("Introduce la descripcion si quieres:");
                    String descripcion = sc.nextLine();

                    Expense expense = new Expense(id, fecha, importe, categoria, descripcion);

                    dao.updateExpense(expense);
                }
                case 4 -> {
                    System.out.println("Has elegido eliminar gasto");

                    System.out.print("Introduce el id del gasto que quieres eliminar:");
                    int id = Integer.parseInt(sc.nextLine());

                    dao.deleteExpense(id);
                }
                case 5 -> {
                    System.out.println("Has elegido salir del menú");
                }
                default -> {
                    System.out.println("Opción no válida");
                }

            }
        } while (opcion != 5);

    }

    public static int mostrarMenu(Scanner sc) {

        System.out.println();
        System.out.println("MENU");
        System.out.println("Opción 1. Crear gasto");
        System.out.println("Opción 2. Ver gasto");
        System.out.println("Opción 3. Modificar gasto");
        System.out.println("Opción 4. Eliminar gasto");
        System.out.println("Opción 5. Salir");
        System.out.println();

        System.out.print("Elige una opción:");

        int opcion = Integer.parseInt(sc.nextLine());

        return opcion;

    }

    public static String elegirCategoria(Scanner sc) {
        System.out.println("Elige una categoría:");
        System.out.println("1. Alimentación");
        System.out.println("2. Transporte");
        System.out.println("3. Ocio");
        System.out.println("4. Hogar");
        System.out.println("5. Otros");

        int opcionCategoria = Integer.parseInt(sc.nextLine());

        String categoria;

        switch (opcionCategoria) {
            case 1 -> categoria = "Alimentación";
            case 2 -> categoria = "Transporte";
            case 3 -> categoria = "Ocio";
            case 4 -> categoria = "Hogar";
            default -> categoria = "Otros";
        }

        return categoria;
    }

}
