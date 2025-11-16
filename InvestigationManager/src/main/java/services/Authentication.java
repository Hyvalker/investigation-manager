package services;

import model.Detective;

import java.util.Scanner;

public class Authentication {

    private Detective detective;

    public Authentication (Detective detective) {
        this.detective = detective;
    }

    public boolean loginAuthentication(Scanner scanner) {

        while (true) {

            System.out.println("Digite o nome de usuário: ");
            String username = scanner.nextLine();
            System.out.println("Digite a senha: ");
            int password = scanner.nextInt();
            scanner.nextLine();

            if (!detective.getSystemUsername().equalsIgnoreCase(username)) {
                System.out.println("Nome de usuário inválido. Tente novamente: ");
                continue;
            } else if (detective.getSystemPassword() != password) {
                System.out.println("Senha inválida. Tente novamente: ");
                continue;
            } else {
                System.out.println("Login efetuado com sucesso.");
                return true;
            }
        }
    }
}
