import Header from './components/Header';
import Java from './components/Java';
import Sql from './components/Sql';
import Spring from './components/Spring';
import Algorithm from './components/Algorithm';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

function App() {
  return ( 
      <Router>
        <Routes>
          <Route path="/" element={<Header/>}/> 
          <Route path="/java" element={<Java/>}/> 
          <Route path="/sql" element={<Sql/>}/> 
          <Route path="/spring" element={<Spring/>}/> 
          <Route path="/algorithm" element={<Algorithm/>}/> 
        </Routes>
      </Router>  
  );
}

export default App;
