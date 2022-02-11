package com.rubberduckies.flytr;

public class App {

    public App() {}

    public void run() {

        BookingTable table = new BookingTable();
        table.update(new Booking());
    }

    public static void main( String[] args ) {
        App app = new App();
        app.run();
    }
}
