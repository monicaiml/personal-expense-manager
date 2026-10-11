import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExpenseDAO {

    private Properties properties;
    private String url;
    private String user;
    private String password;

    public ExpenseDAO() {
        properties = new Properties();

        System.out.println("Carpeta de trabajo: " + System.getProperty("user.dir"));
        try (FileInputStream input = new FileInputStream(
                "config.properties")) {
            properties.load(input);

            url = properties.getProperty("db.url");
            user = properties.getProperty("db.user");
            password = properties.getProperty("db.password");

        } catch (IOException e) {
            System.out.println("Error al cargar la configuración.");
            e.printStackTrace();
        }
    }

    public void createExpense(Expense expense) {

        String sql = "INSERT INTO EXPENSES (fecha, importe, categoria, descripcion) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setObject(1, expense.getDate());
            statement.setBigDecimal(2, expense.getAmount());
            statement.setString(3, expense.getCategory());
            statement.setString(4, expense.getDescription());

            statement.executeUpdate();

            System.out.println("Gasto creado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al crear el gasto.");
            e.printStackTrace();
        }
    }

    public ArrayList<Expense> getExpenses() {

        String sql = "SELECT * FROM EXPENSES ORDER BY fecha DESC";

        ArrayList<Expense> expenses = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                LocalDate date = resultSet.getDate("fecha").toLocalDate();
                BigDecimal amount = resultSet.getBigDecimal("importe");
                String category = resultSet.getString("categoria");
                String description = resultSet.getString("descripcion");

                Expense expense = new Expense(id, date, amount, category, description);

                expenses.add(expense);

            }

            System.out.println("Gastos leídos correctamente.");

            return expenses;

        } catch (SQLException e) {
            System.out.println("Error al leer los gastos.");
            e.printStackTrace();

            return new ArrayList<>();
        }

    }

    public void updateExpense(Expense expense) {

        String sql = "UPDATE EXPENSES SET fecha = ? , importe = ? , categoria = ? , descripcion = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setObject(1, expense.getDate());
            statement.setBigDecimal(2, expense.getAmount());
            statement.setString(3, expense.getCategory());
            statement.setString(4, expense.getDescription());
            statement.setInt(5, expense.getId());

            statement.executeUpdate();

            System.out.println("Gasto modificado correctamente.");

        } catch (SQLException e)

        {
            System.out.println("Error al modificar el gasto.");
            e.printStackTrace();
        }

    }

    public void deleteExpense(int id) {

        String sql = "DELETE FROM EXPENSES WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            statement.executeUpdate();

            System.out.println("Gasto borrado correctamente.");

        } catch (SQLException e)

        {
            System.out.println("Error al borrar el gasto.");
            e.printStackTrace();
        }

    }
}
