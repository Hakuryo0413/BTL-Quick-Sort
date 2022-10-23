# MINH HOẠ SẮP XẾP QUICK SORT
_Trương Thị Huyền Trâm - 21020413_
--------------------------
Trong Project này, mình xin trình bày minh hoạ sắp xếp Quick Sort. Ý  tưởng của bài viết được khảo cứu và trích dẫn chủ yếu từ một số nguồn tài liệu hữu ích như : Geeksforgeeks.org, tutorialspoint.com, stackoverflow.com…

Ngôn ngữ được sử dụng trong game là  Java và thư viện đồ họa  JavaFX
### Mục lục:
- [1. Hướng dẫn cài đặt](https://github.com/Hakuryo0413/QuickSort/blob/master/README.md#:~:text=v%C3%A0%20%C4%91%C3%A1nh%20gi%C3%A1-,H%C6%B0%E1%BB%9Bng%20d%E1%BA%ABn%20c%C3%A0i%20%C4%91%E1%BA%B7t,-B%C6%B0%E1%BB%9Bc%201%3A%20T%E1%BA%A3i)
- [2. Tư tưởng của giải thuật](https://github.com/Hakuryo0413/QuickSort/blob/master/README.md#:~:text=H%C6%B0%E1%BB%9Bng%20d%E1%BA%ABn.-,T%C6%B0%20t%C6%B0%E1%BB%9Fng%20c%E1%BB%A7a%20gi%E1%BA%A3i%20thu%E1%BA%ADt,-Gi%E1%BA%A3i%20thu%E1%BA%ADt%20Quick)
- [3. Độ phức tạp của giải thuật](https://github.com/Hakuryo0413/QuickSort/blob/master/README.md#:~:text=cu%E1%BB%91i%20danh%20s%C3%A1ch.-,%C4%90%E1%BB%99%20ph%E1%BB%A9c%20t%E1%BA%A1p%20c%E1%BB%A7a%20gi%E1%BA%A3i%20thu%E1%BA%ADt,-%C4%90%E1%BB%99%20ph%E1%BB%A9c%20t%E1%BA%A1p)
- [4. Nhận xét và đánh giá](https://github.com/Hakuryo0413/QuickSort/blob/master/README.md#:~:text=O(nlog(n))-,Nh%E1%BA%ADn%20x%C3%A9t%20v%C3%A0%20%C4%91%C3%A1nh%20gi%C3%A1,-M%E1%BA%B7c%20d%C3%B9%2C%20thu%E1%BA%ADt)



1.  Hướng dẫn cài đặt
   -  Bước 1: Tải `JavaFX` ở [đây](https://gluonhq.com/products/javafx/).
   - Bước 2: Tải project game về và mở `IntelliJ IDEA.`
   - Bước 3: Chạy project theo như [Hướng dẫn](https://openjfx.io/openjfx-docs/).

2. Tư tưởng của giải thuật

   Giải thuật Quick Sort với tư tưởng chính :
   Lựa chọn một phần tử trong mảng đóng vai trò như một pivot, sau đó từ giá trị pivot này tiến hành phân lớp mảng thành 2 phần với một phần chỉ toàn gồm các phần tử nhỏ hơn hoặc bằng pivot, trong khi phần còn lại chứa các phần tử lớn hơn pivot.
   Từ hai nửa còn lại ( không xét tới phần tử pivot, bởi vì vị trí của nó đã là cố định), ta tiến hành gọi một cách đệ quy hàm quickSort(...) trên từng nửa đó. Kết quả cuối cùng ta thu được, đó là mảng ban đầu đã được sắp xếp .

   Sau khi hiểu về thuật toán, có lẽ bạn sẽ có một nghi vấn nhỏ nảy lên trong đầu: Tại sao chọn phần tử chốt là phần tử đầu tiên bên trái? Và cách chọn phần tử chốt có ảnh hưởng đến độ nhanh chậm của sắp xếp hay không? Thực tế thì kỹ thuật chọn phần tử chốt ảnh hưởng khá lớn đến thuật toán, bởi chúng ta có khả năng bị rơi vào các vòng lặp vô hạn. Một số cách chọn phần tử chốt để bạn tham khảo:

- Chọn phần tử đứng đầu hoặc đứng cuối làm phần tử chốt.
- Chọn phần tử đứng giữa danh sách làm phần tử chốt.
- Chọn phần tử trung vị trong 3 phần tử đứng đầu, đứng giữa và đứng cuối làm phần tử chốt.
- Chọn phần tử ngẫu nhiên làm phần tử chốt. (Cách này có thể dẫn đến khả năng rơi vào các trường hợp đặc biệt).

_Ở project này, mình minh hoạ cách chọn phần tử chốt ở cuối danh sách._

3. Độ phức tạp của giải thuật

   Độ phức tạp của giải thuật QuickSort là : T(n) = T(k) + T(n-k-1) + O(n) , với k là số phần tử bên nửa trái. Từ đó, trong từng trường hợp :

- Tồi tệ nhất, ứng với k = 0 : T(n) = T(0) + T(n-1) + O(n) = T(n-1) + O(n) = O(n^2)
- Tốt nhất, ứng với k = n/2 T(n) = 2T(n/2) + O(n) = O(nlog(n))
- Trung bình : T(n) = O(nlog(n))

4. Nhận xét và đánh giá

   Mặc dù, thuật toán có độ phức tạp O(n^2) đối với trường hợp tồi tệ nhất. Tuy nhiên trong thực nghiệm, độ phức tạp trung bình của giải thuật ổn định ở mức O(n.log(n))
   Là một trong số những giải thuật có tốc độ nhanh, hiệu quả và phổ biến top đầu lớp các giải thuật sắp xếp ( QuickSort, HeapSort, MergeSort)
   Giải thuật có tính “tại chỗ”, nhưng không ổn định
   Hoạt động tối ưu hơn khi cài đặt sử dụng mảng


