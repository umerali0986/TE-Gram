import axios from 'axios';

export default {

    get() {
        return axios.get('/posts'); 
    },

    getByRouteParam(id){
        return axios.get(`/posts/${id}`)
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
    },

    bookmarkPostById(id){
        return axios.post(`favorites/${id}/favorite`);
    },

    removeBookmarkPostById(id){
        return axios.delete(`favorites/${id}/unfavorite`);
    },

    deletePostById(id){
        return axios.delete(`posts/delete/${id}`);
    }
}