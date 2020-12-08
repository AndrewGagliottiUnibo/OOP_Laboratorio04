package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.BankAccount;

abstract class AbstractBankAccount implements BankAccount {

    public static final double ATM_FEE = 1;
    public static final double MANAGEMENT_FEE = 5;

    private final int userID;
    private double balance;
    private int nOperations;

    /**
     * constructor.
     * @param userID
     * @param balance
     */
    AbstractBankAccount(final int userID, final double balance) {
        this.userID = userID;
        this.balance = balance;
        this.nOperations = 0;
    }

    public int getUserID() {
        return this.userID;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getNTransactions() {
        return this.nOperations;
    }

    private void setBalance(final double value) {
        this.balance = value;
    }

    private void addTransaction() {
        this.nOperations++;
    }

    private void resetTransactions() {
        this.nOperations = 0;
    }

    protected abstract boolean isWithdrawAllowed(double value);
    protected abstract double computeFee();


    protected boolean checkUser(final int id) {
        return this.getUserID() == id;
    }

    public void computeManagementFees(final int usrID) {
        final double taxAmount = this.computeFee();

        if (this.checkUser(usrID) && isWithdrawAllowed(taxAmount)) {
            this.setBalance(this.getBalance() - taxAmount);
            this.resetTransactions();
        }
    }

    public void deposit(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.balance += amount;
            this.addTransaction();
        }
    }

    public void depositFromATM(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.deposit(usrID, amount - ATM_FEE);
        }
    }

    public void withdraw(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.balance -= amount;
            this.addTransaction();
        }
    }

    public void withdrawFromATM(final int usrID, final double amount) {
        this.withdraw(usrID, amount + ATM_FEE);
    }
}
