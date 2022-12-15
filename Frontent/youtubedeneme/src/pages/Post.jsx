import React, { useEffect } from 'react'
import { useState } from 'react'
import PostService from '../services/PostService';
import { Container, Table } from 'react-bootstrap';
export default function Post() {
    const [posts, setPosts] = useState([]);
    useEffect(()=> {
        let postService = new PostService();
        postService.getPosts().then
        (result => setPosts(result.data.data))
    }, [])
  return (
    <Container>
            <div>
                <Table striped bordered hover>
                    <thead>
                        <tr>
                            <th>title</th>
                            <th>text</th>

                        </tr>
                    </thead>
                    <tbody>
                        {
                            posts.map(posts => (
                                <tr key={posts.id}>
                                    <td>{posts.title}</td>
                                    <td>{posts.text}</td>
                                    <td>{posts.userName}</td>
                                </tr>
                            ))
                        }
                    </tbody>
                </Table>
            </div>
        </Container>
  )
}
