
import React, { Component } from 'react'

class ProjectStatusSelect extends Component {
  constructor(props){
    super(props);
  }
  render() {
    const value = this.props.value;
    return (
      <div className="form-group">
      <select className="form-control form-control-lg" onChange={this.props.onChange} name="status">
          <option value="">Select Status</option>
          <option value="TO_DO">TO DO</option>
          <option value="IN_PROGRESS">IN PROGRESS</option>
          <option value="DONE">DONE</option>
      </select>
  </div>
    )
  }
}

export default ProjectStatusSelect;
