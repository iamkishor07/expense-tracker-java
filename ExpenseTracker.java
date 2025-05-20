import java.io.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.List;

public class ExpenseTracker {
    private final Scanner sc = new Scanner(System.in);

    private  final  List<Transaction> transactions = new ArrayList<>();

    private static final String path = "K:\\kishi\\expense-tracker-java\\";
    private static final String FILE_NAME = "transaction.txt";

    private static String options = """
               1.Add Transcation Like INCOME / EXPENSE & Catagoreies into FOOD,RENT,TRAVEL etc.. 
               2.View Monthly Summary
               3.Load from File
               4.Save to the File
               5.Exit
            """;
    public void run()
    {
        while (true)
        {
            System.out.println("Expense Tracker :\n" + options);
            System.out.println("Enter your option: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice)
            {
                case 1 -> addTranscation();
                case 2 -> viewMonthlySummary(transactions);
                case 3 -> loadDataFromFile();
                case 4 -> saveDataToFile(transactions);
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option");

            }
        }
    }

    private void saveDataToFile(List<Transaction> transactions) {
        String saveFileToPath = path + FILE_NAME;
        System.out.println("Saving file to the path: " + saveFileToPath);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(saveFileToPath))) {
            bw.write("TYPE,AMOUNT,CATEGORY,DATE\n");
            for (Transaction t : transactions) {
                bw.write(t.toString() + "\n");
            }
            System.out.println("Saved successfully to " + saveFileToPath+" " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Failed to save to " + FILE_NAME + ": " + e.getMessage());
        }

    }

    private void loadDataFromFile() {
        List<Transaction> listFromFile = new ArrayList<>();
        String filePath = path + FILE_NAME;
        System.out.println("Loading file from the path: " + filePath);
        System.out.println("Make sure the file Name is of: " + FILE_NAME);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            br.readLine(); // skip header that contains the TYPE,AMOUMT,CATEGORY,DATE
            String line ;
            while ((line = br.readLine()) != null)
            {
                String[] parts = line.split(",");
                TransactionType transactionType = TransactionType.valueOf(parts[0]);
                double amount = Double.parseDouble(parts[1]);
                String category = parts[2];
                LocalDate localDate = LocalDate.parse(parts[3]);
                listFromFile.add(new Transaction(transactionType,amount,category,localDate));
            }
            transactions.addAll(listFromFile);
            System.out.println("Loaded successfully from the path" + filePath);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void viewMonthlySummary(List<Transaction> transactions) {
        Map<YearMonth,Double> incomeByMonth = new HashMap<>();
        Map<YearMonth,Double> expenseByMonth = new HashMap<>();
        for(Transaction t : transactions)
        {
            YearMonth ym = YearMonth.from(t.getDate());
            if(t.getType() == TransactionType.INCOME)
            {
                incomeByMonth.put(ym,incomeByMonth.getOrDefault(ym,0.0)+ t.getAmount());
            }
            else
            {
                expenseByMonth.put(ym,expenseByMonth.getOrDefault(ym,0.0) + t.getAmount());
            }
        }

        //Now Print all the Expense & Income Monthly
        Set<YearMonth> allMonths = new TreeSet<>(incomeByMonth.keySet());
        allMonths.addAll(expenseByMonth.keySet());
        ///*** allMonths set contains all the months of expenses & all the months of income

        for(YearMonth ym  : allMonths)
        {
            double income = incomeByMonth.getOrDefault(ym,0.0);
            double expense = expenseByMonth.getOrDefault(ym,0.0);
            double savings = income - expense;

            System.out.println("\n === Summary for "+ ym.getMonth() + " "+ym.getYear()  +" " + "===");
            System.out.println("Total Income: ₹" + income);
            System.out.println("Total Expense: ₹" + expense);
            System.out.println("Net Savings: ₹" + savings);
        }
    }

    private void addTranscation() {
        ///*** This method add the transcation to the transaction list

        System.out.println("Enter the Transcation Type : (INCOME / EXPENSE): ");
        TransactionType transactionType = TransactionType.valueOf(sc.nextLine().toUpperCase());
        System.out.println("Enter the amount: ");
        double amount = Double.parseDouble(sc.nextLine());
        System.out.println("Enter category: ");
        String category = sc.nextLine();
        transactions.add(new Transaction(transactionType,amount,category));
        System.out.println("Transaction Added Successfully ");

    }

}
