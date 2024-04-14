import axios from 'axios';

export default {

    getUserByUsername(username) {
        return axios.get(`/users/profile/${username}`); 
    }
    
}