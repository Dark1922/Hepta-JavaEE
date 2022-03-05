Primeiramente deve-se criar um banco com duas tabelas, no caso foi utilizado MySQL da seguinte forma:

CREATE DATABASE hepta;

CREATE TABLE funcionario (
ID_FUNCIONARIO INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
NOME VARCHAR(30),
FK_SETOR INT,
NU_SALARIO DOUBLE,
DS_EMAIL VARCHAR(30),
NU_IDADE INT,
FOREIGN KEY (FK_SETOR) REFERENCES SETOR(ID_SETOR)
);

CREATE TABLE setor (
ID_SETOR INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
NOME VARCHAR(30)
);

Foi utilizado o Tomcat v9.0.48 no eclipse para testes no servidor.

Deve-se executar o servidor a ser utilizado e acessar a url no navegador http://localhost:8080/funcionarios/rs/funcionarios

Os testes poderão ser feitos atraves do arquivo com.hepta.funcionarios.test.FuncionarioServiceTest.java com JUnit.

Execute o front end index.html com o Open with live Server do visual Studio Code.