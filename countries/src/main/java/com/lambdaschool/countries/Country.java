package com.lambdaschool.countries;

import java.util.concurrent.atomic.AtomicLong;

public class Country {
    private String name;
    private int size,median_age;
    private long population;
    private final long ID;
    private static AtomicLong counter=new AtomicLong(0);

    public Country(String name, long population, int size, int median_age) {
        this.name = name;
        this.population = population;
        this.size = size;
        this.median_age = median_age;

        counter.incrementAndGet();
        ID=counter.longValue();
    }

    public Country(Country clone) {
        this.name = clone.name;
        this.population = clone.population;
        this.size = clone.size;
        this.median_age = clone.median_age;
        this.ID=clone.getID();
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMedian_age() {
        return median_age;
    }

    public void setMedian_age(int median_age) {
        this.median_age = median_age;
    }
}
