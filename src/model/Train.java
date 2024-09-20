package model;

import java.time.LocalTime;

public class Train {
    private String destination;
    private int trainNumber;
    private LocalTime dispatchTime;
    private int generalPlaces;
    private int kupePlaces;
    private int platskartPlaces;
    private int luxPlaces;

    public Train(String destination, int trainNumber, LocalTime dispatchTime, int generalPlaces,
                 int kupePlaces, int platskartPlaces, int luxPlaces) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.dispatchTime = dispatchTime;
        this.generalPlaces = generalPlaces;
        this.kupePlaces = kupePlaces;
        this.platskartPlaces = platskartPlaces;
        this.luxPlaces = luxPlaces;
    }

    public String getDestination() {
        return destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public LocalTime getDispatchTime() {
        return dispatchTime;
    }

    public int getGeneralPlaces() {
        return generalPlaces;
    }

    public int getKupePlaces() {
        return kupePlaces;
    }

    public int getPlatskartPlaces() {
        return platskartPlaces;
    }

    public int getLuxPlaces() {
        return luxPlaces;
    }
////////////////////////////////////////////////////////////////////////
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public void setDispatchTime(LocalTime dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public void setGeneralPlaces(int generalPlaces) {
        this.generalPlaces = generalPlaces;
    }

    public void setKupePlaces(int kupePlaces) {
        this.kupePlaces = kupePlaces;
    }

    public void setPlatskartPlaces(int platskartPlaces) {
        this.platskartPlaces = platskartPlaces;
    }

    public void setLuxPlaces(int luxPlaces) {
        this.luxPlaces = luxPlaces;
    }
//////////////////////////////////////////////////////////////////////////
    public String toString() {
        return "\nTrain:" + "\nDestination: " + getDestination() + "\nTrain Number: " + getTrainNumber() +
                "\nDispatch: " + getDispatchTime() + "\n******************" + "\nGeneral Places: " + getGeneralPlaces() + "\nKupe: " +
                getKupePlaces() + "\nPlatskart: " + getPlatskartPlaces() + "\nLux: " + getLuxPlaces() + "\n";
    }
}
