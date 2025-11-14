package services;

import model.Suspect;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SuspectRegister {
    private List<Suspect> suspectList = new ArrayList<>();

    public List<Suspect> getSuspectList(){
        return suspectList;
    }

    public Suspect addSuspect(Scanner scanner) {
        while (true) {
            try {
                boolean idExist = false;

                System.out.println("Digite o ID do suspeito");
                int id = scanner.nextInt();
                scanner.nextLine();
                for (Suspect suspect : suspectList) {
                    if (suspect.getSystemID() == id) {
                        idExist = true;
                        break;
                    }
                }
                if (idExist) {
                    System.out.println("ID já cadastrado no sistema. Cadastre um ID diferente.");
                    continue;
                }
                System.out.println("Digite o nome do suspeito: ");
                String name = scanner.nextLine();

                int age = -1;
                while (age < 0) {
                    try {
                        System.out.println("Digite a idade do suspeito: ");
                        age = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Digite apenas números.");
                        scanner.nextLine();
                    }
                }
                System.out.println("Digite a descrição do suspeito: ");
                String description = scanner.nextLine();

                System.out.println("Digite o histórico criminal do suspeito: ");//TODO: Criar uma classe CriminalRecords que armazena os registros criminais dos suspeitos e adicionar aqui no lugar da String.
                String criminalRecords = scanner.nextLine();

                Suspect suspect = new Suspect(name, age, description, criminalRecords, id);
                suspectList.add(suspect);
                System.out.println("Suspeito cadastrado com sucesso.");
                return suspect;

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
                scanner.nextLine();
            }
        }
    }
}
