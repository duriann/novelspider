package niukewang_20161015;
/**
 * 		for(条件1;条件2;条件3) {
    	//语句
		}
		执行顺序是条件1->条件2->语句->条件3->条件2->语句->条件3->条件2........
		如果条件2为true，则一直执行。如果条件2位false，则for循环结束
 * @author pineapple
 * @time 2016年10月15日下午11:22:50
 */
public class Test3
{
    static boolean foo(char c)
    {
        System.out.print(c);
        return true;
    }
    public static void main( String[] argv )
    {
        int i = 0;
        for ( foo('A'); foo('B') && (i < 2); foo('C'))
        {
            i++ ;
            foo('D');
        }
    }
}