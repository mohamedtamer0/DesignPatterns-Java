package com.company.Behavioraldesignpatterns.iterator;

public class Literature implements BookIterable{

    private Book[] literature;

    public Literature() {
        literature = new Book[4];
        literature[0] = new Book("Three Kingdoms", "9787532237357", "Shanghai People's Fine Arts Publishing House");
        literature[1] = new Book("Journey to the West", "9787805200552", "Yuelu Publishing House");
        literature[2] = new Book("Water Margin", "9787020015016", "People's Literature Publishing House");
        literature[3] = new Book("Dream of Red Mansions", "9787020002207", "People's Literature Publishing House");
    }

    public Book[] getLiterature() {
        return literature;
    }

    @Override
    public Iterator iterator() {
        return new LiteratureIterator(literature);
    }
}
