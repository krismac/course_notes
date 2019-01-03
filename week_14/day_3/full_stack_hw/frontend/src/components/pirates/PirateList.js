import React from 'react';
import Pirate from './Pirate.js';


const PirateList = (props) => {
	const pirates = props.pirates.map((pirate) => {
		 	return (
				<li key={pirate.id} className="component-item">
					<div className = "component">
				<Pirate ship={pirate.ship} pirate={pirate} />
			</div>
			</li>
		)
		})

	return (
		<ul className="component-list">
	    {pirates}
	  </ul>

	)
}
 export default PirateList;
