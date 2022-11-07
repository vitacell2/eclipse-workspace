create table HR.PRODUCTOS_2 (
       idProducto varchar2(5 char) not null,
        categoria varchar2(255 char),
        condiciones varchar2(255 char),
        descripcion varchar2(255 char),
        disponible number(1,0) not null,
        fabricante varchar2(255 char),
        nombre varchar2(255 char),
        precionUnitario number(19,2),
        unidadesEnPedido number(19,0) not null,
        unidadesEnStock number(19,0) not null,
        primary key (idProducto)
);  
    

DROP TABLE HR.PEDIDO;

 CREATE TABLE HR.PEDIDO(
 	ID INTEGER NOT NULL PRIMARY KEY, 
 	FECHA_PEDIDO DATE NOT NULL,
 	CANTIDAD INTEGER NULL,
 	ID_PRODUCTO VARCHAR2(5) NOT NULL
);

ALTER TABLE HR.PEDIDO
ADD FOREIGN KEY (ID_PRODUCTO) REFERENCES HR.PRODUCTOS_2 (idProducto);

    
CREATE SEQUENCE HR.PEDIDO_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1;