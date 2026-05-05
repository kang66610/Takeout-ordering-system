# Takeout Service 示例

这是一个最小 Spring Boot 示例，展示：

- 餐厅列表分页展示
- 关键字模糊搜索
- 分类筛选
- 菜品详情查询

## 运行

1. 安装 Java 17
2. 安装 Maven
3. 进入项目目录：
   ```bash
   cd takeout-service
   mvn spring-boot:run
   ```

## 示例接口

- `GET /api/restaurants?page=0&size=10&keyword=川菜&category=川菜`
- `GET /api/dishes/1`

如果没有 Maven，可先安装或使用 IDE 导入该 Maven 项目。