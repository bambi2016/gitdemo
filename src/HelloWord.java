public class HelloWord {
  public boolean canReorderDoubled(int[] A) {
        for (int i = 0; i < A.length / 2; i++) {


        }
        return true;
    }

    public int primePalindrome(int N) {
        if (N==1){
            return 2;
        }
        int num = N;
        while (true) {
            //判断是不是回文
            if (isPalindrome(num)){
                //判断是不会素数
                if (isPrime(num)){
                    return num;
                }
            }
            num++;
        }
    }

    public boolean isPalindrome(int i) {
        String s = String.valueOf(i);
        char[] array = s.toCharArray();
        for (int i1 = 0; i1 < array.length / 2; i1++) {
            if (array[i1] != array[array.length - i1 - 1]) {
                return false;
            }
        }
        return true;
    }
    //判断一个数是不是素数
    public boolean isPrime(int n) {
        double sqrt = Math.sqrt(n);
        for (double i = 2; i <= sqrt; i++) {
            if (n / i == (int) (n / i)) {
                return false;
            }
        }
        return true;
    }

    public int longestWPI(int[] hours) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i : hours) {
            if (i > 8) {
                stack.push(i);
            } else if (stack.size() > 0) {
                stack.pop();
            }
            if (stack.size() > result) {
                result = stack.size();
            }
        }
        return result;
    }

    public int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        while (true) {
            int count = 1;
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (count % 2 == 1) {
                    iterator.remove();
                }
                count++;
            }

            if (list.size() == 1) {
                break;
            }
            int c2 = 1;
            for (int i = list.size() - 1; i >= 0; i--) {
                if (c2 % 2 == 1) {
                    list.remove(i);
                }
                c2++;
            }
//            for (Integer it : list) {
//                System.out.print(it+" ");
//            }System.out.println();
            if (list.size() == 1) {
                break;
            }
        }

        return list.get(0);
    }

    public int largest1BorderedSquare(int[][] grid) {
        int large = Math.min(grid.length, grid[0].length);
        for (int i = large; i > 0; i--) {
            boolean b = true;
            lab:
            for (int j = 0; j < grid.length - large + 1; j++) {
                for (int k = 0; k < grid[0].length - large + 1; k++) {
                    for (int l = k; l < large + k; l++) {
                        if (grid[j][k] == 0 || grid[j + large - 1][k] == 0) {
                            break lab;
                        }
                    }
                    for (int l = j; l < large + j; l++) {

                    }
                }
            }
        }
        return 0;
    }

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer inte = map.get(arr[i]);
            if (inte == null) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], inte + 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        int count = 0;
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            result++;
            count += entry.getValue();
            if (count >= arr.length / 2.0) {
                break;
            }
        }
        return result;
    }


    public boolean isContain(int[] candidates, int target) {
        int index = 0;
        return isContain0(candidates, index + 1, target - candidates[index]) || isContain0(candidates, index + 1, target);
    }

    private boolean isContain0(int[] candidates, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (index > candidates.length - 1) {
            return false;
        }
        return isContain0(candidates, index + 1, target - candidates[index]) || isContain0(candidates, index + 1, target);
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int res = 0;
        int preMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - preMin);
            preMin = Math.min(preMin, prices[i]);
        }
        return res;
    }

    public int maxArea(int[] height) {
        return findmaxArea(height, 0);
    }

    private int findmaxArea(int[] height, int from) {
        if (from == height.length - 1) {
            return 0;
        }
        int max = 0;
        for (int i = from + 1; i < height.length; i++) {
            int arr = (i - from) * Math.min(height[from], height[i]);
            if (arr > max) {
                max = arr;
            }
        }
        return Math.max(findmaxArea(height, ++from), max);
    }

    public int[] dailyTemperatures(int[] T) {
        int[] arr = new int[T.length];

        for (int i = arr.length - 2; i >= 0; i--) {
            if (T[i] < T[i + 1]) {
                arr[i] = 1;
            } else {
                boolean b = false;
                int temp = 0;
                for (int j = i + 1; j < T.length; j++) {
                    temp++;
                    if (T[j] > T[i]) {
                        b = true;
                        break;
                    }
                }
                if (b) {
                    arr[i] = temp;
                } else {
                    arr[i] = 0;
                }
            }
        }
        return arr;
    }

    public void setZeroes(int[][] matrix) {
        int[][] arrs = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[0].length; j++) {
                arrs[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (arrs[i][j] == 0) {
                    for (int k = 0; k < matrix[0].length; k++) {
                        matrix[i][k] = 0;
                    }
                    for (int k = 0; k < matrix.length; k++) {
                        matrix[k][j] = 0;
                    }
                    break;
                }
            }
        }
    }

    public int findDuplicate(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public int maxAliveYear(int[] birth, int[] death) {
        int[] ints = new int[101];

        Arrays.sort(birth);
        Arrays.sort(death);
        int indes = 0;
        for (int i = 0; i < ints.length; i++) {

        }
        return 0;
    }

    public int findClosest(String[] words, String word1, String word2) {

        return 0;
    }

    public String customSortString(String S, String T) {
        char[] chars = S.toCharArray();
        char[] array = T.toCharArray();

        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            for (char c1 : array) {
                if (c == c1) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {

        return null;
    }

    public int matrixScore(int[][] A) {
//横向或纵向遍历
        //遍历第一列，保证变换后都为1
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[0].length; j++) {
                    if (A[i][j] == 0) {
                        A[i][j] = 1;
                    } else {
                        A[i][j] = 0;
                    }
                }
            }
        }
        //遍历第二到n列保证1的个数大于0的个数
        for (int i = 1; i < A[0].length; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j][i] == 0) {
                    count++;
                }
            }
            if (count > A.length / 2.0) {
                for (int j = 0; j < A.length; j++) {
                    if (A[j][i] == 0) {
                        A[j][i] = 1;
                    } else {
                        A[j][i] = 0;
                    }
                }
            }
        }
        int result = 0;
        for (int[] ints : A) {
            for (int i = 0; i < ints.length; i++) {
                result += ints[i] << ints.length - i - 1;
            }
        }

        return result;
    }

    private void matrixScoreRecursive(int[][] a) {
        boolean b = false;
        //横向遍历，当看到一列的0的个数大于总列数的一半，则替换该列
        for (int i = 0; i < a[0].length; i++) {
            int count = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[j][i] == 0) {
                    count++;
                }
            }
            if (count > a.length / 2.0) {
                b = true;
                for (int j = 0; j < a.length; j++) {
                    if (a[j][i] == 0) {
                        a[j][i] = 1;
                    } else {
                        a[j][i] = 0;
                    }
                }
            }
        }
        //纵向遍历，当看到一行的0的个数大于总行数的一半，则替换该行
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 0) {
                    count++;
                }
            }
            if (count > a[0].length / 2.0) {
                b = true;
                for (int j = 0; j < a[0].length; j++) {
                    if (a[i][j] == 0) {
                        a[i][j] = 1;
                    } else {
                        a[i][j] = 0;
                    }
                }
            }
        }
        //当发现没有任何一行或列需要替换时跳出递归
        if (!b) {
            return;
        }
        //递归以上两步
        matrixScoreRecursive(a);
    }

    public void gameOfLife(int[][] board) {
        int[][] result = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                result[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    int count = surrondClunt(i, j, board);
                    if (count < 2) {
                        result[i][j] = 0;
                    }
                    if (count > 3) {
                        result[i][j] = 0;
                    }
                } else {
                    int count = surrondClunt(i, j, board);
                    if (count == 3) {
                        result[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                board[i][j] = result[i][j];
            }
        }
    }

    //宽
    private int surrondClunt(int i, int j, int[][] board) {
        int result = 0;
        for (int k = i - 1; k < i + 2; k++) {
            for (int l = j - 1; l < j + 2; l++) {
                if (k < 0 || k >= board.length || l < 0 || l >= board[0].length || (k == i && l == j)) {
                    continue;
                }
                if (board[k][l] == 1) {
                    result++;
                }
            }
        }
        return result;
    }
    //计算周边1的个数


    public List<List<Integer>> combine(int n, int k) {
        search(n, k, new ArrayList(), 1);
        return res;
    }

    public void search(int n, int k, List<Integer> list, int idx) {
        if (k == 0) {
            res.add(new ArrayList(list));
            return;
        }
        if (n - idx + 1 < k) {
            return;
        }
        for (int i = idx; i <= n; i++) {
            list.add(i);
            search(n, k - 1, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i] != null && !"".equals(s1[i])) {
                builder.append(s1[i]).append(" ");
            }
        }
        return builder.toString().trim();
    }

    public String[] permutation(String s) {
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        return null;
    }

    List<List<Integer>> lists = new ArrayList<>();


    public int countServers(int[][] grid) {
        int result = 0;
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            int temp = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    temp++;
                    if (temp == 2) {
                        row.add(i);
                        break;
                    }
                }
            }
        }
        ArrayList<Integer> column = new ArrayList<>();
        for (int i = 0; i < grid[0].length; i++) {
            int temp = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) {
                    temp++;
                    if (temp == 2) {
                        column.add(i);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (row.contains(i) || column.contains(j)) {
                    if (grid[i][j] == 1) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    HashMap<Character, String> map = new HashMap<>();

    public Solution() {
        map.put('!', "1");
        map.put('@', "1");
        map.put('#', "1");
        map.put('a', "2");
        map.put('b', "2");
        map.put('c', "2");
        map.put('d', "3");
        map.put('e', "3");
        map.put('f', "3");
        map.put('g', "4");
        map.put('h', "4");
        map.put('i', "4");
        map.put('j', "5");
        map.put('k', "5");
        map.put('l', "5");
        map.put('m', "6");
        map.put('n', "6");
        map.put('o', "6");
        map.put('q', "7");
        map.put('p', "7");
        map.put('r', "7");
        map.put('s', "7");
        map.put('t', "8");
        map.put('u', "8");
        map.put('v', "8");
        map.put('w', "9");
        map.put('x', "9");
        map.put('y', "9");
        map.put('z', "9");
        map.put(' ', "9");
    }

    public List<String> getValidT9Words(String num, String[] words) {
        ArrayList<String> list = new ArrayList<>();
        for (String s : words) {
            char[] chars = s.toCharArray();
            String temp = "";
            for (char c : chars) {
                temp += map.get(c);
            }
            if (num.equals(temp)) {
                list.add(s);
            }
        }
        return list;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            Arrays.sort(intervals, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));
        }
        for (int[] ints : intervals) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        if (intervals.length <= 1) {
            return 0;
        }
        int result = 0;
        int limit = 0;
        int position = 1;
        while (position < intervals.length) {
            if (intervals[limit][1] > intervals[position][0]) {
                result++;
                position++;
            } else {
                limit = position;
                position++;
            }

        }
        return result;
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> lists = new ArrayList<>();
        int limit = 0;
        while (limit < groupSizes.length) {
            List<Integer> list = new ArrayList<>();
            int temp = groupSizes[limit];
            for (int i = limit; i < groupSizes.length; i++) {
                if (groupSizes[i] != 0) {
                    if (groupSizes[i] == temp) {
                        list.add(i);
                        groupSizes[i] = 0;
                        if (list.size() == temp) {
                            lists.add(list);
                            break;
                        }
                    }
                }
            }
            limit++;
        }
        return lists;
    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer integer = map.get(num);
            if (integer == null) {
                map.put(num, 1);
            } else {
                map.put(num, integer + 1);
            }
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            Integer integer = map.get(next);
            if (integer == 1) {
                return next;
            }
        }
        return -1;
    }

    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return nums;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int minlen = strs[0].length();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            if (chars.length < minlen) {
                minlen = chars.length;
            }
        }
        return null;
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 1;
        }
        int result = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                temp++;
                if (result < temp) {
                    result = temp;
                }
            } else {
                temp = 1;
            }
        }
        return result;
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int pre = nums[0];
        for (int i = 0; i < nums.length; i++) {

        }
        return 0;
    }

    public List<String> readBinaryWatch(int num) {
        ArrayList<String> list = new ArrayList<>();
        if (num == 0) {
            list.add("0:00");
            return list;
        }
        if (num > 10) {
            return null;
        }
        for (int i = 0; i <= num; i++) {
            int hour = num - i;
            int minute = num - hour;

        }
        return null;
    }

    public int Fibonacci(int n) {

        int[] arr = new int[]{0, 1, 1};
        if (n < 3) {
            return arr[n];
        }
        for (int i = 3; i <= n; i++) {
            int k = i % 3;
            arr[k] = arr[(k + 1) % 3] + arr[(k + 2) % 3];
        }
        return arr[n % 3];
    }

    public double Power(double base, int exponent) {
        return 0;
    }

    public int getSeconds(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        return list.get(list.size() - 2);
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        if (input == null || input.length == 0 || input.length < k) {
            return list;
        }
        for (int i = 0; i < k; i++) {
            int minindex = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[minindex]) {
                    minindex = j;
                }
            }
            int temp = input[i];
            input[i] = input[minindex];
            input[minindex] = temp;
            list.add(input[i]);
        }
        return list;
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = nums.length - 1;
        return rob2(nums, len);
    }

    private int rob2(int[] nums, int len) {
        if (len == 0) {
            return nums[0];
        } else if (len == 1) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(nums[len] + rob2(nums, len - 2), rob2(nums, len - 1));
    }


    private int maxProfit2(int[] prices, int x) {
        //如果x==prices.length
        if (x == prices.length - 2) {
            return prices[prices.length - 1] - prices[prices.length - 2];
        }
        return Math.max(max(prices, x + 1) - prices[x], maxProfit2(prices, x + 1));
    }

    private int max(int[] arr, int x) {
        int result = arr[x];
        for (int i = x; i < arr.length; i++) {
            if (arr[i] > result) {
                result = arr[i];
            }
        }
        return result;
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
        }
        return arr[n] % 1000000007;
    }

    //1,2,3,3 ,3
    //3,3 ,2
    public boolean canPartitionKSubsets(int[] nums, int k) {
        //1、如果k大于nums的长度，直接返回false
        //2、转化为一个链表，返回并移除数组中的最大值，然后一遍一遍的找，剩下的值是否可以相加为这个值
        //3、如果最终发现找不到，则加1，然后一遍一遍的找，剩下的值是否可以相加为这个值
        //、当list长度和k正好都为0，返回true 中间
        //4、当klist的长度小于k时，return false
        //  当剩下的数不能加成想要的设置的值时，return false
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }
        int i = list.get(0);
        for (Integer in : list) {
            if (in > i)
                i = in;
        }
        find(list, list.size() - 1, i, k);
        return true;
    }

    //从剩下的list中选一个一组数，相加等于 inter，如果找到: k-1 并 return 这貌似是难点，因为不知道是几个数
    //当找不到时，返回-1
    public int find(List list, int curr, int inter, int k) {

        return k - 1;
    }

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{longer * k};
        }
        int[] arr = new int[k + 1];

        divingBoard2(arr, shorter, longer, arr.length);
        return arr;
    }

    private void divingBoard2(int[] arr, int shorter, int longer, int k) {
        if (k == 0) return;
        arr[k - 1] = (arr.length - k) * shorter + (k - 1) * longer;
        divingBoard2(arr, shorter, longer, k - 1);
    }

    public int tribonacci(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
        return arr[n];
    }

    public int multiply(int A, int B) {
        if (A < B) {
            return multiply2(A, B);
        } else {
            return multiply2(B, A);
        }
    }

    public int multiply2(int A, int B) {
        if (A == 0) {
            return 0;
        }
        if (A == 1) {
            return B;
        }
        return multiply(A - 1, B) + B;
    }

    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / myPow1(x, -n);
        } else {
            return myPow1(x, n);
        }
    }

    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        return myPow1(x, n - 1) * x;
    }
}
