export default class ClientListingController {
    constructor($http) {
        'ngInject';

        this.$http = $http;
        this.name = 'Listagem de Clientes';
        this.clients = [];

        this.findClients().then((response) => {
            this.clients = response
        });
    }

    findClients() {
        return this.$http.get("http://localhost:8082/client").then((resp) => resp.data);
    }

    delete(clientId) {
        this.$http.delete("http://localhost:8082/client/" + clientId)
            .then((resp) => {
                this.findClients().then((response) => {
                    this.clients = response
                });
                alert("Cliente excluído")
            })
            .catch((err) => alert("Erro ao excluir cliente!"));
    }
}