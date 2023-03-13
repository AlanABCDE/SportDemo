// 格式：XXXX年XX月XX日XX时XX分XX秒 星期X
const complement = function (value: any) {
    return value < 10 ? `0${value}` : value;
  };
  
  export const formateDate = (date: any) => {
    const time = new Date(date);
    const year = time.getFullYear();
    const month = complement(time.getMonth() + 1);
    const day = complement(time.getDate());
    const hour = complement(time.getHours());
    const minute = complement(time.getMinutes());
    const second = complement(time.getSeconds());
    const week = '星期' + '日一二三四五六'.charAt(time.getDay());
    return `${year}年${month}月${day}日 ${week} ${hour}:${minute}:${second}`;
  };

  
  