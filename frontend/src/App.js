import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Main from './components/Main';
import Genre from './components/Genre';
import Article from './components/Article';

function App() {
  return ( 
      <Router>
        <Routes>
          <Route path="/" element={<Main/>}/> 
          <Route path="/article/:genre" element={<Genre/>}/> 
          <Route path="/article/:genre/:id" element={<Article/>}/> 
        </Routes>
      </Router>  
  );
}

export default App;
