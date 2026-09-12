package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    // ===== Тесты для конструктора по умолчанию =====

    @Test
    void shouldCreateRadioWithDefaultConstructor() {
        Radio radio = new Radio();

        assertEquals(0, radio.getCurrentStation());
        assertEquals(0, radio.getCurrentVolume());
        assertEquals(10, radio.getStationCount());
    }

    // ===== Тесты для конструктора с параметром =====

    @Test
    void shouldCreateRadioWithStationCount() {
        Radio radio = new Radio(30);

        assertEquals(30, radio.getStationCount());
        assertEquals(0, radio.getCurrentStation());
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldCreateRadioWithInvalidStationCount() {
        Radio radio = new Radio(-5);

        assertEquals(10, radio.getStationCount());
    }

    @Test
    void shouldCreateRadioWithZeroStationCount() {
        Radio radio = new Radio(0);

        assertEquals(10, radio.getStationCount());
    }

    // ===== Тесты для сеттера станции =====

    @Test
    void shouldSetStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(5);

        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationBelowZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.setCurrentStation(-1);

        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.setCurrentStation(10);

        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldSetStationWithCustomStationCount() {
        Radio radio = new Radio(30);

        radio.setCurrentStation(29);

        assertEquals(29, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationAboveCustomMax() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(5);

        radio.setCurrentStation(30);

        assertEquals(5, radio.getCurrentStation());
    }

    // ===== Тесты для next() =====

    @Test
    void shouldSwitchToNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.next();

        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchFromMaxToZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);

        radio.next();

        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchFromMaxToZeroWithCustomStationCount() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(29);

        radio.next();

        assertEquals(0, radio.getCurrentStation());
    }

    // ===== Тесты для prev() =====

    @Test
    void shouldSwitchToPreviousStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.prev();

        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchFromZeroToMax() {
        Radio radio = new Radio();

        radio.prev();

        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchFromZeroToMaxWithCustomStationCount() {
        Radio radio = new Radio(30);

        radio.prev();

        assertEquals(29, radio.getCurrentStation());
    }

    // ===== Тесты для громкости =====

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();

        radio.increaseVolume();

        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    void shouldNotIncreaseVolumeAbove100() {
        Radio radio = new Radio();

        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }

        radio.increaseVolume();

        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();

        radio.increaseVolume();
        radio.decreaseVolume();

        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseVolumeBelowZero() {
        Radio radio = new Radio();

        radio.decreaseVolume();

        assertEquals(0, radio.getCurrentVolume());
    }
}