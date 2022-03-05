var atualizacao = new Vue({
    el:"#atualizacao",
    data: {
        setores: [],
        funcionario: {
            nome: "",
            setor: {
                id : 0
            },
        salario: 0,
        email: "",
        idade: 0
        }
    },
    created: function(){
        let vm = this;
        vm.listarSetores();
        vm.editarFuncionario();
    },
    methods:{
        listarSetores: function(){
            const vm = this;
            axios.get("http://localhost:8080/funcionarios/rs/funcionarios/setores")
                .then(response => {
                    vm.setores = response.data;
                }).catch(error => {
                    alert("Erro interno! Não foi possível listar setores.");
                })
        },
        editarFuncionario(){
            const vm = this;
            const id = window.location.href.split("?").pop();
            axios.get(`http://localhost:8080/funcionarios/rs/funcionarios/${id}`)
                .then(response => { vm.funcionario = response.data;
                }).catch(function (error) {
                
            })
        },
        atualizarFuncionario(){
	        const vm = this;
            const id = window.location.href.split("?").pop();
            axios.put(`http://localhost:8080/funcionarios/rs/funcionarios/${id}`, vm.funcionario)
                .then(response => {
                    alert(response.data);
                   
                }).catch(error => {
                    alert("Erro interno! Não foi possível atualizar funcionário.");
                })
        },
       

    }
})