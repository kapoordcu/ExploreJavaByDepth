CREATE TABLE STUDENT (
 ID 						INT  NOT NULL AUTO_INCREMENT,
 NAME               VARCHAR(15) NOT NULL,
 PRIMARY KEY (ID)
 ) ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE SUBJECT (
STUDENTID INT ZEROFILL NOT NULL REFERENCES EMPLOYEE(ID),
 SUBJECT               VARCHAR(15) NOT NULL
 ) ENGINE = InnoDB
AUTO_INCREMENT = 1;

INSERT INTO STUDENT (NAME) VALUES ('Samantha');
INSERT INTO STUDENT (NAME) VALUES ('Jane');
INSERT INTO STUDENT (NAME) VALUES ('Bob');
INSERT INTO STUDENT (NAME) VALUES ('Scarlet');
INSERT INTO STUDENT (NAME) VALUES ('David');


INSERT INTO SUBJECT (STUDENTID,SUBJECT) VALUES (1, 'Biology');
INSERT INTO SUBJECT (STUDENTID,SUBJECT) VALUES (1, 'Physics');
INSERT INTO SUBJECT (STUDENTID,SUBJECT) VALUES (3, 'History');
INSERT INTO SUBJECT (STUDENTID,SUBJECT) VALUES (4, 'Geography');
INSERT INTO SUBJECT (STUDENTID,SUBJECT) VALUES (4, 'Geography');


SELECT ID, RESULT.SUBJECT, RESULT.STUDENTS_SUBJECT_COUNT FROM STUDENT s INNER JOIN (SELECT
    STUDENTID, SUBJECT, COUNT(*) AS STUDENTS_SUBJECT_COUNT
FROM
    SUBJECT
GROUP BY
    STUDENTID, SUBJECT) RESULT ON(s.ID= RESULT.STUDENTID);


-- // Select Employee with Max Salary
SELECT MAX(SALARY) FROM EMPLOYEE
WHERE SALARY < (SELECT MAX(SALARY) FROM EMPLOYEE);

-- // Select range of employees based on id
SELECT * FROM EMPLOYEE WHERE ID BETWEEN 5 AND 7;

-- // Return employee name, highest salary and department CROSS JOIN
SELECT emp.FNAME, emp.SALARY, dep.DNAME
FROM EMPLOYEE as emp, DEPARTMENT as dep
WHERE emp.DNO = dep.DNUMBER && emp.SALARY=(select max(SALARY) from EMPLOYEE);

-- // Using INNER JOIN
SELECT emp.FNAME, emp.SALARY, dep.DNAME
FROM EMPLOYEE as emp INNER JOIN DEPARTMENT as dep
ON (emp.DNO = dep.DNUMBER) WHERE emp.SALARY IN (select max(SALARY) from EMPLOYEE);


-- // Department wise Salary
SELECT emp.FNAME, emp.SALARY, dep.DNAME from EMPLOYEE as emp INNER JOIN DEPARTMENT as dep
ON (emp.DNO = dep.DNUMBER)
WHERE emp.SALARY IN (select max(SALARY) from EMPLOYEE GROUP BY DNO);


-- // TOP N Salary
SELECT SALARY FROM
(SELECT DISTINCT SALARY, FNAME FROM EMPLOYEE ORDER BY SALARY DESC LIMIT 3)
RESULT ORDER BY SALARY LIMIT 1;


-- // Using CTE = Common Table Expression
WITH RESULT AS (SELECT SALARY, DENSE_RANK() OVER (ORDER BY SALARY DESC) DESCRANK FROM EMPLOYEE)
SELECT SALARY FROM RESULT WHERE DESCRANK=3;

-- CREATE DATABASE IF NOT EXISTS practicesql;
-- use practicesql;

-- CREATE TABLE EMPLOYEE (
--  ID 						INT  NOT NULL AUTO_INCREMENT,
--  FNAME               VARCHAR(15) NOT NULL,
--  LNAME               VARCHAR(15) NOT NULL,
--  SSN                 CHAR(9) NOT NULL,
--  SALARY              DECIMAL(10,2),
--  SUPERSSN            CHAR(9),
--  DNO                 INT NOT NULL,
--  PRIMARY KEY (ID)
--  ) ENGINE = InnoDB
-- AUTO_INCREMENT = 1;



-- INSERT INTO EMPLOYEE (FNAME,LNAME, SSN, SALARY, SUPERSSN, DNO) VALUES ('Lars','Monsen', '3985095', 75000, null, 1);
-- INSERT INTO EMPLOYEE (FNAME,LNAME, SSN, SALARY, SUPERSSN, DNO) VALUES ('Rest','Monsen', '894809',  55000, null, 2);
-- INSERT INTO EMPLOYEE (FNAME,LNAME, SSN, SALARY, SUPERSSN, DNO) VALUES ('Jhan','Gretyjs', '9856789', 23000, null, 3);
-- INSERT INTO EMPLOYEE (FNAME,LNAME, SSN, SALARY, SUPERSSN, DNO) VALUES ('Great', 'Tahdkjd', '7980022', 81020, null, 2);
-- INSERT INTO EMPLOYEE (FNAME,LNAME, SSN, SALARY, SUPERSSN, DNO) VALUES ('Tesndiki', 'Ragsnjs', '0847839', 30241 , null, 2);
-- INSERT INTO EMPLOYEE (FNAME,LNAME, SSN, SALARY, SUPERSSN, DNO) VALUES ('Elias', 'Reajns', '9892292',  56000, null, 3);
-- INSERT INTO EMPLOYEE (FNAME,LNAME, SSN, SALARY, SUPERSSN, DNO) VALUES ('Stas', 'Halks', '34242',  43000, null, 1);
-- INSERT INTO EMPLOYEE (FNAME,LNAME, SSN, SALARY, SUPERSSN, DNO) VALUES ('Jhakjs', 'Minut', '2754443', 60210 , null, 1);
-- INSERT INTO EMPLOYEE (FNAME,LNAME, SSN, SALARY, SUPERSSN, DNO) VALUES ('Jlkalk', 'Ulalks', '774534',  62060, null, 2);
-- INSERT INTO EMPLOYEE (FNAME,LNAME, SSN, SALARY, SUPERSSN, DNO) VALUES ('Diclksa', 'Kslls', '96755',  63500, null, 8);
-- INSERT INTO EMPLOYEE (FNAME,LNAME, SSN, SALARY, SUPERSSN, DNO) VALUES ('Tjhkaj', 'Uoadj', '9802903',  68000, null, 4);
-- INSERT INTO EMPLOYEE (FNAME,LNAME, SSN, SALARY, SUPERSSN, DNO) VALUES ('Reths', 'Grauij', '09948242',  75000, null, 2);
-- INSERT INTO EMPLOYEE (FNAME,LNAME, SSN, SALARY, SUPERSSN, DNO) VALUES ('Greg', 'manto', '98932',  36000, null, 1);
-- INSERT INTO EMPLOYEE (FNAME,LNAME, SSN, SALARY, SUPERSSN, DNO) VALUES ('JIjdowkd', 'owds', '8924802', 75012, null, 2);


-- CREATE TABLE DEPARTMENT (
-- DNUMBER INT ZEROFILL NOT NULL AUTO_INCREMENT REFERENCES EMPLOYEE(ID),
--  DNAME               VARCHAR(15) NOT NULL,
--   MGRSSN              CHAR(9),
--  MGRSTARTDATE        DATE,
--   PRIMARY KEY (DNUMBER)
--  ) ENGINE = InnoDB
-- AUTO_INCREMENT = 1;

-- INSERT INTO DEPARTMENT (DNAME,MGRSSN, MGRSTARTDATE) VALUES ('Digital', '3985095', CURDATE());
-- INSERT INTO DEPARTMENT (DNAME,MGRSSN, MGRSTARTDATE) VALUES ('HR', '0847839', CURDATE()-2);
-- INSERT INTO DEPARTMENT (DNAME,MGRSSN, MGRSTARTDATE) VALUES ('Customer', '9892292', CURDATE()-5);
-- select * from DEPARTMENT;

-- desc EMPLOYEE;
-- desc DEPARTMENT;

























-- CREATE DATABASE IF NOT EXISTS passwordchecker;

-- use passwordchecker;

-- CREATE TABLE `passwords` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `password` varchar(50) NOT NULL,
--   `valid` tinyint(1) NOT NULL,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=202 ;

-- INSERT INTO `passwords` (`id`, `password`, `valid`) VALUES
-- (1, 'UQSWcFkUJA89ukFfRk4=', 0),
-- (2, 'EGfydOOCfrDo05pr3Q==', 0),
-- (3, 'Fy7UUrb5', 0),
-- (4, 'k/9Tktp/CIJsomY=', 0),
-- (5, 'HXjgq00rhxTbPQ==', 0),
-- (6, 'T8A=', 0),
-- (7, 'u2AeRVOtiD5MNQ==', 0),
-- (8, '8mYpMA==', 0),
-- (9, 'JQQ=', 0),
-- (10, 'GbCzfQyNYJvqh1Y=', 0),
-- (11, 'SsV0EUFyg5KSpMIJlw==', 0),
-- (12, 'D/vLH3dcWyfmPOG9', 0),
-- (13, 'bzAr4hZxbQsSAByYcZs=', 0),
-- (14, 'WSNeuA960uLntUtZQw==', 0),
-- (15, 'BKk3sN7IDDQIC2k=', 0),
-- (16, 'dd6SRQ==', 0),
-- (17, 'GtNfHAsuI+sBt6Uw', 0),
-- (18, 'DMQTbWM=', 0),
-- (19, '3Lk=', 0),
-- (20, 'tsCaZhg=', 0),
-- (21, 'FY1px8r1', 0),
-- (22, 'ZPk=', 0),
-- (23, 'G7Fcc3B7XBVRmJU=', 0),
-- (24, 'dRC6yfK20h8=', 0),
-- (25, 'cPGX82NRiO/39B4=', 0),
-- (26, '8vDr/8w53A==', 0),
-- (27, 'DNzZgF6CQt2Y', 0),
-- (28, 'niRg', 0),
-- (29, 'F05dr7wv', 0),
-- (30, 'SQ8zF9zv8gU=', 0),
-- (31, 'q+16ZMhQiIhEVqFu', 0),
-- (32, '69f1RCU=', 0),
-- (33, '4TcmfCd4', 0),
-- (34, 'tfeb8w', 0),
-- (35, 'kAU=', 0),
-- (36, '9aQ=', 0),
-- (37, 'd4LrAw==', 0),
-- (38, '4RYUCquasyhB3A==', 0),
-- (39, '5J2jYA==', 0),
-- (40, '9axZsg==', 0),
-- (41, 'brNCHS4QZg==', 0),
-- (42, 'x4jP', 0),
-- (43, 'KgM=', 0),
-- (44, 'eCK7jCWHPg==', 0),
-- (45, 'Ntk=', 0),
-- (46, 'WEFbJx/NWXwf/LbI', 0),
-- (47, 'Sb1z8G3RgKI1', 0),
-- (48, 'BZ8kcpICOx05rkdX', 0),
-- (49, 'qZfF', 0),
-- (50, 'rZmsJmkk6KffSQ==', 0),
-- (51, 'Yelo', 0),
-- (52, 'jP/LJJqQMw==', 0),
-- (53, '/lwxetPi5bj6NN8=', 0),
-- (54, 'mLbUxL2berJb//Iw', 0),
-- (55, 'ba6cnLBuUFnCiiw3YNs=', 0),
-- (56, 'R/7nZUqOsa4=', 0),
-- (57, 'CGruCg==', 0),
-- (58, 'ATfWwk+AJ2M=', 0),
-- (59, 'sclRi84seEDL', 0),
-- (60, 'VRFoGpfQIf8=', 0),
-- (61, 'wJQ=', 0),
-- (62, 'fsdU3czo', 0),
-- (63, 'Xytr0GNS/aEFuBk=', 0),
-- (64, 'TDusp7FM', 0),
-- (65, '+LK3Bt2DpWs=', 0),
-- (66, 'Pw/teEyDegrf6wM=', 0),
-- (67, 'LVOlG1ti', 0),
-- (68, 'yoiz+0qfDo+8Iw==', 0),
-- (69, 'fZgWbxYeFQ==', 0),
-- (70, '1n3DDDATb5uN', 0),
-- (71, 'Mer6ykZe93Ihx2ty', 0),
-- (72, 'b/oQPV3u8e0IU6VIjg==', 0),
-- (73, 'j4uDsVwmqk+CZuU=', 0),
-- (74, 'Opx7q3a24Bq+YsCb', 0),
-- (75, 'BRU4nX0=', 0),
-- (76, 'Of7NwyUeGFEHH76V', 0),
-- (77, 'oIfPhrwB97unKQ==', 0),
-- (78, 'YlcehePdOUFHgewhyQ==', 0),
-- (79, 'fxjw2lD9oy+B', 0),
-- (80, '5wyBJbsV1K+nwqA=', 0),
-- (81, 'ZBm3UJhXR7Qb', 0),
-- (82, 'gDRIcjBDbR0jh2E=', 0),
-- (83, 'fkQH', 0),
-- (84, 'gO5AhzQ=', 0),
-- (85, 'ie+W4383tL0=', 0),
-- (86, 'p/Q=', 0),
-- (87, '2yIfUJEXSD1Q3C0=', 0),
-- (88, 'c1e34Ub7Jd3pwA==', 0),
-- (89, 'm7rsg8Bdqfuw', 0),
-- (90, '9NZneETC', 0),
-- (91, 'zZLX', 0),
-- (92, 'd+0g+wbjUi4c', 0),
-- (93, 'AKRJr9evUBkm6w==', 0),
-- (94, 'qg0fpoTdIafzGreZMA==', 0),
-- (95, 'ev8jaXH++DUjBM7Nqec=', 0),
-- (96, '7hti&', 0),
-- (97, 'GsuLP+3XSnt05g==', 0),
-- (98, 'HGfMpOyh', 0),
-- (99, '7qKlfKoqI43Suts=', 0),
-- (100, 'YSs=', 0),
-- (101, 'LnVETr/Co/gCLEf4F3U=', 0),
-- (102, 'fadZE8J5fH+F', 0),
-- (103, 'hWuGoYt+HL3gj2QRqA==', 0),
-- (104, '36jarzQtFUKmnw==', 0),
-- (105, '1SXT+RpPAQ==', 0),
-- (106, 'KsdxZw==', 0),
-- (107, 'JHUMqglxadA=', 0),
-- (108, '3Hg=', 0),
-- (109, 'Uxg=', 0),
-- (110, 'EF4=', 0),
-- (111, 'T27hI2YBj2abNdw=', 0),
-- (112, 'KVcQZw3B/CuV', 0),
-- (113, 'rjGLX9mOEv3/NN0=', 0),
-- (114, 'pG9/bXcQpmzW6qL57w==', 0),
-- (115, 'Mk6tJQNMoMxOPrL69A==', 0),
-- (116, 'jT3ofR4=', 0),
-- (117, '9Y0LIBOuvEUjcn+vqxE=', 0),
-- (118, '6ZMKrf24woJxkA==', 0),
-- (119, 'MFBGOR7X7c77q/AamA==', 0),
-- (120, 'ZWQPdJ9Zk0kC', 0),
-- (121, '5Df4jAgKMhN5nUNCTyk=', 0),
-- (122, 'a+MjU=', 0),
-- (123, '8kB45', 0),
-- (124, 'QyODkd9kPgGQ', 0),
-- (125, 'a5Bp8TjxfONYRjbzEg==', 0),
-- (126, 'HISF', 0),
-- (127, 'j/M/E/PrY8OvnsA=', 0),
-- (128, 'xJxYJsRg13Q=', 0),
-- (129, '5iNEhBcBm9w=', 0),
-- (130, '7GTKu31KRg==', 0),
-- (131, 'xSvDZTRz/Ca9', 0),
-- (132, 'LnVjfNhfTg==', 0),
-- (133, '6HA=', 0),
-- (134, '1/XE6PD3h/M=', 0),
-- (135, 'KMiy', 0),
-- (136, 'lEkQvxBDfQ==', 0),
-- (137, 'LCSChoAQUmZt2w==', 0),
-- (138, '2YsUInILZXHW', 0),
-- (139, 'J3YPkZzW2A==', 0),
-- (140, 'eNQGjHygrQA3bg==', 0),
-- (141, 'nTO6DfKqjxEKLg==', 0),
-- (142, 'z/ET', 0),
-- (143, '/42c6w==', 0),
-- (144, 'K3wqO+FbyQ==', 0),
-- (145, '6Jo=', 0),
-- (146, 'euY=', 0),
-- (147, '1sKYnNi8Xve+TQ==', 0),
-- (148, 'fLdcOWnzDs95VBy+Kho=', 0),
-- (149, 'fs5ZHzIWPLAgc/c=', 0),
-- (150, 'PWG41UYTItI/', 0),
-- (151, 'ADcC/UJZYy8=', 0),
-- (152, 'Nmg3N856ckBbxw==', 0),
-- (153, '2lZtsvDo1uE/', 0),
-- (154, '9i9byrbFCYAL9Q==', 0),
-- (155, 'pYOmxg==', 0),
-- (156, 'kbGfC0sSIs0=', 0),
-- (157, 'ao0Oz9UdPkidOzlN', 0),
-- (158, 'N8rvf1v+qCpQAWYoCA==', 0),
-- (159, 'T+TDMFNock8TYN6L7Gk=', 0),
-- (160, 'XIlh6Hk=', 0),
-- (161, '09RkLjFS', 0),
-- (162, 'tZANiZH/FLk=', 0),
-- (163, 'Uts3bUnvSULB348=', 0),
-- (164, '8fpOyupL', 0),
-- (165, 'ggI=', 0),
-- (166, 'G2f/n2fBfWr43JCO9Q==', 0),
-- (167, 'aQ5Czi7qZ8lJUZs=', 0),
-- (168, '2g7jVJQQobmQaQ==', 0),
-- (169, 'e2pTgYTofEs=', 0),
-- (170, '7IXK', 0),
-- (171, 'GyrU0kA=', 0),
-- (172, 'AqB2Mg==', 0),
-- (173, '2v01jHM=', 0),
-- (174, '+a8iSjMATv4=', 0),
-- (175, 'V80TUZIvQyba', 0),
-- (176, 'yXAWw6Q=', 0),
-- (177, '7BmHRxklfvJO', 0),
-- (178, 'jtvhc3w=', 0),
-- (179, '4/gsPjw=', 0),
-- (180, 'TQ5RjRI=', 0),
-- (181, 'Js7FB4mA2fwJgY7ihw==', 0),
-- (182, 'zkRV+A1/P+Tx0fA=', 0),
-- (183, 'Fzey3LiX983izD1sxw==', 0),
-- (184, 'L2YSGYRbCw==', 0),
-- (185, 'SiRky3KeYA==', 0),
-- (186, '+7wo', 0),
-- (187, '0EAJwO8v3KoTflx4WB4=', 0),
-- (188, 'Z44WsQ==', 0),
-- (189, '3Xk=', 0),
-- (190, 'SS6fBqBVcl02yC3Muw==', 0),
-- (191, 'DeqifIxWG9U=', 0),
-- (192, '1Cn+wxNF', 0),
-- (193, 'sNSDUkTPQA==', 0),
-- (194, 'KlxxSw==', 0),
-- (195, 'LdPV928m6ZLwHkE=', 0),
-- (196, 'CtkCCOTrAA==', 0),
-- (197, 'GH3o', 0),
-- (198, 'Kb6nHesCIA==', 0),
-- (199, 'f8k=', 0),
-- (200, '7tKOOCPpoW1D', 0),
-- (201, '+APGv+Ik043b', 0);


-- select * from passwords;

-- #drop table passwords;
-- #drop database passwordchecker;
-- #show databases;