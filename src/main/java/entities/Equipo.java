package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "Equipo")
@Table(name = "equipo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_equipo")
    private Integer id;
    @Column(name = "cuit", nullable = false, unique = true)
    private Integer cuit;
    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;
    @Column(name = "fecha_fundacion")
    private LocalDate fechaFundacion;
    @Column(name = "presidente_apellido_nombre")
    private String presidenteNombreApellido;
    @Column(name = "telefono")
    private Integer telefono;
    @Column(name = "email")
    private String email;
    @Column(name = "fecha_primera_division")
    private LocalDate fechaPrimeraDivision;
    @Column(name = "categoria")
    private Character categoria;
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Jugador> listaJugadores;
    @OneToOne
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion")
    private Direccion direccion;
    @OneToMany(mappedBy = "historial", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HistorialJugador> historiales;

    public Integer getCuit() {
        return cuit;
    }

    public void setCuit(Integer cuit) {
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public String getPresidenteNombreApellido() {
        return presidenteNombreApellido;
    }

    public void setPresidenteNombreApellido(String presidenteNombreApellido) {
        this.presidenteNombreApellido = presidenteNombreApellido;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaPrimeraDivision() {
        return fechaPrimeraDivision;
    }

    public void setFechaPrimeraDivision(LocalDate fechaPrimeraDivision) {
        this.fechaPrimeraDivision = fechaPrimeraDivision;
    }

    public Character getCategoria() {
        return categoria;
    }

    public void setCategoria(Character categoria) {
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<HistorialJugador> getHistoriales() {
        return historiales;
    }

    public void setHistoriales(List<HistorialJugador> historiales) {
        this.historiales = historiales;
    }
}
