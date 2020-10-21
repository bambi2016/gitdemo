import java.util.Arrays;

public class B {
    public void fun1() {
        System.out.println("B创建了一个方法");
    }

    public void fun2() {
        System.out.println("B创建了第二个方法");
    }

    public void fun3() {
        System.out.println("muster创建了一个方法");
    }

    public void fun4() {
        System.out.println("muster创建了第二个方法");
    }

    public void fun5() {
        System.out.println("muster创建了第三个方法");
    }

    public void fun6() {
        System.out.println("muste在看视频");
    }

    public void fun7() {
        System.out.println("muste在看视频3");
    }

    public void fun8() {
        System.out.println("muste在看视频3");
    }

    public void fun9() {
        System.out.println("muste在看视频9");
    }

    public void fun10() {
        System.out.println("muste在看视频10");
        System.out.println("a");
        System.out.println("b");
        System.out.println("c");
        System.out.println("dd");
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }

    public static void main(String[] args) {
        B b = new B();
        int[][] arr = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},};
        System.out.println(b.findNumberIn2DArray(arr, 20));
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        //假
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        //首先从右上往下找大于 target 的值
        //while(true){
        //找到后从右往左找小于等于 target 的值，如果等于直接return ；else 找到第一个小于 target 的值 然后往下找
        //当遇到等于时return；大于 target时 向左
        //} 宽
        int wid = matrix[0].length - 1;
        int hig = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][wid] > target) {
                hig = i;
                break;
            }
            if (matrix[i][wid] == target) {
                return true;
            }
        }

        while (true) {
            boolean b = false;
            //向下
            for (int i = wid; i >= 0; i--) {
                if (matrix[hig][i] < target || (hig < matrix.length - 2 && matrix[hig + 1][i] > target)) {
                    b = true;
                    wid = i;
                    break;
                }
                if (matrix[hig][i] == target) {
                    return true;
                }
            }
            if (!b) {
                return false;
            }
            //向左
            for (int j = hig; j < matrix.length; j++) {
                if (matrix[j][wid] > target) {
                    b = true;
                    hig = j - 1;
                    break;
                }
                if (matrix[j][wid] == target) {
                    return true;
                }
            }
            if (!b) {
                return false;
            }
            System.out.println(hig + " : " + wid);
            if (hig == matrix.length - 1 && wid == 0) {
                return false;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
