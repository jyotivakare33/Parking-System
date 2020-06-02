package src;
import src.*;

import java.util.*;

import static java.lang.System.exit;

public class ParkingAction {
    static List<Vechicle> parkedVechicle = new ArrayList<Vechicle>();
    static  List<Integer> freeSlots = new ArrayList<Integer>();
    static int noOfSlots = 0;

    public static void create_parking_lot(String requestType) {
        System.out.println("Creating Parking Lot . Please enter the details");
        Scanner scanner = new Scanner(System.in);
        String request = requestType;
        String[] input  = request.trim().split(" ");
        int count = 0;
        HashMap<String, String> vechicleDetails = new HashMap<String, String>();
        Vechicle vechicle = new Vechicle();
        noOfSlots = Integer.parseInt(input[1]);
        while(count  < Integer.parseInt(input[1])){
            String value = scanner.nextLine();
            String[] inputValues = value.split(" ");
            vechicleDetails.put(inputValues[1],inputValues[2]);
            vechicle.setVechicleDetails(vechicleDetails);
            parkedVechicle.add(count,vechicle);
            vechicleDetails = new HashMap<String, String>();
            vechicle = new Vechicle();
            System.out.println("Allocated slot number: "+(count+1));
            count++;
        }
        getAction();
    }


    public static void getAction() {
        System.out.println("Please enter input and exit for quitting");
        Scanner scan = new Scanner(System.in);
        String requestType = scan.nextLine();
        String[] request = requestType.split("\\s+");
        SearchParking searchParking = new SearchParking();
        switch (request[0]) {
            case "create_parking_lot":
                create_parking_lot(requestType);
                break;
            case "status":
                getStatus();
                break;
            case "leave":
                leave(requestType);
                break;
            case "park":
                parkVechicle(requestType);
                break;
            case "slot_numbers_for_cars_with_colour":
                searchParking.getRegistrationNumber(requestType);
                break;
            case "registration_numbers_for_cars_with_colour":
                searchParking.getSlotNumber(requestType);
                break;
            case "slot_number_for_registration_number":
                searchParking.getDetails(requestType);
                break;
            case "exit":
                exit(0);
        }
    }

    public static void getStatus() {
        if(noOfSlots != parkedVechicle.size() - 1) {
            for (int index = 0; index <= parkedVechicle.size() - 1; index++) {
                int finalIndex = index;
                parkedVechicle.get(index).getVechicleDetails().entrySet().forEach(entry -> {
                    System.out.println(finalIndex + 1+"  "+entry.getKey() + "  " + entry.getValue());
                });
            }
        }else{
            System.out.println("No cars in Parking");
        }
        getAction();
    }

    public static void leave(String requestType) {
        String[] request = requestType.split(" ");
        int value = Integer.parseInt(request[1]);
        if(noOfSlots != parkedVechicle.size() - 1) {
            parkedVechicle.remove(value - 1);
            freeSlots.add(value - 1);
            Collections.sort(freeSlots);
            System.out.println("Slot number "+value +" is free");
        }else{
            System.out.println("No vechicles in parking");
        }
        getAction();
    }

    public static void parkVechicle(String requestType) {
        Vechicle vechicle = new Vechicle();
        HashMap<String, String> vechicleDetails = new HashMap<String, String>();
        String value = requestType;
        String[] inputValues = value.split(" ");
        vechicleDetails.put(inputValues[1], inputValues[2]);
        vechicle.setVechicleDetails(vechicleDetails);
        if(freeSlots.size() != 0) {
            parkedVechicle.add(freeSlots.get(0), vechicle);
            System.out.println("Allocated slot number: "+freeSlots.get(0));
        }else if(noOfSlots > parkedVechicle.size()-1){
            parkedVechicle.add(parkedVechicle.size(),vechicle);
            System.out.println("Allocated slot number: "+parkedVechicle.size());
        } else{
            System.out.println("Sorry, parking lot is full");
        }
        getAction();
    }
}
