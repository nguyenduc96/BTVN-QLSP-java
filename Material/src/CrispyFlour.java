import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount {
    private double quantity;

    public CrispyFlour() {
    }

    public CrispyFlour(double quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, double quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getMoney() {
        return this.cost * this.quantity;
    }

    @Override
    double getAmount() {
        return super.getAmount() * this.quantity;
    }

    @Override
    public LocalDate getExpiryDate() {
        return super.getExpiryDate().plusYears(1);
    }

    @Override
    public double getRealMoney() {
        double realCost = this.cost * 95 / 100;
        if (this.getExpiryDate().isAfter(LocalDate.now().plusMonths(4))) {
            realCost = (realCost * 80 / 100) * this.quantity;
        } else {
            realCost = (realCost * 60 / 100) * this.quantity;
        }
        return realCost;
    }

    public double getDifferenceMoney() {
        return this.getMoney() - this.getRealMoney();
    }

    @Override
    public String toString() {
        return "CrispyFlour{" +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                ", cost=" + cost +
                "quantity=" + quantity +
                '}' + "\n";
    }
}
