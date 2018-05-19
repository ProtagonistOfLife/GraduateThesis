package com.pcw.bean;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import com.pcw.enumeration.Gender;

import sun.misc.BASE64Encoder;

/**
 * 本类为用户类，用于创建用户对象
 * @author Peng Ciwen
 * @version 1.0 2017.12
*/

public class User {
//	常用属性
	private String username;
	private Long userid;
	private String password;
	
//	不常用属性
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
	 * 无参构造函数
	 */
	public User(){
		this(null, null);
	}	
	
	/**
	 * 用于需要用户全部信息的构造器
	 * @param username 传入用户名
	 * @param password 传入用户密码
	 * @param gender 传入用户性别
	 * @param birth 传入生日
	 */
	public User(String username, String password, Gender gender, Date birth) {
		super();
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.birth = birth;
	}
	
	/**
	 * 用户构造只需要用户常用信息的构造器
	 * @param username 传入用户名
	 * @param password 传入用户密码
	 */
	public User(String username, String password) {
		this(username, password, Gender.male, null);
	}

	/**
	 * 获取用户名
	 * @return String
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置用户名
	 * @param username
	 * 用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取用户id
	 * @return Long
	 */
	public Long getUserid() {
		return userid;
	}

	/**
	 * 设置用户id
	 * @param userid
	 * 用户id，一般情况下由数据库提供，不有个人输入
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}

	/**
	 * 获取密码，一般情况下获取出来的密码都是使用md5加密的，目前暂无使用md5加密
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置密码，密码输入后一般使用MD5码进行加密，技术原因暂未使用
	 * @param password 密码参数
	 */
	public void setPassword(String password){
		this.password = password;
	}

	/**
	 * 获取性别
	 * @return int
	 */
	public int getGender() {
		return gender.ordinal();
	}
	
	/**
	 * 获取性别名称
	 * @return String
	 */
	public String getGenderName(){
		return gender.name();
	}

	/**
	 * 设置性别
	 * @param gender 性别，为枚举类型Gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@SuppressWarnings("static-access")
	public void setGender(int gender){
		this.gender = this.gender.values()[gender];
	}

	/**
	 * 获取生日
	 * @return Date 
	 */
	public Date getBirth() {
		return birth;
	}

	/**
	 * 设置生日
	 * @param birth 用户生日，为Date类型
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	/**
	 * 密码加密保存
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
