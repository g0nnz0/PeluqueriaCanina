package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class ControladoraLogica {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMascota, String razaMascota, String colorMascota, String observaciones, String alergico, String atEspecial, String nombreDuenio, String celDuenio) {
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCel_duenio(celDuenio);
        
        
        Mascota mascota = new Mascota();
        mascota.setNombre(nombreMascota);
        mascota.setRaza(razaMascota);
        mascota.setColor(colorMascota);
        mascota.setAlergico(alergico);
        mascota.setAtencion_especial(atEspecial);
        mascota.setObservaciones(observaciones);
        mascota.setUnDuenio(duenio);
        
        controlPersis.guardar(duenio, mascota);
        
    }

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
    }

    public void borrar(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMascota, String razaMascota, String colorMascota, String observaciones, String alergico, String atEspecial, String nombreDuenio, String celDuenio) {
        
        //Asigno los nuevos datos a masco
        masco.setNombre(nombreMascota);
        masco.setRaza(razaMascota);
        masco.setColor(colorMascota);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atEspecial);
        
        //modifico mascota
        controlPersis.modificarMascota(masco);
        
        //Seteo nuevos valores del dueño
        Duenio due = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        due.setCel_duenio(celDuenio);
        due.setNombre(nombreDuenio);
        
        //Llamar al modificar dueño
        this.modificarDuenio(due);
        
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio due) {
        controlPersis.modificarDuenio(due);
    }
}
