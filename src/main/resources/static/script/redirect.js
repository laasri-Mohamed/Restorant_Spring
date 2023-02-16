$('a').removeClass('active');
$('a:contains(Statistiques)').addClass('active');
$("#main-content").load("page/statistiques.html");

function show(page) {
	if (page == 'resto') {
		$('a').removeClass('active');
		$('a:contains(Restorants)').addClass('active');
		$("#main-content").load("page/resto.html");

		event.preventDefault();
	}
	if (page == 'specialite_resto') {
		$('a').removeClass('active');
		$('a:contains(Spécialite du restaurant)').addClass('active');
		$("#main-content").load("page/specialite_resto.html");

		event.preventDefault();
	}
	if (page == 'photo') {
		$('a').removeClass('active');
		$('a:contains(Photo)').addClass('active');
		$("#main-content").load("page/photo.html");

		event.preventDefault();
	}
	if (page == 'ville') {
		$('a').removeClass('active');
		$('a:contains(Villes)').addClass('active');
		$("#main-content").load("page/ville.html");

		event.preventDefault();
	}
	if (page == 'zone') {
		$('a').removeClass('active');
		$('a:contains(Zones)').addClass('active');
		$("#main-content").load("page/zone.html");

		event.preventDefault();
	}
	if (page == 'serie') {
		$('a').removeClass('active');
		$('a:contains(Séries)').addClass('active');
		$("#main-content").load("page/serie.html");

		event.preventDefault();
	}
	if (page == 'specialite') {
		$('a').removeClass('active');
		$('a:contains(Spécialités)').addClass('active');
		$("#main-content").load("page/specialite.html");

		event.preventDefault();
	}
	if (page == "statistiques") {
		$('a').removeClass('active');
		$('a:contains(Statistiques)').addClass('active');
		$("#main-content").load("page/statistiques.html");
		event.preventDefault();
	}
	if (page == "marques") {
		$('a').removeClass('active');
		$('a:contains(Marques)').addClass('active');
		$("#main-content").load("page/marque.html");
		event.preventDefault();
	}
	if (page == "machines") {
		$('a').removeClass('active');
		$('a:contains(Machines)').addClass('active');
		$("#main-content").load("page/machine.html");
		event.preventDefault();
	}
}
