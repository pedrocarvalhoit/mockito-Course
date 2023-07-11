package com.mockitoCourse.trainBarrier;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.HashSet;
import java.util.Set;

//Behavior-Driven-Development:
//Foster the collaboration and communication between business and tech teams
public class TrainBarrier {

    private EmailService emailService;

    private Set<Integer> passengersOnBoard;

    public TrainBarrier(EmailService emailService){
        this.passengersOnBoard = new HashSet<Integer>();
        this.emailService = emailService;
    }

    public void passengersEntry(int passengerId){
        if(passengerIsEligible(passengerId)){
            passengersOnBoard.add(passengerId);
            emailService.notifyPassenger(passengerId);
        }
    }

    public boolean passengerIsEligible(int passengerId){
        return !passengersOnBoard.contains(passengerId);
    }

    public Set<Integer> getPassengersOnBoard() {
        return passengersOnBoard;
    }
}
