import axios from "axios";
//step5
export default axios.create({
  baseURL: "http://localhost:4000",
  headers: {
    "Content-type": "application/json"
  }
});
