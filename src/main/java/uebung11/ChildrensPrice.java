package uebung11;



public class ChildrensPrice extends Price {

    int getPriceCode(){
        return Movie.CHILDREN;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 1.5;
        if(daysRented > 3){
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}
