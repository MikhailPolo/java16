package ru.netology;


public class NotFoundException extends RuntimeException {
    public NotFoundException(String name) {
        super("Игрок " + name + " не найден");
    }
}

