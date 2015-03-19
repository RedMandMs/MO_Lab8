public class MethodPolkaRibera {

    public GUI gui;

    public MethodPolkaRibera(GUI gui){
        this.gui = gui;
    }

    public MyVector goMethod(MyVector startPoint, double eps){

        MyVector newX = startPoint;
        MyVector oldX = startPoint;

        //The start stage
        int k = 0;
        MyVector d = null;
        MyVector dOld = null;
        double b;
        MethodGoldenSection goldenSec = new MethodGoldenSection();
        double t;

        //The main stage

        printResult(newX, k);

        //Проверка окончания поиска
        while (normaFunction(newX) > eps){
            if(k == 0){
                d = gradFunction(newX).minusBeforVector();
                t = goldenSec.findMin(this, newX, d);
                oldX = newX;
                newX = oldX.addition(d.multipliedByConst(t));
                k++;
                printResult(newX, k);
            }

            dOld = d;
            //если k входит в I, I = 0, n, 2n, 3n..
            if(((k-1) % newX.vals.length) == 0){
                    b = 0;
            }else{
                //!!!!!!! Формула Полока-Ребьера
                b = (gradFunction(newX).multipliedBy(gradFunction(newX).subtraction(gradFunction(oldX))))
                        /(gradFunction(newX).multipliedBy(gradFunction(newX)));

            }
            //Формула Флетчера-Ривса
            //b = Math.pow(normaFunction(newX),2)/Math.pow(normaFunction(oldX),2);

            d = gradFunction(newX).minusBeforVector().addition(dOld.multipliedByConst(b));

            //Ищем t0!!!!!!!!!!!!!!
            t = goldenSec.findMin(this, newX, d);

            oldX = newX;

            newX = oldX.addition(d.multipliedByConst(t));
            k++;
            printResult(newX, k);
        }
        printEndResult(newX);
        return newX;
    }

    /**
     * Значение функции в точке x
     * @param x - точка x
     * @return - значение функции
     */
    public double function(MyVector x){

        return gui.function(x);
    }

    /**
     * Градиент функции
     * @param point - точка
     * @return - значение градиента
     */
    private MyVector gradFunction(MyVector point) {

        return gui.grad(point);
    }

    /**
     * Градиенты функции
     * @param x - точка
     * @return - матрица градиентов
     */
    private double[] gradsFunction(MyVector x) {

        return gui.grad(x).vals;
    }

    /**
     * Норма функции в зданной точке
     * @param x - точка
     * @return - норма
     */
    private double normaFunction(MyVector x){
        double[] gradFunct = gradsFunction(x);

        double sum = 0;

        for (double aGradFunct : gradFunct) {
            sum += aGradFunct * aGradFunct;
        }

        double norma = Math.sqrt(sum);
        return norma;
    }

    private void printResult(MyVector x, int k){

        String vector = "";

        for (int i = 0; i < x.vals.length; i++) {
            if (i != x.vals.length - 1) {
                vector = vector + x.vals[i] + " , ";
            }else {
                vector = vector + x.vals[i];
            }
        }

        String result = "Метод полока Ребьера: Шаг:" + k + ":  X = {" + vector + "};  f(x) = " + function(x);
        gui.putToResult(result);
    }

    private void printEndResult(MyVector x){

        String vector = "";

        for (int i = 0; i < x.vals.length; i++) {
            if (i != x.vals.length - 1) {
                vector = vector + x.vals[i] + " , ";
            }else {
                vector = vector + x.vals[i];
            }
        }

        String result = "\n\nМинимум функции находится в точке X = {" + vector + "}; \nЗначение функции в этой точке: f(X) = " + function(x);

        gui.putToResult(result);
    }
}
