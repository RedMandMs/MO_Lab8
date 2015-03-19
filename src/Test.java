/**
 * Created by Vred.L.Hom on 09.03.2015.
 */
public class Test {

    public static void main(String[] args) {

        testFunct();

    }

    private static void testGoldSven(){
/*        MethodPolkaRibera mPR = new MethodPolkaRibera();

        MethodGoldenSection mGS = new MethodGoldenSection();

        MyVector vec = new MyVector();

        double min = mGS.findMin(mPR, vec, vec);

        System.out.println("Min = " + min);*/
    }

    private static void testFunct(){
        Functions func = new Functions();
        double[] k ={1.69,0};
        MyVector myVector = new MyVector(k);
        System.out.println(func.valueFun(myVector));
    }
}
