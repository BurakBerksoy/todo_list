import React from 'react'
import { IoIosRemoveCircle } from "react-icons/io";
import { FaUserEdit } from "react-icons/fa";



function Todo({todo}) {

  return (
    <div className='todos' style={{display : "flex" , flexDirection : "row" , alignItems : "center" , justifyContent : "space-between" , marginTop : "15px" }}>
        <div className="todo_title">
            {todo.content}
        </div>
        <div className="todo_icons" style={{paddingLeft : "250px"}}>
        <IoIosRemoveCircle style={{fontSize : "30px"}} />
        <FaUserEdit style={{fontSize : "30px"}} />
        </div>
    </div>
  )
}

export default Todo