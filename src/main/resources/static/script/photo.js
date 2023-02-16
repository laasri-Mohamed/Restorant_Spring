$(document)
	.ready(
		function() {

			table = $('#tphoto')
				.DataTable({
					ajax: {
						url: "photos/all",
						dataSrc: ''
					},
					columnDefs: [{
						targets: 2,
						render: function(dat) {
							console.log(dat.url);
							return "<img max-width: 100% src='img/" + dat.url + "' alt='" + dat.resto.nom + "'>";
						}
					}],
					columns: [
						{
							data: "id"
						},
						{
							data: "resto.nom"
						},
						{
							data: null
						},
						{
							"render": function() {
								return '<button type="button" class="btn btn-outline-danger supprimer">Supprimer</button>';
							}

						}]

				});


			$.ajax({
				url: '/villes/all',
				type: 'GET',
				success: function(data) {
					var option = '';
					data.forEach(e => {
						option += '<option value =' + e.id + '>' + e.nom + '</option>';
					});

					$('#ville').append(option);
				},
				error: function(jqXHR, textStatus,
					errorThrown) {
					console.log(textStatus);
				}

			});

			$('#ville').on('change', function() {
				var countryId = this.value;
				$('#zone').html('');
				$.ajax({
					url: '/zones/findByIdVille/' + countryId,
					type: 'get',
					success: function(res) {

						$('#zone').html('<option value="">Select Zone</option>');
						$.each(res, function(key, value) {
							$('#zone').append('<option value =' + value.id + '>' + value.nom + '</option>');
						});
					}
				});
			});

			$('#zone').on('change', function() {
				var zoneId = this.value;
				$('#resto').html('');
				$.ajax({
					url: '/restos/findByIdZone/' + zoneId,
					type: 'get',
					success: function(res) {

						$('#resto').html('<option value="">Select Restaurant</option>');
						$.each(res, function(key, value) {
							$('#resto').append('<option value =' + value.id + '>' + value.nom + '</option>');
						});
					}
				});
			});

			

			$('#table-content')
				.on(
					'click',
					'.supprimer',
					function() {

						var id = $(this).closest('tr').find(
							'td').eq(0).text();
						var oldLing = $(this).closest('tr')
							.clone();
						var newLigne = '<tr style="position: relative;" class="bg-light" ><th scope="row">'
							+ id
							+ '</th><td colspan="4" style="height: 100%;">';
						newLigne += '<h4 class="d-inline-flex">Voulez vous vraiment supprimer ce restaurant ? </h4>';
						newLigne += '<button type="button" class="btn btn-outline-primary btn-sm confirmer" style="margin-left: 25px;">Oui</button>';
						newLigne += '<button type="button" class="btn btn-outline-danger btn-sm annuler" style="margin-left: 25px;">Non</button></td></tr>';

						$(this).closest('tr').replaceWith(
							newLigne);
						$('.annuler').click(
							function() {
								$(this).closest('tr')
									.replaceWith(
										oldLing);
							});
						$('.confirmer')
							.click(
								function(e) {
									e.preventDefault();
									$
										.ajax({
											url: 'photos/delete/'
												+ id,
											data: {},
											type: 'DELETE',
											async: false,
											success: function(
												data,
												textStatus,
												jqXHR) {
												if (data
													.includes("error") == true) {
													$(
														"#error")
														.modal();
												} else {
													table.ajax
														.reload();
												}
											},
											error: function(
												jqXHR,
												textStatus,
												errorThrown) {
												$(
													"#error")
													.modal();
											}
										});

								});

					});

			$('#table-content').on(
				'click',
				'.modifier',
				function() {
					var btn = $('#btn');
					var id = $(this).closest('tr').find('td').eq(0)
						.text();
					;
					var url = $(this).closest('tr').find('td')
						.eq(4).text();

					var resto = $(this).closest('tr').find('td')
						.eq(8).text();
					btn.text('Modifier');
					$("#nom").val(resto);
					$("#adresse").val(adresse);
					$("#openTime").val(openTime);
					$("#id").val(id);
					$("#closeTime").val(closeTime);
					$("#week").val(week);
					$("#rank").val(rank);
					var op = $('#serie option').filter(function() { return $(this).html() == serie; }).val();
					$("#serie").val(op);
					var op1 = $('#zone option').filter(function() { return $(this).html() == zone; }).val();
					$("#zone").val(op1);
					btn.click(function(e) {
						e.preventDefault();
						var p = {
							id: $("#id").val(),
							nom: $("#nom").val(),
							adresse: $("#adresse").val(),
							openTime: $("#openTime").val(),
							closeTime: $("#closeTime").val(),
							week: $("#week").val(),
							rank: $("#rank").val(),
							serie: {
								id: $("#serie").val()

							},
							zone: {
								id: $("#zone").val()

							}
						};
						if ($('#btn').text() == 'Modifier') {
							$.ajax({
								url: 'photos/save',
								contentType: "application/json",
								dataType: "json",
								data: JSON.stringify(p),
								type: 'POST',
								async: false,
								success: function(data,
									textStatus, jqXHR) {
									table.ajax.reload();
									$("#adresse").val('');
									$("#nom").val('');
									btn.text('Ajouter');
								},
								error: function(jqXHR, textStatus,
									errorThrown) {
									console.log(textStatus);
								}
							});
							$("#main-content").load(
								"./page/photo.html");
						}
					});
				});


			const selectImage = document.querySelector('.select-image');
			const inputFile = document.querySelector('#file');
			const imgArea = document.querySelector('.img-area');

			selectImage.addEventListener('click', function() {
				inputFile.click();
			})

			inputFile.addEventListener('change', function() {
				const image = this.files[0]
				if (image.size < 2000000) {
					const reader = new FileReader();
					reader.onload = () => {
						const allImg = imgArea.querySelectorAll('img');
						allImg.forEach(item => item.remove());
						const imgUrl = reader.result;
						const img = document.createElement('img');
						img.src = imgUrl;
						imgArea.appendChild(img);
						imgArea.classList.add('active');
						imgArea.dataset.img = image.name;
					}
					reader.readAsDataURL(image);
				} else {
					alert("Image size more than 2MB");
				}
			})


			// function remplir(data) {
			// var contenu = $('#table-content');
			// var ligne = "";
			// for (i = 0; i < data.length; i++) {
			// ligne += '<tr><th scope="row">' + data[i].id + '</th>';
			// ligne += '<td>' + data[i].code + '</td>';
			// ligne += '<td>' + data[i].nom + '</td>';
			// ligne += '<td>' + data[i].prix + '</td>';
			// ligne += '<td>' + data[i].dateAchat + '</td>';
			// ligne += '<td><button type="button" class="btn
			// btn-outline-danger
			// supprimer">Supprimer</button></td>';
			// ligne += '<td><button type="button" class="btn
			// btn-outline-secondary
			// modifier">Modifier</button></td></tr>';
			// }
			// contenu.html(ligne);
			// }

			// $.ajax({
			// url: 'photos/all',
			// data: {op: ''},
			// type: 'GET',
			// async: false,
			// success: function (data, textStatus, jqXHR) {
			// console.log(data);
			// remplir(data);
			// },
			// error: function (jqXHR, textStatus, errorThrown) {
			// console.log(textStatus);
			// }
			// });
		});
