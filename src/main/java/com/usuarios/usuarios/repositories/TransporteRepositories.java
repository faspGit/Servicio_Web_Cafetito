
package com.usuarios.usuarios.repositories;

import com.usuarios.usuarios.models.Transporte;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TransporteRepositories extends CrudRepository<Transporte,Integer> {
    @Override
    public List<Transporte> findAll();
    
    //Area de Consultas a BD
    @Query(value = "select transporte.estado from transporte  where transporte.matricula= :pMatricula limit 1", nativeQuery = true)
    @Transactional 
    public String consultaTransporte(@Param("pMatricula") String pMatricula);
    
    
    //Area de Consultas a BD
    @Query(value = "select usuario.estado from  usuario where usuario.nit= :pnit limit 1", nativeQuery = true)
    @Transactional 
    public String consultaNit(@Param("pnit") String pnit);
    
    //Area de Consultas a BD
    @Query(value = "select usuario.estado from  usuario where usuario.contrasena = :pcontrasena limit 1", nativeQuery = true)
    @Transactional 
    public String consultaContrasena(@Param("pcontrasena") String pcontrasena);
    
    //Area de Consultas a BD
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update transporte  set estado=1030 where matricula= :pMatricula", nativeQuery = true)
    public int eliminaTransporte(@Param("pMatricula") String pMatricula);


    
}
