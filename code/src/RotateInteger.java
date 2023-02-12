public class RotateInteger {
    public static void main(String[] args) {

        System.out.println(new RotateInteger().rotate(-1230));
        System.out.println(new RotateInteger().rotate(0));
        System.out.println(new RotateInteger().rotate(201));
       // System.out.println(Integer.MAX_VALUE);
        System.out.println(new RotateInteger().rotate(1534236469));
        //2147483647
        //1534236469
    }

    private int rotate(int n) {

        boolean negative = false;

        if(n<0) {
            negative = true;
            n = n*1;
        }

        String val = String.valueOf(n);

        StringBuffer sb = new StringBuffer("");

        int i = val.length() -1;
        boolean first = true;
        while(i>=0) {
            while(first && val.charAt(i) == '0') {
                i--;
                first = false;
            }
            if(i>=0 && val.charAt(i) != '-') {
                sb.append(val.charAt(i));
            }
            i--;
            first = false;
        }

        int ret = 0;

        try{
            if(sb.length()>0) {
                ret = Integer.parseInt(sb.toString());

                if (negative) {
                    ret = ret * (-1);

                }
            }
        } catch(NumberFormatException nfe) {
            ret = 0;
        }
        return ret;
    }


}
