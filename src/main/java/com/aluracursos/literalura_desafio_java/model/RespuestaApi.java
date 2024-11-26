package com.aluracursos.literalura_desafio_java.model;

import com.aluracursos.literalura_desafio_java.dto.LibroDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespuestaApi {

    private int count;
    private String next;
    private String previous;
    private List<LibroDto> results;

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

    public List<LibroDto> getResults() {
        return results;
    }

    public void setResults(List<LibroDto> results) {
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
