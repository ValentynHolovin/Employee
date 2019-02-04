CREATE TABLE IF NOT EXISTS `employees`
(
  `id`      INT(11)     NOT NULL AUTO_INCREMENT,
  `name`    VARCHAR(50) NOT NULL,
  `boss_id` INT(11)     NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `boss_FK1` (`boss_id`),
  UNIQUE INDEX `id` (`id`),
  CONSTRAINT `boss_FK1` FOREIGN KEY (`boss_id`) REFERENCES `employees` (`id`)
)
COLLATE='utf8_general_ci'
ENGINE = InnoDB;