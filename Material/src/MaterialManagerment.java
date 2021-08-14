import java.time.LocalDate;
import java.util.Scanner;

public class MaterialManagerment {
    private Material[] materials;

    public MaterialManagerment() {
    }

    public MaterialManagerment(int size) {
        this.materials = new Material[size];
    }

    public Material[] getMaterials() {
        return materials;
    }

    public void setMaterials(Material[] materials) {
        this.materials = materials;
    }

    public Material[] deleteMaterial(int index) {
        Material[] newMaterials = new Material[this.materials.length - 1];
        for (int i = 0; i < newMaterials.length; i++) {
            if (i < index) {
                newMaterials[i] = this.materials[i];
            } else {
                newMaterials[i] = this.materials[i + 1];
            }
        }
        return newMaterials;
    }

    public Material[] insertMeat(Scanner scanner, int index) {
        Material[] newMaterial = new Material[this.materials.length + 1];
        for (int i = 0; i < newMaterial.length; i++) {
            if (i < index) {
                newMaterial[i] = this.materials[i];
            } else if (i == index) {
                System.out.println("MEAT INFOMATION");
                System.out.print("Enter id material meat : ");
                String id = scanner.nextLine();
                System.out.print("Enter name material meat : ");
                String name = scanner.nextLine();
                System.out.println("Enter manufacturing date : ");
                System.out.print("Enter year : ");
                int year = scanner.nextInt();
                System.out.print("Enter month : ");
                int month = scanner.nextInt();
                System.out.print("Enter day : ");
                int day = scanner.nextInt();
                LocalDate manufacturingDate = LocalDate.of(year, month, day);
                System.out.print("Enter meat cost : ");
                int cost = scanner.nextInt();
                System.out.print("Enter meat weight : ");
                double weight = scanner.nextDouble();
                newMaterial[index] = new Meat(id, name, manufacturingDate, cost, weight);
            } else {
                newMaterial[i] = this.materials[i - 1];
            }
        }
        return newMaterial;
    }

    public Material[] insertCrispyFlour(Scanner scanner, int index) {
        Material[] newMaterial = new Material[this.materials.length + 1];
        for (int i = 0; i < newMaterial.length; i++) {
            if (i < index) {
                newMaterial[i] = this.materials[i];
            } else if (i == index) {
                System.out.println("CRISPY FLOUR INFOMATION");
                System.out.print("Enter id material crispy flour : ");
                String id = scanner.nextLine();
                System.out.print("Enter name material crispy flour : ");
                String name = scanner.nextLine();
                System.out.println("Enter manufacturing date : ");
                System.out.print("Enter year : ");
                int year = scanner.nextInt();
                System.out.print("Enter month : ");
                int month = scanner.nextInt();
                System.out.print("Enter day : ");
                int day = scanner.nextInt();
                LocalDate manufacturingDate = LocalDate.of(year, month, day);
                System.out.print("Enter crispy flour cost : ");
                int cost = scanner.nextInt();
                System.out.print("Enter crispy flour quantity: ");
                double quantity = scanner.nextDouble();
                newMaterial[index] = new CrispyFlour(id, name, manufacturingDate, cost, quantity);
            } else {
                newMaterial[i] = this.materials[i - 1];
            }
        }
        return newMaterial;
    }
}
