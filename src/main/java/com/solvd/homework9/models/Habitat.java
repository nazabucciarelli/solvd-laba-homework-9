package com.solvd.homework9.models;

public class Habitat {
    private String name;

    public Habitat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Habitat habitat = (Habitat) o;

        return name.equals(habitat.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Habitat{" +
                "name='" + name + '\'' +
                '}';
    }
}
