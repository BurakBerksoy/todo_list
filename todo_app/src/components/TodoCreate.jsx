import React, { useState } from "react";
import "../App.css";

function TodoCreate({ createTodo }) {
  const [newTodo, setNewTodo] = useState();

  function handleSumbit() {
    if (!newTodo) return;

    const request = {
      id: Math.floor(Math.random() * 99999999999),
      content: newTodo,
    };

    createTodo(request);
    setNewTodo("");
  }

  return (
    <div className="todo_create" style={{ marginBottom: "100px" }}>
      <div className="">
        <input
          className="todo-input"
          type="text"
          placeholder="Todo Giriniz"
          value={newTodo}
          onChange={(e) => setNewTodo(e.target.value)}
          style={{
            width: "600px",
            borderBottom: "1px solid lightgrey",
            border: "none",
            padding: "10px",
          }}
        />
      </div>
      <div className="">
        <button
          onClick={handleSumbit}
          className="todo"
          style={{
            backgroundColor: "gold",
            border: "none",
            marginLeft: "470px",
            marginTop: "30px",
            cursor: "pointer",
          }}
        >
          Todo Oluştur
        </button>
      </div>
    </div>
  );
}

export default TodoCreate;
