package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;

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
}
