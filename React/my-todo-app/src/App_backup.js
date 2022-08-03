import React, {Component} from "react";
import "./App.css"
// class component 사용

class App extends Component{
  
  constructor(props){
    super(props)
    this.state = {
      todoData : [
        {
          id : "1",
          title : '운동하기',
          completed : false
        }, 
      ]
    
    }
  }

  btnStyle = {
    color:"red",
    border:"none",
    padding:"5px 9px",
    borderRadius:"50%",
    cursor:"pointer",
    float:"right"
  }
  
  getStyle = (completed) => {
    return{
      padding:"20px",
      borderBottom:"1px #ccc dotted",
      textDecoration: completed ? "line-through" : "none"
    }
  }

  
  deleteClick = (id) => {
    // 해당 아이디에 대한 할일 목록 지움
    // 배열 데이터를 지움
    // 변경된 데이터로 화면을 다시 그림
    const newTodoData = this.state.todoData.filter(data=>data.id !== id)

    // react state
    // react에서 데이터가 변할 때 화면을 다시 rendering하기 위해 사용
    // state는 component 안에서 관리
    // 생성자 안에서 정의
    // property
    this.setState({todoData : newTodoData})
  }

  handleChange = (e) => {
    // console.log(e.target.value);
    this.setState({value : e.target.value})
  }

  handleSubmit = (e) =>{
    // 현재 submit event 처리
    // default event 처리 막기
    e.preventDefault();

    let newTodo = {
      id: Date.now(),
      title: this.state.value,
      completed: false
    }

    this.setState({todoData : [...this.state.todoData, newTodo], value:""})
  }

  handleComplteChange = (id) =>{
    // id에 대해 todoData의 completed 상태값을 변경
    let newTodoData =this.state.todoData.map((data)=>{
      if(data.id === id){
        data.completed = !data.completed
      }
      return data
    })

    this.setState({todoData:newTodoData})
  }

  render(){
    return(
      // JSX
      <div className="container">
        <div className="todoBlock">
          <div>
            <h1>오늘의 할일</h1>  
          </div>
          
          {this.state.todoData.map(data => (
          
          <div style={this.getStyle(data.completed)} key={data.id}>
            <input type="checkbox" 
            defaultChecked={false} 
            onChange={()=>this.handleComplteChange(data.id)}
            />  
            {data.title}
            <button style={this.btnStyle}
              onClick={()=>{this.deleteClick(data.id)}}>delete</button>
          </div>
          
          ))}

          <form style={{display : 'flex'}}
            onSubmit={this.handleSubmit}>
            <input type="text" name="todoInput" style={{flex:'10', padding:'5px'}} 
            placeholder="새로운 할 일을 입력하세요" value={this.state.value} onChange={this.handleChange}/>

            <input type="submit" 
            value="입력" 
            className="btn" 
            Wstyle={{flex:'1'}}/>
          </form>

        </div>
      </div>
    )
  }

}

export default App;