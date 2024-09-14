package me.fortibrine.junit.test;

import me.fortibrine.junit.passenger.EmailService;
import me.fortibrine.junit.passenger.PassengerRepository;
import me.fortibrine.junit.passenger.TrainBarriers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TrainBarriersTest {

    @Test
    public void passengerEntry() {

        final int passengerId = 3;

        PassengerRepository passengerRepositoryMock = Mockito.mock(PassengerRepository.class);
        EmailService serviceMock = Mockito.mock(EmailService.class);
        TrainBarriers trainBarriers = new TrainBarriers(passengerRepositoryMock, serviceMock);

        trainBarriers.passengerEntry(passengerId);

        Mockito.verify(passengerRepositoryMock).registerPassengerOnTrain(passengerId);
        Mockito.verify(serviceMock).notifyPassenger(passengerId);

    }

}
