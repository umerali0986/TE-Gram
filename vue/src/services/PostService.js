import axios from 'axios';

export default {

    get() {
        return axios.get('/posts'); 
    },

    getByRouteParam(routeParam){
        return axios.get(`/posts/${routeParam}`)
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