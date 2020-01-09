/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.5.28 : Database - mybatis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
USE `mybatis`;

/*Table structure for table `tb_class` */

DROP TABLE IF EXISTS `tb_class`;

CREATE TABLE `tb_class` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(20) DEFAULT NULL,
  `c_ht_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  UNIQUE KEY `c_ht_id` (`c_ht_id`),
  CONSTRAINT `tb_class_ibfk_1` FOREIGN KEY (`c_ht_id`) REFERENCES `tb_head_teacher` (`ht_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `tb_class` */

insert  into `tb_class`(`c_id`,`c_name`,`c_ht_id`) values 
(1,'Senior Two, Two Clas',1);

/*Table structure for table `tb_course` */

DROP TABLE IF EXISTS `tb_course`;

CREATE TABLE `tb_course` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(20) DEFAULT NULL,
  `c_credit` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `tb_course` */

insert  into `tb_course`(`c_id`,`c_name`,`c_credit`) values 
(1,'Math',5),
(2,'Computer',4),
(3,'History',3);

/*Table structure for table `tb_head_teacher` */

DROP TABLE IF EXISTS `tb_head_teacher`;

CREATE TABLE `tb_head_teacher` (
  `ht_id` int(11) NOT NULL AUTO_INCREMENT,
  `ht_name` varchar(20) DEFAULT NULL,
  `ht_age` int(11) DEFAULT NULL,
  PRIMARY KEY (`ht_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `tb_head_teacher` */

insert  into `tb_head_teacher`(`ht_id`,`ht_name`,`ht_age`) values 
(1,'Lei Alishanda Yilish',40);

/*Table structure for table `tb_select_course` */

DROP TABLE IF EXISTS `tb_select_course`;

CREATE TABLE `tb_select_course` (
  `sc_s_id` int(11) NOT NULL DEFAULT '0',
  `sc_c_id` int(11) NOT NULL DEFAULT '0',
  `sc_date` date DEFAULT NULL,
  PRIMARY KEY (`sc_s_id`,`sc_c_id`),
  KEY `sc_c_id` (`sc_c_id`),
  CONSTRAINT `tb_select_course_ibfk_1` FOREIGN KEY (`sc_s_id`) REFERENCES `tb_student` (`s_id`),
  CONSTRAINT `tb_select_course_ibfk_2` FOREIGN KEY (`sc_c_id`) REFERENCES `tb_course` (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_select_course` */

insert  into `tb_select_course`(`sc_s_id`,`sc_c_id`,`sc_date`) values 
(1,1,'2017-03-01'),
(1,2,'2017-03-01'),
(1,3,'2020-01-01'),
(2,1,'2017-03-02'),
(2,2,'2017-03-02'),
(3,1,'2020-01-09');

/*Table structure for table `tb_student` */

DROP TABLE IF EXISTS `tb_student`;

CREATE TABLE `tb_student` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(20) DEFAULT NULL,
  `s_sex` varchar(10) DEFAULT NULL,
  `s_age` int(11) DEFAULT NULL,
  `s_c_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`s_id`),
  KEY `s_c_id` (`s_c_id`),
  CONSTRAINT `tb_student_ibfk_1` FOREIGN KEY (`s_c_id`) REFERENCES `tb_class` (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `tb_student` */

insert  into `tb_student`(`s_id`,`s_name`,`s_sex`,`s_age`,`s_c_id`) values 
(1,'Tom','male',18,1),
(2,'Jack','male',19,1),
(3,'Rose','female',18,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`sex`,`address`) values 
(1,'Cui Ming','999111','male','chongqing'),
(2,'wang Ming','999222','female','beijing Road 101');

/*Table structure for table `user2` */

DROP TABLE IF EXISTS `user2`;

CREATE TABLE `user2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `user2` */

insert  into `user2`(`id`,`username`,`password`,`sex`,`age`,`phone`,`address`) values 
(1,'Tom','123456','male',18,'18200123456','chengdu');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
