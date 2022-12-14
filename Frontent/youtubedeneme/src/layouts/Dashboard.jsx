import React from 'react'
import { Route, Routes } from 'react-router-dom'
import Post from '../pages/Post'

export default function Dashboard() {
  return (
    <div>
        <Routes>
        <Route path="/" element={<Post />} exact />
        </Routes>
    </div>
  )
}
