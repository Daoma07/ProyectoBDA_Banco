delimiter $$
CREATE TRIGGER retiro_cuenta
before UPDATE ON retiro
FOR EACH ROW
BEGIN
if (old.estado = null and old.monto > 0) then
     
    SET new.estado = new.estado;
    set new. monto = new.monto;
    end if;
	if (old.estado = 'No cobrado' or old.estado='Cobrado') then
    SET new.estado = old.estado;
    set new.monto = old.monto;
    end if;
    if (new.estado = 'Cobrado' and old.monto > 0) then
     UPDATE cuenta
    SET saldo = saldo+new.monto
    WHERE numero_cuenta= NEW.numero_cuenta;
    
   
    
END IF ;

end; 


  # UPDATE retiro
   # SET monto = monto - new.monto
		
    #WHERE numero_cuenta= NEW.numero_cuenta;
    

  


 