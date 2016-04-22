public class Main {
    public static void main(String[] args){
        Customer customer = new Customer(1, "Tom");
        RentableRegularMovie regMovie = new RentableRegularMovie(1, "Harry Potter");
        RentableChildrenMovie child = new RentableChildrenMovie(2, "Peter Pan");

        customer.addTransaction(new RentalTransaction(regMovie, 7));
        customer.addTransaction(new RentalTransaction(child, 7));
        System.out.println(customer.getRentalStatement());
    }
}
