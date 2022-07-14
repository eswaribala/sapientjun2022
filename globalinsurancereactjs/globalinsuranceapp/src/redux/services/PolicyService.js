import http from './http-common'
const create = data => {
    return http.post("/addpolicy", data);
};
export default PolicyService;
