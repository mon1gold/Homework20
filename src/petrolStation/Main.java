package petrolStation;

public class Main {
    public static void main(String[] args) {
        PetrolStation petrolStation = new PetrolStation(1000);
        for (int i = 0; i < 10; i++) {
            new Thread(()-> System.out.println(petrolStation.doRefuel(150))).start();
        }
    }
}
