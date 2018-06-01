package fix;

import org.junit.Test;

import com.wm.utils.array.ArrayUtil;

public class ArrayTest {
	@Test
	public void testResizeArray() {
		int[] a = { 1, 2, 3 };
		a = (int[]) ArrayUtil.resizeArray(a, 5);
		a[3] = 4;
		a[4] = 5;
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}
}
