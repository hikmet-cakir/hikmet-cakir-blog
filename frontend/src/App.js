import Navbar from './Navbar';
import Article from './Article'; 
import { CardGroup, Container } from 'react-bootstrap';

function App() {
  return (
    <div>
      <Navbar />
      <Container fluid>
        <CardGroup className="m-5 d-block">
        <Article/>
        <Article/>
        <Article/>
        <Article/>
        <Article/>
        <Article/>
        <Article/>
        <Article/>
        <Article/>
        <Article/>
        <Article/>
        <Article/>
        <Article/>
        <Article/>
        <Article/>
        </CardGroup>
      </Container>
    </div>
  );
}

export default App;
