
package com.usuarios.usuarios.controllers;

import com.usuarios.usuarios.Dto.usuarioDto;
import com.usuarios.usuarios.models.usuario;
import com.usuarios.usuarios.services.usuarioServices;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class usuarioController {
    @Autowired
    usuarioServices usuarioServices;
   
    //metodo que obtienen la lista de usuarios 
    
    @CrossOrigin(origins="http://localhost:4200")
    @GetMapping(value="demo/findAll")
    public List<usuario> getAllUsuario (){
        return usuarioServices.getAllUsuari();
    }
    //metodo para crear un usuario
     @CrossOrigin(origins="http://localhost:4200")
    @PostMapping(value="create/user")
    public usuario createUsuario(@RequestBody usuarioDto dto) throws Exception{
        return usuarioServices.createUsuario(dto);
    }
    
    //metodo para actualizar un usuario
     @CrossOrigin(origins="http://localhost:4200")
    @PostMapping(value="update/user")
    public usuario updateUsuario(@RequestBody usuarioDto dto) throws Exception {
        return usuarioServices.createUsuario(dto);
    }
    //metodo para eliminar usuarios
    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping(value="delete/User")
    public boolean deleteUsuario(@RequestBody usuarioDto dto){
        return usuarioServices.eliminarUusario(dto.getIdUsuario());
    }
    
    //metodo para obtener un solo usuario
    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping(value="usuario")
    public usuario usuarioUnico(@RequestBody usuarioDto dto){
        List <usuario> listUsuarios = new ArrayList<usuario>();
        listUsuarios = usuarioServices.getAllUsuari();
        for(int i = 0 ; i < listUsuarios.size() ; i++ ){
            if(dto.getIdUsuario().equals(listUsuarios.get(i).getIdUsuario())){
                return listUsuarios.get(i);
            }
        }
     return null;   
    }
    
    //METODO DE BERIFIACACION DE USUARIO 

    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping(value="usuario/login")
    public boolean usuarioBerificacion(@RequestBody usuarioDto dto){
        List <usuario> listUsuarios = new ArrayList<usuario>();
        listUsuarios = usuarioServices.getAllUsuari();
        for(int i = 0 ; i < listUsuarios.size() ; i++ ){
            if(dto.getNombre().equals(listUsuarios.get(i).getNombre())  &&   dto.getContrasena().equals(listUsuarios.get(i).getContrasena()) ){
                return true;
            }
        }
     return false;   
    }
    
}   

