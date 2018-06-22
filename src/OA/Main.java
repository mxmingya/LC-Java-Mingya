package OA; /**
 * Created by mingyama on 9/22/17.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        private TreeNode(int val) {
            this.left = null;
            this.right = null;
            this.val = val;
        }
    }

    private int getLowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        // to find the lowest common ancestor of node1 and node2, we need to utilize the features of Binary Search Tree,
        // which navigates us to left side or right side based on the comparison results of node1.val node2.val and root.val
        // if node1.val < root.val < node2.val, then the current TreeNode is the Lowest Common Ancestor of node1 and node2
        if (node1.val < root.val && node2.val < root.val) return getLowestCommonAncestor(root.left, node1, node2);
        if (node1.val > root.val && node2.val > root.val) return getLowestCommonAncestor(root.right, node1, node2);
        return root.val;
    }

    private double[] computeInterests(String[] nums) {
        // nums[0] loan amount, nums[1] year of loan, nums[2] interest rate, nums[3] down payment
        // P = (monthly rate * Loan amount) / (1 - (1+monthly interest rate)^-n) Here n is no of payment periods.
        double[] res = new double[2];
        double loanAmount = (double)Integer.parseInt(nums[0]) - (double)Integer.parseInt(nums[3]);
        double paymentPeriod = (double) Integer.parseInt(nums[1]) * 12.0;
        double monthlyInterestRate = ((double)Integer.parseInt(nums[2]))/12.0/100.0;// payment is annual rate/12
        double numerator = loanAmount * monthlyInterestRate;
        double denominator = 1 - Math.pow(1 + monthlyInterestRate, 0-paymentPeriod);
        double monthlyPayment = numerator / denominator;
        double totalInterest = monthlyPayment * paymentPeriod - loanAmount;

//        System.out.printf("%f %f %f %f %f %f %f ", loanAmount, paymentPeriod, monthlyInterestRate, numerator, denominator, monthlyPayment, totalInterest);
        res[0] = monthlyPayment;
        res[1] = totalInterest;
        return res;
    }

    private String computeNAVDiff(String input) {
        Map<String, Double> portQty = new HashMap<>();
        Map<String, Double> portPrice = new HashMap<>();
        Map<String, Double> benchQty = new HashMap<>();
        Map<String, Double> benchPrice = new HashMap<>();
        Map<String, Double> diff = new HashMap<>();
        String[] stocks = input.split("\\|"); // 0:port, 1:bench
        String[] portData = stocks[0].split(":")[1].split(";");
        for (int i = 0; i < portData.length; i++) {
            String[] currentStock = portData[i].split(",");
            String name = currentStock[0];
            portQty.put(name, Double.parseDouble(currentStock[1]));
            portPrice.put(name, Double.parseDouble(currentStock[2]));
        }
        String[] benchData = stocks[1].split(":")[1].split(";");
        for (int i = 0; i < benchData.length; i++) {
            String[] currentStock = benchData[i].split(",");
            String name = currentStock[0];
            benchQty.put(name, Double.parseDouble(currentStock[1]));
            benchPrice.put(name, Double.parseDouble(currentStock[2]));
        }
        // make up missing stocks in both bench and port.
        for (String portName : portQty.keySet()) {
            if (!benchQty.containsKey(portName)) {
                benchQty.put(portName, 0.0);
                benchPrice.put(portName, 0.0);
            }
        }
        for (String benchName : benchQty.keySet()) {
            if (!portQty.containsKey(benchName)) {
                portQty.put(benchName, 0.0);
                portPrice.put(benchName, 0.0);
            }
        }
        // compute nav # for port and bench
        double navPort = 0;
        for (String stockName : portQty.keySet()) {
            navPort += portQty.get(stockName) * portPrice.get(stockName);
        }
        double navBench = 0;
        for (String stockName : benchQty.keySet()) {
            navBench += benchQty.get(stockName) * benchPrice.get(stockName);
        }
        for (String stockName: portQty.keySet()) {
            double navPortPercent = portPrice.get(stockName) * portQty.get(stockName) * 100 / navPort;
            double navBenchPercent = benchPrice.get(stockName) * benchQty.get(stockName) * 100 / navBench;
            diff.put(stockName, navPortPercent-navBenchPercent);
        }
        //construct output string
        StringBuilder output = new StringBuilder();
        List<String> nameHolder = new ArrayList<>(diff.keySet());
        Collections.sort(nameHolder);
        for (String stockName : nameHolder) {
            String navValue = diff.get(stockName) == 0.0 ? "-0.0" : String.format("%.2f", diff.get(stockName));
            output.append(stockName).append(":").append(navValue).append(",");
        }
        output.deleteCharAt(output.length()-1);
        return output.toString();
    }

    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
//        for (String s : "PORT:AXN,0,10;BGT,20,30;CXZ,10,30|BENCH:AXN,50,10;BGT,30,30;DFG,30,20;XYZ,0,10".split("\\|")){
//            System.out.println(s);
//        }
//        System.out.println(new OA.Main().computeNAVDiff("PORT:AXN,0,10;BGT,20,30;CXZ,10,30|BENCH:AXN,50,10;BGT,30,30;DFG,30,20;XYZ,0,10"));
//        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//        BufferedReader in = new BufferedReader(reader);
//        String line;
//        while ((line = in.readLine()) != null) {
//            String[] arg = line.split("~");
//            String[] nums = new String[arg.length];
//            for (int i = 0; i < arg.length; i++) {
//                nums[i] = arg[i].trim();
//            }
//            // nums[0] loan amount, nums[1] year of loan, nums[2] interest rate, nums[3] down payment
//            // P = (monthly rate * Loan amount) / (1 - (1+monthly interest rate)^-n) Here n is no of payment periods.
//            double[] res = new OA.Main().computeInterests(nums);
//            double monthlyPayment = res[0];
//            int totalPayment = (int) Math.round(res[1]);
//            String result = String.format("%.2f", monthlyPayment);
//            System.out.printf("$%s~$%d", result, totalPayment);
//        }
//
//        Tree.TreeNode root = new Tree.TreeNode(30);
//        Tree.TreeNode n2 = new Tree.TreeNode(8);
//        Tree.TreeNode n3 = new Tree.TreeNode(3);
//        Tree.TreeNode n4 = new Tree.TreeNode(20);
//        Tree.TreeNode n5 = new Tree.TreeNode(10);
//        Tree.TreeNode n6 = new Tree.TreeNode(29);
//        Tree.TreeNode n7 = new Tree.TreeNode(52);
//        root.left = n2;
//        root.right = n7;
//        n2.left = n3;
//        n2.right = n4;
//        n4.left = n5;
//        n4.right = n6;
//        while ((line = in.readLine()) != null) {
//            String[] arg = line.split(" ");
//            System.out.println(new OA.Main().getLowestCommonAncestor(root, new Tree.TreeNode(Integer.parseInt(arg[0])), new Tree.TreeNode(Integer.parseInt(arg[1]))));
//        }

               /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // find the least common multiplier
        Scanner sc = new Scanner(System.in);
        String len = sc.nextLine();
        int[] nums = new int[Integer.parseInt(len)];
        for (int i = 1; i < Integer.parseInt(len); i++) {
            String current = sc.nextLine();
            nums[i] = Integer.parseInt(current);
        }

        StringBuilder res = new StringBuilder();
        for (int num : nums) {
            res = new StringBuilder();
            int num3= num / 5;
            int num5 = (num % 5) / 3;
            while (num3*5 + num5*3 != num && num3 >= 0 && num5 >= 0) {
                num3--;
                num5 = (num-num3*5)/3;
            }
            if (num3*5 + num5*3 != num) {
                res.append(-1);
            } else {
                for(int i=0;i<num3;i++) res.append(5);
                for(int i=0;i<num5;i++) res.append(3);
            }
            res.append(",");
        }
        String[] result = res.toString().split(",");
        for(String s : result) {
            System.out.println(s);
        }

    }
}


