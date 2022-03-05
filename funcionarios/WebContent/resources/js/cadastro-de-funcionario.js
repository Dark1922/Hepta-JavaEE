var cadastro = new Vue({
    el:"#cadastro",
    data: {
        setores: [],
        funcionario: {
            nome: null,
            setor: {
                id : null
            },
        salario: null,
        email: null,
        idade: null,
        },
     
    },
    created: function(){
        let vm = this;
        vm.listarSetores();
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
        cadastrarFuncionario(){
            const vm = this;
            axios.post("http://localhost:8080/funcionarios/rs/funcionarios", vm.funcionario)
                .then(response => {
                    alert("Cadastrado com Sucesso", response.data);
                    vm.usuarioSalvo();
                  
                }).catch(error => {
                    alert("Preencha os dados corretamente");
                })
        },
          usuarioSalvo(){
            window.location.href = '/pages/novo-funcionario.html';
        },
       

    }
})