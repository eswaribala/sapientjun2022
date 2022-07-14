import http from './http-common'
//step4
const create = data => {
    return http.post("/policy", data);
};

const PolicyService = {
    //getAll,
    //get,
    create,
    //update,
    //remove,
    //removeAll,
    //findByTitle
};
export default PolicyService;
