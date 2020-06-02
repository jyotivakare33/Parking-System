package src;

import java.util.Scanner;

import static src.ParkingAction.*;

public class SearchParking {

    public void getRegistrationNumber(String requestType) {
        String request = requestType;
        String[] input = request.trim().split(" ");
        boolean flag = false;
        if(noOfSlots != parkedVechicle.size() - 1) {
            for (int index = 0; index < parkedVechicle.size(); index++) {
                if(parkedVechicle.get(index).getVechicleDetails().containsValue(input[1])){
                    System.out.println(index+1);
                    flag = true;
                }
            }
            if(!flag) {
                System.out.println("No vechicle with that details");
            }
        }else{
            System.out.println("No vechicles in parking");
        }
        getAction();
    }

    public void getSlotNumber(String requestType) {
        String request = requestType;
        String[] input = request.trim().split(" ");
        boolean flag = false;
        if(noOfSlots != parkedVechicle.size() - 1) {
            for (int index = 0; index < parkedVechicle.size(); index++) {
                if(parkedVechicle.get(index).getVechicleDetails().containsValue(input[1])){
                    System.out.println(parkedVechicle.get(index).getVechicleDetails().keySet());
                    flag = true;
                }
            }
            if(!flag) {
                System.out.println("No vechicle with that details");
            }
        }else{
            System.out.println("No vechicles in parking");
        }
        getAction();
    }

    public void getDetails(String requestType) {
        String request = requestType;
        String[] input = request.trim().split(" ");
        boolean flag = false;
        if(noOfSlots != parkedVechicle.size() - 1) {
            for (int index = 0; index < parkedVechicle.size(); index++) {
                if(parkedVechicle.get(index).getVechicleDetails().containsKey(input[1])){
                    System.out.println(index+1);
                    flag = true;
                }
            }
            if(!flag) {
                System.out.println("No vechicle with that details");
            }
        }else{
            System.out.println("No vechicles in parking");
        }
        getAction();
    }
}
