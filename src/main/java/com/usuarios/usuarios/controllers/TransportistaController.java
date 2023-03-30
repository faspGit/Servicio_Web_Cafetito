package com.usuarios.usuarios.controllers;

import com.usuarios.usuarios.Dto.TransportistaDto;
import com.usuarios.usuarios.models.Transportista;
import com.usuarios.usuarios.services.TransportistaServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransportistaController {
    @Autowired
    TransportistaServices TransportistaServices;
    
    @CrossOrigin(origins="http://localhost:4200")
    @GetMapping(value="Proyecto/findAllProyecto")
    public List<Transportista> getAllTransportista (){
        return TransportistaServices.getAllTransportista();
    }
    
    //metodo para crear un usuario
    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping(value="Transportista/InscribirTransportista")
    public String InscribirTransportista(@RequestBody TransportistaDto dto) throws Exception{
        return TransportistaServices.InscribirTransportista(dto);
    }
    
    //metodo para crear un usuario
    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping(value="Transportista/consultaTransportista")
    public boolean consultaTransportista(@RequestBody TransportistaDto dto){
        return TransportistaServices.consultaTransportista(dto);
    }
    
}
