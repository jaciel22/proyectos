
 package com.example.postgresql.repository;
 import org.springframework.data.jpa.repository.JpaRepository;
 import com.example.postgresql.entity.ProductoEntity;
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.data.repository.query.Param;
 import org.springframework.stereotype.Repository;
 import java.util.List;

 //Es long porque la clave primaria de la clase Producto es long public
 @Repository
 public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{
  //JPQL java query persistance language
   @Query("select p from ProductoEntity p where upper(p.nombre) like upper(:nombre) and p.estado='Disponible'")
  List<ProductoEntity> findByLikeNombre(@Param("nombre") String nombre);

  //@Query("select p from ProductoEntity p where upper(p.nombre) like upper(:nombre) and p.estado='Disponible'")
  List<ProductoEntity> findByAllCustom(String nombre);
  }
