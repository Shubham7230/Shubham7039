import java.util.*;

public class InsertionSortEmployeeIDs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        int[] ids = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Employee ID " + (i + 1) + ": ");
            ids[i] = sc.nextInt();
        }

        for (int i = 1; i < ids.length; i++) {
            int key = ids[i];
            int j = i - 1;
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }
            ids[j + 1] = key;
        }

        System.out.println("Sorted Employee IDs:");
        for (int id : ids) {
            System.out.println(id);
        }
    }
}
