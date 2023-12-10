class solution {
    public static int[] plusOne(int[] digits) {

        Long nums = 0L ;

        for(int i = 0;i<digits.length;i++)
            nums= (nums*10) + digits[i];
        
        int resSize = Long.toString(nums+1).length();
        if(resSize > digits.length)
        {
            int[] res  = new int[resSize];
            for(int i = 0; i<resSize;i++)
            {
                res[i] = Long.toString(nums+1).charAt(i)-'0';
            }
            return res;
        }
        else
        {
            for(int i = 0; i<resSize;i++)
            {
                digits[i] = Long.toString(nums+1).charAt(i)-'0';
            } 
        }
        return digits;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        arr = plusOne(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}