import java.math.BigDecimal;
import java.time.LocalDate;

public class Expense {
    private int id;
    private LocalDate date;
    private BigDecimal amount;
    private String category;
    private String description;

    public Expense(int id, LocalDate date, BigDecimal amount, String category, String description) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    public Expense(LocalDate date, BigDecimal amount, String category, String description) {
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Expense [id=" + id + ", date=" + date + ", amount=" + amount + ", category=" + category
                + ", description=" + description + "]";
    }

}