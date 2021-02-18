package DTOs;

import entities.Direccion;
import entities.HistorialJugador;
import entities.Jugador;

import java.time.LocalDate;
import java.util.List;

public class EquipoDTO {

    private Integer cuit;
    private String nombre;
    private LocalDate fechaFundacion;
    private String presidenteNombreApellido;
    private Integer telefono;
    private String email;
    private LocalDate fechaPrimeraDivision;
    private Character categoria;
    private List<Jugador> listaJugadores;
    private Direccion direccion;
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
