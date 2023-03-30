
package com.usuarios.usuarios.repositories;

import com.usuarios.usuarios.models.Transportista;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface TransportistaRepositories extends CrudRepository<Transportista,Integer>{
    @Override
    public List<Transportista> findAll();
    
    //Area de Consultas a BD
    @Query(value = "select transportista.nombre from transportista  where transportista.numero_licencia= :pLicencia limit 1", nativeQuery = true)
    @Transactional 
    public String consultaTransportista(@Param("pLicencia") String pLicencia);
    
}
