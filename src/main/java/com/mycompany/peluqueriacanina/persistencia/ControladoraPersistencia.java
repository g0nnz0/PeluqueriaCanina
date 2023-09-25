package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import java.util.List;

public class ControladoraPersistencia {
    DuenioJpaController duenioJPA = new DuenioJpaController();
    MascotaJpaController mascotaJPA = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota mascota) {
        duenioJPA.create(duenio);
        mascotaJPA.create(mascota);
    }

    public List<Mascota> traerMascotas() {
        return mascotaJPA.findMascotaEntities();
    }
}
