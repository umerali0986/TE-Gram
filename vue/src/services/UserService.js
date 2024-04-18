import axios from 'axios';

export default {

    getUserByUsername(username) {
        return axios.get(`/users/profile/${username}`); 
    },

    updateUserAvatar(formData){
        return axios.put(`users/avatar`, formData);
    },

    updateUserInfo(user){
        return axios.put('users/update', user);
    },

    deleteUserByUsername(username){
        return axios.delete(`/users/${username}`);
    }
    
}