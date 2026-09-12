package org.example;

public class Radio {
    private int currentStation;
    private int currentVolume;
    private int stationCount;

    public Radio() {
        this.stationCount = 10;
        this.currentStation = 0;
        this.currentVolume = 0;
    }

    public Radio(int stationCount) {
        if (stationCount > 0) {
            this.stationCount = stationCount;
        } else {
            this.stationCount = 10;
        }
        this.currentStation = 0;
        this.currentVolume = 0;
    }

    public int getStationCount() {
        return stationCount;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation >= 0 && currentStation < stationCount) {
            this.currentStation = currentStation;
        }
    }

    public void next() {
        if (currentStation == stationCount - 1) {
            currentStation = 0;
        } else {
            currentStation = currentStation + 1;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = stationCount - 1;
        } else {
            currentStation = currentStation - 1;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume = currentVolume + 1;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        }
    }
}