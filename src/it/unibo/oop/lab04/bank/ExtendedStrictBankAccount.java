package it.unibo.oop.lab04.bank;

public class ExtendedStrictBankAccount extends SimpleBankAccount {
    
    //definisco una costante di pagamento di transazione
    private static final double TAX_PAYMENT = 0.1;
    
    //costruttore - richiamo il costruttore della superclasse
    public ExtendedStrictBankAccount(final int usrID, final double balance) {
        super(usrID, balance);
    }
    
    //override dei metodi della superclasse
    public void computeManagementFees(final int usrID) {
        final double taxAmount = MANAGEMENT_FEE + (super.getNTransactions() * TAX_PAYMENT);
        
        if (super.checkUser(usrID) && this.isWithdrawAllowed(taxAmount)) {
            super.setBalance(super.getBalance() - taxAmount);
            super.resetTransactions();
        }
    }
    
    //creo un metodo per controllare la possibilità di prelevare
    private boolean isWithdrawAllowed(final double amount) {
        return super.getBalance() > amount;
    }
    
    //override metodo per prelevare basato sulla condizione precedente
    public void withdraw(final int usrID, final double amount) {
        if (this.isWithdrawAllowed(amount)) {
            super.withdraw(usrID, amount);
        }
    }
    
  //override metodo per prelevare da ATM basato sulla condizione precedente
    public void withdrawFromATM(final int usrID, final double amount) {
        if (this.isWithdrawAllowed(amount)) {
            super.withdrawFromATM(usrID, amount + ATM_TRANSACTION_FEE);
        }
    }
}
