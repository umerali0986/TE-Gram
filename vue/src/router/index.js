import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

// Import components
import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import AppView from '../views/AppView.vue';
import PostDetailsView from '../views/PostDetailsView.vue';
import UserProfileView from '../views/UserProfileView.vue'
import LikedPostsView from "@/views/LikedPostsView.vue";
import FavoritedPostsView from "@/views/FavoritedPostsView.vue";

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const routes = [
  {
    path: '/',
    component: () => import('@/layouts/DefaultLayout.vue'),
    children: [
      { path: '', name: 'home', component: HomeView },
    ],
  },
  {
    path: '/app',
    name: 'app',
    component: () => import('@/layouts/AppLayout.vue'),
    children: [
      { path: '', name: 'app', component: AppView },
      // { path: 'post/:id', name: 'postDetails', component: PostDetailsView },
    ],
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/app/post/:id',
    name: 'postDetails',
    component: () => import('@/layouts/AppLayout.vue'),
    children: [
      { path: '', name: 'postDetails', component: PostDetailsView }
    ],
  },
  {
    path: '/app/likes',
    name: 'likedPosts',
    component: () => import('@/layouts/AppLayout.vue'),
    children: [
      { path: '', name: 'likedPosts', component: LikedPostsView }
    ],
  },
  {
    path: '/app/favorites',
    name: 'favoritedPosts',
    component: () => import('@/layouts/AppLayout.vue'),
    children: [
      { path: '', name: 'favoritesPosts', component: FavoritedPostsView }
    ],
  },
  {
    path: '/app/profile/:username',
    name: 'userProfile',
    component: () => import('@/layouts/AppLayout.vue'),
    children: [
      { path: '', name: 'userProfileView', component: UserProfileView }
    ],
  },
  {
    path: "/logout",
    name: "logout",
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
  }
];

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});

router.beforeEach((to) => {

  // Get the Vuex store
  const store = useStore();

  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return {name: "login"};
  }
  // Otherwise, do nothing and they'll go to their next destination
});

export default router;
