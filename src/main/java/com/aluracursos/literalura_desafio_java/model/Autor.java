package com.aluracursos.literalura_desafio_java.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Autor {

    @JsonProperty("name")
    private String nombre;
    @JsonProperty("birth_year")
    private int fechaNacimiento;
    @JsonProperty("death_year")
    private int fechaFallecimiento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(int fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }
}
