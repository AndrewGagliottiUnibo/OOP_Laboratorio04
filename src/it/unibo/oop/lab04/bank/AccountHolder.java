package it.unibo.oop.lab04.bank;

public class AccountHolder {

    private final String name;
    private final String surname;
    private final int userID;

    public AccountHolder(final String name, final String surname, final int accountID) {
        this.name = name;
        this.surname = surname;
        this.userID = accountID;
    }

    /**
     * @return the name of the account holder.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the surname of the account holder.
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * @return the ID of the account holder.
     */
    public int getUserID() {
        return this.userID;
    }

    /**
     * @return all data
     */
    public String toString() {
        return "AccountHolder [name=" + name + ", surname=" + surname + ", userID=" + userID + "]";
    }
}
