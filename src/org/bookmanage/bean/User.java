package org.bookmanage.bean;

import java.util.Date;

/*
 * ѧ��ģ��
 */
public class User {
	private String readerId;//����֤��
	private String name;//ѧ������
	private String spec;//רҵ
	private int sex;//�Ա�
	private int num;//������
	private int type;//�û����� 0��ѧ��1�ǹ���Ա
	private String passwd;//�˻�����
	public String getReaderId() {
		return readerId;
	}
	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
