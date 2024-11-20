package com.aluracursos.literalura_desafio_java.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Autor {

    @JsonProperty("name")
    private String nombre;
    @JsonProperty("birth_year")
    private Integer fechaNacimiento;
    @JsonProperty("death_year")
    private Integer fechaFallecimiento;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("👤 Nombre: ").append(nombre).append('\n');
        sb.append("   🗓️ Año de Nacimiento: ").append(fechaNacimiento).append('\n');
        if (fechaFallecimiento != null) {
            sb.append("   🕊️ Año de Fallecimiento: ").append(fechaFallecimiento).append('\n');
        } else {
            sb.append("   🟢 Aún con vida").append('\n');
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Autor autor = (Autor) obj;
        return Objects.equals(nombre, autor.nombre) &&
                Objects.equals(fechaNacimiento, autor.fechaNacimiento) &&
                Objects.equals(fechaFallecimiento, autor.fechaFallecimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fechaNacimiento, fechaFallecimiento);
    }


}
