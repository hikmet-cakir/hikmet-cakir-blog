import React, { useEffect, useState } from 'react';
import { Card, Button, Pagination } from 'semantic-ui-react';
import Header from './Header';

function Main() {
  const [data, setData] = useState([]);
  const [activePage, setActivePage] = useState(1);

  const handlePageChange = (event, { activePage }) => {
    setActivePage(activePage);
  };

  useEffect(() => {
    async function fetchData() {
      try {
        const params = new URLSearchParams({
          size: 10,
          page: activePage - 1
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
  }, [activePage]);

  return (
    <div>
      <Header/>
      <div style={{ display: 'flex', justifyContent: 'center' }}>
        <Card.Group style={{ display: 'block' }}>
          {data.length > 0 &&
            data.map((item) => (
              <Card key={item.id}>
                <Card.Content>
                  <Card.Header>{item.title}</Card.Header>
                  <Card.Meta>{item.content}</Card.Meta>
                  <Card.Description><b>Genre: </b>{item.genre}</Card.Description>
                  <div style={{ display: 'flex', justifyContent: 'flex-end', marginTop: '10px' }}>
                    <Button
                    primary
                    onClick={() => {
                      window.location.href = `/article/${item.genre}/${item.id}`;
                    }}
                    >
                    Read More
                    </Button>
                  </div>
              </Card.Content>
          </Card>
        ))}
        </Card.Group>
      </div>
      <div style={{ display: 'flex', justifyContent: 'center' }}>
        <Pagination
          activePage={activePage}
          onPageChange={handlePageChange}
          totalPages={10}
        />
      </div>
    </div>
  );
}

export default Main;
