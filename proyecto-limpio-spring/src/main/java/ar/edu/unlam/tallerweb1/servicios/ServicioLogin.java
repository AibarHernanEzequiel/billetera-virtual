package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.modelo.Cliente;

public interface ServicioLogin {
    Cliente buscarClientePorCorreo(String correo);
}