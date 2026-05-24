package bankmanager;

/**
 * Certificat de Dépôt (COD - Certificate of Deposit).
 * Hérite de BankAccount.
 * Dépôt bloqué sur une durée fixe avec un taux d'intérêt garanti.
 */
public class COD extends BankAccount {

    // Montant minimum requis pour ouvrir le certificat
    private double limit;

    // Durée du certificat en mois
    private int durationMonths;

    // Taux d'intérêt annuel garanti
    private double interestRate;

    /**
     * Constructeur
     * @param account        - numéro du compte
     * @param balance        - montant déposé
     * @param limit          - montant minimum requis
     * @param durationMonths - durée en mois
     * @param interestRate   - taux d'intérêt annuel
     */
    public COD(String account, double balance, double limit, int durationMonths, double interestRate) {
        super(account, balance);
        this.limit = limit;
        this.durationMonths = durationMonths;
        this.interestRate = interestRate;
    }

    // ============ GETTERS / SETTERS ============

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Calcule le gain total à l'échéance du certificat
     * @return montant final avec intérêts
     */
    public double calculateMaturityAmount() {
        return getBalance() * (1 + interestRate * durationMonths / 12.0);
    }

    /**
     * Le retrait est bloqué sur un COD
     */
    @Override
    public void withdraw(double amount) {
        System.out.println("Erreur : retrait impossible, le certificat est bloqué pendant " + durationMonths + " mois.");
    }

    @Override
    public String toString() {
        return "[Certificat Dépôt] " + super.toString()
                + " | Limite: " + limit + " FCFA"
                + " | Durée: " + durationMonths + " mois"
                + " | Taux: " + (interestRate * 100) + "%"
                + " | À l'échéance: " + String.format("%.2f", calculateMaturityAmount()) + " FCFA";
    }
}