import PubSub from '../helpers/pub_sub.js';

class InstrumentFamilyView {

  constructor(container) {
    this.container = container;
  }

  bindEvents() {
    PubSub.subscribe('InstrumentFamilies:selected-family-ready', (evt) => {
      const instrumentFamily = evt.detail;
      this.render(instrumentFamily);
    });
  }
  render({name, description, instruments}){
    // OR:
  // render(stuff) {
  //   const {name, description, instruments} = stuff;
  //
    // OR:
  //   const name = stuff.name;
  //   const description = stuff.description;
  //   const instruments = stuff.instruments;

    this.container.innerHTML = '';

    const familyName = this.createElement('h2', name);
    this.container.appendChild(familyName);

    const familyDescription = this.createElement('p', description);
    this.container.appendChild(familyDescription);

    const instrumentListTitle = this.createElement('h3', 'Instruments include:');
    this.container.appendChild(instrumentListTitle);

    const instrumentList = this.createInstrumentList(instruments);
    this.container.appendChild(instrumentList);
  }

  createElement(elementType, text) {
    const element = document.createElement(elementType);
    element.textContent = text;
    return element;
  }

  createInstrumentList(instruments) {
    const list = document.createElement('ul');

    instruments.forEach((instrument) => {
      const listItem = document.createElement('li');
      listItem.textContent = instrument;
      list.appendChild(listItem);
    });

    return list;
  }

}

export default InstrumentFamilyView;
