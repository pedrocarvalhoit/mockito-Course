package com.mockitoCourse.trainBarrier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TrainBarrierTest {

    @Mock
    EmailService emailServiceMock;
    final int PASSENGER_ID = 3;

    @Test
    public void passengerEntry(){
        //given - setup for test
        TrainBarrier trainBarrier = new TrainBarrier(emailServiceMock);
        TrainBarrier trainBarrierSpy = spy(trainBarrier);
        when(trainBarrierSpy.passengerIsEligible(PASSENGER_ID)).thenReturn(true);

        //when -method invocation
        trainBarrierSpy.passengersEntry(PASSENGER_ID);

        //then - what we expect
        verify(emailServiceMock).notifyPassenger(PASSENGER_ID);
        Assertions.assertTrue(trainBarrierSpy.getPassengersOnBoard().contains(PASSENGER_ID));
    }

    @Test
    public void passengerEntryBDD(){
        //given - setup for test
        TrainBarrier trainBarrier = new TrainBarrier(emailServiceMock);
        TrainBarrier trainBarrierSpy = spy(trainBarrier);
        given(trainBarrierSpy.passengerIsEligible(PASSENGER_ID))
                .willReturn(true);

        //when -method invocation
        trainBarrierSpy.passengersEntry(PASSENGER_ID);

        //then - what we expect
        then(emailServiceMock)
                .should()
                .notifyPassenger(PASSENGER_ID);
        Assertions.assertTrue(trainBarrierSpy.getPassengersOnBoard().contains(PASSENGER_ID));
    }

}