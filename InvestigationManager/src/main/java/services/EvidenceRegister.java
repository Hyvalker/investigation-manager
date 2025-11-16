package services;

import model.Evidence;
import model.EvidenceType;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EvidenceRegister {

    List<Evidence> evidenceList = new ArrayList<>();

    private static EvidenceType getEvidenceType(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Defina a categoria da evidência: ");
                System.out.println("1 - ARMA");
                System.out.println("2 - BIOLÓGICA");
                System.out.println("3 - OBJETO");
                System.out.println("4 - APARELHO DIGITAL");
                System.out.println("5 - OUTRO");
                int choice = scanner.nextInt();
                scanner.nextLine();

                return switch (choice) {
                    case 1 -> EvidenceType.WEAPON;
                    case 2 -> EvidenceType.BIOLOGICAl;
                    case 3 -> EvidenceType.OBJECT;
                    case 4 -> EvidenceType.DIGITAL_DEVICE;
                    case 5 -> EvidenceType.OTHER;
                    default -> {
                        System.out.println("Opção Inválida. Tente novamente");
                        yield null;
                    }
                };
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite apenas números de 1 a 5.");
                scanner.nextLine();
            }
        }
    }


    public Evidence addEvidence(Scanner scanner) {
        while (true) {
            boolean idExist = false;
            try {
                System.out.println("Digite o ID da evidência: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                for (Evidence evidence : evidenceList) {
                    if (evidence.getEvidenceID() == id) {
                        idExist = true;
                        break;
                    }
                }
                if (idExist) {
                    System.out.println("ID já cadastrado. Cadastre um ID diferente.");
                    continue;
                }

                System.out.println("Define o tipo de evidência");
                EvidenceType evidenceType = getEvidenceType(scanner);

                System.out.println("Digite o título da evidência: ");
                String title = scanner.nextLine();

                System.out.println("Digite a descrição da evidência: ");
                String description = scanner.nextLine();


                Evidence evidence = new Evidence(id, title, description, evidenceType);
                evidenceList.add(evidence);
                System.out.println("Evidência registrada com sucesso.");

                return evidence;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
                scanner.nextLine();
            }
        }
    }
}
