import java.time.LocalDate;

public class Meat extends Material implements Discount {
    private double weight;

    public Meat() {
    }

    public Meat(double weight) {
        this.weight = weight;
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getMoney() {
        return this.cost * this.weight;
    }

    @Override
    double getAmount() {
        return super.getAmount() * this.weight;
    }

    @Override
    LocalDate getExpiryDate() {
        return super.getExpiryDate().plusDays(7);
    }

    @Override
    public double getRealMoney() {
        double realCost = this.cost * 90 / 100;
        if (this.getExpiryDate().isAfter(LocalDate.now().plusDays(5))) {
            realCost = (realCost  * 70 / 100) * this.weight;
        } else {
            realCost = (realCost * 50 / 100) * this.weight;
        }
        return realCost;
    }

    public double getDifferenceMoney() {
        return this.getMoney() - this.getRealMoney();
    }


    @Override
    public String toString() {
        return "Meat{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                ", cost=" + cost +
                ", weight=" + weight +
                '}' + "\n";
    }
}
