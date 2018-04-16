var btnBuscaPessoas = document.querySelector('#busca-pessoas');

btnBuscaPessoas.addEventListener('click', () => {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "https://api-pacientes.herokuapp.com/pacientes");

    xhr.addEventListener('load', () => {
        if(xhr.status == 304 || xhr.status == 200){
            var resposta = xhr.responseText;
            var pessoas = JSON.parse(resposta);
            pessoas.forEach(pessoa => {
                criarNovo(recuperarId(), pessoa.nome, pessoa.peso);
            });
        } else {
            alert("Ocorreu um erro ao buscar as pessoas no servidor.\n\n STATUS: " + xhr.status + "\n\nERRO:" + xhr.responseText);
        }
    });
    xhr.send();
});