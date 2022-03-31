package org.springcloud.pojo;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author My 首先分布式，第一步需要网络通信，第二步序列化，所有的实体类必须实现序列化才可通讯
 */
//@SuppressWarnings(“serial”)
//如果编译器出现这样的警告信息：The serializable class WmailCalendar does not declare a static final serialVersionUID field of type long，使用这个注释将警告信息去掉。
@SuppressWarnings("serial")
@Data
@NoArgsConstructor // 生成一个无参数的构造方法
@Accessors(chain = true) // 链式写法
public class Dept implements Serializable {

	/**
	 * 主键
	 */
	private Long deptno;
	/**
	 * dept名称
	 */
	private String dname;
	/**
	 * 微服务架构，可以一个服务对应一个数据库，一个信息存到不同数据库，db_source标识是哪个数据库
	 */
	private String db_source;

	public Dept(String dname) {
		this.dname = dname;
	}

	// 链式写法：
	public static void main(String[] args) {
		Dept dept = new Dept();
		dept.setDeptno(11L).setDname("aaa").setDb_source("000");
	}

}
