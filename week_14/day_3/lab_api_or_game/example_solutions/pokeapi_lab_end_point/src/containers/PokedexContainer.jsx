import React from 'react';
import GenerationSelect from '../components/GenerationSelect.jsx';
import PokemonSelect from '../components/PokemonSelect.jsx';
import PokemonDetail from '../components/PokemonDetail.jsx';
import Title from '../components/Title.jsx';

class PokedexContainer extends React.Component {
  constructor(props){
    super(props);

    this.state = {
      generation: 1,
      pokemonList: [],
      pokemonDetail: {
        name: 'Pikachu',
        id: 25,
        image: 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png',
        types: ['Electric']
      },
      generationSelectLocked: false,
      pokemonSelectLocked: false,
    };

    this.handleGenerationSelected = this.handleGenerationSelected.bind(this);
    this.handlePokemonSelected = this.handlePokemonSelected.bind(this)
  }

  render() {
    return (
      <div className='pokedex-container'>
        <Title text='Pokedex'/>
        <div className='pokedex'>
          <GenerationSelect
            selectedGeneration={this.state.generation}
            generations={Object.keys(this.props.generationOffsets)}
            handleGenerationSelected={this.handleGenerationSelected}
            locked={this.state.generationSelectLocked}
          />
          <PokemonSelect
            pokemonList={this.state.pokemonList}
            handlePokemonSelected={this.handlePokemonSelected}
            locked={this.state.pokemonSelectLocked}
          />
          <PokemonDetail
          pokemon={this.state.pokemonDetail}
          />
        </div>
      </div>
    );
  }

  componentDidMount() {
    if (this.state.generation) {
      this.updateGeneration(this.state.generation);
    }
  }

  handlePokemonSelected(event) {
    this.setState({generationSelectLocked: true});
    const pokemonId = parseInt(event.target.value, 10);
    this.fetchPokemonDetail(pokemonId);
  }

  handleGenerationSelected(event) {
    this.setState({pokemonSelectLocked: true});
    const generation = parseInt(event.target.value, 10);
    this.updateGeneration(generation);
  }

  updateGeneration(generation) {
    this.setState({generation: generation});

    const generationOffset = this.props.generationOffsets[generation];
    const limit = generationOffset.limit;
    const offset = generationOffset.offset;
    this.fetchPokemonList(limit, offset);

    const firstPokemonId = offset + 1;
    this.fetchPokemonDetail(firstPokemonId);
  }

  fetchPokemonDetail(pokemonId) {
    const url = 'https://pokeapi.co/api/v2/pokemon/' + pokemonId + "/";
    const request = new XMLHttpRequest();
    request.open('GET', url);

    request.addEventListener('load', () => {
      if (request.status === 200) {
        const jsonData = request.responseText;
        const pokemon = JSON.parse(jsonData);
        const pokemonDetail = this.formatPokemonDetail(pokemon);
        this.setState({
          pokemonDetail: pokemonDetail,
          generationSelectLocked: false
        });
      }
    });
    request.send(null);
  }

  fetchPokemonList(limit, offset) {
    const url = 'https://pokeapi.co/api/v2/pokemon/?limit=' + limit + '&offset=' + offset;
    const request = new XMLHttpRequest();
    request.open('GET', url);
    request.addEventListener('load', () => {
      if (request.status === 200) {
        const jsonData = request.responseText;
        const pokedexData = JSON.parse(jsonData);
        const pokemonList = pokedexData.results;
        pokemonList.forEach((pokemon, index) => {
          pokemon.id = (offset + 1) + index;
          pokemon.name = this.capitalise(pokemon.name);
        });
        this.setState({
          pokemonList: pokemonList,
          pokemonSelectLocked: false
        });
      }
    });
    request.send(null);
  }

  capitalise(string) {
    const firstCharacter = string[0].toUpperCase();
    const restOfString = string.slice(1).toLowerCase();
    return firstCharacter + restOfString;
  }

  formatPokemonDetail(pokemonData) {
    const formattedPokemon = {
      name: this.capitalise(pokemonData.name),
      id: pokemonData.id,
      image: pokemonData.sprites.front_default,
      types: [],
    };
    const formattedTypes = pokemonData.types.map(typeObject => {
      return this.capitalise(typeObject.type.name);
    });
    formattedPokemon.types = formattedTypes;
    return formattedPokemon;
  }
}

export default PokedexContainer;
