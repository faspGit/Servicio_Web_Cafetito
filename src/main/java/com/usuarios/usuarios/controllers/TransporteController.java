
package com.usuarios.usuarios.controllers;

import com.usuarios.usuarios.Dto.TransporteDto;
import com.usuarios.usuarios.models.Transporte;
import com.usuarios.usuarios.services.TransporteServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransporteController {
    @Autowired
    TransporteServices TransporteServices;
    
    @CrossOrigin(origins="http://localhost:4200")
    @GetMapping(value="Transporte/findAllTransporte")
    public List<Transporte> getAllTransporte (){
        return TransporteServices.getAllTransporte();
    }
    
    //metodo para crear un usuario
    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping(value="Transporte/InscribirTransporte")
    public String InscribirTransporte(@RequestBody TransporteDto dto){
        return TransporteServices.InscribirTransporte(dto);
    }
    
    //metodo para crear un usuario
    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping(value="Transporte/consultaTransporte")
    public boolean consultarTransporte(@RequestBody TransporteDto dto){
        return TransporteServices.consultarTransporte(dto);
    }
}
