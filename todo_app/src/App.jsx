import './App.css'
import TodoCreate from './components/TodoCreate';
import TodoList from './components/TodoList'
import React, { useEffect, useState } from 'react'
import axios from "axios"

let ListUrl = "https://localhost8080/api/todos/all-list"
let AddUrl = "https://localhost8080/api/todos/save"

function App() {
  
  const [newTodo , setNewTodo] = useState([]);

  const [setdatavalue , setgetdatavalue] = useState();

  const [datavalue , getdatavalue] = useState();

  const createTodo = (todos)=>{
    setNewTodo([...newTodo , todos])
  }


  useEffect(() => {
     const GetApi = async()=>{
      try{
      const api = await axios.get(ListUrl)
      setgetdatavalue(api.data)
      console.log(api.data)
      }
      catch(error){
        console.log(error)
      }
     }

     GetApi();
  })


  useEffect(() => {
    const PostApi = async()=>{
      try{
      const api = await axios.post(AddUrl,newTodo)
      getdatavalue(api.data)
      console.log(api.data)
      }
      catch(error){
        console.log(error)
      }
    }

    PostApi();
  })

  console.log(newTodo)

  return (
    <>
     <div className=""
     style={{
      width: "500px",
      display: "flex",
      flexDirection: "column",
      alignItems: "center",
      justifyContent: "center "
    }}>
      <TodoCreate createTodo={createTodo} />
      <TodoList todos={newTodo} />
     </div>
     <div className="">
      {setdatavalue}
      {datavalue}
     </div>
    </>
  )
}

export default App
