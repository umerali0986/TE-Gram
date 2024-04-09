import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      isValidated: false,
      imageCollections : [
        {id:1, username:'john Doe', updated : '3 hours ago', path:"https://images.pexels.com/photos/1366909/pexels-photo-1366909.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"},
        {id:2, username:'test2', updated : '5 hours ago', path:"https://images.pexels.com/photos/1547813/pexels-photo-1547813.jpeg"},
        {id:3, username:'tes3', updated : '10 hours ago', path:"https://images.pexels.com/photos/3408744/pexels-photo-3408744.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"},
        {id:4, username:'test4', updated : '4 hours ago', path:"https://images.pexels.com/photos/33201/aurora-borealis-lofoten-norway-night.jpg"},
        {id:5, username:'test5', updated : '2 hours ago', path:"https://images.pexels.com/photos/7919366/pexels-photo-7919366.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"},
        {id:6, username:'test6', updated : '3 hours ago', path:"https://images.pexels.com/photos/10163188/pexels-photo-10163188.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"},
      ]
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
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
      }
    },
  });
  return store;
}
