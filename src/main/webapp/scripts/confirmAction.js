function confirme(id) {
	if (confirm("Confirma a exclusão?")) {
		window.location.href = "delete?id=" + id
	}
}