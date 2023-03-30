
package com.usuarios.usuarios.services;

import com.usuarios.usuarios.Dto.TransporteDto;
import com.usuarios.usuarios.models.Transporte;
import com.usuarios.usuarios.repositories.TransporteRepositories;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TransporteServices {
    @Autowired
    TransporteRepositories TransporteRepositories;
    
    @Transactional
    public List<Transporte> getAllTransporte(){
        return TransporteRepositories.findAll();
    }
    
    @Transactional
   public String InscribirTransporte (TransporteDto dto){
       final Transporte Transporte = new Transporte ();
       Transporte.setMatricula(dto.getMatricula());
       Transporte.setModelo(dto.getModelo());
       Transporte.setNumero_ejes(dto.getNumero_ejes());
       Transporte.setMarca(dto.getMarca());
       Transporte.setPesaje_mercaderia(dto.getPesaje_mercaderia());
       Transporte.setFecha_inscripcion(dto.getFecha_inscripcion());
       Transporte.setEstado(1020);
       
       if(dto.getModelo()>=1960){
         TransporteRepositories.save(Transporte);
         return "Transporte Inscrito Correctamente en el beneficio";
       }else{
        return "El Transporte debe ser modelo 1960 o mas reciente";
       }
   }
   
   public boolean consultarTransporte(TransporteDto dto){
        String pMatricula = dto.getMatricula();
        String matricula = this.TransporteRepositories.consultaTransporte(pMatricula);
       System.out.println("Hola Mundo ################################################## "+matricula );
       if(matricula==null || matricula.equals("")){
       return false;
       }else{
       return true;
       }
   }
    
    
    
}
