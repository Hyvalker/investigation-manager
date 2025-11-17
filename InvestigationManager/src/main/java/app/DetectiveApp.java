package app;

import data.DataManager;
import model.Detective;
import services.*;

import java.util.List;
import java.util.Scanner;

public class DetectiveApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DataManager dataManager = new DataManager();

        DetectiveRegister detectiveRegister = new DetectiveRegister();
        ClueRegister clueRegister = new ClueRegister();
        SuspectRegister suspectRegister = new SuspectRegister();
        EvidenceRegister evidenceRegister = new EvidenceRegister();
        CaseRegister caseRegister = new CaseRegister(suspectRegister, clueRegister, evidenceRegister, detectiveRegister);

        System.out.println("--- Sistema Criminal ---");
        System.out.println("Entre com suas credênciais: ");
        List<Detective> detectiveList = dataManager.loadList("detectives.json", Detective.class);
        Detective loggedDetective = Authentication.loginAuthentication(scanner, detectiveList);

        if (loggedDetective != null) {
            while(true) {
                System.out.println("\n--- Bem-vindo detetive " + loggedDetective.getName() + " ---");
                System.out.println("\nO que deseja acessar? \n");
                System.out.println("1 - Cadastrar novo caso");
                System.out.println("2 - Acessar relatório de caso");
                System.out.println("3 - Cadastrar nova pista");
                System.out.println("4 - Cadastrar novo supeito");
                System.out.println("5 - Cadastrar nova evidência");
                System.out.println("0 - Sair");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0 -> {
                        return;
                    }
                    case 1 -> caseRegister.addCase(scanner);
                    case 2 -> caseRegister.showCaseReports(scanner);
                    case 3 -> clueRegister.addClue(scanner);
                    case 4 -> suspectRegister.addSuspect(scanner);
                    case 5 -> evidenceRegister.addEvidence(scanner);
                    default -> System.out.println("Entrada inválida. Digite uma opção de 1 a 5 ou digite 0 para sair");
                }
            }
        }else {
            System.out.println("Falha de autenticação. Encerrando o programa.");
        }
        scanner.close();
    }
}
