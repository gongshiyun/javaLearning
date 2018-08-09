package gsy.main.enumtest;

/**
 * @author gongshiyun
 * @Description TODO
 * @date 2018/7/6
 */
public abstract class TestInnerClass {
    public abstract void dosth();
    public static void main(String[] xx){
        TestInnerClass tic = new TestInnerClass() {
            @Override
            public void dosth(){
                System.out.println("do sth");
            }
        };
        tic.dosth();
    }
}
