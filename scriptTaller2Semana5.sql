-- -----------------------------------------------------
-- Schema crud contactos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS crud_contactos DEFAULT CHARACTER SET utf8 ;
USE crud_contactos ;

-- -----------------------------------------------------
-- Table contacto
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS contacto (
  id INT NOT NULL AUTO_INCREMENT,
  nombre_completo VARCHAR(45) NOT NULL,
  fecha_nacimiento DATE NOT NULL,
  created_at DATETIME NOT NULL,
  update_at DATETIME NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX fecha_nacimiento_UNIQUE (fecha_nacimiento ASC, nombre_completo ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table telefono`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS telefono (
  id INT NOT NULL AUTO_INCREMENT,
  contacto_id INT NOT NULL,
  telefono VARCHAR(45) NOT NULL,
  created_at DATETIME NOT NULL,
  update_at DATETIME NULL,
  PRIMARY KEY (id),
  INDEX fk_telefono_contacto_idx (contacto_id ASC) VISIBLE,
  CONSTRAINT fk_telefono_contacto
    FOREIGN KEY (contacto_id)
    REFERENCES contacto (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table email`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS email (
  id INT NOT NULL AUTO_INCREMENT,
  contacto_id INT NOT NULL,
  email VARCHAR(45) NOT NULL,
  created_at DATETIME NOT NULL,
  update_at DATETIME NULL,
  PRIMARY KEY (id),
  INDEX fk_email_contacto1_idx (contacto_id ASC) VISIBLE,
  CONSTRAINT fk_email_contacto1
    FOREIGN KEY (contacto_id)
    REFERENCES contacto (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- --------------------------------------
-- Insertar el script a ejecutar, abajo.
-- --------------------------------------

