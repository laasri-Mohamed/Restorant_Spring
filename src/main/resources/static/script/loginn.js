			function _(e) {
				return document.getElementById(e);
			}
			let displayform = _('displayForm');
			let forlogin = _('forLogin');
			let loginForm = _('loginForm');
			let forRegister = _('forRegister');
			let registerForm = _('registerForm');
			let formContainer = _('formContainer');
			displayform.addEventListener('click', showForm);

			forlogin.addEventListener('click', (e) => {
				e.preventDefault;
				forRegister.classList.remove('active');
				forlogin.classList.add('active');
				if (loginForm.classList.contains('toggleForm')) {
					formContainer.style.transform = 'translate(0%)';
					formContainer.style.transition = 'transform .5s';
					loginForm.classList.remove('toggleForm');
					registerForm.classList.add('toggleForm');
				}
			});

			forRegister.addEventListener('click', (e) => {
				e.preventDefault;
				forlogin.classList.remove('active');
				forRegister.classList.add('active');
				if (registerForm.classList.contains('toggleForm')) {
					formContainer.style.transform = 'translate(-100%)';
					formContainer.style.transition = 'transform .5s';
					registerForm.classList.remove('toggleForm');
					loginForm.classList.add('toggleForm');
				}
			});

			function showForm() {
				document.querySelector('.formWrapper .card').classList.toggle('show');
			}
