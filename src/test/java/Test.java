import com.lpf.proxy.DynamicProxy;
import com.lpf.proxy.Math;

/**
 * Created by lpf on 2017/7/4 0004.
 */
public class Test {
    //实例化一个DynamicProxy代理对象
    //通过getProxyObject方法获得被代理后的对象
    Math math=(Math)new DynamicProxy().getProxyObject(new Math());

    @org.junit.Test
    public void tese01(){
        int n1=100,n2=5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }
}
