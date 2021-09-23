Ý tưởng:
- Tạo lớp ProductQueue.java gồm 2 biến và 2 phương thức Put() và Take():
  - private Queue<T> items = new LinkedList<>();  // Lưu trữ sản phẩm
  - private int compacity = 3;                    // tổng số lượng sản phẩm. Đang để mặc định là 3. Có thể thay đổi khi khởi tạo đối tượng
  - Phương thức Put():
    - Thêm sản phẩm vào items.
    - Nếu items đã đầy thì đợi cho tới khi có người Take() thì sẽ tiếp tục thêm
  - Phương thức Take():
    - Lấy sản phẩm từ items.
    - Nếu items trống thì phải đợi cho tới khi có người Put() thì sẽ tiếp tục thêm
- Tạo lớp Producer.java là một luồng thực hiện công việc thêm sản phẩm:
  - Sử dụng phương thức Put() để thêm sản phẩm vào items
  - Để mặc định cứ sau 5s lại thêm sản phẩm vào items
- Tạo lớp Consumer.java là một luồng thực hiện công việc lấy sản phẩm:
  - Sử dụng phương thức Take() để lấy sản phẩm từ items
- Lớp Main.java chạy chương trình:
  - Khởi tạo đối tượng ProductQuere và có sẵn 2 sản phẩm trong items
  - Luồng Producer được thực hiện và cứ sau 5s lại có sản phẩm thêm vào
  - Cho liên tục 4 Consumer liên tiếp cách nhau 1.2s thực hiện công việc lấy sản phẩm
  - Kết quả được hiện thị trên màn hình
