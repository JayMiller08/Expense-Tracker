import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;
public class Main{
    static Scanner sc = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Expenses> expenses = new ArrayList<>();
    static String username = "", gender = "";
    static DecimalFormat df = new DecimalFormat("R#,###.00");
    static int age = 0; 
    static double expenseAmount = 0.00;
    static String category = "";
    static double totalExpenseAmount = 0.00;
    static Expenses expense = new Expenses(expenseAmount, category, totalExpenseAmount);
    public static void main(String[] args){
        
        User user = new User(username, gender, age);  //store user details, but username is more important
        
        boolean mainMenuRunning = true;
        int option = 0;

        while(mainMenuRunning){
            System.out.println("*** MAIN MENU ***");
            System.out.println("\n1. Create New Account");
            System.out.println("2. Add an Expense");
            System.out.println("3. View All Expenses");
            System.out.println("4. Filter Expenses by Category");
            System.out.println("5. Calculate Total Expenses");
            System.out.println("0. Exit");
            System.out.print("\nSelect: ");
            option = sc.nextInt();
            sc.nextLine();
            
            //create the methods below
            
            switch(option){
                case 1: createNewAccount();
                    break;
                case 2: addExpense();
                    break;
                case 3: viewExpenses();
                    break;
                case 4: filterExpenseByCategory(expenses, sc);
                    break;
                case 5: calcTotalExpense();
                    break;
                case 0: System.out.println("Thank You for using our service! Good bye.");
                        mainMenuRunning = false;
                    break;

                default: System.out.println("*INVALID SELECTION*");
            }
        }
        
    }
    public static void createNewAccount(){
        String name, surname, username = "", gender = "";
        char initial, selection;
        int age, option2, genderOpt;
        boolean createNewAccMenuRunning = true;

        while(createNewAccMenuRunning){

            System.out.println("=== Create New Profile ===\n");
            System.out.print("Name: ");
            name = sc.nextLine();
            System.out.print("Surname: ");
            surname = sc.nextLine();
            System.out.print("1. Male\n2. Female\nGender: ");
            genderOpt = sc.nextInt();

            if( genderOpt == 1 ){
                gender = "male";
            }else if( genderOpt == 2 ){
                gender = "female";
            }else{
                System.out.println("You have entered an invalid selection.");
            }

            System.out.print("Age: ");
            age = sc.nextInt();
            sc.nextLine();

            if(age < 18){
                System.out.println("Please ask a parent or guardian for additional queries about finances. :)");
            }else if(age < 1){
                System.out.println("You have entered an invalid age.");
            }
            initial = name.charAt(0);
            System.out.println("Is the following information correct? ");
            System.out.println("Name: "+name);
            System.out.println("Surname: "+surname);
            System.out.println("Gender: "+gender);
            System.out.println("Age: "+age);
            System.out.print("\nY / N: ");
            selection = Character.toUpperCase(sc.next().charAt(0));

            if(selection == 'Y'){
                username = initial+". "+ surname;
                System.out.println("Username: "+username);
                User newUser = new User(username, gender, age);
                users.add(newUser);
                createNewAccMenuRunning = false;

            }else if(selection == 'N'){
                sc.nextLine();
            } else {
                System.out.println("Invalid selection");
            }
            

        }
    }

    public static void addExpense(){
        boolean addExpMenuRunning = true;
        int option3 = 0;
        char choice;
        String description = "", category = "";

        while(addExpMenuRunning){
            System.out.println("Please select the category of your expense: ");
            System.out.println("1. Food\n2. Transport\n3. Entertainment\n4. Uncategorized"); //list of categories
            System.out.print("Selection: ");
            option3 = sc.nextInt();
            sc.nextLine();
            if( option3 == 1 ){
                category = "food";
            } else if( option3 == 2 ){
                category = "transport";
            } else if( option3 == 3 ){
                category = "entertainment";
            } else if( option3 == 4 ){
                category = "uncategorized";
            } else{
                System.out.println("Error, invalid input! Please Try Again.");
            }
            Expenses newExpense = new Expenses(expenseAmount, category, totalExpenseAmount);
            newExpense.setCategory(category);
            System.out.print("Would you like to add a description? ( Y / N ): ");
            choice = Character.toUpperCase(sc.next().charAt(0));
            sc.nextLine();
            if( choice == 'Y' ){
                System.out.print("Enter description: ");
                description = sc.nextLine();
            }else if( choice == 'N' ){
                description = "no description";
            } else {
                System.out.println("Error, Invalid Input!");
                continue;
            }

            System.out.print("Enter "+category+" expense amount: R");
            expenseAmount = Math.round(sc.nextDouble() * 100.0) / 100.0;
            newExpense.setExpenseAmount(expenseAmount);
            expenses.add(newExpense);
            System.out.println("Successfully entered expense!");
            System.out.println("\nCategory: "+category+"\nAmount: "+df.format(expenseAmount));
            totalExpenseAmount += expenseAmount;
            expense.setTotalExpenseAmount(totalExpenseAmount);

            System.out.println("Enter another expense?\n1. Yes\n2. No");
            System.out.print("Select: ");
            option3 = sc.nextInt();

            if( option3 == 1 ){
                continue;
            } else if( option3 == 2 ){
                addExpMenuRunning = false;
            }
        }
    }

    public static void viewExpenses(){
        boolean viewExpensesMenuRunning = true;
        int option5;

        while(viewExpensesMenuRunning){
            if( expenses.isEmpty() ){
                System.out.println("=== No Expenses Found ===");
            } else {
                System.out.println("=== Expenses ===\n");
                for(Expenses expense : expenses){
                    System.out.println(expense);
                }
            }
            System.out.println("1. Return to Main Menu");
            System.out.print("Select: ");
            option5 = sc.nextInt();
            sc.nextLine();

            if( option5 != 1 ){
                System.out.println("Invalid selection");
            } else {
                viewExpensesMenuRunning = false;
                break;
            }
        }
    }

    public static void filterExpenseByCategory(ArrayList<Expenses> expenses, Scanner sc){
        boolean filterExpenseByCategoryMenuRunning = true;
        

        while(filterExpenseByCategoryMenuRunning){
            System.out.println("Select Category:");
            System.out.println("1. Food");
            System.out.println("2. Transport");
            System.out.println("3. Entertainment");
            System.out.println("4. Uncategorized");
            System.out.println("0. Return to Main Menu");
            
            int categoryOpt;
            try {
                System.out.print("Selection: ");
                categoryOpt = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 0 and 4.");
                sc.nextLine();
                continue;
            }
            


            String selectedCategory = null;
            switch(categoryOpt){
                case 1: selectedCategory = "food";
                    break;
                case 2: selectedCategory = "transport";
                    break;
                case 3: selectedCategory = "entertainment";
                    break;
                case 4: selectedCategory = "uncategorized";
                    break;
                case 0: System.out.println("Returning to main menu....");
                    filterExpenseByCategoryMenuRunning = false;
                    break;
                
                default: System.out.println("Invalid Input! Please Enter a number between 0 and 4.");
            }

            boolean found = false;
            for( Expenses expense : expenses ){
                if( expense.getCategory().equalsIgnoreCase(selectedCategory) ){
                    System.out.println(expense);
                    found = true;
                }
            }
            if(!found){
                System.out.println("No expenses found in the " + selectedCategory + " category.");
            }
        }
    }
    public static void calcTotalExpense(){

        boolean calcTotalExpenseMenuRunning = true;
        int option6 = 0;
        if(expenses.isEmpty()){
            System.out.println("No Expenses Found.");
        } else {
            while(calcTotalExpenseMenuRunning) {
                System.out.println("==== Total Expenses ===");
                for (Expenses expense : expenses) {
                    System.out.println(expense);
                }
                expense.totalExpenseAmountToString();


                System.out.println("1. Return to Main Menu");
                System.out.print("Selection: ");
                option6 = sc.nextInt();
                sc.nextLine();
                if (option6 != 1) {
                    System.out.println("Invalid Selection!");
                } else {
                    calcTotalExpenseMenuRunning = false;
                }
            }
        }

        
    }
}



