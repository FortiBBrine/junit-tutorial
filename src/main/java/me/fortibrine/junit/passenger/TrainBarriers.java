package me.fortibrine.junit.passenger;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TrainBarriers {

    private final PassengerRepository repository;
    private final EmailService service;

    public void passengerEntry(int passengerId) {
        repository.registerPassengerOnTrain(passengerId);
        service.notifyPassenger(passengerId);
    }
}
