package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] items = tracker.findAll();
                for (Item it : items) {
                    System.out.println(it.getId() + "." + it.getName());
                }
            }else if (select == 2) {
                System.out.println("=== Edit Item ====");
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Successfully");
                } else {
                    System.out.println("Failure");
                }
            }else if (select == 3) {
                System.out.println("=== Delete Item ====");
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Successfully");
                } else {
                    System.out.println("Failure");
                }
            }else if (select == 4) {
                System.out.println("=== Find item by id ====");
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.findById(id) != null) {
                    System.out.println(tracker.findById(id).toString());
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }

            }else if (select == 5) {
                System.out.println("=== Find items by name ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item it : items) {
                        System.out.println(it.toString());
                    }
                    System.out.println();
                } else {
                    System.out.println("Заявки с таким именем не найдены");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0.Add new Item.");
        System.out.println("1.Show all items.");
        System.out.println("2.Edit item.");
        System.out.println("3.Delete item.");
        System.out.println("4.Find item by id.");
        System.out.println("5.Find items by name.");
        System.out.println("6.Exit Program.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);

        //System.out.println(item.getCreated().format(DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss")));
        //System.out.println(item.toString());

    }
}
