import React, { Component } from 'react'
import BackToBoard from './BackToBoard';
import ProjectSummaryInput from './FormElements/ProjectSummaryInput';
import ProjectAcceptanceInput from './FormElements/ProjectAcceptanceInput';
import ProjectStatusSelect from './FormElements/ProjectStatusSelect';
import PropTypes from "prop-types";
import {connect} from "react-redux";
import {addProjectTask} from '../../Redux/Actions/projectTaskActions'
import classnames from "classnames";

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
    this.props.addProjectTask(newProjectTask,this.props.history);
     
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

addProjectTask.propTypes={
    AddProjectTask: PropTypes.func.isRequired,
    errors: PropTypes.object.isRequired
}

const mapStateToPros = state =>({
    errors: state.errors
})

export default connect(mapStateToPros,{addProjectTask}) (AddProjectTask);