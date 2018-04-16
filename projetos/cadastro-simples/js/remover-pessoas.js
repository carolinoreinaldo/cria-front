var tblCadastro = document.querySelector('#tbl-cadastro');
tblCadastro.addEventListener('click', (event) =>{
	var target = event.target;
	if(target.name == 'btn-remover'){
		target.parentNode.parentNode.classList.add('fadeOut');
		setTimeout(() => {
			target.parentNode.parentNode.remove();	
		}, 500);
	}
});