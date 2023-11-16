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

# Cấu trúc thư mục trong project:

