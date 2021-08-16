import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount material : ");
        int size = scanner.nextInt();
        MaterialManagement materialManagement = new MaterialManagement(size);
        Material[] materials = materialManagement.getMaterials();
        initMaterial(size, materials);
        System.out.println(Arrays.toString(materials));
        int choice;
        choiceMenu(scanner, materialManagement, materials);
    }

    private static void choiceMenu(Scanner scanner, MaterialManagement materialManagement, Material[] materials) {
        int choice;
        do {
            menu();
            System.out.print("Enter choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    materials = deleteInfo(scanner, materialManagement);
                    break;
                }
                case 2: {
                    materials = runSubMenu(scanner, materialManagement, materials);
                    break;
                }
                case 3: {
                    calculatorMoney(scanner, materials);
                    break;
                }
                case 0: {
                    System.exit(0);
                }
                default: {
                    System.out.println("Not found!! Please re-enter!!");
                }
            }
        } while (choice != 0);
    }

    private static void calculatorMoney(Scanner scanner, Material[] materials) {
        System.out.println("Enter the index you want to calculate");
        int indexCalculate = scanner.nextInt();
        if (materials[indexCalculate] instanceof Meat) {
            displayMoneyOfMeat(materials[indexCalculate]);
        } else {
            displayMoneyOfCrispyFlour(materials[indexCalculate]);
        }
    }

    private static Material[] deleteInfo(Scanner scanner, MaterialManagement materialManagement) {
        Material[] materials;
        System.out.println("Enter index want delete : ");
        int index = scanner.nextInt();
        materials = materialManagement.deleteMaterial(index);
        System.out.println(Arrays.toString(materials));
        return materials;
    }

    private static Material[] runSubMenu(Scanner scanner, MaterialManagement materialManagement, Material[] materials) {
        System.out.println("1: Add meat");
        System.out.println("2: Add crispy flour");
        System.out.println("Enter choice");
        int choiceNumber = scanner.nextInt();
        switch (choiceNumber) {
            case 1: {
                materials = addMeat(scanner, materialManagement);
                break;
            }
            case 2: {
                materials = addCrispyFlour(scanner, materialManagement);
                break;
            }
        }
        return materials;
    }

    private static void initMaterial(int size, Material[] materials) {
        for (int i = 0; i < size; i++) {
            boolean isEven = i % 2 == 0;
            if (isEven) {
                materials[i] = new Meat("88", "pig", LocalDate.of(2021, 8, 7), 100000, 200);
            } else {
                materials[i] = new CrispyFlour("99", "rice", LocalDate.of(2021, 5, 30), 16000, 1000);
            }
        }
    }

    private static void displayMoneyOfCrispyFlour(Material material) {
        System.out.println("Initial money: " + ((CrispyFlour) material).getMoney() + "VND");
        System.out.println("Payment money : " + ((CrispyFlour) material).getRealMoney() + "VND");
        System.out.println("Difference money : " + ((CrispyFlour) material).getDifferenceMoney() + "VND");
    }

    private static void displayMoneyOfMeat(Material material) {
        System.out.println("Initial money: " + ((Meat) material).getMoney() + "VND");
        System.out.println("Payment money : " + ((Meat) material).getRealMoney() + "VND");
        System.out.println("Difference money : " + ((Meat) material).getDifferenceMoney() + "VND");
    }

    private static Material[] addMeat(Scanner scanner, MaterialManagement materialManagement) {
        Material[] materials;
        System.out.println("Enter index want add meat : ");
        int indexAddMeat = scanner.nextInt();
        scanner.nextLine();
        materials = materialManagement.insertMeat(scanner, indexAddMeat);
        System.out.println("Meat added success!! \n" + Arrays.toString(materials));
        return materials;
    }

    private static Material[] addCrispyFlour(Scanner scanner, MaterialManagement materialManagement) {
        Material[] materials;
        System.out.println("Enter index want add crispy flour : ");
        int indexAddCrispyFlour = scanner.nextInt();
        scanner.nextLine();
        materials = materialManagement.insertCrispyFlour(scanner, indexAddCrispyFlour);
        System.out.println(Arrays.toString(materials));
        System.out.println("Crispy flour added success!! \n" + Arrays.toString(materials));
        return materials;
    }

    public static void menu() {
        System.out.println("1: Delete material");
        System.out.println("2: Add material");
        System.out.println("3: Real Money");
        System.out.println("0: Exit");
    }
}