function gestionBtnUpload() {
	if (document.uploadForm.file.files.length == 0) {
		document.uploadForm.bt_upload.disabled = true;
	} else {
		document.uploadForm.bt_upload.disabled = false;
	}
}


function gestionBtnUploadRegister() {
	var theme = document.uploadForm.theme.value;
	if (theme == "null") {
		document.uploadForm.bt_upload.disabled = true;
	} else {
		document.uploadForm.bt_upload.disabled = false;
	}
}