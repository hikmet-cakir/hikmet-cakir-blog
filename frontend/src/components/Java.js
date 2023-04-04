import Header from './Header';
import React from "react";
import axios from "axios";
import { Card, Container, Icon } from 'semantic-ui-react'


function Java() {
  const [post, setPost] = React.useState(null);
  const baseURL = "http://localhost:8080/article?id=9c1e2c06-5790-438c-b757-dd7adf9dce3f";

  const description = [
    'Amy is a violinist with 2 years experience in the wedding industry.',
    'She enjoys the outdoors and currently resides in upstate New York.',
  ].join(' ')

  React.useEffect(() => {
    axios.get(baseURL).then((response) => {
      setPost(response.data);
      console.log(response.data);
    });
  }, []);

  if (!post) return null;
  
  return (
    <java>
        <Header/> 
        <Container> 
        <div class="ui centered fluid card"> 
          <Card>
            <Card.Content header='Reflection API' />
            <Card.Content description={description} />
            <Card.Content extra>
            <Icon name='angle right'>Go</Icon>
            </Card.Content>
          </Card>
      </div>
      </Container>
    </java>
  );
}

export default Java;