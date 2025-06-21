import java.text.DecimalFormat;

public class Expenses {
    DecimalFormat formatter = new DecimalFormat("R#,###.00");

    double expenseAmount, totalExpenseAmount;
    String category;

    //constructor to initialize expenses
    public Expenses(double expenseAmount, String category, double totalExpenseAmount){
        this.expenseAmount = expenseAmount;
        this.category = category;
        this.totalExpenseAmount = totalExpenseAmount;
    }

    //setter for expenseAmount
    public void setExpenseAmount(double expenseAmount){
        this.expenseAmount = expenseAmount;
    }
    //setter for category
    public void setCategory(String category){
        this.category = category;
    }

    //getter for expenseAmount
    public double getExpenseAmount(){
        return expenseAmount;
    }

    //getter for category
    public String getCategory(){
        return category;
    }

    public void setTotalExpenseAmount(double totalExpenseAmount){
        this.totalExpenseAmount = totalExpenseAmount;
    }
    public double getTotalExpenseAmount(){
        
        return totalExpenseAmount;
    }

    


    @Override
    public String toString(){
        return "Category: "+category+"\nExpense: "+formatter.format(expenseAmount)+"\n";
    }

    public void totalExpenseAmountToString(){
        System.out.println("Total Amount Spent: R"+totalExpenseAmount);
    }
}
