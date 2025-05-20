import java.time.LocalDate;

public class Transaction {
    private final TransactionType type;

    public Transaction(TransactionType type, double amount, String category) {
        this.type = type;
        this.amount = amount;
        this.category = category;
        this.date = LocalDate.now();
    }
    public Transaction(TransactionType type, double amount, String category,LocalDate localDate) {
        this.type = type;
        this.amount = amount;
        this.category = category;
        this.date = localDate;
    }

    public TransactionType getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    private final double amount;
    private final String category;
    private final LocalDate date;

    @Override
    public String toString() {
        return type +","+amount +","+category+","+date;
    }
}
