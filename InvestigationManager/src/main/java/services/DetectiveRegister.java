package services;

import model.Detective;

import java.text.Normalizer;
import java.util.*;

public class DetectiveRegister {

    private List<Detective> detectiveList = new ArrayList<>();

    private Map<String, Integer> usernameCount = new HashMap<>();


    public Detective addDetective(Scanner scanner) {
        while (true) {
            try {
                boolean badgeExist = false;
                //Assigns a badge number to the detective
                System.out.println("Digite o número do distintivo do detetive: ");
                int badgeNumber = scanner.nextInt();
                scanner.nextLine();
                //Checks if badge number is already assigned to another detective.
                for(Detective detective : detectiveList) {
                    if (detective.getBadgeNumber() == badgeNumber) {
                        badgeExist = true;
                        break;
                    }
                }
                if (badgeExist) {
                    System.out.println("Número de distintivo já cadastrado. Cadastre um número diferente.");
                    continue;
                }
                //Get detective's full name.
                System.out.println("Digite o nome completo do detetive: ");
                String name = scanner.nextLine();

                //Get detective's last name in lowercase and without accents
                String baseUsername = generateBaseUsername(name);

                //Checks if the baseUsername already exists and if so, assigns another value (baseUsername + count)
                int count = usernameCount.getOrDefault(baseUsername, 0);
                String systemUsername = (count == 0) ? baseUsername : baseUsername + count;

                usernameCount.put(baseUsername, count + 1);

                //Get detective's age.
                System.out.println("Digite a idade do detetive: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                //Assigns a password for the detective.
                System.out.println("Digite a senha de acesso ao sistema: ");
                int systemPassword = scanner.nextInt();

                //Gets detective's professional history.
                System.out.println("Digite a descrição do histórico profissional do detetive: ");
                String description = scanner.nextLine();

                //Inicializes detective and adds it to detectiveList.
                Detective detective = new Detective(name, age, description, badgeNumber, systemPassword, systemUsername);
                detectiveList.add(detective);

                return detective;

            } catch(InputMismatchException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
                scanner.nextLine();
            }
        }
    }

    //Generates a base username based on the detective's last name (gets detective's last name without accents and in lowercase).
    private String generateBaseUsername(String name){
        String[] parts = name.trim().split("\\s+");
        String lastName = parts[parts.length - 1];

        String normalized = Normalizer.normalize(name, Normalizer.Form.NFD);
        String withoutAccents = normalized.replaceAll("\\p{M}", "");

        return withoutAccents.toLowerCase();
    }

    public List<Detective> getDetectiveList() {
        return detectiveList;
    }

    public Map<String, Integer> getUsernameCount() {
        return usernameCount;
    }
}
