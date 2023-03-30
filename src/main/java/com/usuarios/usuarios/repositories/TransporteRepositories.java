
package com.usuarios.usuarios.repositories;

import com.usuarios.usuarios.models.Transporte;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TransporteRepositories extends CrudRepository<Transporte,Integer> {
    @Override
    public List<Transporte> findAll();
    
    //Area de Consultas a BD
    @Query(value = "select transporte.marca from transporte  where transporte.matricula= :pMatricula limit 1", nativeQuery = true)
    @Transactional 
    public String consultaTransporte(@Param("pMatricula") String pMatricula);
    
}
