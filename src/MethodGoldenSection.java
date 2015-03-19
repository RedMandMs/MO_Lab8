

public class MethodGoldenSection {

    private final double eps = 0.001;

    public double findMin(MethodPolkaRibera inst, MyVector x, MyVector d){
        Sven sven = new Sven();
        double[] interval = sven.findInterval(inst,x,d);

        double a = interval[0];

        double b = interval[1];

        double L = Math.abs(b - a);

        double l = a + 0.618*L;
        double m = a + 0.382*L;

        int k = 1;

        do{
            if(function(inst, x, d, l) < function(inst, x, d, m)){
                a = m;
                m = l;
                L = Math.abs(b - a);
                l = a + 0.618*L;
            }else{
                b = l;
                l = m;
                L = Math.abs(b - a);
                m = a + 0.382*L;
            }
            k++;

            printResult(m, l, inst, x, d, k);
        }while (Math.abs(a-b) >= eps);

        double tkMin = (a+b)/2;

        return tkMin;
    }

    private void printResult(double m, double l, MethodPolkaRibera inst, MyVector x, MyVector d, int k) {
        if(inst.gui.withGS.isSelected()) {
            String result = "                         Метод Золотого сечения: Шаг:" + k + ": \n                         t0(m) = " + m + "   f(m)" + function(inst, x, d, m) + "\n"
                    + "                         t0(l) = " + l + "   f(l)" + function(inst, x, d, l);
            inst.gui.putToResult(result);
        }
    }

    private double function(MethodPolkaRibera inst, MyVector x, MyVector d, double tk) {

        double result;

        MyVector xNew = x.addition(d.multipliedByConst(tk));

        result = inst.function(xNew);

/*        double result;

        result = 2 * tk * tk + 3 * Math.exp(-tk);*/

        return result;
    }

}
