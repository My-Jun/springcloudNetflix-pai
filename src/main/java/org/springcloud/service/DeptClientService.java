package org.springcloud.service;

import java.util.List;

import org.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "SPRINGCLOUD-PROVIDER-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

	@PostMapping("/dept/add")
	public boolean addDept(Dept dept);

	@GetMapping("/dept/queryById/{deptno}")
	public Dept queryById(@PathVariable("deptno") Long deptno);

	@GetMapping("/dept/queryList")
	public List<Dept> queryList();

}
