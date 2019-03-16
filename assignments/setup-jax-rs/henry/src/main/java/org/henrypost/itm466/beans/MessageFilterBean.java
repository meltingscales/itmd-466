package org.henrypost.itm466.beans;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @QueryParam("year")
    private int year;

    @QueryParam("start")
    private int start;

    @QueryParam("size")
    private int size;
}
