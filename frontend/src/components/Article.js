import React, { useEffect, useState } from 'react';
import { Card } from 'semantic-ui-react';
import Header from './Header';
import { useParams } from 'react-router-dom';

function Article() {
  const [data, setData] = useState([]);
  const { id } = useParams();

  useEffect(() => {
    async function fetchData() {
      try {
        const params = new URLSearchParams({
          id: id,
          size: 1,
          page: 0
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
  }, [id]);

  return (
    <div>
      <Header />
      <div style={{ display: 'flex', justifyContent: 'center' }}>
        <Card.Group style={{ display: 'block' }}>
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
      </div>
    </div>
  );
}

export default Article;
