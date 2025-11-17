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

    private DetectiveRegister detectiveRegister;

    private AssignedDetective assignedDetective;



    public CaseRegister(SuspectRegister suspectRegister, ClueRegister clueRegister, EvidenceRegister evidenceRegister, DetectiveRegister detectiveRegister) {
        this.suspectRegister = suspectRegister;
        this.clueRegister = clueRegister;
        this.evidenceRegister = evidenceRegister;
        this.detectiveRegister = detectiveRegister;
    }

    public List<Case> getCaseList() {
        return caseList;
    }

    /**
     * Sets the current status of the case between ONGOING, SOLVED or ARCHIVED
     * It is used to assign the chosen status option to the Case
     * @param scanner Scanner to get user's input
     * @return the chosen status option (ONGOING, SOLVED or ARCHIVED)
     */
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

    /**
     * Creates a new case with title, description, status and associates it with related objects.
     * The case is added to the internal lists of cases (caseList).
     * @param scanner Scanner is used to get user's input
     */
    public void addCase(Scanner scanner) {
        int id;
        while (true) {
            boolean idExist = false;
            try {
                System.out.println("Digite o ID do caso: ");
                id = scanner.nextInt();
                scanner.nextLine();

                for (Case c : caseList) {
                    if (c.getId() == id) {
                        idExist = true;
                        break;
                    }
                }
                if (idExist) {
                    System.out.println("ID já cadastrado. Cadastre um ID diferente.");
                    continue;
                } break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente");
                scanner.nextLine();
            }
        }
        System.out.println("Digite o título do caso: ");
        String title = scanner.nextLine();

        System.out.println("Digite a descrição do caso: ");
        String description = scanner.nextLine();

        Status status = getStatus(scanner);

        Case newCase = new Case(title, description, status, id);

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
            System.out.println("Deseja adicionar uma evidência ao caso? (s/n)");
            String answer = scanner.nextLine();
            while (!answer.equalsIgnoreCase("s") && !answer.equalsIgnoreCase("n")) {
                System.out.println("Entrada inválida. Digite 's' para sim ou 'n' para não.");
                answer = scanner.nextLine();
            }
            if (answer.equalsIgnoreCase("n")) break;

            Evidence newEvidence = evidenceRegister.addEvidence(scanner);
            newCase.addEvidence(newEvidence);
        }
        do {
            System.out.println("Designe um detetive ao caso: ");
            AssignedDetective newAssignedDetective = detectiveRegister.assignDetective(scanner);
            newCase.addAssignedDetective(newAssignedDetective);

            System.out.println("Deseja designar mais um detetive ao caso? (s/n)");
            String answer = scanner.nextLine();

            while (!answer.equalsIgnoreCase("s") && !answer.equalsIgnoreCase("n")) {
                System.out.println("Entrada inválida. Digite 's' para sim ou 'n' para não.");
                answer = scanner.nextLine();
            }
            if (answer.equalsIgnoreCase("n")) break;
        } while (true);

        caseList.add(newCase);
        System.out.println("Caso adicionado com sucesso.");
    }

    public void showCaseReports(Scanner scanner) {
        System.out.println("Digite o ID do case que deseja acessar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Case foundCase = null;
        for (Case c : caseList) {
            if (c.getId() == id) {
                foundCase = c;
                break;
            }
        }
        if (foundCase == null) {
            System.out.println("Nenhum caso encontrado com o ID informado.");
            return;
        }
        System.out.println("--- Detalhes do Caso ---");
        System.out.println("ID: " + foundCase.getId());
        System.out.println("Título :" + foundCase.getTitle());
        System.out.println("Descrição: " + foundCase.getDescription());
        System.out.println("Status: " + foundCase.getStatus());
        System.out.println("\n--- Suspeitos ---");
        for (Suspect suspect : foundCase.getSuspectList()) {
            System.out.println("- " + suspect.getName() + " (" + suspect.getDescription()+ ")");
        }

        System.out.println("\n--- Pistas ---");
        for (Clue clue : foundCase.getClueList()) {
            System.out.println("- " + clue.getDescription());
        }

        System.out.println("\n--- Evidências ---");
        for (Evidence evidence : foundCase.getEvidenceList()) {
            System.out.println("- " + evidence.getDescription());
        }

        System.out.println("\n--- Detetives designados ao caso ---");
        for (AssignedDetective assignedDetective : foundCase.getAssignedDetectiveList()) {
            System.out.println("- " + assignedDetective.getName() + " - distintivo: " + assignedDetective.getBadgeNumber());
        }
    }
}
