import Manager.CacheManager;
import Model.Cache;
import Model.CacheFactory;
import Model.CachePolicy;
import Response.CacheGetResponse;
import Response.CacheSetResponse;

import java.util.Scanner;

public class DriverClass {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int numberOfCache = scanner.nextInt();
        scanner.nextLine();
        for(int i=0; i< numberOfCache; i++){
            String command = scanner.nextLine();
            String commands[] = command.split(" ");
            Long size = Long.parseLong(commands[0]);
            String policy = commands[1];
            Long readCost = Long.parseLong(commands[2]);
            Long writeCost = Long.parseLong(commands[3]);
            CacheManager.addLayer(CacheFactory.getCache(policy, size, CachePolicy.valueOf(policy), readCost, writeCost, i));
        }

        while(true){
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            switch (commands[0]){
                case "SET":
                    CacheSetResponse response =  CacheManager.set(commands[1], commands[2]);
                    System.out.println(response.getCost());
                break;
                case "GET":
                    CacheGetResponse response1 = CacheManager.get(commands[1]);
                    System.out.println(response1.getValue() + " " + response1.getCost());
                break;
            }
        }
    }
}
