public class Main {
    public static void main(String[] args){
        Customer customer = new Customer(1, "Tom", 21);
        RentableNewReleaseMovie regMovie = new RentableNewReleaseMovie(1, "Harry Potter");
        RentableChildrenMovie child = new RentableChildrenMovie(2, "Peter Pan");
        SellableItem sellItem = new SellableMovie(11, "Pirates");
        sellItem.setSalePrice(100);

        customer.addTransaction(new RentalTransaction(regMovie, 7));
        customer.addTransaction(new RentalTransaction(child, 7));
        customer.addTransaction(new RentalTransaction(child, 7));
        customer.addTransaction(new RentalTransaction(child, 7));
        customer.addTransaction(new RentalTransaction(child, 7));
        customer.addTransaction(new RentalTransaction(child, 7));
        customer.addTransaction(new SaleTransaction(sellItem, 2));
        TypeStrategy strategy = new TypeStrategy();
//        strategy.computeFrequentPt(customer);
        System.out.println(customer.getRentalStatement());
    }
}
