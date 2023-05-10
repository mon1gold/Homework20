package petrolStation;

import java.util.concurrent.Semaphore;

public class PetrolStation {
    private static final long REFUEL_TIME = 5000;
    private static final Semaphore SEMAPHORE = new Semaphore(3, true);
    private  Double amount;

    public PetrolStation(double amount) {
        this.amount = amount;
    }

    public double doRefuel(double quantity) {
        try {
            SEMAPHORE.acquire();
            Thread.sleep(REFUEL_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        double petrolAmount;
        synchronized (amount) {
            if (amount < quantity) {
                petrolAmount = amount;
                amount = 0D;
            } else {
                amount -= quantity;
                petrolAmount = quantity;
            }
        }
        SEMAPHORE.release();
        return petrolAmount;
    }
}

