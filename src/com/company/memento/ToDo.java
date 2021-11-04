package com.company.memento;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDo {
    private String mDate;
    private String mTodo;
    private boolean mIsFinish;

    public ToDo() {
        mDate = new SimpleDateFormat("yyyy/MM/dd EE HH:mm:ss").format(new Date());
    }



    public Memento createMemoto() {
        Memento memento = new Memento();
        memento.setDate(mDate);
        memento.setTodo(mTodo);
        memento.setIsFinish(mIsFinish);
        return memento;
    }

    public void restore(Memento memento) {
        mDate = memento.getDate();
        mTodo = memento.getTodo();
        mIsFinish = memento.isFinish();
    }



    @Override
    public String toString() {
        return "ToDo{" +
                "Date='" + mDate + '\'' +
                ", Todo='" + mTodo + '\'' +
                ", IsFinish=" + mIsFinish +
                '}';
    }
}
