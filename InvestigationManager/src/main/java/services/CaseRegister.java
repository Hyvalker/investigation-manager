package services;

import model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CaseRegister {
    private List<Case> caseList = new ArrayList<>();

    private SuspectRegister suspectRegister;

    private ClueRegister clueRegister;

    private EvidenceRegister evidenceRegister;

    public CaseRegister(SuspectRegister suspectRegister, ClueRegister clueRegister, EvidenceRegister evidenceRegister) {
        this.suspectRegister = suspectRegister;
        this.clueRegister = clueRegister;
        this.evidenceRegister = evidenceRegister;
    }

    public List<Case> getCaseList() {
        return caseList;
    }

    //Sets the current status of the case.
    private static Status getStatus(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Defina o status atual do caso: ");
                System.out.println("1 - Em andamento");
                System.out.println("2 - Resolvido");
                System.out.println("3 - Arquivado");
                int choice = scanner.nextInt();
                scanner.nextLine();

                return switch (choice) {
                    case 1 -> Status.ONGOING;
                    case 2 -> Status.SOLVED;
                    case 3 -> Status.ARCHIVED;
                    default -> {
                        System.out.println("Opção inválida. Tente novamente.");
                        yield null;
                    }
                };

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite 1, 2 ou 3.");
                scanner.nextLine();
            }
        }
    }

    public void addCase(Scanner scanner) {
        System.out.println("Digite o título do caso: ");
        String title = scanner.nextLine();

        System.out.println("Digite a descrição do caso: ");
        String description = scanner.nextLine();

        System.out.println("Define o status de andamento do caso: ");
        Status status = getStatus(scanner);

        Case newCase = new Case(title, description, status);

        while (true) {
            System.out.println("Deseja adicionar um suspeito ao caso? (s/n)");
            String answer = scanner.nextLine();
            while (!answer.equalsIgnoreCase("s") && !answer.equalsIgnoreCase("n")) {
                System.out.println("Entrada inválida. Digite 's' para sim ou 'n' para não.");
                answer = scanner.nextLine();
            }
            if (answer.equalsIgnoreCase("n")) break;

            Suspect newSuspect = suspectRegister.addSuspect(scanner);
            newCase.addSuspect(newSuspect);
        }
        while (true) {
            System.out.println("Deseja adicionar uma pista ao caso? (s/n)");
            String answer = scanner.nextLine();
            while (!answer.equalsIgnoreCase("s") && !answer.equalsIgnoreCase("n")) {
                System.out.println("Entrada inválida. Digite 's' para sim ou 'n' para não.");
                answer = scanner.nextLine();
            }
            if (answer.equalsIgnoreCase("n")) break;

            Clue newClue = clueRegister.addClue(scanner);
            newCase.addClue(newClue);
        }
        while (true) {
            System.out.println("Deseja adicionar uma nova evidência ao caso? (s/n)");
            String answer = scanner.nextLine();
            while (!answer.equalsIgnoreCase("s") && !answer.equalsIgnoreCase("n")) {
                System.out.println("Entrada inválida. Digite 's' para sim ou 'n' para não.");
                answer = scanner.nextLine();
            }
            if (answer.equalsIgnoreCase("n")) break;

            Evidence newEvidence = evidenceRegister.addEvidence(scanner);
            newCase.addEvidence(newEvidence);
        }
        caseList.add(newCase);
        System.out.println("Caso adicionado com sucesso.");
    }
}
