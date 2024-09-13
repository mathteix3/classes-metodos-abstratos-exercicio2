package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<TaxPayer> taxPayerList = new ArrayList<TaxPayer>();

        System.out.print("Enter the number of taz payers: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nTaz payer #" + (i+1) + " data: ");
            System.out.print("Individual or company (i/c): ");
            char typeTax = scanner.next().charAt(0);
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Annual income: ");
            double annualIncome = scanner.nextDouble();

            if(typeTax == 'i'){
                System.out.print("Health expenditures: ");
                double healthExpenditures = scanner.nextDouble();
                taxPayerList.add(new Individual(name,annualIncome, healthExpenditures));
            }

            else if (typeTax == 'c'){
                System.out.print("Number of company: ");
                int numberOfEmployees = scanner.nextInt();
                taxPayerList.add(new Company(name,annualIncome,numberOfEmployees));
            }

            else {
                System.out.println("\nError!");
                i--;
            }

        }

        System.out.println("\nTAXES PAID:");
        double totalTaxes = 0;
        for(TaxPayer taxPayer : taxPayerList){
            System.out.println(taxPayer);
            totalTaxes += taxPayer.tax();
        }

        System.out.printf("\nTotal Taxes: $ %.2f", totalTaxes);
        scanner.close();
    }
}
