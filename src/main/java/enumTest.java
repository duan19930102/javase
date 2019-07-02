/**
 * FileName: enumTest
 * Author:   Administrator
 * Date:     2019/4/22 14:28
 * Description: 测试enum
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试enum〉
 *
 * @author Administrator
 * @create 2019/4/22
 * @since 1.0.0
 */
public class enumTest {
    public static void main(String[] args) {
        System.err.println("****************************");
        for (Food.Dessert dessertEnum:Food.Dessert.values()) {
            System.err.println(dessertEnum);
        }
        System.err.println("****************************");
        for (Food.Coffee coffeeEnum:Food.Coffee.values()) {
            System.err.println(coffeeEnum);
        }

        Food food =Food.Dessert.CAKE;
        System.err.println("****************************");
        System.err.println(food);
        food =Food.Coffee.BLACK_COFFEE;
        System.err.println("****************************");
        System.err.println(food);
    }

}