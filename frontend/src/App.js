import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Main from './components/Main';
import Genre from './components/Genre';

function App() {
  return ( 
      <Router>
        <Routes>
          <Route path="/" element={<Main/>}/> 
          <Route path="/article/:genre" element={<Genre/>}/> 
        </Routes>
      </Router>  
  );
}

export default App;
