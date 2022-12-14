import axios from 'axios'

export default class PostService {
  getPosts() {
    return axios.get("http://localhost:8080/api/posts")
  }
}
