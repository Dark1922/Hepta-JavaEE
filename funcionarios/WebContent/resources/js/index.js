var inicio = new Vue({
	el:"#inicio",
    data: {
        lista: []
    },
    created: function(){
        let vm =  this;
        vm.listarFuncionarios();
    },
    methods:{
	//Busca os itens para a lista da primeira página
        listarFuncionarios: function(){
			const vm = this;
			axios.get("http://localhost:8080/funcionarios/rs/funcionarios")
			.then(response => {vm.lista = response.data;
			}).catch(function (error) {
				vm.mostraAlertaErro("Erro interno", "Não foi possível listar funcionários.");
			}).finally(function() {
			});
		},
        mostraAlertaErro(title, message){
            alert(title + ' - ' + message);
        },
        deletarItem(id){
           if (confirm("Tem certeza que deseja excluir?")){
                axios.delete(`http://localhost:8080/funcionarios/rs/funcionarios/${id}`)
                .then(response => {
                    alert(response.data);
                    this.listarFuncionarios();
                });
           } else {

           }

        },
     
         editarItem(id){
            window.location.href = `pages/editar-funcionario.html?${id}`;
        },

    },
});