package com.example.postgresql.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data;
import lombok.NoArgsConstructor;
 @Data
 @Builder
 @AllArgsConstructor
 @NoArgsConstructor
 @Table(name = "tbl_producto") //Usado para indicar el nombre de la tabla
 @Entity(name="ProductoEntity")//Usado para decir que esto es una entidad que esel nombre de la clase
  public class ProductoEntity {
 @Id//Indicado para decir que es la clave primaria
 @Column(name="producto_id") //Indicamos que nombre tiene en la tabla private
 @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqProducto")
 @SequenceGenerator(sequenceName = "seq_productos",allocationSize = 1,name="seqProducto")
 //@GeneratedValue(strategy= GenerationType.IDENTITY)
 Long id;
 @Column(name="nombre")
 private String nombre;
 @Column(name="precio")
 private Double precio;
 @Column(name="stock")
 private Double stock;

  public Long getId() {
   return id;
  }

  public void setId(Long id) {
   this.id = id;
  }

  public String getNombre() {
   return nombre;
  }

  public void setNombre(String nombre) {
   this.nombre = nombre;
  }

  public Double getPrecio() {
   return precio;
  }

  public void setPrecio(Double precio) {
   this.precio = precio;
  }

  public Double getStock() {
   return stock;
  }

  public void setStock(Double stock) {
   this.stock = stock;
  }

  public String getEstado() {
   return estado;
  }

  public void setEstado(String estado) {
   this.estado = estado;
  }

  @Column(name="ESTADO")
 private String estado;

  }
