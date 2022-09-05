const applicantForm = document.getElementById('newForm');
applicantForm.addEventListener('submit', handleFormSubmit);

function serializeForm(formN) {
    return new FormData(formN);
}

function handleFormSubmit(events) {
    serializeForm(applicantForm);
}

function checkValidity(event) {
    const formN = event.target.form;
    const isValid = formN.checkValidity();

    formN.querySelector('button').disabled = !isValid;
}

applicantForm.addEventListener('input', checkValidity);