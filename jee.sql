SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `enssat_tp` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
SHOW WARNINGS;
USE `enssat_tp` ;

-- -----------------------------------------------------
-- Table `enssat_tp`.`Etudiants`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `enssat_tp`.`Etudiants` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `enssat_tp`.`Etudiants` (
  `numetudiant` VARCHAR(45) NOT NULL ,
  `nom` VARCHAR(45) NULL ,
  `prenom` VARCHAR(45) NULL ,
  `ddn` VARCHAR(45) NULL COMMENT 'date' ,
  `emailPro` VARCHAR(45) NULL ,
  `emailPerso` VARCHAR(45) NULL ,
  `bac` VARCHAR(45) NULL COMMENT 'serieBac' ,
  `anBac` VARCHAR(45) NULL ,
  `menBac` VARCHAR(45) NULL ,
  `diplome` VARCHAR(45) NULL COMMENT 'Filiere\nDUT\nCPGE PSI/..' ,
  `anDiplome` VARCHAR(45) NULL COMMENT 'annee' ,
  `villeDiplome` VARCHAR(45) NULL ,
  `S` VARCHAR(45) NULL COMMENT 'M ou F' ,
  `inscription` VARCHAR(45) NULL COMMENT 'annee' ,
  PRIMARY KEY (`numetudiant`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `enssat_tp`.`Groupes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `enssat_tp`.`Groupes` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `enssat_tp`.`Groupes` (
  `idGroupe` INT NOT NULL ,
  `nomGroupe` VARCHAR(45) NULL ,
  `nomProprietaire` VARCHAR(45) NULL ,
  `dateCreation` VARCHAR(45) NULL ,
  PRIMARY KEY (`idGroupe`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `enssat_tp`.`ListeEtudiants`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `enssat_tp`.`ListeEtudiants` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `enssat_tp`.`ListeEtudiants` (
  `Etudiants_numetudiants` VARCHAR(45) NOT NULL ,
  `table1_Groupes` INT NOT NULL ,
  PRIMARY KEY (`Etudiants_numetudiants`, `table1_Groupes`) ,
  INDEX `fk_Etudiants_has_table1_table11` (`table1_Groupes` ASC) ,
  INDEX `fk_Etudiants_has_table1_Etudiants` (`Etudiants_numetudiants` ASC) ,
  CONSTRAINT `fk_Etudiants_has_table1_Etudiants`
    FOREIGN KEY (`Etudiants_numetudiants` )
    REFERENCES `enssat_tp`.`Etudiants` (`numetudiant` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Etudiants_has_table1_table11`
    FOREIGN KEY (`table1_Groupes` )
    REFERENCES `enssat_tp`.`Groupes` (`idGroupe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `enssat_tp`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `enssat_tp`.`Users` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `enssat_tp`.`Users` (
  `pseudo` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `question` VARCHAR(45) NULL ,
  `answer` VARCHAR(45) NULL ,
  `isEditor` TINYINT(1) NOT NULL DEFAULT 0 ,
  `idAdmin` TINYINT(1) NOT NULL DEFAULT 0 ,
  PRIMARY KEY (`pseudo`) )
ENGINE = InnoDB;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `enssat_tp`.`Etudiants`
-- -----------------------------------------------------
START TRANSACTION;
USE `enssat_tp`;
INSERT INTO `enssat_tp`.`Etudiants` (`numetudiant`, `nom`, `prenom`, `ddn`, `emailPro`, `emailPerso`, `bac`, `anBac`, `menBac`, `diplome`, `anDiplome`, `villeDiplome`, `S`, `inscription`) VALUES ('mrj', 'muto', 'yugi', '01/04/1995', 'yugi@kaibacorp.com', 'exodia@otk.com', 's', '2010', 'TB', 'duelMaster', '2012', 'Pegasus', 'M', '2011');

COMMIT;

-- -----------------------------------------------------
-- Data for table `enssat_tp`.`Users`
-- -----------------------------------------------------
START TRANSACTION;
USE `enssat_tp`;
INSERT INTO `enssat_tp`.`Users` (`pseudo`, `password`, `question`, `answer`, `isEditor`, `idAdmin`) VALUES ('matt', 'hello', 'On dit merci qui ?', 'JMR', 1, 1);
INSERT INTO `enssat_tp`.`Users` (`pseudo`, `password`, `question`, `answer`, `isEditor`, `idAdmin`) VALUES ('jojo', 'poker', 'Ma question perferée ?', 'Que vais-je faire de tout cet oseille?', 1, 0);
INSERT INTO `enssat_tp`.`Users` (`pseudo`, `password`, `question`, `answer`, `isEditor`, `idAdmin`) VALUES ('remi', 'kebab', 'quelle sauce ?', 'sans sauce', 0, 0);
INSERT INTO `enssat_tp`.`Users` (`pseudo`, `password`, `question`, `answer`, `isEditor`, `idAdmin`) VALUES ('adrien', 'dodo', 'quelle heure ?', '14h', 0, 1);

COMMIT;