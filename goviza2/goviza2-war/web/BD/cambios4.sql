-- VAMOS A CREAR LA UBICACION EXACTA PARA TENER UN MEJOR CONTROL
-- SE TIENE QUE MODIFICAR EL CODIGO DE INGRESO DE STOCK
CREATE TABLE UBICACION_FISICA(
ID_UBICACION_FISICA int(11) NOT NULL AUTO_INCREMENT,
NOMBRE_UBICACION_FISICA VARCHAR(100) NOT NULL DEFAULT "",
DESCRIPCION_UBICACION_FISICA VARCHAR(100) NOT NULL DEFAULT "",
PRIMARY KEY (ID_UBICACION_FISICA)
)ENGINE=InnoDB;


insert into UBICACION_FISICA(NOMBRE_UBICACION_FISICA,DESCRIPCION_UBICACION_FISICA)
values('UBICACION SISTEMA','SISTEMA');

/*
vamos a alterar lacolumna de las dos tablas online
y agregamos la nueva columna.
*/

ALTER TABLE INGRESO_PRODUCTO_TIENDA DROP COLUMN UBICACION;
ALTER TABLE INGRESO_PRODUCTO_TIENDA ADD ID_UBICACION_FISICA int(11) NOT NULL default 1;
ALTER TABLE INGRESO_PRODUCTO_TIENDA ADD CONSTRAINT fk_ubicacion FOREIGN KEY (ID_UBICACION_FISICA) REFERENCES UBICACION_FISICA (ID_UBICACION_FISICA);


/* LO MISMO PARA SALIDA*/

ALTER TABLE DETALLE_ALMACEN_PRODUCTOS DROP COLUMN DESCRIPCION_UBICACION;
ALTER TABLE DETALLE_ALMACEN_PRODUCTOS ADD ID_UBICACION_FISICA int(11) NOT NULL default 1;
ALTER TABLE DETALLE_ALMACEN_PRODUCTOS ADD CONSTRAINT fk_ubicacion2 FOREIGN KEY (ID_UBICACION_FISICA) REFERENCES UBICACION_FISICA (ID_UBICACION_FISICA);

/* ELIMINAMOS EL DISPARADOR ANTERIOR*/
DROP TRIGGER inserta_ingreso_almacen;
/*CREAMOS UNO NUEVO*/
DELIMITER //
CREATE TRIGGER inserta_ingreso_almacen
 AFTER INSERT ON INGRESO_PRODUCTO_TIENDA
 FOR EACH ROW
 BEGIN

insert into DETALLE_ALMACEN_PRODUCTOS(
ID_PRODUCTO,
COSTO,
ID_TIENDA,
CANTIDAD,
SALIERON,
QUEDARON,
FECHA_INGRESO,
FECHA_VENCIMIENTO,
DESCRIPCION_MOTIVO,
ID_UBICACION_FISICA,
ID_PROCEDENCIA_PRODUCTO_ALMACEN,
ID_ESTADO_PRODUCTO_COSTO_ALMACEN)
values (new.ID_PRODUCTO,NEW.COSTO_UNITARIO,new.ID_TIENDA,NEW.CANTIDAD,0,new.CANTIDAD,new.FECHA_INGRESO,new.FECHA_VENCIMIENTO ,new.MOTIVO,new.ID_UBICACION_FISICA,1,1);

 END//
DELIMITER ;


/* me quede aqui !!! */


CREATE TABLE INVENTARIO_FISICO(
ID_INVENTARIO_FISICO int(11) NOT NULL AUTO_INCREMENT,
OBERVACIONES VARCHAR(100) NOT NULL DEFAULT "",
FECHA_INICIO DATE NOT NULL ,
FECHA_TERMINO DATE NOT NULL ,
ID_TIENDA int(11) NOT NULL,
PRIMARY KEY (ID_INVENTARIO_FISICO),
FOREIGN KEY (ID_TIENDA) REFERENCES TIENDA (ID_TIENDA)
)ENGINE=InnoDB;

CREATE TABLE DETALLE_INVENTARIO_UBICACION_FISICA(
ID_DETALLE_INVENTARIO_UBICACION_FISICA int(11) NOT NULL AUTO_INCREMENT,
ID_INVENTARIO_FISICO int(11) not null,
ID_UBICACION_FISICA int(11) NOT NULL,
PRIMARY KEY (ID_DETALLE_INVENTARIO_UBICACION_FISICA),
FOREIGN KEY (ID_INVENTARIO_FISICO) REFERENCES INVENTARIO_FISICO (ID_INVENTARIO_FISICO),
FOREIGN KEY (ID_UBICACION_FISICA) REFERENCES UBICACION_FISICA (ID_UBICACION_FISICA)
)ENGINE=InnoDB;

CREATE TABLE DETALLE_UBICACION_FISICA_PRODUCTO(
ID_DETALLE_UBICACION_FISICA_PRODUCTO int(11) NOT NULL AUTO_INCREMENT,
ID_DETALLE_INVENTARIO_UBICACION_FISICA int(11) NOT NULL,
ID_PRODUCTO int(11) NOT NULL,
PRIMARY KEY (ID_DETALLE_UBICACION_FISICA_PRODUCTO),
FOREIGN KEY (ID_DETALLE_INVENTARIO_UBICACION_FISICA) REFERENCES DETALLE_INVENTARIO_UBICACION_FISICA (ID_DETALLE_INVENTARIO_UBICACION_FISICA),
FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTO (ID_PRODUCTO)
)ENGINE=InnoDB;

