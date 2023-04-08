import React, { useEffect, useState } from 'react';
import { Card } from 'semantic-ui-react';
import Header from './Header';

function Java() {
  const [data, setData] = useState([]);

  useEffect(() => {
    async function fetchData() {
      try {
        const params = new URLSearchParams({
          genre: 'JAVA',
          size: 1,
          page: 1
        });
        const response = await fetch(`http://localhost:8080/article?${params.toString()}`);

        if (!response.ok) {
          throw new Error('Network response was not ok');
        }

        const responseData = await response.json();
        setData(responseData.data.articles);
      } catch (error) {
        console.error(error);
      }
    }

    fetchData();
  }, []);

  return (
    <java>
      <Header />
      <Card.Group>
        {data.length > 0 &&
          data.map((item) => (
            <Card key={item.id}>
              <Card.Content>
                <Card.Header>{item.title}</Card.Header>
                <Card.Meta>{item.content}</Card.Meta>
                <Card.Description>{item.genre}</Card.Description>
              </Card.Content>
            </Card>
          ))}
      </Card.Group>
    </java>
  );
}

export default Java;
