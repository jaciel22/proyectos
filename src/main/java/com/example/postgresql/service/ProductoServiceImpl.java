package com.example.postgresql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postgresql.entity.ProductoEntity;
import com.example.postgresql.repository.ProductoRepository;

import static com.example.postgresql.utils.BDUtil.getLike;
  
  @Service
  public class ProductoServiceImpl implements ProductoService {
  //@Autowired no se recomienda usar inyección de dependencias por propiedad
  //Se sugiere usar inyección de dependencias por constructor //


  private final ProductoRepository productoRepository;
  
  public ProductoServiceImpl(final ProductoRepository productoRepository) {
  this.productoRepository=productoRepository;
  }
  
  @Override
  public List<ProductoEntity> findAll() throws ServiceException {
    System.out.println("A");
    return productoRepository.findAll();
  }

  @Override
  public ProductoEntity save(ProductoEntity productoEntity) throws ServiceException {
    return productoRepository.save(productoEntity);
  }

    @Override
    public Optional<ProductoEntity> findById(Long id) throws ServiceException {
      return productoRepository.findById(id);
    }
  @Override
    public List<ProductoEntity> findByLikeNombre(String nombre) throws ServiceException{
    return productoRepository.findByLikeNombre(getLike(nombre));
  }
  }
 