package services;

import model.Detective;

import java.text.Normalizer;
import java.util.*;

public class DetectiveRegister {

    private List<Detective> detectiveList = new ArrayList<>();

    private Map<String, Integer> usernameCount = new HashMap<>();

    private String readName(Scanner scanner) {
        System.out.println("Digite o nome do investigador: ");
        return scanner.nextLine();
    }

    private int readBadgeNumber(Scanner scanner) {
        while (true) {
            try {
                boolean badgeExist = false;

                System.out.println("Digite o número do distintivo do detetive: ");
                int badgeNumber = scanner.nextInt();
                scanner.nextLine();

                for (Detective detective : detectiveList) {
                    if (detective.getBadgeNumber() == badgeNumber) {
                        badgeExist = true;
                        break;
                    }
                }
                if (badgeExist) {
                    System.out.println("Número de distintivo já cadastrado. Tente novamente.");
                    continue;
                }
                return badgeNumber;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.nextLine();
            }
        }
    }

    private String generateSystemUsername(String name) {
        //Get detective's last name in lowercase and without accents
        String baseUsername = generateBaseUsername(name);

        //Checks if the baseUsername already exists and if so, assigns another value (baseUsername + count)
        int count = usernameCount.getOrDefault(baseUsername, 0);
        String systemUsername = (count == 0) ? baseUsername : baseUsername + count;

        usernameCount.put(baseUsername, count + 1);

        return systemUsername;
    }

    private int readAge(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Digite a idade do detetive: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                return age;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tenta novamente");
                scanner.nextLine();
            }
        }
    }

    private String readSystemPassword(Scanner scanner) {
        String systemPassword;
        while (true) {
            System.out.println("Digite uma senha de acesso ao sistema. A senha deve ter entre 6 e 12 caracteres: ");
            systemPassword = scanner.nextLine();
            if (systemPassword.length() < 6 || systemPassword.length() > 12) {
                System.out.println("Senha inválida. A senha deve ter entre 6 e 12 caracteres. Tente novamente");
                continue;
            }
            break;
        }
        return systemPassword;
    }

    private String readDescription(Scanner scanner) {
        System.out.println("Digite a descrição do histórico profissional do detetive: ");
        return scanner.nextLine();
    }

    public Detective addDetective(Scanner scanner) {
        int badgeNumber = readBadgeNumber(scanner);
        String name = readName(scanner);
        String systemUsername = generateSystemUsername(name);
        int age = readAge(scanner);
        String systemPassword = readSystemPassword(scanner);
        String description = readDescription(scanner);

        Detective detective = new Detective(name, age, description, badgeNumber, systemPassword, systemUsername);
        detectiveList.add(detective);

        return detective;
    }

    //Generates a base username based on the detective's last name (gets detective's last name without accents and in lowercase).
    private String generateBaseUsername(String name) {
        String[] parts = name.trim().split("\\s+");
        String lastName = parts[parts.length - 1];

        String normalized = Normalizer.normalize(lastName, Normalizer.Form.NFD);
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
