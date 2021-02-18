package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "HistorialJugador")
@Table(name = "historial")
@Inheritance(strategy = InheritanceType.JOINED)
public class HistorialJugador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_historial")
    private Integer id;
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicioContrato;
    @Column(name = "fecha_fin")
    private LocalDate fechaFinContrato;
    @Column(name = "posicion")
    private String posicion;
    @ManyToOne()
    @JoinColumn(name = "cuit_equipo", referencedColumnName = "cuit")
    private Equipo equipo;
    @ManyToOne()
    @JoinColumn(name = "id_jugador", referencedColumnName = "id_persona")
    private Jugador jugador;


    public LocalDate getFechaInicioContrato() {
        return fechaInicioContrato;
    }

    public void setFechaInicioContrato(LocalDate fechaInicioContrato) {
        this.fechaInicioContrato = fechaInicioContrato;
    }

    public LocalDate getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(LocalDate fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}
