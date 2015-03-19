import java.util.List;

/**
 * Created by Vred.L.Hom on 22.02.2015.
 */
public class Sven {

    double h = 0.01;

    public double[] findInterval(MethodPolkaRibera inst, MyVector x, MyVector d){

        double tk1 = 1;
        double tk2 = 1 + h;
        double tk0 = 1;

        if(function(inst, x, d, tk1)<function(inst, x, d, tk2)){
            h=-h;
            tk2 = tk1 + h;
        }

        int k = 0;

        while (function(inst, x, d, tk1) > function(inst, x, d, tk2)){
            tk0 = tk1;
            tk1 = tk2;
            tk2 = tk1 +h;
            h=2*h;
            k++;
            printResult(inst, x, d, k, tk0, tk2);
        }

        double[] result = new double[2];

        if(tk0>tk2) {
            result[0] = tk2;
            result[1] = tk0;
        }else{
            result[0] = tk0;
            result[1] = tk2;
        }


        return result;
    }

    private void printResult(MethodPolkaRibera inst, MyVector x, MyVector d, int k, double tk0, double tk2) {
        if(inst.gui.withSven.isSelected()) {
            String result;
            if (tk0 > tk2) {
                result = "               Метод Свенна: Шаг " + k + ":  tk =[" + tk2 + " ; " + tk0 + "]; ";
            } else {
                result = "               Метод Свенна: Шаг " + k + ":  tk =[" + tk0 + " ; " + tk2 + "]; ";
            }
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
