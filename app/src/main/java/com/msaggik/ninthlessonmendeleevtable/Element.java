package com.msaggik.ninthlessonmendeleevtable;

public class Element {
    // поля
    private String name; // название
    private String symbol; // символ
    private int number; // номер
    private float mass; // масса
    private int openingYear; // год открытия

    // конструктор
    public Element(String name, String symbol, int number, float mass, int openingYear) {
        this.name = name;
        this.symbol = symbol;
        this.number = number;
        this.mass = mass;
        this.openingYear = openingYear;
    }

    // геттеры и сеттеры
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public float getMass() {
        return mass;
    }
    public void setMass(float mass) {
        this.mass = mass;
    }
    public int getOpeningYear() {
        return openingYear;
    }
    public void setOpeningYear(int openingYear) {
        this.openingYear = openingYear;
    }
}
