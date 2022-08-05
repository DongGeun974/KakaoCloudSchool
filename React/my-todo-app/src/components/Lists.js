import React from 'react'
import { DragDropContext, Draggable, Droppable } from 'react-beautiful-dnd'
import List from './List';
import Edit from './Edit'

// 구조분해할당 이용
const Lists = React.memo(({deleteClick, todoData, setTodoData}) => {

    console.log("lists component 실행");

    const handleDrop = (e) =>{
        // e : event 객체, event에 대한 세부 정보를 가짐
        // e.source : drag한 객체
        // e.destination : drop한 객체
        if(!e.destination) return;

        const newTodoDate = [...todoData]

        const [reorder] = newTodoDate.splice(e.source.index, 1)
        newTodoDate.splice(e.destination.index, 0, reorder)

        setTodoData(newTodoDate)
    }

    return (
        <div>
            <DragDropContext onDragEnd={handleDrop}>
                <Droppable droppableId='to-do'>
                    {(provided)=>(
                        <div {...provided.droppableProps} ref={provided.innerRef}>
                            {todoData.map((data, index) => (
                                <Draggable 
                                    key={data.id} 
                                    draggableId={data.id.toString()}
                                    index={index}>
                                    {(provided, snapshot)=>(
                                        // need component

                                        data.edited ? 
                                        <Edit id={data.id} 
                                        title={data.title}
                                        completed={data.completed}
                                        todoData={todoData}
                                        setTodoData={setTodoData}
                                        provided={provided}
                                        snapshot={snapshot} 
                                        deleteClick={deleteClick}/>:
                                        <List id={data.id} 
                                        title={data.title}
                                        completed={data.completed}
                                        todoData={todoData}
                                        setTodoData={setTodoData}
                                        provided={provided}
                                        snapshot={snapshot} 
                                        deleteClick={deleteClick}/> 

                                    )}
                                </Draggable>
                            ))}
                            {provided.placeholder}
                        </div>
                    )}
                    
                </Droppable>
            </DragDropContext>
        </div>
    )
}
); 

export default Lists;