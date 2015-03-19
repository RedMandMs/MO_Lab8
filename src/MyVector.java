import java.util.Vector;

public class MyVector {

    /**
     * Значение вестора
     */
    public double [] vals;

    public MyVector(double[] vals) {
        this.vals = vals;
    }

    /**
     * Умножение векторов
     * @param vector2 -2й вектор
     * @return - сколярное произведение или 0 в случае разного размера векторов
     */
    public double multipliedBy(MyVector vector2){
        double sum = 0;
        if(vector2.vals.length == this.vals.length){
            for (int i = 0; i < vector2.vals.length; i++) {
                sum += (this.vals[i] * vector2.vals[i]);
            }
        }
        return sum;
    }

    /**
     * Вычесть из вектора
     * @param vector2 - вычитаемый вектор
     */
    public MyVector subtraction(MyVector vector2){
        MyVector newVect = new MyVector(this.vals.clone());
        if(vector2.vals.length == this.vals.length){
            for (int i = 0; i < vector2.vals.length; i++) {
                newVect.vals[i]-=vector2.vals[i];
            }
        }
        return newVect;
    }

    /**
     * Прибавить к вектору
     * @param vector2 - вычитаемый вектор
     */
    public MyVector addition(MyVector vector2){
        MyVector newVect = new MyVector(this.vals.clone());
        if(vector2.vals.length == this.vals.length){
            for (int i = 0; i < vector2.vals.length; i++) {
                newVect.vals[i]+=vector2.vals[i];
            }
        }
        return newVect;
    }

    /**
     * умножение на число
     * @param val - умножитель
     */
    public MyVector multipliedByConst(double val){
        MyVector newVect = new MyVector(this.vals.clone());
        for (int i = 0; i < this.vals.length; i++) {
            newVect.vals[i] = this.vals[i]* val;
        }
        return newVect;
    }

    public MyVector minusBeforVector(){
        MyVector newVect = new MyVector(this.vals.clone());
        for (int i = 0; i < this.vals.length; i++) {
            newVect.vals[i] = - this.vals[i];
        }
        return newVect;
    }
}
