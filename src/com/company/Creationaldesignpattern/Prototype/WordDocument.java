package com.company.Creationaldesignpattern.Prototype;

import java.util.ArrayList;

public class WordDocument implements Cloneable {
    private String text;
    private ArrayList<String> images = new ArrayList<>();

    public WordDocument() {
        System.out.println("-----Init-----");
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public void addImage(String image) {
        images.add(image);
    }

    public void showDocument() {
        System.out.println("-----Start-----");
        System.out.println("Text : " + text);
        System.out.println("Image List : ");
        for (String mImage : images) {
            System.out.println("Image Name : " + mImage);
        }
        System.out.println("-----End-----");
    }

    protected WordDocument clone() {
        try {
            WordDocument copy = (WordDocument) super.clone();
            copy.text = this.text;
//            copy.images = this.images;
            copy.images = (ArrayList<String>) this.images.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        WordDocument originDoc = new WordDocument();
        originDoc.setText("This is a document");
        originDoc.addImage("Image 1");
        originDoc.addImage("Image 2");
        originDoc.addImage("Image 3");
        originDoc.showDocument();
        WordDocument copyDoc = originDoc.clone();
        copyDoc.showDocument();
        copyDoc.setText("This is a copy document");
        // add this line to test the origin document what will happen after the copy document add a image
        copyDoc.addImage("a new Image");
        copyDoc.showDocument();
        copyDoc.showDocument();
    }

}













