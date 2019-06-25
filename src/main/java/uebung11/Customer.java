package uebung11;


import java.util.Enumeration;
import java.util.Vector;

class Customer {

    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    private double amountFor(Rental aRental) {
        return aRental.getCharge();
    }

    public String statement(){

        Enumeration rentals = _rentals.elements();
        String result = "Rental record for " + getName() + "\n";
        while(rentals.hasMoreElements()){

            Rental each = (Rental) rentals.nextElement();

            // add bonus for a two day new release rental
            //if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) frequentRenterPoints++;
            // show figures for the rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        //add footer lines
        result +=  "Amount owed is " +
                String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private double getTotalCharge(){
        double result = 0;
        Enumeration rentals = _rentals.elements();

        while(rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints(){

        int result = 0;
        Enumeration rentals = _rentals.elements();

        while(rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

}