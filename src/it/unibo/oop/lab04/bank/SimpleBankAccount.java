package it.unibo.oop.lab04.bank;

public class SimpleBankAccount implements BankAccount {
    /**
     * 
     */
    public static final double ATM_TRANSACTION_FEE = 1;
    /**
     * 
     */
    public static final double MANAGEMENT_FEE = 5;

    private double balance;
    private int nTransactions;
    private final int usrID;

    public SimpleBankAccount(final int usrID, final double balance) {
        this.usrID = usrID;
        this.balance = balance;
        this.nTransactions = 0;
    }

    /**
     * @param id
     * @return true if usrID is correct
     */
    protected boolean checkUser(final int id) {
        return this.usrID == id;
    }

    /**
     * @param usrID
     */
    @Override
    public void computeManagementFees(final int usrID) {
        if (checkUser(usrID)) {
            this.balance -= SimpleBankAccount.MANAGEMENT_FEE;
        }
    }

    /**
     * @param usrID
     * @param amount
     */
    @Override
    public void deposit(final int usrID, final double amount) {
        this.transactionOp(usrID, amount);
    }

    /**
     * @param usrID
     * @param amount
     */
    @Override
    public void depositFromATM(final int usrID, final double amount) {
        this.deposit(usrID, amount - SimpleBankAccount.ATM_TRANSACTION_FEE);
    }

    /**
     * @return balance value
     */
    @Override
    public double getBalance() {
        return this.balance;
    }

    /**
     * @return number of transaction
     */
    @Override
    public int getNTransactions() {
        return this.nTransactions;
    }

    /**
     * 
     */
    protected void incTransactions() {
        this.nTransactions++;
    }

    /**
     * 
     */
    protected void resetTransactions() {
        this.nTransactions = 0;
    }

    /**
     * @param amount
     */
    protected void setBalance(final double amount) {
        this.balance = amount;
    }

    /**
     * transaction operation.
     * @param usrID
     * @param amount
     */
    private void transactionOp(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.balance += amount;
            this.incTransactions();
        }
    }

    /**
     * @param usrID
     * @param amount
     */
    @Override
    public void withdraw(final int usrID, final double amount) {
        this.transactionOp(usrID, -amount);
    }

    /**
     * @param usrID
     * @param amount
     */
    @Override
    public void withdrawFromATM(final int usrID, final double amount) {
        this.withdraw(usrID, amount + SimpleBankAccount.ATM_TRANSACTION_FEE);
    }

}
