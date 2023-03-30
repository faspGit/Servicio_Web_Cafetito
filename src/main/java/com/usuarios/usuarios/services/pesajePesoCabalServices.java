
package com.usuarios.usuarios.services;

import com.usuarios.usuarios.Dto.pesajePesoCabalDto;
import com.usuarios.usuarios.models.pesajePesoCabal;
import com.usuarios.usuarios.repositories.pesajePesoCabalRepositories;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usuarios.usuarios.repositories.TransportistaRepositories;

@Service
@Transactional
public class pesajePesoCabalServices {
    @Autowired
    pesajePesoCabalRepositories pesajePesoCabalRepositories;
    
    
    @Transactional
    public List<pesajePesoCabal> getAllPesajes(){
        return pesajePesoCabalRepositories.findAll();
    }
    
    @Transactional
    public pesajePesoCabal createPesaje(pesajePesoCabalDto dto){
        final pesajePesoCabal pesajePesoCabal = new pesajePesoCabal();
        pesajePesoCabal.setIdCuenta(dto.getIdCuenta());
        pesajePesoCabal.setPrimerPesaje(dto.getPrimerPesaje());
        pesajePesoCabal.setPesajeParcial(dto.getPesajeParcial());
        pesajePesoCabal.setUltimoPesaje(dto.getUltimoPesaje());
        pesajePesoCabal.setPesoMarcado(dto.getPesoMarcado());
        return pesajePesoCabalRepositories.save(pesajePesoCabal);
    }
}
