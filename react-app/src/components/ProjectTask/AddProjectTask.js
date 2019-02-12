import React, { Component } from 'react'
import BackToBoard from './BackToBoard';
import ProjectSummaryInput from './FormElements/ProjectSummaryInput';
import ProjectAcceptanceInput from './FormElements/ProjectAcceptanceInput';
import ProjectStatusSelect from './FormElements/ProjectStatusSelect';

class AddProjectTask extends Component {

  constructor(){
      super();
      this.state={
          summary: "",
          acceptanceCriteria: "",
          status:""
      }
  }
  
  onChange=(e)=>{
      this.setState({[e.target.name]:e.target.value});
  }

  onSubmit=(e)=>{
      e.preventDefault();
      const newProjectTask = {
        summary: this.state.summary,
        acceptanceCriteria: this.state.acceptanceCriteria,
        status:this.state.status
      }

      console.log(newProjectTask);
  }

  render() {
    return (
      
        <div className="addProjectTask">
        <div className="container">
            <div className="row">
                <div className="col-md-8 m-auto">
                    <BackToBoard/>
                    <h4 className="display-4 text-center">Add /Update Project Task</h4>
                    <form>
                        <ProjectSummaryInput value={this.state.summary} onChange={this.onChange}/>
                        <ProjectAcceptanceInput value={this.state.acceptanceCriteria} onChange={this.onChange}/>
                        <ProjectStatusSelect value={this.state.status} onChange={this.onChange}/>
                        <input type="submit" className="btn btn-primary btn-block mt-4" onClick={this.onSubmit}/>
                    </form>
                </div>
            </div>
        </div>
    </div>
    )
  }
}
export default AddProjectTask;