import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter material : ");
        int size = scanner.nextInt();
        MaterialManagerment materialManagerment = new MaterialManagerment(size);
        Material[] materials = materialManagerment.getMaterials();
        for (int i = 0; i < size; i++) {
            boolean isEven = i % 2 == 0;
            if (isEven) {
                materials[i] = new Meat("88", "pig", LocalDate.of(2021, 8, 7), 100000, 200);
            } else {
                materials[i] = new CrispyFlour("99", "rice", LocalDate.of(2021, 5, 30), 16000, 1000);
            }
        }
        System.out.println(Arrays.toString(materials));
        int choice = -1;
        do {
            menu();
            System.out.print("Enter choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    System.out.println("Enter index want delete : ");
                    int index = scanner.nextInt();
                    materials = materialManagerment.deleteMaterial(index);
                    System.out.println(Arrays.toString(materials));
                    break;
                }
                case 2: {
                    System.out.println("1: Add meat");
                    System.out.println("2: Add crispy flour");
                    System.out.println("Enter choice");
                    int choiceNumber = scanner.nextInt();
                    switch (choiceNumber){
                        case 1: {
                            System.out.println("Enter index want add meat : ");
                            int indexAddMeat= scanner.nextInt();
                            scanner.nextLine();
                            materials = materialManagerment.insertMeat(scanner, indexAddMeat);
                            System.out.println("Meat added success!! \n" +Arrays.toString(materials));
                            break;
                        }
                        case 2: {
                            System.out.println("Enter index want add crispy flour : ");
                            int indexAddCrispyFlour = scanner.nextInt();
                            scanner.nextLine();
                            materials = materialManagerment.insertCrispyFlour(scanner, indexAddCrispyFlour);
                            System.out.println(Arrays.toString(materials));
                            System.out.println("Crispy flour added success!! \n" +Arrays.toString(materials));
                            break;
                        }
                    }
                }
                case 3: {
                    System.out.println("Enter the index you want to calculate");
                    int indexCalculate = scanner.nextInt();
                    if (materials[indexCalculate] instanceof  Meat){
                        System.out.println("Initial money: " + ((Meat) materials[indexCalculate]).getMoney() + "VND");
                        System.out.println("Payment money : " + ((Meat) materials[indexCalculate]).getRealMoney() + "VND");
                        System.out.println("Difference money : " + ((Meat) materials[indexCalculate]).getDifferenceMoney() + "VND");
                    }else {
                        System.out.println("Initial money: " + ((CrispyFlour) materials[indexCalculate]).getMoney() + "VND");
                        System.out.println("Payment money : " + ((CrispyFlour) materials[indexCalculate]).getRealMoney() + "VND");
                        System.out.println("Difference money : " + ((CrispyFlour) materials[indexCalculate]).getDifferenceMoney() + "VND");
                    }
                    break;
                }
                case 0: {
                    System.exit(0);
                }
            }
        } while (choice != 0);
    }

    public static void menu() {
        System.out.println("1: Delete material");
        System.out.println("2: Add material");
        System.out.println("3: Real Money");
        System.out.println("0: Exit");
    }

}
