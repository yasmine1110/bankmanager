package bankmanager;

/**
 * Classe principale - Point d'entrée de l'application BankManager.
 * Teste toutes les classes et leurs fonctionnalités.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("        BANK MANAGER - DÉMONSTRATION   ");
        System.out.println("========================================\n");

        // ---- COMPTE COURANT ----
        System.out.println("--- Compte Courant ---");
        CheckingAccount checking = new CheckingAccount("CC-001", 150000, 50000);
        System.out.println(checking);

        checking.deposit(20000);           // dépôt normal
        checking.withdraw(200000);         // retrait avec découvert
        checking.withdraw(300000);         // dépasse la limite -> erreur

        // Modification et lecture des attributs
        checking.setAccount("CC-001-V2");
        checking.setBalance(100000);
        System.out.println("Après modification : " + checking.getAccount()
                + " | Solde : " + checking.getBalance() + " FCFA\n");

        // ---- COMPTE ÉPARGNE ----
        System.out.println("--- Compte Épargne ---");
        SavingsAccount savings = new SavingsAccount("CE-002", 500000, 2000000, 0.035);
        System.out.println(savings);

        savings.deposit(300000);           // dépôt dans la limite
        savings.applyInterest();           // application des intérêts
        savings.deposit(2000000);          // dépasse le plafond -> erreur

        System.out.println("Numéro : " + savings.getAccount()
                + " | Solde : " + savings.getBalance() + " FCFA\n");

        // ---- CERTIFICAT DE DÉPÔT ----
        System.out.println("--- Certificat de Dépôt ---");
        COD cod = new COD("COD-003", 1000000, 500000, 12, 0.05);
        System.out.println(cod);

        cod.withdraw(100000);              // retrait bloqué -> erreur
        cod.deposit(200000);               // dépôt autorisé

        System.out.println("Solde final : " + cod.getBalance() + " FCFA");
        System.out.println("Gain à l'échéance : "
                + String.format("%.2f", cod.calculateMaturityAmount()) + " FCFA\n");

        System.out.println("========================================");
        System.out.println("             FIN DU PROGRAMME          ");
        System.out.println("========================================");
    }
}