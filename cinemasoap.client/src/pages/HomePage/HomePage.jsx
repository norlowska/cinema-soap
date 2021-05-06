import React, { useState } from 'react';
import { Typography, Tag } from 'antd';
import { Repertoire } from '../../components';
import './HomePage.css';

const HomePage = () => {
  const [selectedIndex, setSelectedIndex] = useState(0);
  const data = [];
  const addDays = days => {
    const date = new Date();
    date.setDate(date.getDate() + days);
    return date;
  };

  const dates = [new Date(), addDays(1), addDays(2), addDays(3), addDays(4)];
  return (
    <div className='repertoire'>
      <Typography.Title level={2}>Repertuar</Typography.Title>
      <div className='repertoire__dates'>
        {dates.map((item, index) => (
          <div key={index}>
            <Tag.CheckableTag
              className='repertoire__date'
              checked={selectedIndex === index}
              onChange={() => setSelectedIndex(index)}
            >
              {index === 0
                ? 'Dziś'
                : `${item.getDate()}.${
                    item.getMonth() + 1 < 10 ? '0' + (item.getMonth() + 1) : item.getMonth() + 1
                  }`}
            </Tag.CheckableTag>
          </div>
        ))}
      </div>
      <Repertoire moviesList={data[selectedIndex]} />
    </div>
  );
};

export default HomePage;
