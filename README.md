
# Expense Tracker – SOLID Java Console Application
    A simple, console-based Java application that helps users track income and expenses, categorize transactions,
    generate monthly summaries, and save/load data to/from files. Built with clean design principles
    using SOLID architecture.
# 🚀 Features
    Add income or expense transactions
    Categorize entries (e.g., Food, Rent, Travel, Salary, Business)
    View monthly summaries of income, expenses, and savings
    Save data to a txt file (in Downloads folder or custom path)
    Load data from a previously saved file
    Supports structured txt input for bulk transaction loading

# 📂 Project Structure
    ├── Main.java                # Application entry point
    ├── ExpenseTracker.java      # Main application logic
    ├── Transaction.java         # Represents an income/expense record
    ├── TransactionType.java     # Enum: INCOME or EXPENSE
    ├── transaction.txt          # Generated txt file
    ├── README.md                # Breif Description on Expense Tracker
# 📄 File Format (.txt)
    Your txt file should follow this structure:

    TYPE,AMOUNT,CATEGORY,DATE
    INCOME,10000,Salary,2025-05-01
    EXPENSE,3000,Food,2025-05-05

# ‍💻 How to Use
1.Clone this repositry to your local machine
    git clone https://github.com/your-username/expense-tracker-java.git
    cd expense-tracker-java
Replace your-username with your actual GitHub username.

2.Compile and run:
    Before Running Your Application pls change the path to download/load Files in ExpenseTracker.java
![img_7](https://github.com/user-attachments/assets/c6dd7b5f-cac2-41f9-b2c6-21bea3bcdae0)
    javac Main.java
    java Main

3.Application Options
![img](https://github.com/user-attachments/assets/554e60f8-73a0-4e80-9507-b6349007c3cd)
4.Enter your option
# ➕ Add Transaction
    # For Exp: I'm adding a transcation of 45000 , which is INCOME,category salary
    Once You've Entered the option 1, ie, add transcation It'll ask for the Type of the Transcation (Income /Expense)
![img_1](https://github.com/user-attachments/assets/0053b1e6-4cc6-48d5-b980-b777cabc06c5)
    Once You've Entered the Type, It'll ask for the amount
![img_2](https://github.com/user-attachments/assets/7ce1de41-2b7f-4a11-8c70-4e9cfb5c9f2c)
    Once You've Entered the amount, It'll ask for the Category like food,salary etc
![img_3](https://github.com/user-attachments/assets/5eb72e5b-6227-4a42-b2e7-dcbe1d6ce1db)
    Once You've Entered the category , it will added the transcation successfully
![img_4](https://github.com/user-attachments/assets/709412ab-7f4f-4807-a43d-5744dfbe1dc3)

# 📊 View Monthly Summary 
    # For Exp : If you want to see the Monthly Summary you can see via option 2.
![img_6](https://github.com/user-attachments/assets/96c24d91-7d33-4bdc-9e3f-826b0ab3cad0)

# 💾 Save to File:
    # You Want to Save all the transactions you've done till know
    Once You run the Application , It'll give you options, In that choose 4.Save to the file
![img_5](https://github.com/user-attachments/assets/567e122f-4f0a-4829-9bef-48b7c9f9d341)
It'll give the specific path where the file is saved.

# 📂 Load from File
    #You want to load data/Transaction from a file 
    #Make sure you have change the path in ExpenseTracker.java & Inorder to load,make sure there exist one txt
    #file with the name as specified int ExpenseTracker.java or Incase if you've change , your file name
    Once this is done, it will load data form the file, 
![img_8](https://github.com/user-attachments/assets/0b0d07cc-23c4-41b9-bb2e-1fa2eb4e2ee6)
    My transaction.txt file contains the below data 
    Once Application started, I'll give option : 3 to load
![img_9](https://github.com/user-attachments/assets/90c0a3ae-971d-412b-b86a-6f61ecf6bec8)
    Once that is completed, Now see the monthly summary via Option:2
![img_10](https://github.com/user-attachments/assets/cbd7abfe-7835-4ecf-8176-6c65376c5304)
    So the data/Summary which i've got is from the file 

# 👨‍💻 Author
Built by Kishor Kumar - writing clean, maintainable Java code with SOLID design and real-world use cases in mind.

    

