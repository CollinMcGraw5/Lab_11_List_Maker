import java.util.ArrayList;

public class ListMaker {
    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = SafeInput.getRegExString("Enter your choice [AaDdIiPpQq]:", "[AaDdIiPpQq]");
            switch (choice.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm("Are you sure you want to quit? (Y/N)")) {
                        running = false;
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        System.out.println("Thank you for using the ListMaker! Goodbye.");
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("A - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    private static void addItem() {
        String item = SafeInput.getNonZeroLenString("Enter the item to add:");
        list.add(item);
        System.out.println("Item added.");
    }

    private static void deleteItem() {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        printNumberedList();
        int itemToDelete = SafeInput.getRangedInt("Enter the item number to delete:", 1, list.size());
        list.remove(itemToDelete - 1);
        System.out.println("Item deleted.");
    }

    private static void insertItem() {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Adding the first item.");
            addItem();
            return;
        }
        printNumberedList();
        int index = SafeInput.getRangedInt("Enter the position to insert at:", 1, list.size() + 1);
        String item = SafeInput.getNonZeroLenString("Enter the item to insert:");
        list.add(index - 1, item);
        System.out.println("Item inserted.");
    }

    private static void printList() {
        if (list.isEmpty()) {
            System.out.println("The list is currently empty.");
            return;
        }
        System.out.println("Current List:");
        for (String item : list) {
            System.out.println(item);
        }
    }

    private static void printNumberedList() {
        if (list.isEmpty()) {
            System.out.println("The list is currently empty.");
            return;
        }
        System.out.println("Numbered List:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ": " + list.get(i));
        }
    }
}