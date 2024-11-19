package com.aluracursos.literalura_desafio_java.model;

import java.util.List;

public class RespuestaApi {

    private int count;
    private String next;
    private String previous;
    private List<Libro> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Libro> getResults() {
        return results;
    }

    public void setResults(List<Libro> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "RespuestaApi{" + '\n' +
                "count=" + count + "," + '\n' +
                "next='" + next + "," + '\n' +
                "previous='" + previous + "," + '\n' +
                "results= " + results + "," + '\n' +
                '}';
    }

}
