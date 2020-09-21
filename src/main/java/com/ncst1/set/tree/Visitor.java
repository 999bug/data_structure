package com.ncst1.set.tree;

/**
 * 自己实现的遍历树形结构
 *
 * @return
 */
public  abstract class Visitor<E> {
	boolean stop;

	/**
	 * @return 如果返回true，就代表停止遍历
	 */
	public abstract boolean visit(E element);
}