
package com.usuarios.usuarios.services;

import com.usuarios.usuarios.Dto.TransporteDto;
import com.usuarios.usuarios.models.Transporte;
import com.usuarios.usuarios.repositories.TransporteRepositories;
import java.util.Base64;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TransporteServices {

     private static final String clave = "MiClaveSecreta12"; // Clave secreta para encriptar
    @Autowired
    TransporteRepositories TransporteRepositories;

    @Transactional
    public List<Transporte> getAllTransporte() {
        return TransporteRepositories.findAll();
    }

    @Transactional
    public String InscribirTransporte(TransporteDto dto, String nit, String contrasena) throws Exception {
        String a = nit;
        String b = this.encriptar(contrasena);
        String c = this.desencriptar(b);
        final Transporte Transporte = new Transporte();
        Transporte.setMatricula(dto.getMatricula());
        Transporte.setModelo(dto.getModelo());
        Transporte.setNumero_ejes(dto.getNumero_ejes());
        Transporte.setMarca(dto.getMarca());
        Transporte.setPesaje_mercaderia(dto.getPesaje_mercaderia());
        Transporte.setFecha_inscripcion(dto.getFecha_inscripcion());
        Transporte.setEstado(1020);
        if (this.consultaDatos(a,b)) {
            if (dto.getModelo() >= 1960) {
                TransporteRepositories.save(Transporte);
                return "Transporte Inscrito Correctamente en el beneficio";
            } else {
                return "El Transporte debe ser modelo 1960 o mas reciente";
            }
        } else {
            return "Acceso no autorizado";
        }
    }

    public String consultarTransporte(TransporteDto dto, String nit, String contrasena) throws Exception {
        String a = nit;
        String b = this.encriptar(contrasena);
        String c = this.desencriptar(b);
        String pMatricula = dto.getMatricula();
        String matricula = this.TransporteRepositories.consultaTransporte(pMatricula);
        if (this.consultaDatos(a,b)) {
        if (matricula == null || matricula.equals("")) {
            return "El transporte no esta inscrito o no esta activo";
        } else {
            return "El Transporte esta activo";
        }
        }else {
            return "Acceso no autorizado";
        }
    }

    public boolean consultaDatos(String a, String b) {
        String pnit = a;
        String pcontrasena = b;
        String nit = this.TransporteRepositories.consultaNit(pnit);
        String contrasena = this.TransporteRepositories.consultaContrasena(pcontrasena);
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
