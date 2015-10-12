CREATE SCHEMA IF NOT EXISTS `app_comprar_passagens_aereas` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;

CREATE TABLE IF NOT EXISTS `app_comprar_passagens_aereas`.`Aeroporto` (
  `idAeroporto` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(150) NOT NULL,
  `sigla` VARCHAR(3) NOT NULL,
  `endereco` VARCHAR(255) NOT NULL,
  `dataCadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idAeroporto`),
  UNIQUE INDEX `sigla_UNIQUE` (`sigla` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `app_comprar_passagens_aereas`.`Aeronave` (
  `idAeronave` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(150) NOT NULL,
  `familia` VARCHAR(80) NOT NULL,
  `modelo` VARCHAR(80) NOT NULL,
  `assentosTotal` INT NOT NULL DEFAULT 0,
  `assentosVagosTotal` INT NOT NULL DEFAULT 0,
  `status` ENUM('Disponível', 'Reservado', 'Inativo') NOT NULL,
  `dataCadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idAeronave`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `app_comprar_passagens_aereas`.`Voo` (
  `idVoo` INT NOT NULL AUTO_INCREMENT,
  `idAeronave` INT NOT NULL,
  `idAeroportoOrigem` INT NOT NULL,
  `idAeroportoDestino` INT NOT NULL,
  `valor` DOUBLE NOT NULL,
  `status` ENUM('Disponível', 'Cancelado', 'Adiado', 'Prorrogado', 'Suspenso', 'Transferido', 'Pendente') NOT NULL,
  `dataPartida` TIMESTAMP NOT NULL,
  `dataCadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idVoo`),
  INDEX `isAeronave_idx` (`idAeronave` ASC),
  INDEX `FK_idAeroportoOrigem_idx` (`idAeroportoOrigem` ASC),
  INDEX `FK_idAeroportoDestino_idx` (`idAeroportoDestino` ASC),
  CONSTRAINT `FK_idAeronave`
    FOREIGN KEY (`idAeronave`)
    REFERENCES `app_comprar_passagens_aereas`.`Aeronave` (`idAeronave`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_idAeroportoOrigem`
    FOREIGN KEY (`idAeroportoOrigem`)
    REFERENCES `app_comprar_passagens_aereas`.`Aeroporto` (`idAeroporto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_idAeroportoDestino`
    FOREIGN KEY (`idAeroportoDestino`)
    REFERENCES `app_comprar_passagens_aereas`.`Aeroporto` (`idAeroporto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `app_comprar_passagens_aereas`.`Assento` (
  `idAssento` INT NOT NULL AUTO_INCREMENT,
  `idAeronave` INT NOT NULL,
  `classe` ENUM('Executiva', 'Econômica', 'Bagagem') NOT NULL,
  `localizacao` VARCHAR(4) NOT NULL,
  `status` ENUM('Disponivel', 'Ocupado') NOT NULL,
  `dataCadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idAssento`),
  INDEX `Aeronave_idAssento_idx` (`idAeronave` ASC),
  CONSTRAINT `Aeronave_idAssento`
    FOREIGN KEY (`idAeronave`)
    REFERENCES `app_comprar_passagens_aereas`.`Aeronave` (`idAeronave`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `app_comprar_passagens_aereas`.`Passagem` (
  `idPassagem` INT NOT NULL AUTO_INCREMENT,
  `idVoo` INT NOT NULL,
  `status` ENUM('Confirmado', 'Transferido', 'Cancelado') NOT NULL,
  `valorTotal` DOUBLE NOT NULL,
  `dataCheckin` TIMESTAMP NOT NULL DEFAULT 0,
  `dataCadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idPassagem`),
  INDEX `idVoo_idx` (`idVoo` ASC),
  CONSTRAINT `idVoo`
    FOREIGN KEY (`idVoo`)
    REFERENCES `app_comprar_passagens_aereas`.`Voo` (`idVoo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `app_comprar_passagens_aereas`.`Passageiro` (
  `idPassageiro` INT NOT NULL AUTO_INCREMENT,
  `formaTratamento` ENUM('Sr.', 'Sra.', 'Srta.', 'Madame') NOT NULL,
  `nomeCompleto` VARCHAR(100) NOT NULL,
  `genero` ENUM('M', 'F') NOT NULL,
  `dataNascimento` DATE NOT NULL,
  `perfil` ENUM('Adulto','Criança','Bebê') NOT NULL,
  `cpf` BIGINT NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `telefone` VARCHAR(16) NULL DEFAULT NULL,
  `responsavel` TINYINT(1) NOT NULL,
  `dataCadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idPassageiro`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `app_comprar_passagens_aereas`.`PassagemPassageiro` (
  `idPassagemPassageiro` INT NOT NULL AUTO_INCREMENT,
  `idPassagem` INT NOT NULL,
  `idPassageiro` INT NOT NULL,
  PRIMARY KEY (`idPassagemPassageiro`),
  INDEX `PassagemPassageiro_idPassagem_idx` (`idPassagem` ASC),
  INDEX `PassagemPassageiro_idPassageiro_idx` (`idPassageiro` ASC),
  CONSTRAINT `PassagemPassageiro_idPassagem`
    FOREIGN KEY (`idPassagem`)
    REFERENCES `app_comprar_passagens_aereas`.`Passagem` (`idPassagem`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `PassagemPassageiro_idPassageiro`
    FOREIGN KEY (`idPassageiro`)
    REFERENCES `app_comprar_passagens_aereas`.`Passageiro` (`idPassageiro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `app_comprar_passagens_aereas`.`Pagamento` (
  `idPagamento` INT NOT NULL AUTO_INCREMENT,
  `idPassagem` INT NOT NULL,
  `tipoPagamento` ENUM('Crédito', 'Débito') NOT NULL,
  `valorPago` DOUBLE NOT NULL,
  `dataPagamento` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idPagamento`),
  INDEX `idPassagem_idx` (`idPassagem` ASC),
  CONSTRAINT `idPassagem`
    FOREIGN KEY (`idPassagem`)
    REFERENCES `app_comprar_passagens_aereas`.`Passagem` (`idPassagem`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `app_comprar_passagens_aereas`.`Credito` (
  `idCredito` INT NOT NULL AUTO_INCREMENT,
  `idPagamento` INT NOT NULL,
  `idPassageiro` INT NOT NULL,
  `numeroCartao` INT NOT NULL,
  `codigoSeguranca` INT NOT NULL,
  `validade` VARCHAR(4) NOT NULL,
  `numeroParcelas` INT NOT NULL,
  `dataCadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idCredito`),
  INDEX `idPagamento_idx` (`idPagamento` ASC),
  INDEX `Credito_idPassageiro_idx` (`idPassageiro` ASC),
  CONSTRAINT `Credito_idPagamento`
    FOREIGN KEY (`idPagamento`)
    REFERENCES `app_comprar_passagens_aereas`.`Pagamento` (`idPagamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Credito_idPassageiro`
    FOREIGN KEY (`idPassageiro`)
    REFERENCES `app_comprar_passagens_aereas`.`Passageiro` (`idPassageiro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `app_comprar_passagens_aereas`.`Debito` (
  `idDebito` INT NOT NULL AUTO_INCREMENT,
  `idPagamento` INT NOT NULL,
  `idPassageiro` INT NOT NULL,
  `instituicaoBancaria` VARCHAR(45) NOT NULL,
  `agencia` INT NOT NULL,
  `conta` INT NOT NULL,
  `dataCadastro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idDebito`),
  INDEX `Debito_idPagamento_idx` (`idPagamento` ASC),
  INDEX `Debito_idPassageiro_idx` (`idPassageiro` ASC),
  CONSTRAINT `Debito_idPagamento`
    FOREIGN KEY (`idPagamento`)
    REFERENCES `app_comprar_passagens_aereas`.`Pagamento` (`idPagamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Debito_idPassageiro`
    FOREIGN KEY (`idPassageiro`)
    REFERENCES `app_comprar_passagens_aereas`.`Passageiro` (`idPassageiro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
