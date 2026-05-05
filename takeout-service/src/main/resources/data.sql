INSERT INTO restaurants (id, name, category, description, image_url) VALUES
  (1, '城市小吃', '快餐', '方便快捷的中式快餐，适合午餐与晚餐。', 'https://example.com/images/restaurant1.jpg'),
  (2, '川味传奇', '川菜', '麻辣鲜香的正宗川菜体验。', 'https://example.com/images/restaurant2.jpg');

INSERT INTO dishes (id, name, category, description, image_url, price_cents, restaurant_id) VALUES
  (1, '宫保鸡丁', '热菜', '鸡丁香辣，花生酥脆。', 'https://example.com/images/dish1.jpg', 3600, 2),
  (2, '麻婆豆腐', '热菜', '豆腐嫩滑，辣味十足。', 'https://example.com/images/dish2.jpg', 2800, 2),
  (3, '炸鸡腿饭', '便当', '香酥鸡腿搭配米饭与蔬菜。', 'https://example.com/images/dish3.jpg', 3200, 1),
  (4, '扬州炒饭', '炒饭', '经典扬州炒饭，料足味鲜。', 'https://example.com/images/dish4.jpg', 3000, 1);
