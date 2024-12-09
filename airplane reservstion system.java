import java.util.ArrayList;
import java.util.Scanner;

public class AirplaneReservationSystem {

    // Class to represent a seat
    static class Seat {
        private String seatNumber;
        private boolean isBooked;
        private String passengerName;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
            this.isBooked = false;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean isBooked() {
            return isBooked;
        }

        public void bookSeat(String passengerName) {
            this.isBooked = true;
            this.passengerName = passengerName;
        }

        public void cancelBooking() {
            this.isBooked = false;
            this.passengerName = null;
        }

        public String getPassengerName() {
            return passengerName;
        }

        @Override
        public String toString() {
            return "Seat " + seatNumber + (isBooked ? " (Booked by: " + passengerName + ")" : " (Available)");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize seats
        ArrayList<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            seats.add(new Seat("A" + i));
            seats.add(new Seat("B" + i));
        }

        while (true) {
            System.out.println("\nAirplane Reservation System");
            System.out.println("1. View Seats");
            System.out.println("2. Book a Seat");
            System.out.println("3. Cancel a Booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Seats:");
                    for (Seat seat : seats) {
                        System.out.println(seat);
                    }
                    break;
                case 2:
                    System.out.print("Enter seat number to book: ");
                    String seatNumberToBook = scanner.nextLine().toUpperCase();
                    Seat seatToBook = findSeat(seats, seatNumberToBook);
                    if (seatToBook == null) {
                        System.out.println("Invalid seat number!");
                    } else if (seatToBook.isBooked()) {
                        System.out.println("Seat already booked!");
                    } else {
                        System.out.print("Enter passenger name: ");
                        String passengerName = scanner.nextLine();
                        seatToBook.bookSeat(passengerName);
                        System.out.println("Seat " + seatNumberToBook + " successfully booked for " + passengerName + ".");
                    }
                    break;
                case 3:
                    System.out.print("Enter seat number to cancel booking: ");
                    String seatNumberToCancel = scanner.nextLine().toUpperCase();
                    Seat seatToCancel = findSeat(seats, seatNumberToCancel);
                    if (seatToCancel == null) {
                        System.out.println("Invalid seat number!");
                    } else if (!seatToCancel.isBooked()) {
                        System.out.println("Seat is not booked!");
                    } else {
                        seatToCancel.cancelBooking();
                        System.out.println("Booking for seat " + seatNumberToCancel + " has been canceled.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting system. Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Helper method to find a seat by its number
    private static Seat findSeat(ArrayList<Seat> seats, String seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                return seat;
            }
        }
        return null;
    }
}
