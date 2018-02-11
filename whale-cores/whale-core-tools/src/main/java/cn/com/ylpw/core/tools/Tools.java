/**
 * <p>Title: Tools.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017, zj7687362@gmail.com All Rights Reserved. </p>
 * <p>Company: www.jcore.cn</p>
 * @author 张嘉杰
 * @date 2017年2月9日 上午8:51:25
 */
package cn.com.ylpw.core.tools;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Title: Tools.java
 * </p>
 * <p>
 * Description: 基础工具类
 * </p>
 * 
 * @author 张嘉杰
 * @date 2017年2月9日 上午8:51:25
 */
public abstract class Tools {


	/***
	 * <p>将list 拆分成N个list</p>
	 * @author LT
	 * @date 2017年9月28日 上午11:32:28
	 * @return List<List<T>>
	 * @param source
	 * @param n
	 * @return
	 */
	public static <T> List<List<T>> averageAssign(List<T> source, int n) {
		List<List<T>> result = new ArrayList<List<T>>();
		int remaider = source.size() % n; // (先计算出余数)
		int number = source.size() / n; // 然后是商
		int offset = 0;// 偏移量
		for (int i = 0; i < n; i++) {
			List<T> value = null;
			if (remaider > 0) {
				value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
				remaider--;
				offset++;
			} else {
				value = source.subList(i * number + offset, (i + 1) * number + offset);
			}
			result.add(value);
		}
		return result;
	}

}
