package bankmanager;

/**
 * Compte Courant (CheckingAccount).
 * Hérite de BankAccount.
 * Ajoute une limite de découvert autorisé.
 */
public class CheckingAccount extends BankAccount {

    // Découvert maximum autorisé sur le compte courant
    private double limit;

    /**
     * Constructeur
     * @param account - numéro du compte
     * @param balance - solde initial
     * @param limit   - limite de découvert autorisée
     */
    public CheckingAccount(String account, double balance, double limit) {
        super(account, balance); // appel du constructeur de BankAccount
        this.limit = limit;
    }

    // ============ GETTER / SETTER ============

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        if (limit >= 0) {
            this.limit = limit;
        } else {
            System.out.println("Erreur : la limite ne peut pas être négative.");
        }
    }

    /**
     * Retrait avec prise en compte du découvert autorisé
     * @param amount - montant à retirer
     */
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= (getBalance() + limit)) {
            setBalance(getBalance() - amount);
            System.out.println("Retrait de " + amount + " FCFA effectué (découvert inclus).");
        } else {
            System.out.println("Erreur : dépasse la limite de découvert autorisé.");
        }
    }

    @Override
    public String toString() {
        return "[Compte Courant]  " + super.toString() + " | Limite découvert: " + limit + " FCFA";
    }
}