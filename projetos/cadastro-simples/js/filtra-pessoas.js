var inputPesquisaPessoa = document.querySelector('.pesquisa-nome');
inputPesquisaPessoa.addEventListener('input', function(){
	var pessoas = document.querySelectorAll('.pessoa');
	pessoas.forEach(pessoa => {
		var nome = pessoa.querySelector('.td-nome').textContent;
		//o 'i' é para indicar que é ignore case sensitive
		var regex = new RegExp(this.value, "i");
		if(!regex.test(nome)){
			pessoa.classList.add('invisivel');
		} else {
			pessoa.classList.remove('invisivel');
		}
	});
});