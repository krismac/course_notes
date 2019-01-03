document.addEventListener('DOMContentLoaded', () => {

  const button = document.querySelector('#button');
  button.addEventListener('click', handleButtonClick);

  const textInput = document.querySelector('#input');
  textInput.addEventListener('input', handleInput);

  const select = document.querySelector('#select');
  select.addEventListener('change', handleSelectChange);

  const form = document.querySelector('#form');
  form.addEventListener('submit', handleFormSubmit);

});

const handleButtonClick = function() {
  const resultParagraph = document.querySelector('#button-result');
  resultParagraph.textContent = 'That button has definitely been clicked.';
}

const handleInput = function(event) {
  const resultParagraph = document.querySelector('#input-result');
  resultParagraph.textContent = `You typed: ${event.target.value}`;
}

const handleSelectChange = function(event) {
  const resultParagraph = document.querySelector('#select-result');
  resultParagraph.textContent = `You went with: "${event.target.value}".`;
}

const handleFormSubmit = function(event) {
  event.preventDefault();
  const resultParagraph = document.querySelector('#form-result');
  resultParagraph.textContent = `
    Your name:
    ${this.first_name.value}
    ${this.last_name.value}
  `
}
