/*
IMPORTANTE AQUI ES DONDE SE INDICA QUE SE DEBE SACAR EL PRODUCTO
SEGUN EL COSTO POR ESO ESTA EXPRESADO EN EL ORDER BY COSTO, EN EL CURSOR C
*/

drop TRIGGER inserta_detalles;

DELIMITER //
CREATE TRIGGER inserta_detalles
 AFTER INSERT ON DETALLE_VENTA_PRODUCTO
/*
usa este detalle, para que uses el ID_VENTA, a traves de eso vas a poder actualizar un campo
en la venta que se llame : Utilidad y que sea la resta del costo en almacen entre el precio de venta
*/
 FOR EACH ROW
 BEGIN
declare x int(11) default 0;
declare id_ int(11) default 0;

/*
agregado para las salidas en almacen
*/
DECLARE id_cliente  int(11) default 0;
DECLARE desc_ubicacion VARCHAR(370) default '';


DECLARE id_deta  int(50);
DECLARE _cant int(10);
DECLARE _resto int(10);
DECLARE _ID_TIENDA  INT(11);
DECLARE err_no_more_records CONDITION FOR 1329;
DECLARE c CURSOR FOR select dt.ID_DETALLE_ALMACEN_PRODUCTOS, dt.QUEDARON,dt.ID_TIENDA
,UF.NOMBRE_UBICACION_FISICA from DETALLE_ALMACEN_PRODUCTOS dt 
inner join UBICACION_FISICA UF on UF.ID_UBICACION_FISICA = dt.ID_UBICACION_FISICA
where dt.ID_PRODUCTO=new.ID_PRODUCTO and dt.ID_ESTADO_PRODUCTO_COSTO_ALMACEN=1

order by dt.COSTO;
DECLARE EXIT HANDLER FOR err_no_more_records



BEGIN
END;


/*agregado un nuevo into para cliente.*/
/*select ID_CLIENTE into id_cliente from VENTA where ID_VENTA = NEW.ID_VENTA;   */

select distinct v.ID_TIENDA, v.ID_CLIENTE into id_ , id_cliente  from DETALLE_VENTA_PRODUCTO dt inner join VENTA v
on dt.ID_VENTA=v.ID_VENTA where v.ID_VENTA=NEW.ID_VENTA;
UPDATE STOCK_PRODUCTO_TIENDA_ORIGEN AS stk
set stk.CANTIDAD = stk.CANTIDAD-NEW.CANTIDAD
where stk.ID_PRODUCTO = new.ID_PRODUCTO and stk.ID_TIENDA_ORIGEN = id_;
set _resto =new.CANTIDAD;
OPEN c;

SET x = 0;
size: LOOP
FETCH c INTO id_deta,_cant,_ID_TIENDA,desc_ubicacion;

if id_  = _ID_TIENDA and _cant <= _resto then



update DETALLE_ALMACEN_PRODUCTOS set ID_ESTADO_PRODUCTO_COSTO_ALMACEN=2,SALIERON=SALIERON+_cant,QUEDARON=0  
WHERE ID_DETALLE_ALMACEN_PRODUCTOS=id_deta;
/*
agregando la referencia a orden de salida en almacen
*/
insert ORDEN_SALIDA_DETALLE_ALMACEN_PRODUCTOS(ID_DETALLE_ALMACEN_PRODUCTOS,ID_CLIENTE,OBSERVACIONES_UBICACION,
FECHA_REGISTRO,CODIGO_FACTURA_BOLETA,CANTIDAD,ID_ESTADO_ORDEN_SALIDA_DETALLE_ALMACEN_PRODUCTOS)
values (id_deta,id_cliente,desc_ubicacion, NOW(),NEW.ID_VENTA,_cant,1);


set _resto = _resto - _cant;
else

if id_  = _ID_TIENDA then
update DETALLE_ALMACEN_PRODUCTOS set ID_ESTADO_PRODUCTO_COSTO_ALMACEN=1,SALIERON=SALIERON + _resto,QUEDARON=QUEDARON-_resto
WHERE ID_DETALLE_ALMACEN_PRODUCTOS=id_deta;
/*
agregando la referencia a orden de salida en almacen
*/
insert ORDEN_SALIDA_DETALLE_ALMACEN_PRODUCTOS(ID_DETALLE_ALMACEN_PRODUCTOS,ID_CLIENTE,OBSERVACIONES_UBICACION,
FECHA_REGISTRO,CODIGO_FACTURA_BOLETA,CANTIDAD,ID_ESTADO_ORDEN_SALIDA_DETALLE_ALMACEN_PRODUCTOS)
values (id_deta,id_cliente,desc_ubicacion,NOW(),NEW.ID_VENTA,_resto,1);

set _resto=0;
end if;


end if;


  if _resto=0 then
 leave size; 
           
end if;

END LOOP size;
CLOSE c;


END//
DELIMITER ;












drop TRIGGER inserta_detalles_factura;

DELIMITER //
CREATE TRIGGER inserta_detalles_factura
 AFTER INSERT ON DETALLE_FACTURA_VENTA_PRODUCTO
/*
usa este detalle, para que uses el ID_VENTA, a traves de eso vas a poder actualizar un campo
en la venta que se llame : Utilidad y que sea la resta del costo en almacen entre el precio de venta
*/
 FOR EACH ROW
 BEGIN
declare x int(11) default 0;
declare id_ int(12) default 0;

/*
agregado para las salidas en almacen
*/
DECLARE id_cliente  int(11) default 0;
DECLARE desc_ubicacion VARCHAR(370) default '';


DECLARE id_deta  int(50);
DECLARE _cant int(10);
DECLARE _resto int(10);
DECLARE _ID_TIENDA  INT(11);
DECLARE err_no_more_records CONDITION FOR 1329;
DECLARE c CURSOR FOR select dt.ID_DETALLE_ALMACEN_PRODUCTOS, dt.QUEDARON,dt.ID_TIENDA
,UF.NOMBRE_UBICACION_FISICA from DETALLE_ALMACEN_PRODUCTOS dt 
inner join UBICACION_FISICA UF on UF.ID_UBICACION_FISICA = dt.ID_UBICACION_FISICA
where dt.ID_PRODUCTO=new.ID_PRODUCTO and dt.ID_ESTADO_PRODUCTO_COSTO_ALMACEN=1
order by dt.COSTO;
DECLARE EXIT HANDLER FOR err_no_more_records



BEGIN
END;

/*agregado un nuevo into para cliente.*/
select distinct v.ID_TIENDA, v.ID_CLIENTE into id_ , id_cliente from DETALLE_FACTURA_VENTA_PRODUCTO dt inner join FACTURA_VENTA v
on dt.ID_FACTURA_VENTA=v.ID_FACTURA_VENTA where v.ID_FACTURA_VENTA=NEW.ID_FACTURA_VENTA;
UPDATE STOCK_PRODUCTO_TIENDA_ORIGEN AS stk
set stk.CANTIDAD = stk.CANTIDAD-NEW.CANTIDAD
where stk.ID_PRODUCTO = new.ID_PRODUCTO and stk.ID_TIENDA_ORIGEN = id_;

set _resto =new.CANTIDAD;
OPEN c;

SET x = 0;
size: LOOP
FETCH c INTO id_deta,_cant,_ID_TIENDA,desc_ubicacion;

if id_  = _ID_TIENDA and _cant <= _resto then



update DETALLE_ALMACEN_PRODUCTOS set ID_ESTADO_PRODUCTO_COSTO_ALMACEN=2,SALIERON=SALIERON+_cant,QUEDARON=0  
WHERE ID_DETALLE_ALMACEN_PRODUCTOS=id_deta;


/*
agregando la referencia a orden de salida en almacen
*/
insert ORDEN_SALIDA_DETALLE_ALMACEN_PRODUCTOS(ID_DETALLE_ALMACEN_PRODUCTOS,ID_CLIENTE,OBSERVACIONES_UBICACION,
FECHA_REGISTRO,CODIGO_FACTURA_BOLETA,CANTIDAD,ID_ESTADO_ORDEN_SALIDA_DETALLE_ALMACEN_PRODUCTOS)
values (id_deta,id_cliente,desc_ubicacion, NOW(),NEW.ID_FACTURA_VENTA,_cant,1);



set _resto = _resto - _cant;
else

if id_  = _ID_TIENDA then
update DETALLE_ALMACEN_PRODUCTOS set ID_ESTADO_PRODUCTO_COSTO_ALMACEN=1,SALIERON=SALIERON + _resto,QUEDARON=QUEDARON-_resto
WHERE ID_DETALLE_ALMACEN_PRODUCTOS=id_deta;

/*
agregando la referencia a orden de salida en almacen
*/
insert ORDEN_SALIDA_DETALLE_ALMACEN_PRODUCTOS(ID_DETALLE_ALMACEN_PRODUCTOS,ID_CLIENTE,OBSERVACIONES_UBICACION,
FECHA_REGISTRO,CODIGO_FACTURA_BOLETA,CANTIDAD,ID_ESTADO_ORDEN_SALIDA_DETALLE_ALMACEN_PRODUCTOS)
values (id_deta,id_cliente,desc_ubicacion,NOW(),NEW.ID_FACTURA_VENTA,_resto,1);


set _resto=0;
end if;


end if;


  if _resto=0 then
 leave size; 
           
end if;

END LOOP size;
CLOSE c;


END//
DELIMITER ;


DROP TABLE VENTA_RAPIDA;
/* CREADO PARA CODIGO DE BARRAS */
CREATE TABLE VENTA_RAPIDA(
ID_VENTA_RAPIDA INT(11) NOT NULL AUTO_INCREMENT,
FECHA_VENTA DATE NOT NULL ,
ID_TIENDA int(11) NOT NULL,
PRIMARY KEY (ID_VENTA_RAPIDA),
FOREIGN KEY (ID_TIENDA) REFERENCES TIENDA (ID_TIENDA)
)ENGINE=InnoDB;

CREATE TABLE DETALLE_VENTA_RAPIDA_PRODUCTO(
ID_DETALLE_VENTA_RAPIDA_PRODUCTO INT(11) NOT NULL AUTO_INCREMENT,
ID_VENTA_RAPIDA INT(11) NOT NULL,
ID_CLIENTE int(11) NOT NULL,
ID_PRODUCTO INT(11) NOT NULL,
PRECIO_VENTA DECIMAL (9,2) NOT NULL,
CANTIDAD INT NOT NULL DEFAULT 1,
PRIMARY KEY (ID_DETALLE_VENTA_RAPIDA_PRODUCTO),
FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTO (ID_PRODUCTO),
FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTE (ID_CLIENTE),
FOREIGN KEY (ID_VENTA_RAPIDA) REFERENCES VENTA_RAPIDA (ID_VENTA_RAPIDA)
)ENGINE=InnoDB;


ALTER TABLE DETALLE_UBICACION_FISICA_PRODUCTO ADD CANTIDAD INT NOT NULL default 1;


DELIMITER //
CREATE TRIGGER inserta_venta_rapida
 AFTER INSERT ON DETALLE_VENTA_RAPIDA_PRODUCTO
 FOR EACH ROW
 BEGIN
declare id_ int(11) default 0;

select distinct v.ID_TIENDA into id_ from DETALLE_VENTA_RAPIDA_PRODUCTO dt 
inner join VENTA_RAPIDA v
on dt.ID_VENTA_RAPIDA=v.ID_VENTA_RAPIDA where v.ID_VENTA_RAPIDA=NEW.ID_VENTA_RAPIDA;

UPDATE STOCK_PRODUCTO_TIENDA_ORIGEN AS stk
set stk.CANTIDAD = stk.CANTIDAD-NEW.CANTIDAD
where stk.ID_PRODUCTO = new.ID_PRODUCTO and stk.ID_TIENDA_ORIGEN = id_;
/*  TIENES QUE AGERGAR LAS ORDENES DE SALIDA */

END//
DELIMITER ;




DELIMITER //
CREATE TRIGGER elimina_venta_rapida
 BEFORE delete ON DETALLE_VENTA_RAPIDA_PRODUCTO
 FOR EACH ROW
 BEGIN
declare id_ int(11) default 0;

select distinct v.ID_TIENDA into id_ from DETALLE_VENTA_RAPIDA_PRODUCTO dt 
inner join VENTA_RAPIDA v
on dt.ID_VENTA_RAPIDA=v.ID_VENTA_RAPIDA where v.ID_VENTA_RAPIDA=OLD.ID_VENTA_RAPIDA;

UPDATE STOCK_PRODUCTO_TIENDA_ORIGEN AS stk
set stk.CANTIDAD = stk.CANTIDAD+OLD.CANTIDAD
where stk.ID_PRODUCTO = OLD.ID_PRODUCTO and stk.ID_TIENDA_ORIGEN = id_;

/*  TIENES QUE AGERGAR LAS ORDENES DE SALIDA */

END//
DELIMITER ;
