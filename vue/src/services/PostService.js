import axios from 'axios';

export default {

    get() {
        return axios.get('/posts'); 
    },

    getByRouteParam(username){
        return axios.get(`/posts/${username}`)
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