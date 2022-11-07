package com.curso.domain.repository;

import com.curso.domain.Producto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("enMemoriaProductoRepository")
public class EnMemoriaProductoRepository  implements ProductoRepository{

    private List<Producto> listaDeProductos = new ArrayList<Producto>();
	private Logger log = Logger.getLogger("EnMemoriaProductoRepository");
 
    //contructor
    
    public EnMemoriaProductoRepository() {
	    log.info("........... instanciando EnMemoriaProductoRepository");
	    Producto iphone = new Producto("P1234","iPhone 5s", new BigDecimal(500));
	    iphone.setDescripcion("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
	    iphone.setCategoria("Smart Phone");
	    iphone.setFabricante("Apple");
	    iphone.setUnidadesEnStock(1000);
	    
	    Producto laptop_dell = new Producto("P1235","Dell Inspiron", new BigDecimal(700));
	    laptop_dell.setDescripcion("Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors");
	    laptop_dell.setCategoria("Laptop");
	    laptop_dell.setFabricante("Dell");
	    laptop_dell.setUnidadesEnStock(1000);
	    
	    Producto tablet_Nexus = new Producto("P1236","Nexus 7", new BigDecimal(300));
	    tablet_Nexus.setDescripcion("Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon™ S4 Pro processor");
	    tablet_Nexus.setCategoria("Tablet");
	    tablet_Nexus.setFabricante("Google");
	    tablet_Nexus.setUnidadesEnStock(1000);
	    
	    listaDeProductos.add(iphone);
	    listaDeProductos.add(laptop_dell);
	    listaDeProductos.add(tablet_Nexus);
	        
    }

    @Override
    public List<Producto> getAllProductos() {
        return listaDeProductos;
    }
    
    @Override
    public Producto getProductoById(String idProducto) {
    	Producto pEncontrado = null;
    	for(Producto p: this.listaDeProductos) {
    		if(p.getIdProducto().equals(idProducto)) {
    			pEncontrado = p;
    			break;
    		}
    	}
    	return pEncontrado;
    }

	@Override
	public void create(Producto producto) {
		this.listaDeProductos.add(producto);
	}

	@Override
	public List<Producto> getProductosPorCategoria(String categoria) {
		
		return this.listaDeProductos;
	}

	@Override
	public void update(Producto producto) {
		// TODO Auto-generated method stub
		
	}

 
    @Override
    public void delete(String idProducto) {
    	// TODO Auto-generated method stub
    	
    }
    
    
    
    
}
