import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      postCollection: [],
      loading: false,
      isValidated: false,
      imageCollections : [
        {id:1, username:'john_doe', updated : '3 hours ago', likes : 300, liked : false, path:"https://images.pexels.com/photos/1366909/pexels-photo-1366909.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"},
        {id:2, username:'billie_eilish', updated : '5 hours ago', likes : 300, liked: true, path:"https://images.pexels.com/photos/1547813/pexels-photo-1547813.jpeg"},
        {id:3, username:'blizzard', updated : '10 hours ago', likes : 400, liked: false, path:"https://images.pexels.com/photos/3408744/pexels-photo-3408744.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"},
        {id:4, username:'ben_teaches', updated : '4 hours ago', likes : 1200, liked: true, path:"https://images.pexels.com/photos/33201/aurora-borealis-lofoten-norway-night.jpg"},
        {id:5, username:'intellij', updated : '2 hours ago', likes : 100, liked: false, path:"https://images.pexels.com/photos/7919366/pexels-photo-7919366.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"},
        {id:6, username:'codewithme', updated : '3 hours ago', likes : 50, liked: true, path:"https://images.pexels.com/photos/10163188/pexels-photo-10163188.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"},
      ],
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_LOADING(state, loading) {
        state.loading = loading;
      },
      SET_LIKED(state, id) {
        const image = state.postCollection.find(post => post.id === id);
        if (image) {
          image.liked = !image.liked;
          if (image.liked) {
            image.totalLikes += 1;
          } else {
            image.totalLikes -= 1;
          }
        }
      },
      SET_CONTENT(state, content) {
        state.postCollection =  content;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      },
      TOGGLE_VALIDATION_STATUS(state){
        state.isValidated = !state.isValidated; 
      },
      ADD_CREATED_POST_TO_POSTCOLLECTIONS(state, newPost){
        state.postCollection.push(newPost);
      }
    },
  });
  return store;
}
