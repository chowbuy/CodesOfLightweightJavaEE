package org.crazyit.app.service.impl;

import org.crazyit.app.service.*;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class American implements Person
{
	// 实现Person接口必须实现如下两个方法
	public String sayHello(String name)
	{
		return name + ",Hello!";
	}
	public String sayGoodBye(String name)
	{
		return name + ",Good Bye!";
	}
}