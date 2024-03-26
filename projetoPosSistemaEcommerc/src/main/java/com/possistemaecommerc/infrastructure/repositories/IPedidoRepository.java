package com.possistemaecommerc.infrastructure.repositories;

import com.possistemaecommerc.controllers.configuration.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPedidoRepository extends JpaRepository<Pedido,Integer> {

/*    @Query(value = "select p from Pedido p join Cliente c on p.id_pedido=p.id_pedido where c.id_cliente= p.id_cliente",nativeQuery = true)
    List<Pedido> findByClientePorIdPedido(@Param("idCliente") Integer idCliente);*/
@Query("from Pedido p join p.cliente c where c.idCliente= :pIdCliente")
    List<Pedido> findByCliente(@Param("pIdCliente") Integer idCliente);
}
