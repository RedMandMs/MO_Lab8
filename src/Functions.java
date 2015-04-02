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

    public MyVector numGradFun(MyVector point){
        double delta = 0.0001;
        int countVar = point.vals.length;
        double [] vals = new double[countVar];
        for(int i = 0; i < countVar; i++){
            double [] newVals = point.vals.clone();
            newVals[i] = point.vals[i] + delta;
            MyVector newPoint = new MyVector(newVals);
            vals[i] = (valueFun(newPoint) - valueFun(point)) / delta;
        }
        MyVector result = new MyVector(vals);
        return result;
    }



    //Отработанные

    public MyVector numGradFunFull(MyVector point){
        double [] vals;
        double delta = 0.0001;
        if(isFirstFunct){
            double deltaX1 = point.vals[0] + delta;
            double deltaX2 = point.vals[1] + delta;
            MyVector newPoint1 = new MyVector(new double[]{deltaX1, point.vals[1]});
            MyVector newPoint2 = new MyVector(new double[]{point.vals[0], deltaX2});
            vals = new double[2];
            vals[0] = (valueFun(newPoint1) - valueFun(point)) / delta;
            vals[1] = (valueFun(newPoint2) - valueFun(point)) / delta;
        }else{
            double deltaX1 = point.vals[0] + delta;
            double deltaX2= point.vals[1] + delta;
            double deltaX3 = point.vals[2] + delta;
            double deltaX4 = point.vals[3] + delta;
            vals = new double[4];
            MyVector newPoint1 = new MyVector(new double[]{deltaX1, point.vals[1], point.vals[2], point.vals[3]});
            MyVector newPoint2 = new MyVector(new double[]{point.vals[0], deltaX2, point.vals[2], point.vals[3]});
            MyVector newPoint3 = new MyVector(new double[]{point.vals[0], point.vals[1], deltaX3, point.vals[3]});
            MyVector newPoint4 = new MyVector(new double[]{point.vals[0], point.vals[1], point.vals[2], deltaX4});
            vals[0] = (valueFun(newPoint1) - valueFun(point)) / delta;
            vals[1] = (valueFun(newPoint2) - valueFun(point)) / delta;
            vals[2] = (valueFun(newPoint3) - valueFun(point)) / delta;
            vals[3] = (valueFun(newPoint4) - valueFun(point)) / delta;
        }
        MyVector result = new MyVector(vals);
        return result;
    }

    public  MyVector gradFun(MyVector point){
        double [] vals;
        if(isFirstFunct){
            double x1 = point.vals[0];
            double x2 = point.vals[1];
            vals = new double[2];
            vals[0] = 8 * x1 - 4 * Math.pow(x2,2) + 1;
            vals[1] = 6 * x2 - 8 * x1 * x2;
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


}
