import React, { useState } from 'react'

const Edit = React.memo(({id,title,completed,todoData,setTodoData,provided,snapshot,deleteClick}) => {
  
  console.log("edit component 실행");
  
  const [value, setValue] = useState("");

  const handleChange = (e) =>{
    setValue(e.target.value)
  }

  const saveClick = (id) =>{
    let newTodoData = todoData.map((data)=>{
      if(data.id === id){
        data.title = value
      }
      return data
    })
    setTodoData(newTodoData)
    backClick(id)
  }

  const backClick = (id) =>{
    let newTodoData = todoData.map((data)=>{
      if(data.id === id){
        data.edited = !data.edited
      }
      return data
    })
    setTodoData(newTodoData)
  }


  return (
    <div key={id}
      {...provided.draggableProps}
      ref={provided.innerRef}
      {...provided.dragHandleProps}>
      <div className={`${snapshot.isDragging ? "bg-gray-500":"bg-gray-100" } flex items-center justify-between w-full px-4 py-1 my-2 text-gray-600 border rounded`}>
        <div className='items-center'>
            <input type="text"
                onChange={handleChange} 
                value={value}/>
            {" "}
        </div>
        <div className='items-center'>
            <button onClick={() => saveClick(id)}>save</button>{"   "}
            <button onClick={() => backClick(id)}>back</button>
        </div>
      </div>
    </div>
  )
}
)

export default Edit;
