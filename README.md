# 52100110 - Trần Tấn Thành
# Thông tin đề tài:
Trong bài báo cáo giữa kì này, em chọn Templete Engine khá phổ biến đó là Thymeleaf và kết hợp cùng với Spring Boot để tạo nên một trang Web bán giày.
# Giới thiệu qua về Thymeleaf và Spring Boot:
## Thymeleaf:

Thymeleaf là một công cụ mạnh mẽ và linh hoạt cho việc xây dựng giao diện người dùng trong ứng dụng web sử dụng Java. Khi kết hợp với Spring Boot, Thymeleaf trở thành một lựa chọn phổ biến cho việc tạo ra các trang web động và tương tác với dữ liệu từ phía máy chủ.
Cú pháp của Thymeleaf rất gần gũi với HTML thông thường, làm cho việc phát triển giao diện trở nên dễ dàng và ít phức tạp hơn.

## Sự kết hợp với Spring Boot:

Trong Spring Boot, các Controller xử lý các yêu cầu HTTP từ client và chuẩn bị dữ liệu để hiển thị trên giao diện.
Dữ liệu được đưa vào Model, sau đó được truyền đến Thymeleaf template để hiển thị.

Thymeleaf cho phép chúng ta chèn dữ liệu động vào các template HTML thông qua cú pháp đơn giản và rõ ràng.
Ví dụ, chúng ta có thể sử dụng các thẻ Thymeleaf như th:text, th:each, th:if để hiển thị dữ liệu từ model.

## Anotation trong Spring Boot là gì và các Annotation phổ biến được dùng trong đề tài:
### Anotation trong Spring Boot là gì?
Trong Spring Boot, Annotation là cách để cung cấp metadata cho mã nguồn của bạn, giúp framework hiểu được cách triển khai các thành phần của ứng dụng. Điều này giúp Spring Boot tự động cấu hình và quản lý các thành phần một cách dễ dàng.
### Annotation phổ biến dùng trong đề tài:

@RestController:
  - Chú thích Controller để xử lý các yêu cầu RESTful.
  - Kết hợp cả @Controller và @ResponseBody.

@RequestMapping:
  - Ánh xạ yêu cầu HTTP đến một phương thức xử lý trong Controller.
  - Định nghĩa URI và HTTP method (GET, POST, PUT, DELETE) cho xử lý.

@Autowired:
  - Chỉ định rằng một trường hoặc phương thức sẽ được tiêm (inject) dependency bởi Spring container.

@Service, @Repository, @Component:
  - @Service: Chỉ định rằng một class là một dịch vụ (service).
  - @Repository: Chỉ định rằng một class là một repository, thường để truy cập vào cơ sở dữ liệu.
  - @Component: Đánh dấu một class là một thành phần của Spring, có thể được quản lý và quản lý dependency.

@Configuration, @Bean:
  - @Configuration: Đánh dấu một class chứa các phương thức để tạo ra các Bean.
  - @Bean: Đánh dấu một phương thức trả về một đối tượng được quản lý bởi Spring.

@PostMapping, @GetMapping, @PutMapping, @DeleteMapping:
  - Tương ứng với các phương thức HTTP POST, GET, PUT, DELETE.


# Công nghệ sử dụng:

## Spring Boot:
Spring Boot là một framework phát triển dựa trên Spring Framework, được thiết kế để giúp tạo ứng dụng Java nhanh chóng và dễ dàng. Nó cung cấp cấu hình mặc định và các thư viện tích hợp sẵn để giảm bớt sự phức tạp trong việc xây dựng ứng dụng Spring.

## Thymeleaf:
Thymeleaf là một engine template dùng cho việc phát triển các giao diện người dùng trong ứng dụng web Java. Nó cho phép tích hợp mã HTML với code Java và hỗ trợ các tính năng như lặp, điều kiện, thay thế biểu thức, và binding dữ liệu.

## MySQL:
MySQL là một hệ quản trị cơ sở dữ liệu phổ biến, mã nguồn mở, có khả năng xử lý các tác vụ cơ bản và phức tạp. Nó sử dụng ngôn ngữ truy vấn SQL để tương tác với cơ sở dữ liệu.

## Spring Security:
Spring Security cung cấp cơ chế bảo mật mạnh mẽ cho các ứng dụng Spring. Nó giúp quản lý xác thực, phân quyền và bảo vệ các tài nguyên trong ứng dụng web.

## Spring Data JPA:
Spring Data JPA là một phần mở rộng của Spring để làm việc với cơ sở dữ liệu sử dụng JPA (Java Persistence API). Nó cung cấp các công cụ, thư viện và cấu trúc để tương tác với cơ sở dữ liệu thông qua các repository và hỗ trợ việc mapping đối tượng sang cấu trúc dữ liệu quan hệ.

# Thiết kế cơ sở dữ liệu:

## ERD:

## ERD mức vật lý:
![image](https://github.com/WilliamTran2k3/ShoesStore/assets/102520170/6098a72c-e5e3-4bce-bd08-df9718816b6d)

### Giải thích về ERD:
- User đây là model chung cho cả admin và customer, mỗi customer sẽ có nhiều đơn đặt hàng và nhiều sản phẩm trong giỏ hàng.
- Category là model chứa thông tin về loại giày, Brand là chứa thông tin về thương hiệu giày.
- Mỗi một giày (Shoes) sẽ gồm id tham chiếu đến Category và Brand, mỗi giày sẽ chứa thông tin như tên giày, giá bán, mô tả chi tiết.
- Color là bảng chứa các màu giày phổ biến được lưu sẵn trong hệ thống để tiện cho việc thêm phía admin.
- Size là bảng size giày.
- Giày sẽ có nhiều màu sắc khác nhau nên sẽ có bảng Shoes_color - bảng này chứa thông tin về màu sắc của giày là id tham chiếu đến Color, id tham chiếu đến giày và hình ảnh riêng tương ứng với giày (imagePath).
- Với mỗi màu giày sẽ có nhiều size khác nhau nên sẽ có thêm bảng Shoes_variation chứa tham chiếu đến Shoes_color và tham chiếu đến size.
- Mỗi một đơn hàng (Shoes_order) sẽ có nhiều chi tiết đơn hàng (Shoes_orderline) - chứa các thông tin như tham chiếu đến biến thể của giày, số lượng đặt và giá sản phẩm tại thời điểm mua.
- Khi khách hàng thêm một sản phẩm vào giỏ hàng, hệ thống sẽ lưu lại vào Cart_item để tiện cho việc khi người dùng đăng nhập lại vào hệ thống sẽ vẫn còn sản phẩm trong giỏ hàng. Khi xác nhận đặt hàng, tất cả các item trong bảng này sẽ được xóa khỏi Cart_item sau khi lưu sang bảng Shoes_orderline.



# Cấu trúc thư mục trong project:

## Cấu trúc tổng quát:
<img src="https://github.com/WilliamTran2k3/ShoesStore/assets/102520170/95e2352e-56e3-4e36-81da-8537f4f73e34" min-width="400px" max-width="400px" width="400px" align="right">


<p align="left"> 
  Thư mục api: chứa các api tương tác với giỏ hàng, đơn đặt hàng, giày...
  
  Thư mục config: chứa các cấu hình bảo mật (Security) cho project
  
  Thư mục controller: chứa các controller điều hướng trang Web
  
  Thư mục dto: Chứa các class dùng để chuyển đổi dữ liệu từ Model để tránh tình trạng đệ quy vô tận (Infinite Recursion) khi trả dữ liệu về bằng JSON
  
  Thư mục model: Chứa các class để ánh xạ xuống các bảng trong cơ sở dữ liệu
  
  Thư mục repository: Chứa các interface tương tác với cơ sở dữ liệu
  
  Thư mục service: Chứa các class thực hiện nhiệm vụ xử lý logic
  
  Thư mục utils: Chứa các class hỗ trợ cho việc xử lý trong project

  Thư mục resource/static: Chứa các folder css, js, images

  Thư mục resource/templates: Chứa folder layout và các file view 
</p>

## Cấu trúc chi tiết:

Bên trong thư mục api: ngoài chứa các class api còn chứa folder requestDTO - đây là folder dùng để định nghĩa các request để khi thực hiện các request bằng fetch/ajax ở phía client, server sẽ tự động mapping request body đó sang cho các class đã định nghĩa trong requestDTO

Bên trong thư mục service: chứa các interface định nghĩa các phương thức cần thiết cho mỗi service, và một folder chứa các implementation tương ứng với mỗi interface.

Bên trong thư mục templates: Có một folder layout - là folder chứa các file layout chính, và các file view khác

# Cấu hình để chạy project:

1. Khởi tạo database bằng lệnh:
```
CREATE DATABASE shoes_shopping
```
2. Sau đó chạy project
3. Import file Sql đã cung cấp sẵn để có dữ liệu
4. Để tạo một tài khoản admin theo ý thầy có thể vào file AdminInitializer trong folder config để định nghĩa lại username và password (ở đây em đã cấu hình sẵn khi chạy ứng dụng thì tên tài khoản và mật khẩu admin mặc định sẽ là admin)
<img src="https://github.com/WilliamTran2k3/ShoesStore/assets/102520170/98a9fd1c-1508-48d4-9a5e-042d158dad02" width="800px">

# API trong ứng dụng:

## API Customer:

### Register - Đăng ký:
Method: POST

Endpoint:
```
localhost:8080/api/v1/customer/register
```

![image](https://github.com/WilliamTran2k3/ShoesStore/assets/102520170/4c804e1f-c5ff-4b40-a4e0-fe64b6b368ef)


## API Shoes:

### Search - Tìm kiếm:

Đây là API tìm kiếm sản phẩm theo tên gần giống với tên sản phẩm

Method: GET

Endpoint:
```
localhost:8080/api/v1/shoes/search?keyword=abc
```

![image](https://github.com/WilliamTran2k3/ShoesStore/assets/102520170/abc3f1d2-133d-4aaf-bf7d-a4f592082fc3)

### Get all shoes - Lấy danh sách giày hiện có:

API này trả về toàn bộ giày đang có trên hệ thống

Method: GET

Endpoint:
```
localhost:8080/api/v1/shoes
```

![image](https://github.com/WilliamTran2k3/ShoesStore/assets/102520170/b3c5820b-c767-4310-acd9-6da16285044e)

### Get Shoes Variation - Lấy danh sách các biến thể của giày:

API này trả về danh sách các biến thể của giày (Một giày có nhiều màu, nhiều size)

Method: GET

Endpoint:
```
localhost:8080/api/v1/shoes/variation/2
```

![image](https://github.com/WilliamTran2k3/ShoesStore/assets/102520170/84b19190-8ac5-452a-893b-d605e0dace5b)

### Filter - Lọc:

API này cho phép lọc sản phẩm theo nhiều trường khác nhau như giá tiền thấp nhất, cao nhất, theo danh sách các thương hiệu, theo màu sắc

Method: POST

Endpoint:
```
localhost:8080/api/v1/shoes/filter
```

![image](https://github.com/WilliamTran2k3/ShoesStore/assets/102520170/e500b88b-5d77-4fba-ac0f-dcb3b21c826a)


### Add new shoes - Thêm một sản phẩm mới:

API này thêm một sản phẩm mới với tên, giá, mô tả, thương hiệu (id), loại giày (id) và danh sách các màu giày

Method: POST

Endpoint:
```
localhost:8080/api/v1/shoes
```

![image](https://github.com/WilliamTran2k3/ShoesStore/assets/102520170/d0ab4dc3-3c85-48de-b89b-436da34bd9a2)

## API Cart:

### Get All Cart Item - Lấy danh sách các sản phẩm trong giỏ hàng:

API này cho phép lấy danh sách các sản phẩm đã được thêm vào giỏ hàng của khách hàng theo id khách hàng

Method: GET

Endpoint:
```
localhost:8080/api/v1/cart/1
```

![image](https://github.com/WilliamTran2k3/ShoesStore/assets/102520170/76d01683-bdb9-4a8d-a616-fba702a0aff1)

### Add Cart Item - Thêm sản phẩm vào giỏ hàng:

API này cho phép thêm một sản phẩm vào giỏ hàng 

Method: POST

Endpoint:
```
localhost:8080/api/v1/cart
```

![image](https://github.com/WilliamTran2k3/ShoesStore/assets/102520170/59147db9-dd6c-4b9c-be3b-743c3102d753)

### Update Cart Item - Cập nhật giỏ hàng:

API này cho phép người dùng cập nhật lại số lượng sản phẩm mà họ muốn đặt

Method: PUT

Endpoint:
```
localhost:8080/api/v1/cart/cartItem/3
```

![image](https://github.com/WilliamTran2k3/ShoesStore/assets/102520170/0237765b-c28d-4b28-9448-254f73f7a74b)

### Delete Cart Item - Xóa đơn hàng ra khỏi giỏ:

API này cho phép người dùng xóa món hàng ra khỏi giỏ khi có nhu cầu

Method: DELETE

Endpoint: 
```
localhost:8080/api/v1/cart/cartItem/4
```

![image](https://github.com/WilliamTran2k3/ShoesStore/assets/102520170/f03dd861-c2b7-4153-880b-c3ddb93b77b5)

## API Order:

### Get All Order - Lấy danh sách các đơn đặt hàng của khách hàng:

API này trả về danh sách các đơn đặt hàng trên hệ thống

Method: GET

Endpoint:
```
localhost:8080/api/v1/order
```

![image](https://github.com/WilliamTran2k3/ShoesStore/assets/102520170/7ac9b62b-811c-48b6-a2e2-0dbae6ef5fad)

### Get Detail Order - Chi tiết đơn đặt hàng:

API này cho phép xem chi tiết đơn hàng gồm những sản phẩm gì

Method: GET

Endpoint:
```
localhost:8080/api/v1/order/1
```

![image](https://github.com/WilliamTran2k3/ShoesStore/assets/102520170/e26942e4-bb18-4a1d-aeed-294850444fc5)

### Save Order / Checkout - Xác nhận đặt hàng:

API này cho phép người dùng sau khi đã thêm các sản phẩm vào giỏ hàng thì có thể xác nhận đặt hàng

Method: POST

Endpoint:
```
localhost:8080/api/v1/order/2
```

![image](https://github.com/WilliamTran2k3/ShoesStore/assets/102520170/08a8d7b1-de65-47c4-9f3a-59b944294328)


### Update Status - Cập nhật trạng thái đơn hàng:

API cho phép admin cập nhật lại trạng thái của đơn hàng

Method: PUT

Endpoint:
```
localhost:8080/api/v1/order/1
```

![image](https://github.com/WilliamTran2k3/ShoesStore/assets/102520170/5b0c7b91-c9a3-4b65-b73f-39d38db71629)



