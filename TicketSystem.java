import java.util.*;

class Ticket {
    int seatNo;
    String name;
    String type;
    boolean booked;

    Ticket(int seatNo) {
        this.seatNo = seatNo;   // FIXED
        booked = false;
    }

    public String toString() {
        if (booked)
            return "Seat: " + seatNo + " | Name: " + name + " | Type: " + type;
        else
            return "Seat: " + seatNo + " | Available";
    }
}

public class TicketSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Ticket> list = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            list.add(new Ticket(i));
        }
// TITLE HERE
    System.out.println("===== TICKET BOOKING SYSTEM =====");

        int ch;

        do {
            System.out.println("\n1. Offline Booking");
            System.out.println("2. Online Booking");
            System.out.println("3. View Tickets");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("Enter seat number: ");
                int s = sc.nextInt();

                for (Ticket t : list) {
                    if (t.seatNo == s) {
                        if (!t.booked) {
                            t.booked = true;
                            t.name = "Counter";
                            t.type = "Offline";
                            System.out.println("Offline Ticket Booked");
                        } else {
                            System.out.println("Seat Already Booked");
                        }
                    }
                }

            } else if (ch == 2) {
                System.out.print("Enter seat number: ");
                int s = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter name: ");
                String name = sc.nextLine();

                for (Ticket t : list) {
                    if (t.seatNo == s) {
                        if (!t.booked) {
                            t.booked = true;
                            t.name = name;
                            t.type = "Online";
                            System.out.println("Online Ticket Booked"); 
                        } else {
                            System.out.println("Seat Already Booked");
                        }
                    }
                }

            } else if (ch == 3) {
                System.out.println("\n--- Ticket List ---");
                for (Ticket t : list) {
                    System.out.println(t);
                }

            } else if (ch == 4) {
                System.out.print("Enter seat number: ");
                int s = sc.nextInt();

                for (Ticket t : list) {
                    if (t.seatNo == s) {
                        if (t.booked) {
                            t.booked = false;
                            t.name = "";
                            t.type = "";
                            System.out.println("Ticket Cancelled"); 
                        } else {
                            System.out.println("Seat Already Empty");
                        }
                    }
                }
            }

        } while (ch != 5);

        System.out.println("Thank You");
    }
}