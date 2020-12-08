package it.unibo.oop.lab04.bank;

public class StrictBankAccount implements BankAccount {

    /**
     * 
     */
    private static final double ATM_TRANSACTION_FEE = 1;
    /**
     * 
     */
    private static final double MANAGEMENT_FEE = 5;
    /**
     * 
     */
    private static final double TRANSACTION_FEE = 0.1;

    private final int usrID;
    private double balance;
    private int nTransactions;

    /**
     * constructor.
     * @param usrID
     * @param balance
     */
    public StrictBankAccount(final int usrID, final double balance) {
        this.usrID = usrID;
        this.balance = balance;
    }

    /**
     * @param id
     * @return true if usrID is correct.
     */
    private boolean checkUser(final int id) {
        return this.usrID == id;
    }

    /**
     * @param usrID
     */
    @Override
    public void computeManagementFees(final int usrID) {
        final double feeAmount = MANAGEMENT_FEE + (nTransactions * StrictBankAccount.TRANSACTION_FEE);
        if (checkUser(usrID) && isWithdrawAllowed(feeAmount)) {
            balance -= feeAmount;
            nTransactions = 0;
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
        this.deposit(usrID, amount - StrictBankAccount.ATM_TRANSACTION_FEE);
    }

    /**
     * 
     */
    @Override
    public double getBalance() {
        return this.balance;
    }

    /**
     * 
     */
    @Override
    public int getNTransactions() {
        return nTransactions;
    }

    /**
     * 
     */
    private void incTransactions() {
        nTransactions++;
    }

    /**
     * @param amount
     */
    private boolean isWithdrawAllowed(final double amount) {
        return balance > amount;
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
    public void withdraw(final int usrID, final double amount) {
        if (isWithdrawAllowed(amount)) {
            this.transactionOp(usrID, -amount);
        }
    }

    /**
     * @param usrID
     * @param amount
     */
    public void withdrawFromATM(final int usrID, final double amount) {
        this.withdraw(usrID, amount + StrictBankAccount.ATM_TRANSACTION_FEE);
    }
}
