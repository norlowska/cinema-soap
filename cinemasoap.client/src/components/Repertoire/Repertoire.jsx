import React from 'react';
import { List } from 'antd';
import './Repertoire.css';

const Repertoire = ({ moviesList }) => {
  return (
    <List
      className='repertoire__list'
      itemLayout='vertical'
      size='large'
      pagination={{
        onChange: page => {
          console.log(page);
        },
        pageSize: 8,
      }}
      dataSource={moviesList}
      renderItem={item => ({ item })}
    ></List>
  );
};

export default Repertoire;
