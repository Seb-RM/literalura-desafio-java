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

    public void setFechaNacimiento(Integer fechaNacimiento) {
        if (fechaNacimiento == null || fechaNacimiento < 0) {
            this.fechaNacimiento = 0;
        } else {
            this.fechaNacimiento = fechaNacimiento;
        }
    }

    public int getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Integer fechaFallecimiento) {
        if (fechaFallecimiento == null) {
            this.fechaFallecimiento = 0;
        } else if (fechaFallecimiento < 0) {
            this.fechaFallecimiento = 0;
        } else if (fechaNacimiento != null && fechaFallecimiento <= fechaNacimiento) {
            this.fechaFallecimiento = 0;
        } else {
            this.fechaFallecimiento = fechaFallecimiento;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n👤 Nombre: ").append(nombre).append('\n');
        sb.append("   🗓️ Año de Nacimiento: ").append(fechaNacimiento).append('\n');
        if (fechaFallecimiento != null) {
            sb.append("   🕊️ Año de Fallecimiento: ").append(fechaFallecimiento);
        } else {
            sb.append("   🟢 Aún con vida");
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
