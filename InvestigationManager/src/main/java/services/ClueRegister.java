package services;

import model.Clue;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClueRegister {
    private List<Clue> clueList = new ArrayList<>();

    public List<Clue> getClueList() {
        return clueList;
    }

    public Clue addClue(Scanner scanner) {
        while (true) {
            boolean idExist = false;
            try {
                System.out.println("Digite o ID da pista: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                for (Clue clue : clueList) {
                    if (clue.getClueID() == id) {
                        idExist = true;
                        break;
                    }
                }
                if (idExist) {
                    System.out.println("ID já cadastrado. Cadastre um ID diferente.");
                    continue;
                }
                LocalDate date = null;
                while (date == null) {
                    try {
                        System.out.println("Digite a data em que a pista foi encontrada");
                        String textDate = scanner.nextLine();
                        date = LocalDate.parse(textDate);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de data incorreto. Utilize o formato AAAA-MM-DD");
                    }
                }
                System.out.println("Digite a descrição da pista: ");
                String description = scanner.nextLine();

                Clue clue = new Clue(id, date, description);
                clueList.add(clue);
                System.out.println("Pista registrada com sucesso.");
                return clue;

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
                scanner.nextLine();
            }
        }
    }
}
