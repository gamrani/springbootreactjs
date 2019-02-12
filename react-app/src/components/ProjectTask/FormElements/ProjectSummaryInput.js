import React, { Component } from 'react'

class ProjectSummaryInput extends Component {

  constructor(props){
    super(props);
  }
  render() {
    const value = this.props.value;
    return (
      <div className="form-group">
       <input type="text" className="form-control form-control-lg" 
       value={value} name="summary" 
       placeholder="Project Task summary" 
       onChange={this.props.onChange}/>
      </div>
    )
  }
}

export default ProjectSummaryInput;