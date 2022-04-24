const AWS = require('aws-sdk');
const mysql = require("mysql");

AWS.config.update({region: 'sa-east-1'});

const connection = mysql.createConnection({
    host: "database-1.cp5isi1guqeu.sa-east-1.rds.amazonaws.com",
    port: "3306",
    user: "master",
    password: "master123",
    database: "dbextratomovtitulo",
})

const tabela = "CREATE TABLE TABELA (id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(30) NOT NULL, sobrenome VARCHAR(30) NOT NULL, email VARCHAR(50), data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP );";
const insert = "INSERT INTO TABELA (nome, sobrenome, email) VALUES ('juliana', 'silveira', 'juliana@gmail.com'), ('neide', 'moura', 'neide@gmail.com'), ('roberto', 'mendes', 'roberto@gmail.com'),  ('maria', 'cavagnole', 'maria@gmail.com'), ('marlene', 'santos', 'marlene@gmail.com'), ('layane', 'siqueira', 'layane@gmail.com')";
const select = "SELECT id, nome, sobrenome, email FROM TABELA;";
const deleteById = "delete from TABELA WHERE id = 23";


class ConsultaSolicitacoes {

buscarMovimentacoesExpurgo(){
    return new Promise((resolve, reject) => {

        connection.query(select, function(error, result) {
            if(error){
                console.log(error, "deu zebra");
                reject(error);
            }
            
            connection.end();
            resolve(result);
        });

    });
}

}



module.exports = ConsultaSolicitacoes;