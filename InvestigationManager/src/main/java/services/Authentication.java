package services;

import model.Detective;


import java.util.List;
import java.util.Scanner;

public class Authentication {

    //Authentication method for the Police Department admin
    public static boolean loginAuthentication(Scanner scanner, Detective detective) {
        while (true) {
            System.out.println("Digite o nome de usuário: ");
            String username = scanner.nextLine();
            System.out.println("Digite a senha: ");
            String password = scanner.nextLine();

            if (!detective.getSystemUsername().equalsIgnoreCase(username)) {
                System.out.println("Nome de usuário inválido. Tente novamente: ");
                continue;
            } else if (!detective.getSystemPassword().equals(password)) {
                System.out.println("Senha inválida. Tente novamente: ");
                continue;
            } else {
                System.out.println("Login efetuado com sucesso.");
                return true;
            }
        }
    }

    //Authentication method for the Detectives on the list
    public static Detective loginAuthentication(Scanner scanner, List<Detective> detectiveList) {
        while (true) {
            System.out.println("Digite o nome de usuário: ");
            String username = scanner.nextLine();
            System.out.println("Digite a senha: ");
            String password = scanner.nextLine();

            for (Detective detective : detectiveList) {
                if (detective.getSystemUsername().equalsIgnoreCase(username) &&
                        detective.getSystemPassword().equals(password)) {
                    System.out.println("Login efetuado com sucesso.");
                    return detective;
                }
            }
            System.out.println("Credenciais inválidas. Digite 1 para tentar novamente ou digite 0 para sair: ");
            String choice = scanner.nextLine();

            while(!choice.equalsIgnoreCase("1") && !choice.equalsIgnoreCase("0")){
                System.out.println("Entrada inválida. Digite 1 para tentar novamente ou 0 para sair: ");
                choice = scanner.nextLine();
            }
            if (choice.equalsIgnoreCase("0")){
                break;
            } else {
                continue;
            }
        }
        return null;
    }
}
