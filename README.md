# BankManager

Application Java de gestion de comptes bancaires développée dans le cadre d'un exercice de Programmation Orientée Objet (POO).

## Description

BankManager permet de modéliser et gérer différents types de comptes bancaires.
Le projet illustre les concepts fondamentaux de la POO en Java : l'héritage, l'encapsulation, le polymorphisme et les constructeurs.

## Structure du projet

src/bankmanager/
- BankAccount.java      : Classe parent (compte de base)
- CheckingAccount.java  : Compte courant (avec découvert)
- SavingsAccount.java   : Compte épargne (avec intérêts)
- COD.java              : Certificat de dépôt (bloqué)
- Main.java             : Point d'entrée du programme

## Fonctionnalités

- BankAccount : dépôt, retrait, lecture et modification du solde et du numéro de compte
- CheckingAccount : retrait avec découvert autorisé jusqu'à la limite définie
- SavingsAccount : plafond de dépôt et application automatique des intérêts
- COD : dépôt bloqué sur une durée fixe, calcul du montant à l'échéance, retrait interdit

## Prérequis

- Java JDK 11 ou supérieur
- IntelliJ IDEA (recommandé)

## Exécution

Compiler : javac -d out src/bankmanager/*.java
Exécuter : java -cp out bankmanager.Main

## Concepts POO illustrés

- Héritage : CheckingAccount, SavingsAccount et COD étendent BankAccount
- Encapsulation : attributs privés avec getters et setters
- Polymorphisme : méthode withdraw() redéfinie dans chaque classe enfant
- Constructeurs : appel de super(account, balance) depuis les classes enfants

## Auteur

Projet réalisé dans le cadre du cours de Programmation Orientée Objet (POO) en Java.
