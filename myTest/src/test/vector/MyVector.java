package test.vector;

import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.Object;
import java.lang.System;

/**
 * 动态数组构造
 */
public class MyVector {
	private Object[] elementData;
	private int elementCount;

	// 确定容量的方法
	private void ensureCapacity(int minCapacity) {
		int oldCapacity = elementData.length;// 获取到当前的长度
		// 比原来的长度要大
		if (minCapacity > oldCapacity) {
			Object oldData[] = elementData;
			int newCapacity = oldCapacity * 2;// 拓展长度
			// 如果拓展两倍后还比设置的小,则设置的为准
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
			}
			elementData = new Object[newCapacity];
			System.arraycopy(oldData, 0, elementData, 0, elementCount);
		}
	}

	// 默认构造是个元素
	public MyVector() {
		this(10);
	}

	// 参数化初始化
	public MyVector(int initialCapacity) {
		elementData = new Object[initialCapacity];
		elementCount = 0;
	}

	public void add(int index, Object element) {
		if (index >= elementCount + 1) {
			throw new ArrayIndexOutOfBoundsException(index + ">" + elementCount);
		}
		// 拓展新数组
		ensureCapacity(elementCount + 1);
		System.arraycopy(elementData, index, elementData, index + 1,
				elementCount - index);
		elementData[index] = element;
		elementCount++;
	}

	public void add(Object element) {
		add(elementCount, element);
	}

	public void set(int index, Object element) {
		if (index >= elementCount) {
			throw new ArrayIndexOutOfBoundsException(index + ">="
					+ elementCount);
		}
		elementData[index] = element;
	}

	public Object get(int index) {
		if (index >= elementCount) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return elementData[index];
	}

	public int size() {
		return elementCount;
	}

	// 集合
	public int indexOf(Object element) {
		if (element == null) {
			for (int i = 0; i < elementCount; i++) {
				if (elementData[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < elementCount; i++) {
				if (element.equals(elementData[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	public boolean contain(Object element) {
		return indexOf(element) > 0;
	}

	public void remove(Object element) {
		int i = indexOf(element);
		if (i > 0) {
			remove(i);
		}
	}

	public void remove(int index) {
		if (index >= elementCount) {
			throw new ArrayIndexOutOfBoundsException(index + ">="
					+ elementCount);
		} else if (index < 0) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		int j = elementCount - index - 1;
		if (j > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, j);
		}
		elementCount--;
		elementData[elementCount] = null;
	}
}
