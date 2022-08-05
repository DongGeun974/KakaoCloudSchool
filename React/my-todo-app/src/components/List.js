import React from 'react'

const List = React.memo(({id,title,completed,todoData,setTodoData,provided,snapshot,deleteClick}) => {
  
  console.log("list component 실행");

  const handleCompleteChange = (id) =>{
    let newTodoData = todoData.map((data)=>{
      if(data.id === id){
        data.completed = !data.completed
      }
      return data
    })
    setTodoData(newTodoData)
  }

  const editClick= (id)=>{
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
            <input type="checkbox"
                defaultChecked={false}
                onChange={() => handleCompleteChange(id)} />
            {" "}<span className={completed ? "line-through" : undefined}>{title}</span>
        </div>
        <div className='items-center'>
            <button onClick={() => editClick(id)}>edit</button>{"   "}
            <button onClick={() => deleteClick(id)}>delete</button>
        </div>
      </div>
    </div>
  )
}
)

export default List;
