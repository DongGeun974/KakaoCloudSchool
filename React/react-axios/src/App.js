import './App.css';
import axios from 'axios';

function App() {

  const option = {
    url : 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json',
    method: 'get',
    params: {
      key:'fba851033a2514be7b6784b968bae1d1',
      targetDt: '20220801'
    },
    responseType : 'json'
  }

  const callAjax = ()=>{
    axios(option)
    .then(function(response){
      console.log(response);
    })
    .catch(function(){
      console.log("error");
    })
    .finally(function(){
      console.log("무조건 출력");
    })
  }

  return (
    <div>
      <button onClick={callAjax}>서버호출</button>
    </div>
  );
}

export default App;
