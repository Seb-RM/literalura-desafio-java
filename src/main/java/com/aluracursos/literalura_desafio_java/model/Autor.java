package com.aluracursos.literalura_desafio_java.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "fecha_nacimiento")
    private Integer fechaNacimiento;

    @Column(name = "fecha_fallecimiento")
    private Integer fechaFallecimiento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        if (fechaNacimiento == null || fechaNacimiento < 0) {
            this.fechaNacimiento = 0;
        } else {
            this.fechaNacimiento = fechaNacimiento;
        }
    }

    public Integer getFechaFallecimiento() {
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
