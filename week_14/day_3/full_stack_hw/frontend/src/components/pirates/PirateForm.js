import React from 'react';

const PirateForm = (props) => {


  function handleSubmit(event){
    event.preventDefault();
    const pirate = {
        "firstName": event.target.firstName.value,
        "lastName": event.target.lastName.value,
        "age": event.target.age.value,
        "ship": event.target.ship.value,
        "raids": [...event.target.raids.options].filter((option) => {
          return option.selected
        }).map((option) => {
          return option.value
        })
      }
    props.handlePiratePost(pirate)

  }



    const shipOptions = props.ships.map((ship, index) => {
      return <option key={index} value={ship._links.self.href}>{ship.name}</option>
    })

    const raidOptions = props.raids.map((raid, index) => {
        return <option key={index} value={raid._links.self.href}>{raid.location}</option>
      })


      return (
        <div>
          <form onSubmit={handleSubmit}>
            <input type="text" placeholder="First Name" name="firstName"/>
            <input type="text" placeholder="Last Name" name="lastName"/>
            <input type="number" placeholder="Age" name="age"/>
            <select name="ship">
              {shipOptions}
            </select>
            <select multiple name="raids" >
              {raidOptions}
            </select>
            <button type="submit">Save</button>
          </form>
        </div>
    )


}

export default PirateForm;
