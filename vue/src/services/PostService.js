import axios from 'axios';

export default {

    get() {
        return axios.get('/posts'); 
    },

<<<<<<< HEAD
    getByRouteParam(username){
        return axios.get(`/posts/${username}`)
=======
    getByRouteParam(id){
        return axios.get(`/posts/${id}`)
>>>>>>> 3ba98ad72b70f48eba423f740b9c973889c2430d
    },

    getPostsByUsername(username){
        return axios.get(`/posts/${username}/posts`)
    },

    post(formData){
        return axios.post('/posts', formData); 
    },

    likePostById(id){
        return axios.post(`posts/${id}/like`);
    },

    unlikePostById(id){
        return axios.post(`posts/${id}/unlike`);
    }
}