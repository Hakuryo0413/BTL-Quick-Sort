# MINH HOẠ SẮP XẾP QUICK SORT
_Trương Thị Huyền Trâm - 21020413_
--------------------------
Trong Project này, mình xin trình bày minh hoạ sắp xếp Quick Sort. Ý  tưởng của bài viết được khảo cứu và trích dẫn chủ yếu từ một số nguồn tài liệu hữu ích như : Geeksforgeeks.org, tutorialspoint.com, stackoverflow.com…

Ngôn ngữ được sử dụng trong game là  Java và thư viện đồ họa  JavaFX
### Mục lục:
- [1. Hướng dẫn cài đặt](https://github.com/Hakuryo0413/BTL-Quick-Sort#1--h%C6%B0%E1%BB%9Bng-d%E1%BA%ABn-c%C3%A0i-%C4%91%E1%BA%B7t)
- [2. Tư tưởng của giải thuật](https://github.com/Hakuryo0413/BTL-Quick-Sort#2-t%C6%B0-t%C6%B0%E1%BB%9Fng-c%E1%BB%A7a-gi%E1%BA%A3i-thu%E1%BA%ADt)
- [3. Độ phức tạp của giải thuật](https://github.com/Hakuryo0413/BTL-Quick-Sort#3-%C4%91%E1%BB%99-ph%E1%BB%A9c-t%E1%BA%A1p-c%E1%BB%A7a-gi%E1%BA%A3i-thu%E1%BA%ADt)
- [4. Nhận xét và đánh giá](https://github.com/Hakuryo0413/BTL-Quick-Sort#4-nh%E1%BA%ADn-x%C3%A9t-v%C3%A0-%C4%91%C3%A1nh-gi%C3%A1)



### 1.  Hướng dẫn cài đặt
   - Bước 1: Tải project về và mở `IntelliJ IDEA.`
   - Bước 2: Ở Maven tab, chọn Plugins -> compiler -> compiler:compile
   - Bước 3: Sau khi compile , chọn Plugins -> javafx -> javafx:run.

### 2. Tư tưởng của giải thuật

   Giải thuật Quick Sort với tư tưởng chính :
   Lựa chọn một phần tử trong mảng đóng vai trò như một pivot, sau đó từ giá trị pivot này tiến hành phân lớp mảng thành 2 phần với một phần chỉ toàn gồm các phần tử nhỏ hơn hoặc bằng pivot, trong khi phần còn lại chứa các phần tử lớn hơn pivot.
   Từ hai nửa còn lại ( không xét tới phần tử pivot, bởi vì vị trí của nó đã là cố định), ta tiến hành gọi một cách đệ quy hàm quickSort(...) trên từng nửa đó. Kết quả cuối cùng ta thu được, đó là mảng ban đầu đã được sắp xếp .

   Sau khi hiểu về thuật toán, có lẽ bạn sẽ có một nghi vấn nhỏ nảy lên trong đầu: Tại sao chọn phần tử chốt là phần tử đầu tiên bên trái? Và cách chọn phần tử chốt có ảnh hưởng đến độ nhanh chậm của sắp xếp hay không? Thực tế thì kỹ thuật chọn phần tử chốt ảnh hưởng khá lớn đến thuật toán, bởi chúng ta có khả năng bị rơi vào các vòng lặp vô hạn. Một số cách chọn phần tử chốt để bạn tham khảo:

- Chọn phần tử đứng đầu hoặc đứng cuối làm phần tử chốt.
- Chọn phần tử đứng giữa danh sách làm phần tử chốt.
- Chọn phần tử trung vị trong 3 phần tử đứng đầu, đứng giữa và đứng cuối làm phần tử chốt.
- Chọn phần tử ngẫu nhiên làm phần tử chốt. (Cách này có thể dẫn đến khả năng rơi vào các trường hợp đặc biệt).

_Ở project này, mình minh hoạ cách chọn phần tử chốt ở cuối danh sách._

### 3. Minh hoạ thuật toán
 
   Màu sắc: 
   - BLUE: màu các phần tử chưa được sắp xếp đúng vị trí.
   - YELLOW: màu phần tử pivot.
   - RED: màu phần tử được chọn để so sánh với phần tử pivot.
   - GREEN: màu phần tử nhỏ hơn phần tử pivot.
   - PURPLE: màu phần tử lớn hơn phần tử pivot.
   - ORANGE: màu phần tử đã được sắp xếp đúng vị trí.

   Code:

     // arr[] --> Mảng cần được sắp xếp,
     // low --> chỉ mục bắt đầu,
     // high --> chỉ mục kết thúc
     private void quickSort(CNode[] arr, int low, int high) {
     if (low < high) {
     // q là chỉ mục của chốt, arr[q] là vị trí của chốt
     int q = partition(arr, low, high);
     // Sắp xếp đệ quy các phần tử
     // trước phân vùng và sau phân vùng
     quickSort(arr, low, q - 1);
     quickSort(arr, q + 1, high);
     } else if (low == high) {
     // xử lý trường hợp lỗi 1 phần tử ko đổi màu
     arr[high].setRightColor(true);
     transitions.add(colorCNode(arr, SORTED_COLOR, true, high));

     }
     }

    // Hàm nhận phần tử cuối cùng làm chốt,
    // đặt các phần tử nhỏ hơn chốt ở trước
    // và lớn hơn ở sau nó
    private int partition(CNode[] arr, int low, int high) {
    // pivot (Element to be placed at right position)
    CNode pivot = arr[high];
    // đổi màu của pivot sang PIVOT_COLOR (YELLOW)
    transitions.add(colorCNode(arr, PIVOT_COLOR, true, high));
    int i = low - 1; // vị trí của phần tử nhỏ hơn

        for (int j = low; j < high; j++) {
            // đổi màu của phần tử arr[j] sang SELECT_COLOR (RED)
            transitions.add(colorCNode(arr, SELECT_COLOR, true, j));
            // nếu phần tử hiện tại nhỏ hơn chốt
            if (arr[j].getValue() <= pivot.getValue()) {
                transitions.add(colorCNode(arr, SMALLER_COLOR, true, j)); // đổi màu sang SMALLER_COLOR (GREEN)
                i++;
                transitions.add(swap(arr, i, j));
            } else {
                transitions.add(colorCNode(arr, BIGGER_COLOR, true, j)); // đổi màu sang BIGGER_COLOR(PURPLE)
            }
        }

        transitions.add(swap(arr, i + 1, high));


        int sorted = i + 1;
        arr[sorted].setRightColor(true);
        transitions.add(colorCNode(arr, SORTED_COLOR, true, sorted));

        for (int j = 0; j < arr.length; j++) {
            if (j != sorted) {
                if (!arr[j].isRightColor()) {
                    transitions.add(colorCNode(arr, START_COLOR, false, j));
                }
            }
        }

        return i + 1;
    }
   
### 4. Độ phức tạp của giải thuật

   Độ phức tạp của giải thuật QuickSort là : T(n) = T(k) + T(n-k-1) + O(n) , với k là số phần tử bên nửa trái. Từ đó, trong từng trường hợp :

- Tồi tệ nhất, ứng với k = 0 : T(n) = T(0) + T(n-1) + O(n) = T(n-1) + O(n) = O(n^2)
- Tốt nhất, ứng với k = n/2 T(n) = 2T(n/2) + O(n) = O(nlog(n))
- Trung bình : T(n) = O(nlog(n))

### 5. Nhận xét và đánh giá

   Mặc dù, thuật toán có độ phức tạp O(n^2) đối với trường hợp tồi tệ nhất. Tuy nhiên trong thực nghiệm, độ phức tạp trung bình của giải thuật ổn định ở mức O(n.log(n))
   Là một trong số những giải thuật có tốc độ nhanh, hiệu quả và phổ biến top đầu lớp các giải thuật sắp xếp ( QuickSort, HeapSort, MergeSort)
   Giải thuật có tính “tại chỗ”, nhưng không ổn định
   Hoạt động tối ưu hơn khi cài đặt sử dụng mảng


