package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

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
    void shouldNotSetStationAboveNine() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.setCurrentStation(10);

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
    void shouldSwitchFromNineToZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);

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
    void shouldSwitchFromZeroToNine() {
        Radio radio = new Radio();

        radio.prev();

        assertEquals(9, radio.getCurrentStation());
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

    // ===== Тесты для конструкторов =====

    @Test
    void shouldCreateRadioWithDefaultConstructor() {
        Radio radio = new Radio();

        assertEquals(0, radio.getCurrentStation());
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldCreateRadioWithParameters() {
        Radio radio = new Radio(5, 50);

        assertEquals(5, radio.getCurrentStation());
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    void shouldNotCreateRadioWithInvalidStation() {
        Radio radio = new Radio(-1, 50);

        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldNotCreateRadioWithInvalidVolume() {
        Radio radio = new Radio(5, 150);

        assertEquals(0, radio.getCurrentVolume());
    }
}