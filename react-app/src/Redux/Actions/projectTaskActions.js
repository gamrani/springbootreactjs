import axios from "axios";

const url = "http://localhost:8080/api/board";

export const addProjectTask = (project_task,history)=> async dispatch => {

    await axios.post(url+"/saveProjectTask",project_task);
    history.push("/");

}