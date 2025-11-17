package app;

import data.DataManager;
import model.Detective;
import services.Authentication;
import services.DetectiveRegister;

import java.util.Scanner;

public class NewDetectiveRegistration {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);


        DetectiveRegister register = new DetectiveRegister();
        Detective pdAdmin = new Detective("Carlos siqueira de Andrade", 45, "Delegado de polícia", 835, "andrade1234", "andrade");

        System.out.println("--- Bem-vindo ao cadastramento de novos investigadores ---");
        System.out.println("Entre com suas credenciais: ");

        if (Authentication.loginAuthentication(scanner, pdAdmin)) {
            System.out.println("Bem-vindo " + pdAdmin.getName());

            while(true) {
                System.out.println("Deseja cadastrar um novo investigador? (s/n)");
                String choice = scanner.nextLine();

                while(!choice.equalsIgnoreCase("s") && !choice.equalsIgnoreCase("n")) {
                    System.out.println("Entrada inválida. Digite 's' para sim ou 'n' para não.");
                    scanner.nextLine();
                }
                if (choice.equalsIgnoreCase("s")) {
                    register.addDetective(scanner);
                    DataManager dataManager = new DataManager();
                    dataManager.saveList(register.getDetectiveList(), "detectives.json");
                } else return;
            }
        }
    }
}
