export default class HomeController {
    constructor($http) {
        'ngInject';

        this.$http = $http;
        this.client = {};
        this.name = 'Cadastro de Cliente';
        this.risks = [];

        this.findRisks().then((response) => {
            this.risks = response
        });
    }

    findRisks() {
        return this.$http.get("http://localhost:8082/risk").then((resp) => resp.data);
    }

    saveClient() {
        return this.$http.post("http://localhost:8082/client", this.client).then((resp) => resp.data);
    }

    save() {
        const fieldsRequired = []
        if (this.client.name == null || this.client.name == '') {
            fieldsRequired.push("Nome")
        }
        if (this.client.creditLimit == null) {
            fieldsRequired.push("Limite de crédito")
        }
        if (this.client.riskId == null) {
            fieldsRequired.push("Risco")
        }
        if (fieldsRequired.length > 0) {
            alert("Os seguintes campos são obrigatórios: " + fieldsRequired )
        } else {
            this.saveClient().then((response) => {alert("Salvo com sucesso!")}).catch((err) => {
                alert("Erro ao salvar cliente, revise os campos!")
            })
        }
    }

    getRealCreditLimit() {
        const riskSelected = this.risks.find(r => r.riskId == this.client.riskId)
        return this.client.creditLimit ? this.client.creditLimit - (this.client.creditLimit * (riskSelected ? riskSelected.percentageInterest/100 : 0)) : 0
    }
}
