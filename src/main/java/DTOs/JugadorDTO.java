package DTOs;

import entities.Equipo;
import entities.HistorialJugador;

import java.time.LocalDate;
import java.util.List;

public class JugadorDTO extends PersonaDTO{
    private LocalDate fechaRetiro;
    private LocalDate fechaDebut;
    private LocalDate fechaNacimiento;
    private Integer cantidadPartidos;
    private Integer cantidadGoles;
    private Float peso;
    private Float altura;
    private Equipo equipo;
    private List<HistorialJugador> historiales;

    public LocalDate getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(LocalDate fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public LocalDate getFechaDebut() {
        return fechaDebut;
    }

    public void setFechaDebut(LocalDate fechaDebut) {
        this.fechaDebut = fechaDebut;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getCantidadPartidos() {
        return cantidadPartidos;
    }

    public void setCantidadPartidos(Integer cantidadPartidos) {
        this.cantidadPartidos = cantidadPartidos;
    }

    public Integer getCantidadGoles() {
        return cantidadGoles;
    }

    public void setCantidadGoles(Integer cantidadGoles) {
        this.cantidadGoles = cantidadGoles;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<HistorialJugador> getHistoriales() {
        return historiales;
    }

    public void setHistoriales(List<HistorialJugador> historiales) {
        this.historiales = historiales;
    }
}
