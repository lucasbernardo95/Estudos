const AWS = require('aws-sdk');

AWS.config.update({region: 'sa-east-1'});
AWS.config.loadFromPath('./config.json');

var sqs = new AWS.SQS({apiVersion: '2012-11-05'});

class SQSAws {

    enviarSolicitacaoExportacaoSQS(mensagem){
        console.log("enviando dados para SQS aws");

        const mensagemFormatada = formatarMensagem(mensagem);

        sqs.sendMessage(mensagemFormatada, function(err, data) {
            if (err) {
              console.log("Error", err);
            } else {
              console.log("Success", data);
            }
          });
    };

}

function formatarMensagem(mensagem) {
    return  {
        MessageBody: JSON.stringify(mensagem),
        QueueUrl: "https://sqs.sa-east-1.amazonaws.com/252675654047/expurgoSolicitacoes.fifo",
        MessageDeduplicationId: "ID-"+mensagem[0].nome,
        MessageGroupId: "UserOrders"
    };
}

module.exports = SQSAws;