package com.aaa.pagetest.util;

import java.util.List;

/**
 * 
 * @author Li
 *
 * @param <E> ҳ
 */
public class PageBean<E> {

	public PageBean(int dataTotal, int pageCur, int pageSize) {
		this.dataTotal = dataTotal;
		this.pageCur = pageCur;
		this.pageSize = pageSize;
		//�����ǰҳ��С��1
		if (this.pageCur < 1) {
			this.pageCur = 1;
		}
		// �������ҳ��
		pageTotal = dataTotal % pageSize == 0 ? (dataTotal / pageSize) : (dataTotal / pageSize) + 1;
		// �����ǰҳ������
		if (this.pageCur > pageTotal) {
			this.pageCur = pageTotal;
		}

	}

	private int pageCur; // ��ǰҳ��
	private int pageSize; // ÿһҳ��ʾ����������
	private int dataTotal; // ����������
	private int pageTotal; // ��ҳ��

	private List<E> list; // һҳ������

	public int getPageCur() {
		return pageCur;
	}

	public void setPageCur(int pageCur) {
		this.pageCur = pageCur;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getDataTotal() {
		return dataTotal;
	}

	public void setDataTotal(int dataTotal) {
		this.dataTotal = dataTotal;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

}
