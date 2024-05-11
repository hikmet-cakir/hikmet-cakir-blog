import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

function Article() {
    return ( 
      <Card className="m-5 border-0 shadow"> 
        <Card.Body> 
          <Card.Title>Record in Java</Card.Title>
          <Card.Text>
            Did you realize that some classes in the application are being used only to hold or transfer data? In addition to that, these classes often contain lots...
          </Card.Text>
          <Button>Go</Button>
        </Card.Body>
      </Card> 
    );
  }
 
  export default Article;