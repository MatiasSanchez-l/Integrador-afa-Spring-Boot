package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "Jugador")
@Table(name = "jugador")
@PrimaryKeyJoinColumn(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Jugador extends Persona{

    @Column(name = "fecha_retiro")
    private LocalDate fechaRetiro;
    @Column(name = "fecha_debut")
    private LocalDate fechaDebut;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "cant_partidos")
    private Integer cantidadPartidos;
    @Column(name = "cant_goles")
    private Integer cantidadGoles;
    @Column(name = "peso")
    private Float peso;
    @Column(name = "altura")
    private Float altura;
    @ManyToOne()
    @JoinColumn(name = "cuit_equipo", referencedColumnName = "cuit")
    private Equipo equipo;
    @OneToMany(mappedBy = "historial", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
