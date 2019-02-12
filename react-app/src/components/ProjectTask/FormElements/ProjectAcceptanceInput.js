import React, { Component } from 'react'

class ProjectAcceptanceInput extends Component {
  constructor(props){
    super(props);
  }
  render() {
    const value = this.props.value;
    return (
      <div className="form-group">
        <textarea className="form-control form-control-lg" 
        value={value} placeholder="Acceptance Criteria" 
        name="acceptanceCriteria"
        onChange={this.props.onChange}></textarea>
     </div>
    )
  }
}
export default ProjectAcceptanceInput;
