
DROP PROCEDURE IF EXISTS proc_drop_all_fk_constraints_CF73904F;

DELIMITER //
CREATE PROCEDURE proc_drop_all_fk_constraints_CF73904F()
BEGIN
	DECLARE tableNames VARCHAR(500);
	DECLARE i INT default 1;
	DECLARE count INT default 1;
	DECLARE tableName varchar(100);

	declare fkConstraintName varchar(100);

	SET tableNames = "AttributeSetInstanceStateEventRemovedProperties TeamPlayers TeamMascots TeamStateEventPlayers TeamStateEventMascots"; 
	SET i = 1;
	SET count = CHAR_LENGTH(tableNames) - CHAR_LENGTH(REPLACE(tableNames,' ','')) + 1;  
	
	WHILE i <= count  DO  
    
		set tableName = SUBSTRING_INDEX(SUBSTRING_INDEX(tableNames, ' ' , i), ' ' , -1);
        
		set fkConstraintName = (SELECT CONSTRAINT_NAME FROM information_schema.TABLE_CONSTRAINTS WHERE
					CONSTRAINT_SCHEMA = DATABASE() AND
					TABLE_NAME        = tableName AND
					CONSTRAINT_TYPE   = 'FOREIGN KEY');
                    
		set @sqlVar = if(fkConstraintName is not null, 
					concat('ALTER TABLE ', tableName, ' drop foreign key ', fkConstraintName),
					'select 1');
                    
		prepare stmt from @sqlVar;
		execute stmt;		
		DEALLOCATE PREPARE stmt;

		SET i = i + 1;
	END WHILE;
    
END //

call proc_drop_all_fk_constraints_CF73904F();

DROP PROCEDURE IF EXISTS proc_drop_all_fk_constraints_CF73904F;


