function validateVields() {
	if (frmContact.name.value === "") {
		alert('Preencha o campo Nome')
		frmContact2.name.focus()
		return false
	} else if (frmContact.fone.value === "") {
		alert('Preencha o campo Fone')
		frmContact2.fone.focus()
		return false
	} else if (frmContact.zipCode.value === "") {
		alert('Preencha o campo CEP')
		frmContact.zipCode.focus()
		return false
	} else {
		document.forms["frmContact"].submit()
	}
}
