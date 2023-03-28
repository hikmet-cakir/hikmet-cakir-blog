import Header from './Header';
import React from 'react'
import { Card, Icon } from 'semantic-ui-react'


function Java() {
  const description = [
    'Amy is a violinist with 2 years experience in the wedding industry.',
    'She enjoys the outdoors and currently resides in upstate New York.',
  ].join(' ')
  return (
    <java>
        <Header/>
          <Card>
            <Card.Content header='Reflection API' />
            <Card.Content description={description} />
            <Card.Content extra>
            <Icon name='angle right'>Go</Icon>
            </Card.Content>
      </Card>
    </java>
  );
}

export default Java;