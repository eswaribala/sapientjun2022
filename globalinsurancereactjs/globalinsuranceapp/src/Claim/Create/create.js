import React, {useEffect, useState} from "react";
import axios from "axios";


export const url = "https://jsonplaceholder.typicode.com/users";
export function ClaimCreate(){
    const [users, setUsers] = useState([]);

    // Load the data from the server
    useEffect(() => {
        let mounted = true;

        const getUsers = async () => {
            const response = await axios.get(url);
            if (mounted) {
                setUsers(response.data);
            }
        }
    })
    function formatUserName(username) {
        return username.startsWith('@') ? username : '@' + username;
    }
     return(
         <div className="App">
             <div>Users:</div>
             {users.length ? (
                 <ul data-testid="user-list">
                     {users.map((user) => (
                         <li key={user.id} className="user" data-testid="user-item">
                             <span>{user.name}</span> (
                             <span>{formatUserName(user.username)}</span>)
                         </li>
                     ))}
                 </ul>
             ) : (
                 <div>Loading users...</div>
             )}
         </div>
     )

}
