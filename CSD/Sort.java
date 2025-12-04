package CSD;

/**
 * Sort algorithms với Student object
 * Có thể thay đổi Student thành kiểu dữ liệu khác tùy đề bài
 */

class Student {
    private String ID;
    private String name;
    private double gpa;

    public Student(String ID, String name, double gpa) {
        this.ID = ID;
        this.name = name;
        this.gpa = gpa;
    }

    // So sánh theo GPA
    public int compareTo(Student o) {
        if (this.gpa > o.gpa)
            return 1;
        else if (this.gpa < o.gpa)
            return -1;
        return 0;
    }

    // So sánh theo ID
    public int compareByID(Student o) {
        return this.ID.compareTo(o.ID);
    }

    // So sánh theo Name
    public int compareByName(Student o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public String toString() {
        return "Student[ID=" + ID + ", name=" + name + ", gpa=" + String.format("%.2f", gpa) + "]";
    }

    // Getters and Setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}

public class Sort {

    public Sort() {
    }

    // ========== BUBBLE SORT - Theo GPA ==========
    void bubbleSortByGPA(Student[] a) {
        int length = a.length;
        System.out.println("Initial:");
        disp(a);

        for (int i = 0; i < length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    Student tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
            System.out.println("Pass " + (i + 1) + ":");
            disp(a);
        }
    }

    // ========== BUBBLE SORT - Theo ID ==========
    void bubbleSortByID(Student[] a) {
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (a[j].compareByID(a[j + 1]) > 0) {
                    Student tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    isSwapped = true;
                }
            }
            if (!isSwapped)
                break;
        }
    }

    // ========== BUBBLE SORT - Theo Name ==========
    void bubbleSortByName(Student[] a) {
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (a[j].compareByName(a[j + 1]) > 0) {
                    Student tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    isSwapped = true;
                }
            }
            if (!isSwapped)
                break;
        }
    }

    // ========== INSERTION SORT - Theo GPA ==========
    void insertionSortByGPA(Student[] a) {
        int length = a.length;
        System.out.println("Initial:");
        disp(a);

        for (int i = 1; i < length; i++) {
            Student key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].compareTo(key) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
            System.out.println("Pass " + i + ":");
            disp(a);
        }
    }

    // ========== INSERTION SORT - Theo ID ==========
    void insertionSortByID(Student[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {
            Student key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].compareByID(key) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    // ========== INSERTION SORT - Theo Name ==========
    void insertionSortByName(Student[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {
            Student key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].compareByName(key) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    // ========== SELECTION SORT - Theo GPA ==========
    void selectionSortByGPA(Student[] a) {
        int length = a.length;
        System.out.println("Initial:");
        disp(a);

        for (int i = 0; i < length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < length; j++) {
                if (a[j].compareTo(a[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                Student temp = a[i];
                a[i] = a[minIdx];
                a[minIdx] = temp;
            }
            System.out.println("Pass " + (i + 1) + ":");
            disp(a);
        }
    }

    // ========== SELECTION SORT - Theo ID ==========
    void selectionSortByID(Student[] a) {
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < length; j++) {
                if (a[j].compareByID(a[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                Student temp = a[i];
                a[i] = a[minIdx];
                a[minIdx] = temp;
            }
        }
    }

    // ========== QUICK SORT - Theo GPA ==========
    void quickSortByGPA(Student[] a, int left, int right) {
        if (left >= right) {
            return;
        }

        Student pivot = a[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (a[j].compareTo(pivot) <= 0) {
                i++;
                Student temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        Student temp = a[i + 1];
        a[i + 1] = a[right];
        a[right] = temp;

        int pivotIndex = i + 1;

        quickSortByGPA(a, left, pivotIndex - 1);
        quickSortByGPA(a, pivotIndex + 1, right);
    }

    // ========== QUICK SORT - Theo ID ==========
    void quickSortByID(Student[] a, int left, int right) {
        if (left >= right) {
            return;
        }

        Student pivot = a[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (a[j].compareByID(pivot) <= 0) {
                i++;
                Student temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        Student temp = a[i + 1];
        a[i + 1] = a[right];
        a[right] = temp;

        int pivotIndex = i + 1;

        quickSortByID(a, left, pivotIndex - 1);
        quickSortByID(a, pivotIndex + 1, right);
    }

    // ========== MERGE SORT - Theo GPA ==========
    void mergeSortByGPA(Student[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortByGPA(a, left, mid);
        mergeSortByGPA(a, mid + 1, right);
        mergeByGPA(a, left, mid, right);
    }

    void mergeByGPA(Student[] a, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        Student[] L = new Student[n1];
        Student[] R = new Student[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = a[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = a[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                a[k++] = L[i++];
            } else {
                a[k++] = R[j++];
            }
        }
        while (i < n1) {
            a[k++] = L[i++];
        }
        while (j < n2) {
            a[k++] = R[j++];
        }
    }

    // ========== MERGE SORT - Theo Name ==========
    void mergeSortByName(Student[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortByName(a, left, mid);
        mergeSortByName(a, mid + 1, right);
        mergeByName(a, left, mid, right);
    }

    void mergeByName(Student[] a, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        Student[] L = new Student[n1];
        Student[] R = new Student[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = a[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = a[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].compareByName(R[j]) <= 0) {
                a[k++] = L[i++];
            } else {
                a[k++] = R[j++];
            }
        }
        while (i < n1) {
            a[k++] = L[i++];
        }
        while (j < n2) {
            a[k++] = R[j++];
        }
    }

    // ========== HEAP SORT - Theo GPA ==========
    void heapSortByGPA(Student[] a) {
        int n = a.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyByGPA(a, n, i);
        }

        // Extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            Student temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            heapifyByGPA(a, i, 0);
        }
    }

    void heapifyByGPA(Student[] a, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && a[left].compareTo(a[largest]) > 0) {
            largest = left;
        }

        if (right < n && a[right].compareTo(a[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            Student swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;

            heapifyByGPA(a, n, largest);
        }
    }

    // ========== UTILITY ==========
    void disp(Student[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) + ". " + arr[i]);
        }
        System.out.println();
    }

    boolean isSortedByGPA(Student[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].compareTo(a[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    boolean isSortedByID(Student[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].compareByID(a[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    // ========== MAIN ==========
    public static void main(String[] args) {
        Sort sort = new Sort();

        System.out.println("========== BUBBLE SORT BY GPA ==========");
        Student[] arr1 = {
                new Student("S005", "Eve", 3.2),
                new Student("S003", "Charlie", 3.8),
                new Student("S001", "Alice", 3.5),
                new Student("S004", "David", 3.9),
                new Student("S002", "Bob", 3.1)
        };
        sort.bubbleSortByGPA(arr1);
        System.out.println("Sorted: " + sort.isSortedByGPA(arr1));

        System.out.println("\n========== INSERTION SORT BY GPA ==========");
        Student[] arr2 = {
                new Student("S005", "Eve", 3.2),
                new Student("S003", "Charlie", 3.8),
                new Student("S001", "Alice", 3.5),
                new Student("S004", "David", 3.9),
                new Student("S002", "Bob", 3.1)
        };
        sort.insertionSortByGPA(arr2);
        System.out.println("Sorted: " + sort.isSortedByGPA(arr2));

        System.out.println("\n========== SELECTION SORT BY GPA ==========");
        Student[] arr3 = {
                new Student("S005", "Eve", 3.2),
                new Student("S003", "Charlie", 3.8),
                new Student("S001", "Alice", 3.5),
                new Student("S004", "David", 3.9),
                new Student("S002", "Bob", 3.1)
        };
        sort.selectionSortByGPA(arr3);
        System.out.println("Sorted: " + sort.isSortedByGPA(arr3));

        System.out.println("\n========== QUICK SORT BY GPA ==========");
        Student[] arr4 = {
                new Student("S005", "Eve", 3.2),
                new Student("S003", "Charlie", 3.8),
                new Student("S001", "Alice", 3.5),
                new Student("S004", "David", 3.9),
                new Student("S002", "Bob", 3.1)
        };
        sort.quickSortByGPA(arr4, 0, arr4.length - 1);
        System.out.println("After Quick Sort:");
        sort.disp(arr4);

        System.out.println("\n========== MERGE SORT BY GPA ==========");
        Student[] arr5 = {
                new Student("S005", "Eve", 3.2),
                new Student("S003", "Charlie", 3.8),
                new Student("S001", "Alice", 3.5),
                new Student("S004", "David", 3.9),
                new Student("S002", "Bob", 3.1)
        };
        sort.mergeSortByGPA(arr5, 0, arr5.length - 1);
        System.out.println("After Merge Sort:");
        sort.disp(arr5);

        System.out.println("\n========== HEAP SORT BY GPA ==========");
        Student[] arr6 = {
                new Student("S005", "Eve", 3.2),
                new Student("S003", "Charlie", 3.8),
                new Student("S001", "Alice", 3.5),
                new Student("S004", "David", 3.9),
                new Student("S002", "Bob", 3.1)
        };
        sort.heapSortByGPA(arr6);
        System.out.println("After Heap Sort:");
        sort.disp(arr6);

        System.out.println("\n========== SORT BY ID ==========");
        Student[] arr7 = {
                new Student("S005", "Eve", 3.2),
                new Student("S003", "Charlie", 3.8),
                new Student("S001", "Alice", 3.5),
                new Student("S004", "David", 3.9),
                new Student("S002", "Bob", 3.1)
        };
        sort.bubbleSortByID(arr7);
        System.out.println("After Sort by ID:");
        sort.disp(arr7);
        System.out.println("Sorted by ID: " + sort.isSortedByID(arr7));

        System.out.println("\n========== SORT BY NAME ==========");
        Student[] arr8 = {
                new Student("S005", "Eve", 3.2),
                new Student("S003", "Charlie", 3.8),
                new Student("S001", "Alice", 3.5),
                new Student("S004", "David", 3.9),
                new Student("S002", "Bob", 3.1)
        };
        sort.mergeSortByName(arr8, 0, arr8.length - 1);
        System.out.println("After Sort by Name:");
        sort.disp(arr8);
    }
}