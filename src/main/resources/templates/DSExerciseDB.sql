CREATE DATABASE IF NOT EXISTS `DSExercise`;
USE `DSExercise`;
DROP TABLE `foundpet`;
SELECT * FROM `lostpet`;
UPDATE `user_security` SET `password` = '$2a$12$byuEdx6ktDHX7c8LHm4lzuDj5qeHzf.phOdPFZVy3qraG01FceJjG' WHERE email = "root";
ALTER TABLE `pet`
    ADD CONSTRAINT `FK_DETAIL_amkaOwner_citizen` FOREIGN KEY (`amkaOwner`)
        REFERENCES `citizen` (`AMKA`) ON DELETE CASCADE;
SHOW TABLES;



CREATE TABLE `administrator` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `password`  varchar(45) DEFAULT NULL,
                                 `email` varchar(45) UNIQUE DEFAULT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `citizen` (
                           `AMKA` int(11) UNIQUE NOT NULL auto_increment,
                           `fullName` varchar(45)  NOT NULL,
                           `municipalHouse` varchar(45) NOT NULL,
                           `password` varchar(45)  NOT NULL,
                           `email` varchar(45) UNIQUE NOT NULL,
                           `address` varchar(45) NOT NULL,
                           `age` varchar(45) NOT NULL,
                           PRIMARY KEY (`AMKA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pet` (
                       `numberOfMicrochip` int(45) UNIQUE NOT NULL auto_increment,
                       `race` varchar(45) DEFAULT NULL,
                       `gender` varchar(45) DEFAULT NULL,
                       `dateOfBirth` varchar(45) DEFAULT NULL,
                       `amkaOwner` int(11) DEFAULT NULL,
                       PRIMARY KEY (`numberOfMicrochip`),
                       KEY `FK_DETAIL_amkaOwner_citizen` (`amkaOwner`),
                       CONSTRAINT `FK_DETAIL_pet` FOREIGN KEY (`amkaOwner`) REFERENCES `citizen` (`AMKA`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `vet` (
                       `AMKA` int(11) UNIQUE NOT NULL auto_increment,
                       `fullName` varchar(45) DEFAULT NULL,
                       `municipalHouse` varchar(45) DEFAULT NULL,
                       `password` varchar(45)  DEFAULT NULL,
                       `email` varchar(45) UNIQUE DEFAULT NULL,
                       `age` int(11) DEFAULT NULL,
                       PRIMARY KEY (`AMKA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `municipalEmployee` (
                                     `AMKA` int(11) UNIQUE NOT NULL,
                                     `fullName` varchar(45) DEFAULT NULL,
                                     `municipalHouse` varchar(45) DEFAULT NULL,
                                     `password` varchar(45)  DEFAULT NULL,
                                     `email` varchar(45) UNIQUE DEFAULT NULL,
                                     PRIMARY KEY (`AMKA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
                        `AMKA` int(11) UNIQUE NOT NULL,
                        `fullName` varchar(45) DEFAULT NULL,
                        PRIMARY KEY (`AMKA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `administrator` VALUES
                                (1,'12345','argiris@hua.gr'),
                                (2,'12345','mara@hua.gr');

INSERT INTO `citizen` values
                          (0123456789,'Panagiotis','Patra','1234','panos@hua.gr','kapou',13),
                          (1234567890,'Rafail','Kalamata','1234','rafail@hua.gr','kapou allou',14);

INSERT INTO `vet` values
                      (01,'Giorgos','Athina','1234','giorgos@hua.gr',13),
                      (12,'Maria','Korinthos','1234','maria@hua.gr',14);

INSERT INTO `municipalEmployee` values
                                    (1,'Mhtsos','Thessaloniki','1234','mhtsos@hua.gr'),
                                    (2,'Xristina','Volos','1234','xristina@hua.gr');

INSERT INTO `pet` values
                      ('1234','pitbull','arseniko','kapote','0123456789'),
                      ('12345','rontvailer','thhlyko','pote','1234567890');

CREATE TABLE IF NOT EXISTS `user_security` (
    `email` varchar(50) UNIQUE NOT NULL,
    `password` varchar(100) NOT NULL,
    `enabled` tinyint(1) NOT NULL,
    PRIMARY KEY (`email`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `authorities` (
    `email` varchar(50) UNIQUE NOT NULL,
    `authority` varchar(50) NOT NULL,
    UNIQUE KEY `ix_auth_email` (`email`,`authority`),
    CONSTRAINT `fk_authorities_users` FOREIGN KEY (`email`) REFERENCES `user_security` (`email`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user_security` (`email`, `password`, `enabled`) VALUES
                                                                 ('panos@hua.gr', '$2a$12$iC8.o5Tv7rCHlCja5sdl0u.Ew25HojnR1RdbF6h5uLsIUcAg.miSi', 1),
                                                                 ('rafail@hua.gr', '$2a$12$iC8.o5Tv7rCHlCja5sdl0u.Ew25HojnR1RdbF6h5uLsIUcAg.miSi', 1),
                                                                 ('giorgos@hua.gr', '$2a$12$iC8.o5Tv7rCHlCja5sdl0u.Ew25HojnR1RdbF6h5uLsIUcAg.miSi', 1),
                                                                 ('maria@hua.gr', '$2a$12$iC8.o5Tv7rCHlCja5sdl0u.Ew25HojnR1RdbF6h5uLsIUcAg.miSi', 1),
                                                                 ('mhtsos@hua.gr', '$2a$12$iC8.o5Tv7rCHlCja5sdl0u.Ew25HojnR1RdbF6h5uLsIUcAg.miSi', 1),
                                                                 ('xristina@hua.gr', '$2a$12$iC8.o5Tv7rCHlCja5sdl0u.Ew25HojnR1RdbF6h5uLsIUcAg.miSi', 1),			/* pass for all other users = 1234 */
                                                                 ('argiris@hua.gr', '$2a$12$byuEdx6ktDHX7c8LHm4lzuDj5qeHzf.phOdPFZVy3qraG01FceJjG', 1),
                                                                 ('mara@hua.gr', '$2a$12$byuEdx6ktDHX7c8LHm4lzuDj5qeHzf.phOdPFZVy3qraG01FceJjG', 1);			/* pass for admins = 12345 */

INSERT INTO `authorities` (`email`, `authority`) VALUES
                                                     ('argiris@hua.gr', 'ROLE_ADMIN'),
                                                     ('mara@hua.gr', 'ROLE_ADMIN'),
                                                     ('panos@hua.gr', 'ROLE_CITIZEN'),
                                                     ('rafail@hua.gr', 'ROLE_CITIZEN'),
                                                     ('giorgos@hua.gr', 'ROLE_VET'),
                                                     ('maria@hua.gr', 'ROLE_VET'),
                                                     ('mhtsos@hua.gr', 'ROLE_MUNICIPAL'),
                                                     ('xristina@hua.gr', 'ROLE_MUNICIPAL');

CREATE TABLE `vet_pet` (
                           `vet_amka` int(45) NOT NULL,
                           `pet_microchip` int(45) NOT NULL,
                           PRIMARY KEY (`vet_amka`,`pet_microchip`),
                           KEY `FK_VET_idx` (`vet_amka`),
                           CONSTRAINT `FK_VET` FOREIGN KEY (`vet_amka`)
                               REFERENCES `vet` (`AMKA`)
                               ON DELETE NO ACTION ON UPDATE NO ACTION,
                           CONSTRAINT `FK_PET` FOREIGN KEY (`pet_microchip`)
                               REFERENCES `pet` (`numberOfMicrochip`)
                               ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `municipalEmployee_pet` (
                                         `municipalEmployee_amka` int(11) NOT NULL,
                                         `pet_microchip` int(45) NOT NULL,
                                         PRIMARY KEY (`municipalEmployee_amka`,`pet_microchip`),
                                         KEY `FK_municipalEmployee_idx` (`municipalEmployee_amka`),
                                         CONSTRAINT `FK_municipalEmployee` FOREIGN KEY (`municipalEmployee_amka`)
                                             REFERENCES `municipalemployee` (`AMKA`)
                                             ON DELETE NO ACTION ON UPDATE NO ACTION,
                                         CONSTRAINT `FK_PET2` FOREIGN KEY (`pet_microchip`)
                                             REFERENCES `pet` (`numberOfMicrochip`)
                                             ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `municipalEmployee_citizen` (
                                             `municipalEmployee_amka` int(11) NOT NULL,
                                             `citizen_amka` int(11) NOT NULL,
                                             PRIMARY KEY (`municipalEmployee_amka`,`citizen_amka`),
                                             KEY `FK_municipalEmployee_idx` (`municipalEmployee_amka`),
                                             CONSTRAINT `FK_municipalEmployee2` FOREIGN KEY (`municipalEmployee_amka`)
                                                 REFERENCES `municipalemployee` (`AMKA`)
                                                 ON DELETE NO ACTION ON UPDATE NO ACTION,
                                             CONSTRAINT `FK_CITIZEN` FOREIGN KEY (`citizen_amka`)
                                                 REFERENCES `citizen` (`AMKA`)
                                                 ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table `lostPet`(
                          `amkaOwner` int(11) DEFAULT NULL,
                          `numberOfMicrochip` int(45) UNIQUE NOT NULL auto_increment,
                          PRIMARY KEY (`numberOfMicrochip`)
);

create table `foundPet`(
                           `numberOfMicrochip` int(45) UNIQUE NOT NULL auto_increment,
                           PRIMARY KEY (`numberOfMicrochip`)
);

INSERT INTO `lostPet` values
                          ('123456789','1234'),
                          ('1478529630','8741');

INSERT INTO `foundPet` values
    ('123456789');

create table `lostPet_pet`(
                              `pet_numberOfMicrochip` int(45) NOT NULL,
                              `lostPet_numberOfMicrochip` int(45) NOT NULL,
                              PRIMARY KEY (`pet_numberOfMicrochip`,`lostPet_numberOfMicrochip`),
                              KEY `FK_pet_idx` (`pet_numberOfMicrochip`),
                              CONSTRAINT `FK_pet1` FOREIGN KEY (`pet_numberOfMicrochip`)
                                  REFERENCES `pet` (`numberOfMicrochip`)
                                  ON DELETE NO ACTION ON UPDATE NO ACTION,
                              CONSTRAINT `FK_lostPet` FOREIGN KEY (`lostPet_numberOfMicrochip`)
                                  REFERENCES `lostPet` (`numberOfMicrochip`)
                                  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table `foundPet_pet`(
                               `pet_numberOfMicrochip` int(45) NOT NULL,
                               `foundPet_numberOfMicrochip` int(45) NOT NULL,
                               PRIMARY KEY (`pet_numberOfMicrochip`,`foundPet_numberOfMicrochip`),
                               KEY `FK_pet_idx` (`pet_numberOfMicrochip`),
                               CONSTRAINT `FK_pet3` FOREIGN KEY (`pet_numberOfMicrochip`)
                                   REFERENCES `pet` (`numberOfMicrochip`)
                                   ON DELETE NO ACTION ON UPDATE NO ACTION,
                               CONSTRAINT `FK_foundPet` FOREIGN KEY (`foundPet_numberOfMicrochip`)
                                   REFERENCES `foundPet` (`numberOfMicrochip`)
                                   ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


