/**
 * Created by Vred.L.Hom on 10.03.2015.
 */
public class Functions {

    boolean isFirstFunct = true;

    public double valueFun(MyVector point){

        double result;

        if(isFirstFunct){
            double x1 = point.vals[0];
            double x2 = point.vals[1];
            result = 4 * Math.pow(x1, 2) + 3 * Math.pow(x2,2) - 4 * x1 * Math.pow(x2,2) + x1;
        }else{
            double x1 = point.vals[0];
            double x2 = point.vals[1];
            double x3 = point.vals[2];
            double x4 = point.vals[3];
            result = Math.pow((x1 + 10 * x2),2)
                    + 5 * Math.pow((x3 - x4), 2)
                    + Math.pow((x2 - 2 * x3),4)
                    + 10 * Math.pow((x1 - x4),4);
        }
        return result;
    }

    public  MyVector gradFun(MyVector point){
        double [] vals;
        if(isFirstFunct){
            double x1 = point.vals[0];
            double x2 = point.vals[1];
            vals = new double[2];
            vals[0] = 8 * x1 - 4 * Math.pow(x2,2) + 1;
            vals[1] =6 * x2 - 8 * x1 * x2;
        }else{
            double x1 = point.vals[0];
            double x2 = point.vals[1];
            double x3 = point.vals[2];
            double x4 = point.vals[3];
            vals = new double[4];
            vals[0] = 2 * (20 * Math.pow((x1-x4),3) + x1 + 10 * x2);
            vals[1] = 4 *(5 * (x1 + 10*x2) + Math.pow((x2 - 2*x3),3));
            vals[2] = 10 * (x3 - x4) - 8 * Math.pow((x2 - 2 * x3), 3);
            vals[3] = 10 * (x4 - x3 - 4 * Math.pow((x1 - x4),3));
        }
        MyVector result = new MyVector(vals);
        return result;
    }

    /*public double valueFun(MyVector point) {

        double x = point.vals[0];
        double y = point.vals[1];
        return 2 * x * x
                + 2 * y * y
                + 2 * x * y
                + 20 * x
                + 10 * y
                + 10;
    }

    public  MyVector gradFun(MyVector point) {
        double[] vals;
        double x = point.vals[0];
        double y = point.vals[1];
        vals = new double[2];
        vals[0] =     4 * x
                    + 2 * y
                    + 20;

        vals[1] =     4 * y
                    + 2 * x
                    + 10;
        MyVector result = new MyVector(vals);
        return result;
    }*/
}
