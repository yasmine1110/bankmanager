package bankmanager;

/**
 * Compte Épargne (SavingsAccount).
 * Hérite de BankAccount.
 * Ajoute un plafond de dépôt et un taux d'intérêt annuel.
 */
public class SavingsAccount extends BankAccount {

    // Plafond maximum du compte épargne
    private double limit;

    // Taux d'intérêt annuel (ex: 0.035 = 3.5%)
    private double interestRate;

    /**
     * Constructeur
     * @param account      - numéro du compte
     * @param balance      - solde initial
     * @param limit        - plafond du compte épargne
     * @param interestRate - taux d'intérêt annuel
     */
    public SavingsAccount(String account, double balance, double limit, double interestRate) {
        super(account, balance);
        this.limit = limit;
        this.interestRate = interestRate;
    }

    // ============ GETTERS / SETTERS ============

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Calcule et applique les intérêts annuels sur le solde
     */
    public void applyInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
        System.out.println("Intérêts appliqués : +" + interest + " FCFA");
    }

    /**
     * Dépôt avec vérification du plafond
     */
    @Override
    public void deposit(double amount) {
        if (getBalance() + amount <= limit) {
            super.deposit(amount);
        } else {
            System.out.println("Erreur : dépôt dépasse le plafond de " + limit + " FCFA.");
        }
    }

    @Override
    public String toString() {
        return "[Compte Épargne]   " + super.toString()
                + " | Plafond: " + limit + " FCFA"
                + " | Taux: " + (interestRate * 100) + "%";
    }
}