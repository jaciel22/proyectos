package com.example.postgresql.controller;

import java.util.List;
import org.slf4j.Logger;

import com.example.postgresql.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.postgresql.entity.ProductoEntity;
import com.example.postgresql.service.ProductoService;
import static com.example.postgresql.commons.GlobalConstant.API_PRODUCTO;
import static java.util.Objects.isNull;
import java.util.Optional;

//En spring creamos una api usando la notacion Rest Controller
@Slf4j
@RestController
@RequestMapping(API_PRODUCTO)
public class ProductoController {
	private final ProductoRepository productoRepository;
	//Conectamos nuestra capa de servicio con la capa de controlador
	/*Usaremos inyección por constructor (inyeccion de dependencias las
	siguientes dos lineas con condigo */

	private final ProductoService productoService;


	public ProductoController(ProductoService productoService,
							  ProductoRepository productoRepository) {

		this.productoService = productoService;
		this.productoRepository = productoRepository;
	}

	//Devolvemos el resultado
	@GetMapping
	public ResponseEntity<?> findAll(){

		try {
			//Lo guardamos en una variable para gestionar los errores
			List<ProductoEntity> productos = productoService.findAll();
			//return productoService.findAll();
			if (productos.isEmpty()){
				return ResponseEntity.noContent().build();
			}
			//Si no hay errores regresa ok
			return ResponseEntity.ok(productos);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	}

	/*El path variable solo se utiliza para números */
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable /*(value="id",required=true*/ Long id){

		try {
			//Lo guardamos en una variable para gestionar los errores
			Optional<ProductoEntity> optProducto = productoService.findById(id);
			//return productoService.findAll();
			if (optProducto.isEmpty()){
				return ResponseEntity.noContent().build();
			}
			//Si no hay errores regresa ok
			return ResponseEntity.ok(optProducto);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@CrossOrigin(origins = "http://localhost:4200") // Especifica los orígenes permitidos
	@GetMapping("/by-nombre")
	public ResponseEntity<?> findByLikeNombre(@RequestParam /*(value="id",defaultValue="",required=true*/ String nombre){

		try {
			//Lo guardamos en una variable para gestionar los errores
			List<ProductoEntity> productos = productoService.findByLikeNombre(nombre);
			HttpHeaders headers = new HttpHeaders();
			headers.add("Access-Control-Allow-Origin", "*");
			headers.add("Access-Control-Allow-Methods", "POST");
			headers.add("Access-Control-Allow-Headers", "Content-Type");
			//return productoService.findAll();
			if (productos.isEmpty()){
				return ResponseEntity.noContent().build();
			}
			//Si no hay errores regresa ok
			return ResponseEntity.ok(productos);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@CrossOrigin(origins = "http://localhost:4200") // Especifica los orígenes permitidos
	@PostMapping
	//public ProductoEntity save(@RequestBody ProductoEntity productoEntity){
	public ResponseEntity<?> save(@RequestBody ProductoEntity productoEntity){
		try {
			System.out.println("Endpoint save - Request received");
			HttpHeaders headers = new HttpHeaders();
			headers.add("Access-Control-Allow-Origin", "*");
			headers.add("Access-Control-Allow-Methods", "POST");
			headers.add("Access-Control-Allow-Headers", "Content-Type");
			//return productoService.save(productoEntity);
			//Añadimos el manejador de errores
			ProductoEntity oProductoEntity = productoService.save(productoEntity);
			if (isNull(oProductoEntity)){
				return ResponseEntity.badRequest().build();
			}
			System.out.println("Exitoso!!");
			return ResponseEntity.status(HttpStatus.CREATED).body(oProductoEntity);
		} catch (Exception e) {
			return null;
		}
	}
	

}
