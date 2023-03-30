/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.services;

import com.usuarios.usuarios.Dto.TransportistaDto;
import com.usuarios.usuarios.models.Transportista;
import java.util.List;
import javax.transaction.Transactional;
import com.usuarios.usuarios.repositories.TransportistaRepositories;
import java.util.Base64;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author fasp9
 */
@Service
@Transactional
public class TransportistaServices {
    private static final String clave = "MiClaveSecreta12"; // Clave secreta para encriptar
   
     @Autowired
    TransportistaRepositories TransportistaRepositories;
    
    @Transactional
    public List<Transportista> getAllTransportista(){
        return TransportistaRepositories.findAll();
    }
    
    @Transactional
   public String InscribirTransportista (TransportistaDto dto) throws Exception{
       //String nombreIncriptada =  encriptar(dto.getNombre());
       //String nombreDesencriptado = desencriptar(nombreIncriptada);
       final Transportista Transportista = new Transportista ();
       Transportista.setNumeroLicencia(dto.getNumeroLicencia());
       Transportista.setNombre(dto.getNombre());
       Transportista.setApellido(dto.getApellido());
       Transportista.setTipoLicencia(dto.getTipoLicencia());
       Transportista.setEstado(1020);
       //Transportista.setFechaCreacion(dto.getFechaCreacion());
       //System.out.println("NOMBRE ENCRIPTADO....>>>>>>>>><<<<<<<: "+nombreIncriptada);
       //System.out.println("NOMBRE Desencriptado....>>>>>>>>><<<<<<<: "+nombreDesencriptado);
       if(dto.getTipoLicencia().equals("A")){
         TransportistaRepositories.save(Transportista);
         return "El Transportista fue Inscrito Correctamente en el Beneficio";
       }else{
        return "El Transportista debe tener licencia tipo A";
       }
   }
   
   //Metodo que consulta el estado del estado del transportista en el beneficio.
   public boolean consultaTransportista(TransportistaDto dto){
        String pLicencia = dto.getNumeroLicencia();
        String numeroLicencia = this.TransportistaRepositories.consultaTransportista(pLicencia);
       if(numeroLicencia==null || numeroLicencia.equals("")){
       return false;
       }else{
       return true;
       }
   }
   
   @Transactional 
    public boolean EliminarTransportista(Integer id){
        try{
            TransportistaRepositories.deleteById(id);
           return true;
        }catch(Exception e){
            return false;
        }
    }
  
     
}
