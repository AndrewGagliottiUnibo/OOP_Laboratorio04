package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.BankAccount;

abstract class AbstractBankAccount implements BankAccount {

    public static final double ATM_FEE = 1;
    public static final double MANAGEMENT_FEE = 5;
    
    //metodi privati
    private final int userID;
    private double balance;
    private int nOperations;
    
    //costruttore usato soprattutto nella chiamata delle sottoclassi
    public AbstractBankAccount(final int userID, final double balance) {
        this.userID = userID;
        this.balance = balance;
        this.nOperations = 0;
    }

    //getters
    public int getUserID() {
        return this.userID;
    }

    public double getBalance() {
        return this.balance;
    }
    
    public int getNTransactions() {
        return this.nOperations;
    }
    
    //setter
    private void setBalance(double value) {
        this.balance = value;
    }
    
    private void addTransaction() {
        this.nOperations++;
    }
    
    private void resetTransactions() {
        this.nOperations = 0;
    }
    
    //metodi astratti
    protected abstract boolean isWithdrawAllowed(double value);
    
    protected abstract double computeFee();
    
  //metodi di interfaccia e implementazioni
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

    public void deposit(int usrID, double amount) {
        if(checkUser(usrID)) {
            this.balance += amount;
            this.addTransaction();
        }    
    }

    public void depositFromATM(int usrID, double amount) {
        if(checkUser(usrID)) {
            this.deposit(usrID, amount - ATM_FEE);
        }
    }

    public void withdraw(int usrID, double amount) {
        if(checkUser(usrID)) {
            this.balance -= amount;
            this.addTransaction();
        }    
    }

    public void withdrawFromATM(int usrID, double amount) {
        this.withdraw(usrID, amount + ATM_FEE);
    }
}
