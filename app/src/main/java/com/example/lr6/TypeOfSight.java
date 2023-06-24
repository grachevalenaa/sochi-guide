package com.example.lr6;

public enum TypeOfSight {

    ALL ("Все"),

    HISTORICAL ("Исторические"),

    ENTERTAINMENT ("Развлекательные"),

    SPORTY ("Спортивные");

    private final String text;


    TypeOfSight(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
