package entities;

public class Individual extends TaxPayer{

    private double healthExpenditures;

    public Individual(String name, Double annualIncome, double healthExpenditures) {
        super(name, annualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax(){
        if(getAnnualIncome() < 20000){
            return (getAnnualIncome() * 0.15) - (healthExpenditures * 0.5);
        }else {
            return (getAnnualIncome() * 0.25) - (healthExpenditures * 0.5);
        }
    }

    public String toString() {
        return String.format("%s : $ %.2f", getName(), tax() );
    }
}
