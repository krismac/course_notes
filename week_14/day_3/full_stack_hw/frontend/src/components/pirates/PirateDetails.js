import React  from 'react';
import {Link} from 'react-router-dom';

const PirateDetails = (props) => {

  const onDelete = () => {
    props.handleDelete(props.pirate.id);
  }

  const onEdit = () => {
    props.handleEdit(props.pirate.id)
  }

  if(!props.raids){
    return null;
  }
  const raids = props.raids.map((raid, index) => {
    return <li key = {index}>{raid.location}</li>
  })

  return (
    <React.Fragment>
    Raids:
    <ul>
      {raids}
    </ul>
    <button onClick={onDelete}>Delete Pirate</button>
    <button onClick={onEdit}>Edit Pirate</button>
    </React.Fragment>
  )
}

export default PirateDetails;
