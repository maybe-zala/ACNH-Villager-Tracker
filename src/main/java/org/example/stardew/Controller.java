package org.example.stardew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class Controller implements CommandLineRunner {

    @Autowired
    private CharacterDao dao;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("⊹ ࣪ ˖welcome to the animal crossing character tracker!˖࣪ ⊹");
            System.out.println("please choose an option below:");
            System.out.println("1. view all");
            System.out.println("2. add");
            System.out.println("3. view one");
            System.out.println("4. update");
            System.out.println("5. delete");
            System.out.println("6. exit");
            System.out.print("option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                for (Characters c : dao.findAll()) {
                    System.out.println(c.getId() + ". " + c.getName()
                            + " | " + c.getGender()
                            + " | " + c.getBday()
                            + " | " + c.getColor()
                            + " | " + c.getHobby());
                }
            }
            else if (choice == 2) {
                System.out.print("name: ");
                String name = scanner.nextLine();
                System.out.print("gender: ");
                String gender = scanner.nextLine();
                System.out.print("birthday: ");
                String bday = scanner.nextLine();
                System.out.print("color: ");
                String color = scanner.nextLine();
                System.out.print("hobby: ");
                String hobby = scanner.nextLine();

                Characters c = new Characters();
                c.setName(name);
                c.setGender(gender);
                c.setBday(bday);
                c.setColor(color);
                c.setHobby(hobby);
                dao.save(c);
                System.out.println("⊹ added! ⊹");
            }
            else if (choice == 3) {
                System.out.print("id: ");
                Long id = scanner.nextLong();
                Characters c = dao.findById(id).orElse(null);
                if (c != null) {
                    System.out.println(c.getName() + " | " + c.getGender() + " | " + c.getBday() + " | " + c.getColor() + " | " + c.getHobby());
                }
            }
            else if (choice == 4) {
                System.out.print("id: ");
                Long id = scanner.nextLong();
                Characters c = dao.findById(id).orElse(null);
                if (c != null) {
                    System.out.print("new name: ");
                    scanner.nextLine();
                    c.setName(scanner.nextLine());
                    dao.save(c);
                    System.out.println("⊹ updated! ⊹");
                }
            }
            else if (choice == 5) {
                System.out.print("id: ");
                Long id = scanner.nextLong();
                dao.deleteById(id);
                System.out.println("⊹ deleted! ⊹");
            }
            else if (choice == 6) {
                running = false;
            }
        }
    }
}
