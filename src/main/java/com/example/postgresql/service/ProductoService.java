
  package com.example.postgresql.service;
  
  import java.util.List;
  import java.util.Optional;

  import com.example.postgresql.entity.ProductoEntity;
  
  public interface ProductoService {
  
  
  //No es necesario especificar que el método es publico ya que en java los
  //métodos de una interface son públicos por defecto
  
  
  //Devolveremos una lista de productos
  List<ProductoEntity> findAll() throws ServiceException;
  
  ProductoEntity save(ProductoEntity productoEntity) throws ServiceException;

    //Optional se utiliza cuando puede devolver uno o ninguno
    //Fue creado en java 8 y nos ayuda a gestionar los nulos para que no se caiga la aplicación
    Optional<ProductoEntity> findById(Long id) throws ServiceException;

    List<ProductoEntity> findByLikeNombre(String nombre ) throws ServiceException;
  }
 