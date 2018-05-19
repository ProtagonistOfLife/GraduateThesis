package com.pcw.bean;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import com.pcw.enumeration.Gender;

import sun.misc.BASE64Encoder;

/**
 * ����Ϊ�û��࣬���ڴ����û�����
 * @author Peng Ciwen
 * @version 1.0 2017.12
*/

public class User {
//	��������
	private String username;
	private Long userid;
	private String password;
	
//	����������
	private Gender gender;
	private Date birth;
	private String email;
	private String phonenum;
	
	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * �޲ι��캯��
	 */
	public User(){
		this(null, null);
	}	
	
	/**
	 * ������Ҫ�û�ȫ����Ϣ�Ĺ�����
	 * @param username �����û���
	 * @param password �����û�����
	 * @param gender �����û��Ա�
	 * @param birth ��������
	 */
	public User(String username, String password, Gender gender, Date birth) {
		super();
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.birth = birth;
	}
	
	/**
	 * �û�����ֻ��Ҫ�û�������Ϣ�Ĺ�����
	 * @param username �����û���
	 * @param password �����û�����
	 */
	public User(String username, String password) {
		this(username, password, Gender.male, null);
	}

	/**
	 * ��ȡ�û���
	 * @return String
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * �����û���
	 * @param username
	 * �û���
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * ��ȡ�û�id
	 * @return Long
	 */
	public Long getUserid() {
		return userid;
	}

	/**
	 * �����û�id
	 * @param userid
	 * �û�id��һ������������ݿ��ṩ�����и�������
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}

	/**
	 * ��ȡ���룬һ������»�ȡ���������붼��ʹ��md5���ܵģ�Ŀǰ����ʹ��md5����
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * �������룬���������һ��ʹ��MD5����м��ܣ�����ԭ����δʹ��
	 * @param password �������
	 */
	public void setPassword(String password){
		this.password = password;
	}

	/**
	 * ��ȡ�Ա�
	 * @return int
	 */
	public int getGender() {
		return gender.ordinal();
	}
	
	/**
	 * ��ȡ�Ա�����
	 * @return String
	 */
	public String getGenderName(){
		return gender.name();
	}

	/**
	 * �����Ա�
	 * @param gender �Ա�Ϊö������Gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@SuppressWarnings("static-access")
	public void setGender(int gender){
		this.gender = this.gender.values()[gender];
	}

	/**
	 * ��ȡ����
	 * @return Date 
	 */
	public Date getBirth() {
		return birth;
	}

	/**
	 * ��������
	 * @param birth �û����գ�ΪDate����
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	/**
	 * ������ܱ���
	 * @param str
	 * @return newstr 
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String encodeByMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base = new BASE64Encoder();
		String newstr = base.encode(md5.digest(str.getBytes("gbk")));
		return newstr;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", userid=" + userid + ", password=" + password + ", gender=" + gender
				+ ", birth=" + birth + ", email=" + email + ", phonenum=" + phonenum + "]";
	}
}
