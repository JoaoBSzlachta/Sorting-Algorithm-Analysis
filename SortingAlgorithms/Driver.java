import utilities.*;

public class Driver {
    public static void main(String[] args) {
        Tester tester = new Tester();
        Util util = new Util();

        tester.getSortingMethod("bubble", 5);
        tester.showRTmili();
        util.showBlancSpace();

        tester.getSortingMethod("selection", 5);
        tester.showRTmili();
        util.showBlancSpace();

//        tester.getSortingMethod("merge", 20);
//        tester.showRTmili();
//        util.showBlancSpace();
        //NÃO UTILIZAR MÉTODO MERGE, ESTA SESSÃO ESTÁ COM ERRO
    }
}
