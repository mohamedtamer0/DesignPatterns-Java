package com.company.Behavioraldesignpatterns.iterator;

public class LiteratureIterator  implements Iterator{


    private Book[] literatures;

    private int index;

    public LiteratureIterator(Book[] literatures) {
        this.literatures = literatures;
    }

    @Override
    public boolean hasNext() {
        return (index < literatures.length - 1 && literatures[index] != null);
    }

    @Override
    public Book next() {
        return literatures[index++];
    }
}
