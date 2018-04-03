package demo.others;

public class ExceptionTest {

    public void test1()throws Exception{
        int a=0,b=1;
        try{
            int c = b/a;
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.print("001");
        System.out.print("002");
        System.out.print("003");
    }

    /*public static void main(String[] args)throws Exception{
        ExceptionTest exceptionTest = new ExceptionTest();
        exceptionTest.test1();
    }*/

}
