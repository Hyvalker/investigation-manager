package app;

import model.Detective;

import java.util.Scanner;

public class NewDetectiveRegistration {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        Detective pdAdmin = new Detective();
        pdAdmin.setName("Carlos Siqueira de Andrade");
        pdAdmin.setAge(45);
        pdAdmin.setDescription("Delegado de polícia");
        pdAdmin.setBadgeNumber(835);
        pdAdmin.setSystemPassword(8295);
        pdAdmin.setSystemUsername("andrade");

        System.out.println("--- Bem vindo ao cadastramento de novos investigadores ---");
        System.out.println("Entre com seus dados de login: ");
        System.out.println("Login: ");
        String login = scanner.nextLine();
        System.out.println("Senha: ");
        int password = scanner.nextInt();



    }
}
