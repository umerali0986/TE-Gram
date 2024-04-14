import axios from "axios";

export default{

    save(postId, comment){
        return axios.post(`/posts/${postId}/comment`,comment);
    }
}