package org.springcloud.service;

import java.util.List;

import org.springcloud.pojo.Dept;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

// 降级
/**
 * @author My 接口异常熔断退回 FallbackFactory
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {

	public DeptClientService create(Throwable cause) {
		return new DeptClientService() {

			public boolean addDept(Dept dept) {
				return false;
			}

			public Dept queryById(Long deptno) {
				return new Dept().setDeptno(deptno).setDname("id=>" + deptno + ",没有对应信息，客户端提供降级的信息，此服务已关闭 ")
						.setDb_source("没有数据");
			}

			public List<Dept> queryList() {
				return null;
			}

		};
	}

}
