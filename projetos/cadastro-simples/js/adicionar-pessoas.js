var recuperarId = () => {
	var ids = document.querySelectorAll('.td-id');
	var lastId = 0;
	if(ids.length > 0) {
		lastId = ids[ids.length-1].innerHTML;
	}
	return parseInt(lastId) + 1;
}

var criarNovo = (id, nome, idade) => {
	var tdId = document.createElement('td');
	tdId.classList.add('td-id');
	tdId.innerHTML = id;

	var tdNome = document.createElement('td');
	tdNome.classList.add('td-nome');
	tdNome.innerHTML = nome;

	var tdIdade = document.createElement('td');
	tdIdade.innerHTML = idade;

	var btnRemover = document.createElement('button');
	btnRemover.name = 'btn-remover';
	btnRemover.innerHTML = 'X'
	btnRemover.classList.add('btn-remover');

	var tdRemover = document.createElement('td');
	tdRemover.appendChild(btnRemover);

	var tr = document.createElement('tr');
	tr.classList.add('pessoa');

	tr.appendChild(tdId);
	tr.appendChild(tdNome);
	tr.appendChild(tdIdade);
	tr.appendChild(tdRemover);

	document.querySelector('#tbl-cadastro').appendChild(tr);
}

var btnAdd = document.querySelector("#btn-add");
btnAdd.addEventListener('click', function(event){
	event.preventDefault();

	var inputs = document.querySelectorAll('.input-info');
	inputs.forEach(element => {
		element.classList.remove('input-error');
	});

	var id = recuperarId();
	var nome = document.querySelector('#input-nome');
	var idade = document.querySelector('#input-idade');

	var existeErro = false;
	if(nome.value == '') {
		nome.classList.add('input-error');
		existeErro = true;
	}

	if(idade.value == '') {
		idade.classList.add('input-error');
		existeErro = true;
	}

	if(existeErro){
		return;
	}

	criarNovo(id, nome.value, idade.value)
});