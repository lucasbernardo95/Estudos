const AWS = require('aws-sdk');
AWS.config.update({region: 'sa-east-1'});

const ConsultaSolicitacoes = require('./dataBase.js');
const SQSAws = require('./SQS.js');

const promise = new Promise((resolve, reject) => {

    const consulta = new  ConsultaSolicitacoes();
    
    consulta.buscarMovimentacoesExpurgo().then((response) => {

        if(response) {
            //console.log(response, "Deu bom", response.length);

            var size = 10; var exportacoesSQS = [];

            const sqs = new SQSAws();

            var indiceSQS = 0;
            for (var i=0; i<response.length; i+=size) {
                exportacoesSQS.push(response.slice(i,i+size));

                sqs.enviarSolicitacaoExportacaoSQS(exportacoesSQS[indiceSQS]);

                indiceSQS++;
            }
            
            

        } else {
            console.log("Deu ruim");
        }
    }).catch((error) => {
        console.log(error, "Triste");
    });

});

function getRangeResponse(end, start, element) {
    
    return element(end - (start - 1)).fill().map((value, index) => start + index);
}