package bankmanager;

/**
 * Classe parent représentant un compte bancaire de base.
 * Contient les attributs communs à tous les types de comptes.
 */
public class BankAccount {

    // Numéro unique du compte bancaire
    private String account;

    // Solde disponible sur le compte
    private double balance;

    /**
     * Constructeur principal
     * @param account - numéro du compte
     * @param balance - solde initial
     */
    public BankAccount(String account, double balance) {
        this.account = account;
        this.balance = balance;
    }

    // ============ GETTERS ============

    public String getAccount() {
        return account;
    }

    public double getBalance() {
        return balance;
    }

    // ============ SETTERS ============

    public void setAccount(String account) {
        this.account = account;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Erreur : le solde ne peut pas être négatif.");
        }
    }

    /**
     * Déposer de l'argent sur le compte
     * @param amount - montant à déposer
     */
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Dépôt de " + amount + " FCFA effectué.");
        } else {
            System.out.println("Erreur : montant invalide.");
        }
    }

    /**
     * Retirer de l'argent du compte
     * @param amount - montant à retirer
     */
    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Retrait de " + amount + " FCFA effectué.");
        } else {
            System.out.println("Erreur : fonds insuffisants ou montant invalide.");
        }
    }

    /**
     * Affichage des informations du compte
     */
    @Override
    public String toString() {
        return "Compte: " + account + " | Solde: " + balance + " FCFA";
    }
}