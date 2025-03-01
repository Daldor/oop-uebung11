package uebung11;

class Rental {

    int getFrequentRenterPoints(){
        if((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1){
            return 2;
        } else {
            return 1;
        }
    }

    double getCharge(){
        return _movie.getCharge(_daysRented);
    }

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }



}
