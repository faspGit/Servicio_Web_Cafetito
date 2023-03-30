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
   public String InscribirTransportista (TransportistaDto dto, String nit, String contrasena) throws Exception{
        String a = nit;
        String b = this.encriptar(contrasena);
        String c = this.desencriptar(b);
       String passEncriptado = encriptar(contrasena);
       final Transportista Transportista = new Transportista ();
       Transportista.setNumeroLicencia(dto.getNumeroLicencia());
       Transportista.setNombre(dto.getNombre());
       Transportista.setApellido(dto.getApellido());
       Transportista.setTipoLicencia(dto.getTipoLicencia());
       Transportista.setEstado(1020);
       if (this.consultaDatos(a,b)) {
       if(dto.getTipoLicencia().equals("A")){
         TransportistaRepositories.save(Transportista);
         return "El Transportista fue Inscrito Correctamente en el Beneficio";
       }else{
        return "El Transportista debe tener licencia tipo A";
       }
       }else {
            return "Acceso no autorizado";
        }
   }
   
   //Metodo que consulta el estado del estado del transportista en el beneficio.
   public String consultaTransportista(TransportistaDto dto, String nit, String contrasena) throws Exception{
        String a = nit;
        String b = this.encriptar(contrasena);
        String c = this.desencriptar(b);
        String pLicencia = dto.getNumeroLicencia();
        String numeroLicencia = this.TransportistaRepositories.consultaTransportista(pLicencia);
        if (this.consultaDatos(a,b)) {
       if(numeroLicencia==null || numeroLicencia.equals("")){
       return "El Transportista no esta inscrito o no esta activo";
       }else{
       return "El Transportista esta activo";
       }
        }else {
            return "Acceso no autorizado";
        }
   }
   
   public boolean consultaDatos(String a, String b) {
        String pnit = a;
        String pcontrasena = b;
        String nit = this.TransportistaRepositories.consultaNit(pnit);
        String contrasena = this.TransportistaRepositories.consultaContrasena(pcontrasena);
        if (nit !=null && nit!="" && contrasena!=null && contrasena!="") {
            System.out.println("Los datos del agricultor son validos");
            return true;
        } else {
            return false;
        }
    }
    
     public static String encriptar(String texto) throws Exception {
        SecretKeySpec claveSecreta = new SecretKeySpec(clave.getBytes(), "AES");
        Cipher cifrador = Cipher.getInstance("AES");
        cifrador.init(Cipher.ENCRYPT_MODE, claveSecreta);
        byte[] textoEncriptado = cifrador.doFinal(texto.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(textoEncriptado);
    }
     
     public static String desencriptar(String textoEncriptado) throws Exception {
        SecretKeySpec claveSecreta = new SecretKeySpec(clave.getBytes(), "AES");
        Cipher cifrador = Cipher.getInstance("AES");
        cifrador.init(Cipher.DECRYPT_MODE, claveSecreta);
        byte[] textoDesencriptado = cifrador.doFinal(Base64.getDecoder().decode(textoEncriptado));
        return new String(textoDesencriptado, "UTF-8");
    }
     
}
